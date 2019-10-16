package orangebank.repository;

import org.springframework.data.repository.CrudRepository;


import orangebank.entity.Transaction;

public interface TransactionRepository  extends CrudRepository<Transaction, String> {

}
