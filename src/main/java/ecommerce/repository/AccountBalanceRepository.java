package ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import ecommerce.entity.AccountBalance;

public interface AccountBalanceRepository  extends CrudRepository<AccountBalance, String> { 
    
   
}


