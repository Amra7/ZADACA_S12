package ba.bitcamp.homework.Vedad.xml;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 * Class that reads from xml document.
 * Contains main class.
 * @author amrapoprzanovic
 *
 */
public class BusXMLReader {

	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException {
		DocumentBuilder docReader = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();
		Document xmldoc = docReader
				.parse(new File("./XML/BusLinesStation.xml"));
		
		NodeList xmlBusStation = xmldoc.getElementsByTagName("bus");
		
		LinkedList<Bus> busStation = new LinkedList<Bus>();
		LinkedList<Bus> buses = new LinkedList<Bus>();
		
		for( int i=0; i<xmlBusStation.getLength(); i++){
			Node current = xmlBusStation.item(i);
			if ( current instanceof Element){
				Element currentElement = (Element)current;
				int numberOfBus = Integer.parseInt(currentElement.getAttribute("numBus"));
				String busLineName = currentElement.getAttribute("busLine");
				
//				Bus tempBus = new Bus(numberOfBus, busLineName);
				buses.add(new Bus(numberOfBus, busLineName));
				
				NodeList xmlCurrentChild = current.getChildNodes();
				for ( int j=0; j< xmlCurrentChild.getLength(); j++){
					Node currentChild = xmlCurrentChild.item(j);
					if( currentChild instanceof Element){
						Element currentChildElement =  (Element) currentChild;
						int numberOfBusChild = Integer.parseInt(currentChildElement.getAttribute("numBus"));
						String busLineNameChild = currentChildElement.getAttribute("busLine");
//						tempBus.addBus(new Bus( numberOfBusChild, busLineNameChild));
						buses.add(new Bus( numberOfBusChild, busLineNameChild));
						
					}
				}
				
				busStation.addAll(buses);
			}
			
		}

		Iterator<Bus> iter = busStation.iterator();
		while( iter.hasNext()){
			System.out.println(iter.next().toString());
		}
	}
	
	// end of class
}
