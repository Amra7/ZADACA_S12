package ba.bitcamp.homework.Tarik.threads;

import java.net.MalformedURLException;

public class BitThreadExtends extends Thread {

	private String name;
	private String url;

	public BitThreadExtends(String name, String url) {
		this.name = name;
		this.url = url;

	}

	public void run() {
		try {
			Crawler crawl = new Crawler(name, url);
			Crawler.NUM_OF_CRAWLS_DONE++;
			System.out.println("NUM_OF_CRAWLS_DONE: "
					+ new Integer(Crawler.NUM_OF_CRAWLS_DONE).toString());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Hello from thread that extends Thread: "+ name);
		System.out.println("______________________________________________");

	}
}
