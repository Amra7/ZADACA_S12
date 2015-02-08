package ba.bitcamp.homework.Tarik.threadsapp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * WebCrawler class in the AppThread class that is executed by each crawler
 * thread.
 * @author amrapoprzanovic
 *
 */
public class Crawler {

	private static final int BUFFER_SIZE = 4000;

	public static volatile int pagesCrawled = 0;
	public static final String filePath = "./File/crawled.txt/";

	/**
	 * Constructor for Crawler takes two parameters.
	 * @param outputFileName - file name where we are saving urls.
	 * @param url  -different addresses to resource onInternet.
	 * @throws MalformedURLException
	 */
	public Crawler(String outputFileName, String url)
			throws MalformedURLException {
		getUrlContents(outputFileName, url);
		writeToCrawlingDiaries(url);
	}

	public static void getUrlContents(String outputFileName, String url)
			throws MalformedURLException {
		URL urlObject = new URL(url);
		try {
			URLConnection connection = urlObject.openConnection();
			InputStream is = connection.getInputStream();
			FileOutputStream fos = new FileOutputStream(filePath);

			int byteReads = -1;
			byte[] buffer = new byte[BUFFER_SIZE];
			while ((byteReads = is.read(buffer)) >= 0) {
				fos.write(buffer, 0, byteReads);
			}
			fos.close();
			is.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	/**
	 * Method that synchronized writing urls into file cawlingDiaries.txt after every thread finishes.
	 * @param url  - different addresses to resource onInternet.
	 */
	public static synchronized void writeToCrawlingDiaries(String url) {
		File cawlingDiaries = new File("./File/cawlingDiaries.txt");

		SimpleDateFormat sdf = new SimpleDateFormat("[ yyyy-MM-dd  H:mm:ss ]");
		Date date = new Date();
		String enterDate = sdf.format(date);
		FileWriter fr;
		try {
			fr = new FileWriter(cawlingDiaries, true);
			fr.write(enterDate.toString());
			fr.write(url.toString() + "\n");
			fr.flush();
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

} // end of class
