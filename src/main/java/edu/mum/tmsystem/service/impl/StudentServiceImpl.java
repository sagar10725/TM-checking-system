package edu.mum.tmsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.tmsystem.domain.Student;
import edu.mum.tmsystem.enums.StatusType;
import edu.mum.tmsystem.repository.IStudentRepository;
import edu.mum.tmsystem.service.IStudentService;

@Service
@Transactional
public class StudentServiceImpl implements IStudentService {

	@Autowired
	IStudentRepository studentRepository;

	@Override
	public List<Student> getAllStudent() {
		return (List<Student>) studentRepository.findAll();
	}

	@Override
	public void deleteStudentById(Long id) {
		studentRepository.delete(id);
	}

	@Override
	public List<Student> getStudentsByStatus(StatusType status) {
		return (List<Student>) studentRepository.findStudentByStatus(status);
	}

	@Override
	public Student getStudent(Long id) {
		return (Student) studentRepository.findOne(id); 
	}

	@Override
	public void saveStudent(Student student) {
		studentRepository.save(student);
	}

	@Override
	public Student getStudentByUserId(Long id) {
		return studentRepository.getStudentByUserId(id);
	}

	@Override
	public Student getStudentById(Long id) {
		return (Student) studentRepository.findOne(id);
	}

	@Override
	public Student getStudentByStudentID(String studentId) {
		return (Student) studentRepository.getStudentByStudentId(studentId);
	}

}
