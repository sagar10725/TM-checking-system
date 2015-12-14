package edu.mum.tmsystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.tmsystem.domain.CheckingTimes;

@Repository
public interface ICheckingTimesRepository extends CrudRepository<CheckingTimes, Integer> {

}
