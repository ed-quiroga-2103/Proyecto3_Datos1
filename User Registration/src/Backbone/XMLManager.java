package Backbone;

import java.io.File;


import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;

public class XMLManager {
	
	public String[] readXML(String userid) {
		 try {
			 	File fXmlFile;
			 
			 	if(System.getProperty("os.name").equals("Linux")){
					
					fXmlFile = new File(System.getProperty("user.dir")+"/"+userid+".xml");

				}else{
					
					fXmlFile = new File(System.getProperty("user.dir")+"\\"+userid+".xml");

				}
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(fXmlFile);

				doc.getDocumentElement().normalize();

				System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

				NodeList nList = doc.getElementsByTagName("user");

				System.out.println("----------------------------");

				for (int temp = 0; temp < nList.getLength(); temp++) {

					Node nNode = nList.item(temp);

					if (nNode.getNodeType() == Node.ELEMENT_NODE) {

						Element eElement = (Element) nNode;

						String email = eElement.getAttribute("email");
						String first =  eElement.getAttribute("first");
						String last = eElement.getAttribute("last");
						String user = eElement.getAttribute("userid");
						String pass = eElement.getAttribute("pass");
						
						String[] data = {email,first,last,user,pass};
						
						return data;
					}
				}
			    } catch (Exception e) {
				e.printStackTrace();
				return null;
			    }
		return null;
			  }

	public void saveToXML(String email, String pass, String userid, String first, String last) {
		
		try {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		// root elements
		Document doc = docBuilder.newDocument();
		
		Element staff = doc.createElement("user");
		doc.appendChild(staff);

		// set attribute to staff element
		// shorten way
		// staff.setAttribute("id", "1");
		
		staff.setAttribute("email", email);
		System.out.println(email);
		staff.setAttribute("pass", pass);
		System.out.println(pass);
		System.out.println(userid);
		System.out.println(first);
		System.out.println(last);
		staff.setAttribute("userid", userid);
		staff.setAttribute("first", first);
		staff.setAttribute("last", last);
		

		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		
		StreamResult result;
		
		if(System.getProperty("os.name").equals("Linux")){
		
			result = new StreamResult(
					new File(System.getProperty("user.dir")+"/"+userid+".xml"));
		}else{
			
			result = new StreamResult(
					new File(System.getProperty("user.dir")+"\\"+userid+".xml"));
			
		}
		// Output to console for testing
		// StreamResult result = new StreamResult(System.out);

		transformer.transform(source, result);

		System.out.println("File saved!");

	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
}

	
	public static void main(String[] args) {
		
		
		
		
		
		
	}

}
