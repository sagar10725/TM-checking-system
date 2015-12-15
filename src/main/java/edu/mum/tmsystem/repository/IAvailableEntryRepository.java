package edu.mum.tmsystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.tmsystem.domain.AvailableEntry;

@Repository
public interface IAvailableEntryRepository extends CrudRepository<AvailableEntry, Long> {

}
