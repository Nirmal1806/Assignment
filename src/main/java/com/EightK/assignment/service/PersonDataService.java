package com.EightK.assignment.service;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import com.EightK.assignment.dataaccess.MysqlDataAccess;
import com.EightK.assignment.xml.Person;
import com.EightK.assignment.xml.PersonData;

@Component
public class PersonDataService {
	
	
	@Autowired(required=true)
	MysqlDataAccess mysqlDataAccess;

	public void insertIntoDb(File personData) throws JAXBException
	{
	
		try {
		JAXBContext jaxbContext = JAXBContext.newInstance(PersonData.class);  
		   
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
        PersonData personDataObj = (PersonData) jaxbUnmarshaller.unmarshal(personData);  
          
        System.out.println(personDataObj.getPerson().get(0).getPension());  
        System.out.println("Answers:"+personData.getName());  
        List<Person> personlists = personDataObj.getPerson();          
        
        mysqlDataAccess.saveEntities(personlists);
		}catch(DataIntegrityViolationException e)
		{
			
		}catch(Exception e)
		{
			
		}
        
	}

}
