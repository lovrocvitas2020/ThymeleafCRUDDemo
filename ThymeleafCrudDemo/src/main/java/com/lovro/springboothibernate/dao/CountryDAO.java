package com.lovro.springboothibernate.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lovro.springboothibernate.model.Country;
import com.lovro.springboothibernate.repository.CountryRepository;

@Service
public class CountryDAO {
	
	@Autowired
	CountryRepository countryRepository;
	
	/*Save a country*/
	public Country saveCountry(Country cou) {
		return countryRepository.save(cou);  // Spring metode
		
	}
	
	/*Search all countries*/
	public List<Country> findAll(){
		return countryRepository.findAll();		// Spring metode
	}
	
	/*get country by id*/
	public Country findCountry(Integer id) {
		return countryRepository.findOne(id); // Spring metode
	}
	
	/*delete country*/
	public void deleteCountry(Country cou) {
		countryRepository.delete(cou); // Spring metode
	}
	
	
    //search all countries order by
	public Country findAllCountriesOrder(Country cou){
		Integer id = cou.getId();
		System.out.println("findAllCountriesOrder id: "+id);
		return countryRepository.findOne(id);
	}

}
