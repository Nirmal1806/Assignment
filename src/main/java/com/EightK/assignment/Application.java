package com.EightK.assignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.EightK.assignment.constants.ApplicationConstants;
import com.EightK.assignment.xml.XmlService;

@SpringBootApplication
@EnableAutoConfiguration
public class Application {	
	
	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(Application.class, args);
		
		 
	}

}
