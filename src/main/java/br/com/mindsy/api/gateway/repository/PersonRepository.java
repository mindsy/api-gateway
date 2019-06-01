package br.com.mindsy.api.gateway.repository;

import br.com.mindsy.api.gateway.model.PersonEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<PersonEntity, Long> {
}
