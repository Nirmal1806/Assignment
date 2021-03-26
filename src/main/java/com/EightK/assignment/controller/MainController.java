package com.EightK.assignment.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.EightK.assignment.service.DataBaseService;
import com.EightK.assignment.xml.Person;

@RestController
public class MainController {

	@Autowired
	DataBaseService dbService;
	
	@GetMapping("/")
	public ModelAndView responseForm()
	{
		return new ModelAndView("client");
	}

	@GetMapping("/getDetails")
	List getDetails(HttpServletRequest  request, HttpServletResponse res)
	{
		String field = request.getParameter("field");
		String operator = request.getParameter("operator");
		String keyword = request.getParameter("keyword");
		
		List<Person> pList= dbService.getPersonDetails(field,operator,keyword);		
		return pList;
		
	}
	
}
