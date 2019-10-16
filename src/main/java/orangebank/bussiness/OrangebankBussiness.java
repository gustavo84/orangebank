package orangebank.bussiness;


import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orangebank.controller.OrangebankController.OrderBy;
import orangebank.entity.AccountBalance;
import orangebank.entity.SearchResponse;
import orangebank.entity.SearchTransaction;
import orangebank.entity.SearchTransaction.Chanel;
import orangebank.entity.Transaction;
import orangebank.repository.AccountBalanceRepository;
import orangebank.repository.TransactionRepository;




@Service
public class OrangebankBussiness {

    @Autowired
    private AccountBalanceRepository accountBalance;
    
    @Autowired
    private TransactionRepository transactionRep;

    public void createTransaction(Transaction transaction) throws Exception {
        if (accountBalance.existsById(transaction.getAccount_iban())) {
            AccountBalance ac = accountBalance.findById(transaction.getAccount_iban()).get();
            // It is IMPORTANT to note that a transaction that leaves the total account
            // balance bellow 0 is not allowed.
            if (!transactionRep.existsById(transaction.getReference())) {
                if (transaction.getAmount() < ac.getTotalAmount()) {
                    transactionRep.save(transaction);
                    ac.setTotalAmount(ac.getTotalAmount() - transaction.getAmount());
                    accountBalance.save(ac);
                } else {
                    throw new Exception("Not enought amount in account balance for the next account: "
                            + transaction.getAccount_iban());
                }
            } else {
                throw new Exception("The transaction already exists " + transaction.getReference());
            }
        } else {
            throw new Exception("The account iban not present in accounts balances: " + transaction.getAccount_iban());
        }

    }

    public SearchResponse searchTransactions(SearchTransaction searchTransaction) throws Exception {
        SearchResponse response = null;
        if (transactionRep.existsById(searchTransaction.getReference())) {
            Transaction transaction = transactionRep.findById(searchTransaction.getReference()).get();

            long diff = new Date().getTime() - transaction.getDate().getTime();
            if (TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) == 0) {
                if (searchTransaction.getChannel().equals(Chanel.ATM)
                        || searchTransaction.getChannel().equals(Chanel.CLIENT)) {
                    response = new SearchResponse(searchTransaction.getReference(), SearchResponse.Status.PENDING,
                            transaction.getAmount());
                } else if (searchTransaction.getChannel().equals(Chanel.INTERNAL)) {
                    response = new SearchResponse(searchTransaction.getReference(), SearchResponse.Status.PENDING,
                            transaction.getAmount(), transaction.getFee());
                }
            } else if (TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) > 0) {
                if (searchTransaction.getChannel().equals(Chanel.ATM)
                        || searchTransaction.getChannel().equals(Chanel.CLIENT)) {
                    response = new SearchResponse(searchTransaction.getReference(), SearchResponse.Status.SETTLED,
                            transaction.getAmount());
                } else if (searchTransaction.getChannel().equals(Chanel.INTERNAL)) {
                    response = new SearchResponse(searchTransaction.getReference(), SearchResponse.Status.SETTLED,
                            transaction.getAmount(), transaction.getFee());
                }
            } else if (TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) < 0) {
                if (searchTransaction.getChannel().equals(Chanel.ATM)) {
                    response = new SearchResponse(searchTransaction.getReference(), SearchResponse.Status.PENDING,
                            transaction.getAmount());
                }else if (searchTransaction.getChannel().equals(Chanel.CLIENT)) {
                    response = new SearchResponse(searchTransaction.getReference(), SearchResponse.Status.FUTURE,
                            transaction.getAmount());
                } else if (searchTransaction.getChannel().equals(Chanel.INTERNAL)) {
                    response = new SearchResponse(searchTransaction.getReference(), SearchResponse.Status.FUTURE,
                            transaction.getAmount(), transaction.getFee());
                }
            }
        } else {
            response = new SearchResponse(searchTransaction.getReference(), SearchResponse.Status.INVALID);
        }
        return response;
        // TODO Auto-generated method stub

    }

    public List<Transaction> searchTransactionByAccountIban(String accountIban,OrderBy order) {

        return OrderBy.ASC.equals(order)? transactionRep.findByAccountibanOrderByAmountAsc(accountIban): transactionRep.findByAccountibanOrderByAmountDesc(accountIban);
       
    }


}
