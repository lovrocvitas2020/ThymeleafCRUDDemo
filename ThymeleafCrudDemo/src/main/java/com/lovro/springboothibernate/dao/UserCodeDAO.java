package com.lovro.springboothibernate.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lovro.springboothibernate.model.UserCode;
import com.lovro.springboothibernate.repository.UserCodeRepository;

@Service
public class UserCodeDAO {
	
	@Autowired 
	UserCodeRepository userCodeRepository;

	
	/*to save an user code*/
	
	public UserCode save(UserCode userc) {
		return userCodeRepository.save(userc);
	}
	
	
	/* search all UserCodes*/
	
	public List<UserCode> findAll(){
		return userCodeRepository.findAll();
	}
	
	
	/*get an user code by id*/
	public UserCode findOne(Integer id) {
		return userCodeRepository.findOne(id);
	}
	
	
	/*delete an usercode*/
	
	public void delete(UserCode std) {
		userCodeRepository.delete(std);
	}
}
