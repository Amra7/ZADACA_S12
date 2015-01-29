package ba.bitcamp.homework.Benjo.xmlrss;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadKlix {

	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException {

		URL rssUrl = new URL("http://www.klix.ba/rss/svevijesti");
		DocumentBuilder docReader = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();
		Document xmldoc = docReader.parse(rssUrl.openStream());

		System.out.println("Root element: "
				+ xmldoc.getDocumentElement().getNodeName());
		// System.out.println("Child root element: " +
		// xmldoc.getDocumentElement().getFirstChild());

		NodeList xmlItem = xmldoc.getElementsByTagName("item");

		LinkedList<Article> articles = new LinkedList<Article>();
		LinkedList<Article> singleArticle = new LinkedList<Article>();

		String title = "";
		String article = "";
		for (int i = 0; i < xmlItem.getLength(); i++) {
			Node current = xmlItem.item(i);
			if (current instanceof Element) {

				NodeList innerArticle = current.getChildNodes();

				for (int j = 0; j < innerArticle.getLength(); j++) {
					Node innerCurrent = innerArticle.item(j);
					if (innerCurrent instanceof Element) {
						Element innerCurrentElement = (Element) innerCurrent;

						if (innerCurrent.getNodeName()
								.equalsIgnoreCase("title")) {
							title = current.getTextContent();
							System.out.println("Title: \n" + title);
							System.out.println("_________________________________________________________");
						}
						// if(current.getNodeName().equalsIgnoreCase("uvod")){
						// String uvod = current.getTextContent();
						// System.out.println("uvod: \n" + uvod );
						// }

						if (innerCurrent.getNodeName().equalsIgnoreCase(
								"clanak")) {
							article = current.getTextContent();
							System.out.println("Article: \n" + article);
							System.out.println("_________________________________________________________");
						}

					}

				}
				singleArticle.add(new Article(title, article));

			}
		}
		Scanner scan =  new Scanner(System.in);
		System.out.println("Unesi broj clanka: ");
		int numArticle = scan.nextInt();
		int count = 0;

		 Iterator<Article> iter = articles.iterator();
		 while( iter.hasNext()){
			 count++;
			 Article art = iter.next();
			 if (count == numArticle){
				 System.out.println("-------------------------------------------------------------------------------");
				 System.out.println();
				 System.out.printf("Trazili ste clanak pod brojem %d %s \n", numArticle, art.toString());
				 break;
			 }
		
		 }
	}

	// end of main class
}
