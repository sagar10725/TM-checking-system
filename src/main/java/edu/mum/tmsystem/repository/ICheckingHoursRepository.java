package edu.mum.tmsystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.tmsystem.domain.CheckingHours;

@Repository
public interface ICheckingHoursRepository extends CrudRepository<CheckingHours, Integer> {

}
