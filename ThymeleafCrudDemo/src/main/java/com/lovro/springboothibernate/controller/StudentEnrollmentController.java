
package com.lovro.springboothibernate.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



import com.lovro.springboothibernate.*;
import com.lovro.springboothibernate.dao.CountryDAO;
import com.lovro.springboothibernate.dao.StudentDAO;
import com.lovro.springboothibernate.model.Country;
import com.lovro.springboothibernate.model.Student;
import com.lovro.springboothibernate.model.UserCode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




/**
 * Class which contains all methods and application logic
 * 
 * 
 * @author Lovro
 *
 */
@Controller
public class StudentEnrollmentController {
	
	@Autowired
	private StudentDAO studentDao;
	
	@Autowired
	private CountryDAO countryDao;
	
	
	/**
	 * Method used to enroll new student
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/enroll",method=RequestMethod.GET)
	public String newRegistration(ModelMap model) {
		System.out.println("newRegistration model: "+model.toString());
		Student student = new Student();
		model.addAttribute("student",student);
		return "enroll";
	}
	
	/**
	 * Method newRegistration2
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/enroll2",method=RequestMethod.GET)
	public String newRegistration2(ModelMap model) {
		System.out.println("enroll2 ");
		Student student = new Student();
		model.addAttribute("student",student);
		return "enroll2";
	}
	
	/**
	 * Method newUserCode 
	 * 
	 * @param editusercode
	 * @return
	 */
	@RequestMapping(value="/editusercode",method=RequestMethod.GET)
	public String newUserCode(ModelMap model) {
		System.out.println("model editusercode - newUserCode");
		UserCode usercode =  new UserCode();
		model.addAttribute("usercode",usercode);		
		return "editusercode";
	}
	
	
	/**
	 * Method openHomepage
	 * 
	 * @param homepage
	 * @return
	 */
	@RequestMapping(value="/homepage",method=RequestMethod.GET)
	public String openHomepage(ModelMap model) {
		System.out.println("openHomepage: "+model.toString());
		//Student student = new Student();
		//model.addAttribute("student",student);
		return "homepage";
	}
	
	
	
	/**
	 *  Method for opening screen viewcountires with redirect
	 *   
	 * @return
	 */
	@RequestMapping(value="/viewcountries",method=RequestMethod.GET ) // value="enroll/viewcountries"
	public ModelAndView openPageViewCountries() {  // public String openPageViewCountries()
		System.out.println("openPageViewCountries");
		List<Country> listcountry = countryDao.findAll();  // countryDao.findAllCountries();
		
		System.out.println("listcountry: size:"+listcountry.size());
		// test
		for(int i=0; i< listcountry.size(); i++) {
			//System.out.println("ispis Capital:"+listcountry.get(i).getCapital());
		}
		
		/*System.out.println("Test for each country");
		for(Country country : listcountry) {
			System.out.println(country.getContinent());
		}*/
		
		
		return new ModelAndView("viewcountries","list",listcountry);
		
		//return "viewcountries"; // "redirect:/viewcountries"
	}
	
	
	/**
	 * Method openPageViewTest used for testing
	 * 
	 * @return
	 */
	@RequestMapping(value="/test",method=RequestMethod.GET )
	public String openPageViewTest() {
		System.out.println("openPageViewTest");
		
		return "redirect:/test";
	}
	
	/**
	 * Metohd used for fetching all students
	 * 
	 * @return
	 */
	@RequestMapping(value="/viewstudents")
	public ModelAndView getAll() {
		System.out.println("ModelAndView getAll /viewstudents");
		List<Student> list = studentDao.findAll();
		return new ModelAndView("viewstudents","list",list);
	}
	
	/*
	 * Method for opening screen viewstudents
	 *
	 */
	@RequestMapping(value="enroll/viewstudents")
	public ModelAndView openPageViewStudents() {
		System.out.println("openPageViewStudents ");
		List<Student> list=studentDao.findAll();
		return new ModelAndView("viewstudents","list",list);
	}
	
	
	
	
	
