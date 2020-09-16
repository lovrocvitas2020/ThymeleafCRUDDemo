package com.lovro.springboothibernate.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lovro.springboothibernate.model.Student;
import com.lovro.springboothibernate.repository.StudentRepository;

@Service
public class StudentDAO {
	@Autowired
	StudentRepository studentRepository;
	
	
	/**
	 * Method for saving student
	 * 
	 * @param std
	 * @return
	 */
	public Student save(Student std) {
		return studentRepository.save(std);
	}
	
	
	
	/**
	 * Searches all students
	 * 
	 * @return
	 */
	public List<Student> findAll(){
		return studentRepository.findAll();
	}
	
	
	/**
	 * Searches one student
	 * 
	 * @param id
	 * @return
	 */
	public Student findOne(Integer id) {
		return studentRepository.findOne(id);
	}
	
	
	
	/**
	 * Deletes one student
	 * 
	 * @param std
	 */
	public void delete(Student std) {
		studentRepository.delete(std);
	}
	

}