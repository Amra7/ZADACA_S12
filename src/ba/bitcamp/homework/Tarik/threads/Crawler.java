package ba.bitcamp.homework.Tarik.threads;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class Crawler {

	private static final int BUFFER_SIZE = 2020;
	private static final String saveFilePath = "/tmp/crawled/";
	public static volatile int NUM_OF_CRAWLS_DONE = 0;
	
	public Crawler(String url, String outputFileName ) throws MalformedURLException{
		getUrlContents(url, outputFileName);
	}

	private static void getUrlContents(String url, String outputFileName) throws MalformedURLException {
		URL urlObject  = new URL(url);
		
		try {
			URLConnection connection = urlObject.openConnection();
			InputStream in = connection.getInputStream();
			FileOutputStream out = new FileOutputStream(saveFilePath);
			
			int byteReads = -1;
			byte[]buffer = new byte[BUFFER_SIZE];
			while( (byteReads = in.read()) >= 0){
				out.write(buffer, 0, byteReads);
			}
			out.close();
			in.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
