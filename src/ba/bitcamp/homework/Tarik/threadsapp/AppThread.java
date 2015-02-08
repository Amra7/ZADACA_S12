package ba.bitcamp.homework.Tarik.threadsapp;

import java.net.MalformedURLException;
/**
 * The AppThread class within which this Crawler instance is running.
 * @author amrapoprzanovic
 *
 */
public class AppThread extends Thread {

	private String name;
	private String url;
	
	/**
	 * Constructor for AppThread with two parameters.
	 * @param name - name of thread.
	 * @param url - different addresses to resource onInternet.
	 */
	public AppThread ( String name, String url){
		this.name = name;
		this.url = url;
		
	}
	
	@Override
	public void run() {
	
		
		try {
			Crawler crawler  = new Crawler(name, url);
			Crawler.pagesCrawled++;
			System.out.println("Num of crawled pages: " + new Integer(Crawler.pagesCrawled).toString());
		
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Hello froem thred that extends Thread: " + name);
		System.out.println("______________________________________________");
		}
}
