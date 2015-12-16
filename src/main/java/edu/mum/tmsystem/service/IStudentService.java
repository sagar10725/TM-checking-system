package edu.mum.tmsystem.service;

import java.util.List;

import edu.mum.tmsystem.domain.Student;
import edu.mum.tmsystem.enums.StatusType;

public interface IStudentService {

	public List<Student> getAllStudent();

	public void deleteStudentById(Long id);

	public List<Student> getStudentsByStatus(StatusType status);

	public Student getStudent(Long id);

	public void saveStudent(Student student);

	public Student getStudentByUserId(Long id);

	public Student getStudentById(Long id);
}
