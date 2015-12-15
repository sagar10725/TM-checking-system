package edu.mum.tmsystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.tmsystem.domain.TMHistory;

@Repository
public interface ITMCheckerRepository extends CrudRepository<TMHistory, Long>{

}
