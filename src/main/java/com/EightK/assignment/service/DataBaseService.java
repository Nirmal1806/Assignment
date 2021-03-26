package com.EightK.assignment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.EightK.assignment.RowMapper.PersonMapper;
import com.EightK.assignment.dataaccess.MysqlDataAccess;
import com.EightK.assignment.xml.Person;

@Service
public class DataBaseService {
	

	@Autowired
	private JdbcTemplate jdbc;
	
	
	
	 public List getPersonDetails(String field, String operator, String keyword)
	{
		 String sql ="Select * from person where "+field;
		 
		 if(operator.equals("Is"))
		 {
			 sql+= " = '"+keyword+"'";
		 }else
		 {
			 sql+= " like '%"+keyword+"%'";
		 }
		 
		 List<Person> pList =  jdbc.query(sql,new PersonMapper());

		return pList;
	}

}
