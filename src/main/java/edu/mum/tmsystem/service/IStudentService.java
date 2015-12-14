package edu.mum.tmsystem.service;

import java.util.List;

import edu.mum.tmsystem.domain.Student;

public interface IStudentService {

	public List<Student> getAllStudent();

	public void deleteStudentById(Long id);

	
}
