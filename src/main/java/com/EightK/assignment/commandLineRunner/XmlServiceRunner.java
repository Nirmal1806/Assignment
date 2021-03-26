package com.EightK.assignment.commandLineRunner;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.EightK.assignment.constants.ApplicationConstants;
import com.EightK.assignment.xml.XmlService;

@Component
public class XmlServiceRunner implements CommandLineRunner{
	
	@Autowired
	XmlService xmlService;
	
	  @Override
	  public void run(String... args) throws Exception {
		  
		  File geoData = new File(ApplicationConstants.CONF_PATH+"geodata.xml");
			File salaryData = new File(ApplicationConstants.CONF_PATH+"salarydata.xml");
		
	        //Parse the file
	        xmlService.mergeXML(geoData,salaryData);    
	  
	  }

}
