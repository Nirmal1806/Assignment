package com.EightK.assignment.xml;

import org.xml.sax.helpers.DefaultHandler;

public class PersonDataParserHandler extends DefaultHandler {
	// This is the list which shall be populated while parsing the XML.
	/*
	 * private ArrayList personList = new ArrayList();
	 * 
	 * //As we read any XML element we will push that in this stack private Stack
	 * elementStack = new Stack();
	 * 
	 * //As we complete one person block in XML, we will push the person instance in
	 * personList private Stack objectStack = new Stack();
	 * 
	 * public void startDocument() throws SAXException {
	 * //System.out.println("start of the document   : "); }
	 * 
	 * public void endDocument() throws SAXException {
	 * //System.out.println("end of the document document     : "); }
	 * 
	 * public void startElement(String uri, String localName, String qName,
	 * Attributes attributes) throws SAXException { //Push it in element stack
	 * this.elementStack.push(qName);
	 * 
	 * //If this is start of 'person' element then prepare a new person instance and
	 * push it in object stack if ("person".equals(qName)) { //New person instance
	 * PersonData person = new PersonData();
	 * 
	 * //Set all required attributes in any XML element here itself if(attributes !=
	 * null && attributes.getLength() == 1) { person.setName(""); }
	 * this.objectStack.push(person); } }
	 * 
	 * public void endElement(String uri, String localName, String qName) throws
	 * SAXException { //Remove last added element this.elementStack.pop();
	 * 
	 * //person instance has been constructed so pop it from object stack and push
	 * in personList if ("person".equals(qName)) { PersonData object = (PersonData)
	 * this.objectStack.pop(); this.personList.add(object); } }
	 * 
	 *//**
		 * This will be called everytime parser encounter a value node
		 */
	/*
	 * public void characters(char[] ch, int start, int length) throws SAXException
	 * { String value = new String(ch, start, length).trim();
	 * 
	 * if (value.length() == 0) { return; // ignore white space }
	 * 
	 * //handle the value based on to which element it belongs if
	 * ("firstName".equals(currentElement())) { PersonData person = (PersonData)
	 * this.objectStack.peek(); person.setName(value); } else if
	 * ("lastName".equals(currentElement())) { PersonData person = (PersonData)
	 * this.objectStack.peek(); person.setName(value); } }
	 * 
	 *//**
		 * Utility method for getting the current element in processing
		 *//*
			 * private String currentElement() { return (String) this.elementStack.peek(); }
			 * 
			 * //Accessor for personList object public ArrayList getPersonData() { return
			 * personList; }
			 */

}
