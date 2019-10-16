package orangebank.bussiness;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orangebank.entity.Transaction;
import orangebank.entity.AccountBalance;
import orangebank.repository.AccountBalanceRepository;
import orangebank.repository.TransactionRepository;




@Service
public class OrangebankBussiness {

    @Autowired
    private AccountBalanceRepository AccountBalance;
    
    @Autowired
    private TransactionRepository transactionRep;
    
    public void createTransaction(Transaction transaction) throws Exception {
        AccountBalance ac = AccountBalance.findById(transaction.getAccount_iban()).get();
        //It is IMPORTANT to note that a transaction that leaves the total account balance bellow 0 is not allowed.
        if(transaction.getAmount()<ac.getTotalAmount()) {
            transactionRep.save(transaction);
            ac.setTotalAmount(ac.getTotalAmount()-transaction.getAmount());
            AccountBalance.save(ac);
        }else {
            throw new Exception("Not enought amount in account balance for the next account: "+transaction.getAccount_iban());
        }
        
    }


}
