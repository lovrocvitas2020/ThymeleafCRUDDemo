package com.lovro.springboothibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lovro.springboothibernate.model.Student;

/**
 * Interface used to connect to database
 * 
 * @author lovro.cvitas
 *
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {

}