package edu.mum.tmsystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.tmsystem.domain.DefaultCheckingSeats;

@Repository
public interface IDefaultCheckingSeatsRepository extends CrudRepository<DefaultCheckingSeats, Long> {

}
