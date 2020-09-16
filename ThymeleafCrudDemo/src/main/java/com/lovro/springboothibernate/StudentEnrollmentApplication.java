
package com.lovro.springboothibernate;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Test Spring CRUD application
 *  
 *  Steps for starting application 
 *  Right click on class  StudentEnrollmentApplication
 *  and Run As - Java Application
 *  address: http://localhost:8080/enroll
 *  
 *   for code changes restart applicaton
 *  
 *  baza world
 *  tables: student, country
 * 
 * @author Lovro
 *
 */

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan(basePackages={"com.lovro.springboothibernate.controller","com.lovro.springboothibernate.dao",
		"com.lovro.springboothibernate.model","com.lovro.springboothibernate.repository"})
public class StudentEnrollmentApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(StudentEnrollmentApplication.class, args);
		

	}

}