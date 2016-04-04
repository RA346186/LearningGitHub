/**
 *  Copyright Wipro Technologies ,2015
 *  Created on Mar 08, 2016
 *  FieldAssist Solution Script Service
 *  
 *  Created by - rajiv_vilas@yahoo.com
 *    
 */
package com.wipro.cto.auth.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.wipro.cto.auth.model.Student;
import com.wipro.cto.auth.service.StudentService;

@Path("/student")
public class StudentController {

	@POST
	@Path("/createStudent")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void createStudent(String student) {

		Gson gson = new Gson();
		Student inputObj = gson.fromJson(student, Student.class);
		System.out.println("Student Id: " + inputObj.getId() + " Student Name : " + inputObj.getName() + " Student Age: " + inputObj.getAge());
		try {
				ApplicationContext context = new ClassPathXmlApplicationContext("resources/auth/beans.xml");
				StudentService studentService = (StudentService)context.getBean("studentService");
				System.out.println(studentService);
				studentService.create(inputObj.getName(), inputObj.getAge());
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	  public static void main(String args[]) { 
		  String input =  "{age:37,name:\"Rajiv Sharma\", id:57}"; 
		  new StudentController().createStudent(input);
	  }
	 

}
