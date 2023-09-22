package orangebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import orangebank.entity.SnfAgente;


@Repository
public interface AgentRepository  extends CrudRepository<SnfAgente, Integer> {
	
	

}