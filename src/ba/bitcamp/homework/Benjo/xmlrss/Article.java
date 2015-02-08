package ba.bitcamp.homework.Benjo.xmlrss;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
/**
 * Class that creates article.
 * @author Amra
 *
 */
public class Article {

	public String title;
	public String article;
	
	/**
	 * Constructor for article.
	 * @param title
	 * @param article
	 */
	public Article(String title, String article){
		this.title = title;
		this.article =  article;
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Article [title=" + title + "\n article=" + article + "]";
	}
	

	
	
	
	
}
