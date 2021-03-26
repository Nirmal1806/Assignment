package com.EightK.assignment.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SalaryData {
	
	@XmlElement(name="person data")
	PersonData pd;

	public PersonData getPd() {
		return pd;
	}

	public void setPd(PersonData pd) {
		this.pd = pd;
	}

}
