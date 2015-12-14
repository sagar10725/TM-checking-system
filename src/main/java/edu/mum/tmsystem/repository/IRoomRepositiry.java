package edu.mum.tmsystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.tmsystem.domain.Room;

@Repository
public interface IRoomRepositiry extends CrudRepository<Room, Integer> {

}
