package br.com.mindsy.api.gateway.repository;

import br.com.mindsy.api.gateway.model.PsychologistEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PsychologistRepository extends CrudRepository<PsychologistEntity, String> {

}
