package com.lovro.springboothibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lovro.springboothibernate.model.UserCode;


/**
 * Interface used to connect to database
 * 
 * @author lovro.cvitas
 *
 */
public interface UserCodeRepository extends JpaRepository<UserCode, Integer> {

}