	/**
	 * Method for saving student
	 * @param student
	 * @param result
	 * @param model
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveRegistration(@Valid Student student,BindingResult result,ModelMap model,RedirectAttributes redirectAttributes) {
		
		System.out.println("method saveRegistration");
		if(result.hasErrors()) {
			System.out.println("has errors");
			return "enroll";
		}
	
		studentDao.save(student);
		
		return "redirect:/viewstudents";
	}
	

	
	/**
	 * Method for editing students
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/editstudent/{id}")
	public String editStudent (@PathVariable int id,ModelMap model) {
		System.out.println("editStudent method id: "+id+" model: "+model);
		Student student=studentDao.findOne(id);
		model.addAttribute("student",student);
		return "editstudent";
	}
	
	/**
	 * Method for saving students 
	 * 
	 * @param p
	 * @return
	 */
	@RequestMapping(value="/editsave",method=RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("student") Student p) {
		System.out.println("editsave (student) method");
		Student student=studentDao.findOne(p.getId());
		
		student.setFirstName(p.getFirstName());
		student.setLastName(p.getLastName());
		student.setCountry(p.getCountry());
		student.setEmail(p.getEmail());
		student.setSection(p.getSection());
		student.setSex(p.getSex());
		
		studentDao.save(student);
		return new ModelAndView("redirect:/viewstudents");
	}
	
	/**
	 * Method for deleting students
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/deletestudent/{id}",method=RequestMethod.GET)
	public ModelAndView deleteStudent(@PathVariable int id) {
		System.out.println("deleteStudent method id: "+id);
		Student student=studentDao.findOne(id);
		studentDao.delete(student);
		return new ModelAndView("redirect:/viewstudents");
	}
	
	
	/**
	 * Method for editing countries
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/editcountry/{id}")
	public String editCountry (@PathVariable int id,ModelMap model) {
		try {
			System.out.println("editCountry method id: "+id+" model: "+model);
			Country country=countryDao.findCountry(id);
			model.addAttribute("country",country);
			System.out.println("Open Screen Edit Country");
			
			return "editcountry";
		} catch(Exception e) {
			System.out.println("Error occured: "+e.getMessage());
		}
		return null;
		
	}
	
	
	/**
	 * Method for saving students 
	 * 
	 * @param p
	 * @return
	 */
	@RequestMapping(value="/editsavecountry",method=RequestMethod.POST)
	public ModelAndView editsaveCountry(@ModelAttribute("country") Country c) {
		System.out.println("editsavecountry  method");
		
		Country country=countryDao.findCountry(c.getId());
		country.setName(c.getName());
		country.setRegion(c.getRegion());
		System.out.println("country name: "+country.getName());
		countryDao.saveCountry(country);
		
		
		
		/*
		student.setFirstName(p.getFirstName());
		student.setLastName(p.getLastName());
		student.setCountry(p.getCountry());
		student.setEmail(p.getEmail());
		student.setSection(p.getSection());
		student.setSex(p.getSex());
		
		studentDao.save(student);
		return new ModelAndView("redirect:/viewstudents");
		*/
		return new ModelAndView("redirect:/viewcountries");
	}
	
	// Combobox for sections
	@ModelAttribute("sections")
	public List<String> intializeSections(){
		List<String> sections = new ArrayList<String>();
		sections.add("Graduate");
		sections.add("Post Graduate");
		sections.add("Reasearch");
		sections.add("PhD");
		return sections;
	}
	
	
	/*
	 * Method used to populate the country list in view. 
	 */
	@ModelAttribute("countries")
	public List<String> initializeCountries() {

		List<String> countries = new ArrayList<String>();
		
		countries.add("AUSTRIA");
		countries.add("USA");
		countries.add("CANADA");
		countries.add("CROATIA");
		countries.add("CHINA");
		countries.add("FRANCE");
		countries.add("GERMANY");
		countries.add("ITALY");
		countries.add("SLOVENIA");
		countries.add("HUNGARY");
		countries.add("FRANCE");
		countries.add("SPAIN");
		countries.add("OTHER");
		return countries;
	}

	@ModelAttribute("regions")
	public List<String> initializeRegions(){
		
		List<String> regions = new ArrayList<String>();
						
		regions.add("Antarctica");
		regions.add("Australia and New Zealand");
		regions.add("Baltic Countries");
		regions.add("British Islands");
		regions.add("Caribbean");
		regions.add("Central Africa");
		regions.add("Central America");
		regions.add("Eastern Africa");
		regions.add("Eastern Asia");
		regions.add("Eastern Europe");
		regions.add("Melanesia");
		regions.add("Micronesia");
		regions.add("Micronesia/Caribbean");
		regions.add("Middle East");
		regions.add("Nordic Countries");
		regions.add("North America");
		regions.add("Northern Africa");
		regions.add("Polynesia");
		regions.add("South America");
		regions.add("Southeast Asia");
		regions.add("Southern Africa");
		regions.add("Southern and Central Asia");
		regions.add("Southern Europe");
		regions.add("Western Africa");
		regions.add("Western Europe");

		return regions;
	}
	

}