package com.lovro.springboothibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lovro.springboothibernate.model.Country;

/**
 * Interface used to conenct to database
 * 
 * @author lovro.cvitas
 *
 */
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
