package api.sujata.banking.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import api.sujata.banking.beans.ReturnLinks;

@Repository
public interface ReturnLinksRepository extends CrudRepository<ReturnLinks,Integer>{

}
