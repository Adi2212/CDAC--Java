package com.cms.service;

import java.time.LocalDate;

import com.cms.core.Customer;
import com.cms.core.ServicePlan;
import com.cms.custom_exceptions.CMSHandlingException;

/*
 * no dup customers 
(i.e if the customer tries to register using existing email
 , raise custom exception)


 */
public class CMSValidations {
	public static final String EMAIL_PATTERN = "^[a-z][a-z0-9._-]*@[a-z]+\\.(com|org|net)$";
	
	
//add a single method to validate all inputs
	public static Customer validateAllInputs(String firstName, 
			String lastName, String email, String password,
			int regAmount, String dob, String plan, 
			Customer[] customers) throws CMSHandlingException {
		validateEmail(email);
		checkForDuplicate(email, customers);
		validatePlan(plan);
		
		return new Customer(firstName, lastName, email, 
				password, regAmount,
				LocalDate.parse(dob) ,ServicePlan.valueOf(plan));
	}

	// add a static method to check for dup
	public static void checkForDuplicate(String email, Customer[] custs) throws CMSHandlingException {
		 //create customer object to hold only supplied email
		Customer newCust=new Customer(email);
		for (Customer c : custs)
			if (c != null) {
				if (c.equals(newCust)) {
					throw new CMSHandlingException("Email is dup !!!!!!");
				}
			}
	}
	
	public static void validateEmail(String email)throws CMSHandlingException {
		if(!email.matches(EMAIL_PATTERN)) {
			throw new CMSHandlingException("Invalid Email...");
		}
	}
	
	public static ServicePlan validatePlan(String plan) throws CMSHandlingException {
		for(ServicePlan sp : ServicePlan.values()) {
			if (sp.name().equals(plan)) {
				return sp;
			}
		}
		throw new CMSHandlingException("Invalid plan. Choose from SILVER, GOLD, DIAMOND, PLATINUM");
	}
	
	 
}
