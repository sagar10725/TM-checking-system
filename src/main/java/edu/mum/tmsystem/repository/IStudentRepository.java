package edu.mum.tmsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.tmsystem.domain.Student;
import edu.mum.tmsystem.enums.StatusType;

@Repository
public interface IStudentRepository extends CrudRepository<Student, Long> {

	@Query("SELECT s FROM Student s WHERE s.user.status = :status")
	List<Student> findStudentByStatus(@Param("status") StatusType status);
	
	@Query("SELECT s FROM Student s WHERE s.user.id = :id")
	public Student getStudentByUserId(@Param("id") Long id);
	
	@Query("SELECT s FROM Student s WHERE s.studentId = :studentId")
	public Student getStudentByStudentId(@Param("studentId") String studentId);
	
}
