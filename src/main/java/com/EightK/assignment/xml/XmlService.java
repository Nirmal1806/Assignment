package com.EightK.assignment.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.EightK.assignment.constants.ApplicationConstants;
import com.EightK.assignment.service.PersonDataService;

@Component
public class XmlService {

	@Autowired
	PersonDataService personDataService;

	public void mergeXML(File geodataXML, File salarydataXML) {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		Document geodata = null;
		Document salarydata = null;
		Document personData = null;

		try {
			db = dbf.newDocumentBuilder();
			personData = db.newDocument();
			geodata = db.parse(geodataXML);
			salarydata = db.parse(salarydataXML);
			geodata.getDocumentElement().normalize();
			salarydata.getDocumentElement().normalize();

			NodeList geodataList = geodata.getElementsByTagName("geodata");
			NodeList salarydataList = salarydata.getElementsByTagName("salarydata");

			Element personDataEle = personData.createElement("persondata");
			personData.appendChild(personDataEle);

			for (int itr = 0; itr < geodataList.getLength(); itr++) {
				Node geoDataNode = geodataList.item(itr);

				if (geoDataNode.getNodeType() == Node.ELEMENT_NODE) {

					Element geoDataEle = (Element) geoDataNode;
					NodeList personList = geoDataEle.getElementsByTagName("person");

					for (int itr1 = 0; itr1 < personList.getLength(); itr1++) {

						Node geoDataPersonNode = personList.item(itr1);
						Element geoDataPersonEle = (Element) geoDataPersonNode;

						NamedNodeMap geoDataPersonAttributes = geoDataPersonNode.getAttributes();
						Node geoDataPersonAttributeValue = geoDataPersonAttributes.getNamedItem("name");

						Element persons = personData.createElement("person");
						String phNo = geoDataPersonEle.getElementsByTagName("phonenumber").item(0).getTextContent() ;
						if(phNo != null && phNo != "" ) {
						Attr name = personData.createAttribute("name");
						name.setValue(geoDataPersonAttributeValue.getNodeValue());
						persons.setAttributeNode(name);

						Element address = personData.createElement("address");
						address.appendChild(personData.createTextNode(
								geoDataPersonEle.getElementsByTagName("address").item(0).getTextContent()));

						Element phonenumber = personData.createElement("phonenumber");
						phonenumber.appendChild(personData.createTextNode(
								geoDataPersonEle.getElementsByTagName("phonenumber").item(0).getTextContent()));

						persons.appendChild(address);
						persons.appendChild(phonenumber);
						personDataEle.appendChild(persons);
						}
					}
				}
			}

			for (int itr = 0; itr < salarydataList.getLength(); itr++) {
				Node salaryDataNode = salarydataList.item(itr);

				if (salaryDataNode.getNodeType() == Node.ELEMENT_NODE) {

					Element salaryDataElement = (Element) salaryDataNode;
					NodeList salaryDataPersonList = salaryDataElement.getElementsByTagName("person");

					for (int itr1 = 0; itr1 < salaryDataPersonList.getLength(); itr1++) {

						Node person = salaryDataPersonList.item(itr1);
						Element personEle = (Element) person;

						NamedNodeMap attributes = person.getAttributes();
						Node nameAttribute = attributes.getNamedItem("name");

						NodeList personDataList = personDataEle.getElementsByTagName("person");

						for (int itr2 = 0; itr2 < personDataList.getLength(); itr2++) {

							Node personDataNode = personDataList.item(itr2);
							Element personsEle = (Element) personDataNode;

							NamedNodeMap personDataAttributes = personDataNode.getAttributes();
							Node personDataAttributeValue = personDataAttributes.getNamedItem("name");

							if (personDataAttributeValue.getNodeValue().equals(nameAttribute.getNodeValue())) {

								Element salary = personData.createElement("salary");
								salary.appendChild(personData.createTextNode(
										personEle.getElementsByTagName("salary").item(0).getTextContent()));

								Element pension = personData.createElement("pension");
								pension.appendChild(personData.createTextNode(
										personEle.getElementsByTagName("pension").item(0).getTextContent()));

								personsEle.appendChild(salary);
								personsEle.appendChild(pension);
								personDataEle.appendChild(personsEle);

								break;
							}
						}
					}
				}
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(personData);
			StreamResult result = new StreamResult(new File(ApplicationConstants.CONF_PATH + "persondata.xml"));
			transformer.transform(source, result);

			personDataService.insertIntoDb(new File(ApplicationConstants.CONF_PATH + "persondata.xml"));

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
