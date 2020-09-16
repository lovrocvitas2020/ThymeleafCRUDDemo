package com.lovro.springboothibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lovro.springboothibernate.dao.CountryDAO;
import com.lovro.springboothibernate.model.Country;
import com.lovro.springboothibernate.repository.CountryRepository;

@Controller
public class CountryController {
	
	
	private CountryDAO countryDao;
	
	@Autowired
	CountryRepository countryRepository;
	
	// Method for opening screen viewcountries 
	/*
	@RequestMapping(value="/viewcountries",method=RequestMethod.GET)
	public ModelAndView openPageViewCountries() {
		
		List<Country> listcountries = countryDao.findAllCountries();
		
		return new ModelAndView("viewcountries","list", listcountries);
	}
	*/
}
