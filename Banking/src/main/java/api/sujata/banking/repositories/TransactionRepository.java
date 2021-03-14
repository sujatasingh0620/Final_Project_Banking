package api.sujata.banking.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import api.sujata.banking.beans.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction,String> {

}
