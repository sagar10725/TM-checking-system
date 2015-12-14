package edu.mum.tmsystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.tmsystem.domain.Student;

@Repository
public interface IStudentRepository extends CrudRepository<Student, Long> {

}
