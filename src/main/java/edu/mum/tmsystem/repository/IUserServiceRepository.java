package edu.mum.tmsystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.tmsystem.domain.User;

@Repository
public interface IUserServiceRepository extends CrudRepository<User, Long> {

}
