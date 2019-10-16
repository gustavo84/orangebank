package orangebank.repository;

import org.springframework.data.repository.CrudRepository;

import orangebank.entity.AccountBalance;

public interface AccountBalanceRepository  extends CrudRepository<AccountBalance, String> { 
    
   
}


