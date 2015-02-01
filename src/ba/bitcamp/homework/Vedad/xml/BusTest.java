package ba.bitcamp.homework.Vedad.xml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.LinkedList;

/**
 * Class that test class Bus.
 * Contains main methods and adds example of buses into new LinkedList of Buses.
 * This class converts Bus to xml document.
 * @author amrapoprzanovic
 *
 */
public class BusTest {

	public static void main(String[] args) {
		
		Bus b1 = new Bus(1, "Zenica");
		Bus b2 = new Bus(2, "Sarajevo");
		Bus b3 = new Bus(3, "Tuzla");
		Bus b4 = new Bus(4, "Mostar");
		Bus b5 = new Bus(5, "Zagreb");
		Bus b6 = new Bus(6, "Beograd");
		
		b1.addBus(new Bus(11, "Mostar"));
		b1.addBus(new Bus(12, "Tuzla"));
		b1.addBus(new Bus(13, "Bec"));
		
		b2.addBus(new Bus(21, "Bec"));
		b2.addBus(new Bus(22, "Graz"));
		b2.addBus(new Bus(23, "Ljubljana"));
		
		b3.addBus(new Bus(31, "Mostar"));
		b3.addBus(new Bus(32, "Zagreb"));
		b3.addBus(new Bus(33, "Beograd"));
		
		b4.addBus(new Bus(41, "Neum"));
		b4.addBus(new Bus(42, "Split"));
		b4.addBus(new Bus(43, "Rijeka"));
		
		b5.addBus(new Bus(51, "Bec"));
		b5.addBus(new Bus(52,"Split"));
		b5.addBus(new Bus(53, "Beograd"));
		
		b6.addBus(new Bus(61, "Skoplje"));
		b6.addBus(new Bus(62, "Podgorica"));
		b6.addBus(new Bus(63, "Sarajevo"));
		
		
		LinkedList<Bus> busStation = new LinkedList<Bus>();
		busStation.add(b1);
		busStation.add(b2);
		busStation.add(b3);
		busStation.add(b4);
		busStation.add(b5);
		busStation.add(b6);
		
		System.out.println(busStation.toString());
		
//		try {
//			Bus.toXML(busStation, new FileOutputStream("./XML/BusLinesStation.xml"));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
  }
	// end of main method
}
