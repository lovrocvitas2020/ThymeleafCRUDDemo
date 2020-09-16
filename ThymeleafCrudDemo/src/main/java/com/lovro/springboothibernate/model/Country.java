package com.lovro.springboothibernate.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="Country")
@EntityListeners(AuditingEntityListener.class)
public class Country {
	
	/**
	 * 
	 */
	public Country() {
		
	}
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String Code;
	
	private String Name;
	
	private String Continent;
	
	private String Region;
	
	private double SurfaceArea;
	
	private int IndepYear;
	
	private int Population;
	
	private double LifeExpectancy;
	
	private double GDP;
	
	private double GDPOld;
	
	private String LocalName;
	
	private String GovermentForm;
	
	private String HeadOfState;
	
	private int Capital;
	
	private String Code2;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getContinent() {
		return Continent;
	}

	public void setContinent(String continent) {
		Continent = continent;
	}

	public String getRegion() {
		return Region;
	}

	public void setRegion(String region) {
		Region = region;
	}

	public double getSurfaceArea() {
		return SurfaceArea;
	}

	public void setSurfaceArea(double surfaceArea) {
		SurfaceArea = surfaceArea;
	}

	public int getIndepYear() {
		return IndepYear;
	}

	public void setIndepYear(int indepYear) {
		IndepYear = indepYear;
	}

	public int getPopulation() {
		return Population;
	}

	public void setPopulation(int population) {
		Population = population;
	}

	public double getLifeExpectancy() {
		return LifeExpectancy;
	}

	public void setLifeExpectancy(double lifeExpectancy) {
		LifeExpectancy = lifeExpectancy;
	}

	public double getGDP() {
		return GDP;
	}

	public void setGDP(double gDP) {
		GDP = gDP;
	}

	public double getGDPOld() {
		return GDPOld;
	}

	public void setGDPOld(double gDPOld) {
		GDPOld = gDPOld;
	}

	public String getLocalName() {
		return LocalName;
	}

	public void setLocalName(String localName) {
		LocalName = localName;
	}

	public String getGovermentForm() {
		return GovermentForm;
	}

	public void setGovermentForm(String govermentForm) {
		GovermentForm = govermentForm;
	}

	public String getHeadOfState() {
		return HeadOfState;
	}

	public void setHeadOfState(String headOfState) {
		HeadOfState = headOfState;
	}

	public int getCapital() {
		return Capital;
	}

	public void setCapital(int capital) {
		Capital = capital;
	}

	public String getCode2() {
		return Code2;
	}

	public void setCode2(String code2) {
		Code2 = code2;
	}
		
	

}
