package edu.mum.tmsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.tmsystem.domain.AvailableEntry;

@Repository
public interface IAvailableEntryRepository extends CrudRepository<AvailableEntry, Long> {

	@Query("SELECT ae FROM AvailableEntry ae WHERE ae.availableSeats > 0")
	public List<AvailableEntry> getAllAvailableEntriesWithAvailableSeats();
}
