package edu.mum.tmsystem.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.tmsystem.domain.DefaultCheckingSeats;
import edu.mum.tmsystem.enums.CheckingType;

@Repository
public interface IDefaultCheckingSeatsRepository extends CrudRepository<DefaultCheckingSeats, Long> {

	@Query("SELECT d FROM DefaultCheckingSeatsByCheckingType d WHERE d.checkingType = :checkingType")
	DefaultCheckingSeats findDefaultCheckingSeatsByCheckingType(@Param("checkingType") CheckingType checkingType);

}
