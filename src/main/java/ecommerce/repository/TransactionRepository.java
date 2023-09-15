package ecommerce.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ecommerce.entity.AccountBalance;
import ecommerce.entity.Price;

public interface TransactionRepository  extends CrudRepository<Price, String> {

    


    
 List<Price> findByAccountibanOrderByAmountDesc(String accountiban);
 
 List<Price> findByAccountibanOrderByAmountAsc(String accountiban);
 
}
