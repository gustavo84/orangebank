package orangebank.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import orangebank.entity.AccountBalance;
import orangebank.entity.Transaction;

public interface TransactionRepository  extends CrudRepository<Transaction, String> {

    


    
 List<Transaction> findByAccountibanOrderByAmountDesc(String accountiban);
 
 List<Transaction> findByAccountibanOrderByAmountAsc(String accountiban);
 
}
