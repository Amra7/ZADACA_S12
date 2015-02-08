package ba.bitcamp.homework.Tarik.threadsapp;

import java.io.File;

/**
 * Application class that reads URLs from arrays of String of URLs and read page
 * addresses (URLs) and sends them to the crawling mechanism .
 * 
 * @author amrapoprzanovic
 *
 */
public class Application {

	private static final String filePath = "/file/crawled";
	private static File outputDirectory = new File(filePath);

	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		String[] urls = new String[5];
		urls[0] = "http://www.archdaily.com/";
		urls[1] = "http://www.pik.ba/";
		urls[2] = "http://www.reddit.com/";
		urls[3] = "http://www.architonic.com/";
		urls[4] = "http://www.klix.ba/";

		if (!outputDirectory.exists()) {
			System.out.println("Output directory does not exist!");
			outputDirectory.mkdir();
			System.out.println("Output directory is created!");
		}
		for (int i = 0; i < urls.length; i++) {
			if (urls[i] != null) {
				AppThread appThread = new AppThread("Thread: "
						+ new Integer(i).toString(), urls[i]);
				appThread.start();
			}
		}

	} // end of main method
	
	
} //  end of class
