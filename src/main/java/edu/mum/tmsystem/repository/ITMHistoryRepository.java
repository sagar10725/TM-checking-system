package edu.mum.tmsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.tmsystem.domain.TMHistory;

@Repository
public interface ITMHistoryRepository extends CrudRepository<TMHistory, Integer>{
	
	@Query("SELECT tmh FROM TMHistory tmh WHERE tmh.student.id = :id")
	public List<TMHistory> getTMHistoriesByStudentID(@Param("id") Long id);
	
}
