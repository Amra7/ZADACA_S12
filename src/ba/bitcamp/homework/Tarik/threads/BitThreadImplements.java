package ba.bitcamp.homework.Tarik.threads;

import java.net.MalformedURLException;

public class BitThreadImplements implements Runnable {

	private String name;
	private String url;

	public BitThreadImplements(String name, String url) {
		this.name = name;
		this.url = url;
	}

	@Override
	public void run() {

		try {
			Crawler crawler = new Crawler(name, url);
			Crawler.NUM_OF_CRAWLS_DONE++;
			System.out.println("NUM_OF_CRAWLS_DONE: "
					+ new Integer(Crawler.NUM_OF_CRAWLS_DONE).toString());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Hello from thread that implements Runnable: " +  name);
		System.out.println("______________________________________________________");
	}

}
