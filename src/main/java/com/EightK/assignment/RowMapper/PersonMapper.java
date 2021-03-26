package com.EightK.assignment.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.EightK.assignment.xml.Person;

public class PersonMapper implements RowMapper<Person> {
	
	public Person mapRow(ResultSet rs, int rownum)throws SQLException{
		Person person = new Person();
		person.setName(rs.getString("name"));
		person.setAddress(rs.getString("phonenumber"));
		person.setPhonenumber(rs.getString("address"));
		person.setPension(rs.getString("salary"));
		person.setSalary(rs.getString("pension"));
		return person;
	}

}
