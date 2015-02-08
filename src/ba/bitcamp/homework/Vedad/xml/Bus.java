package ba.bitcamp.homework.Vedad.xml;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Class that creates Bus and also add Buses into Linked list called
 * busStationLines. Class receives two parameters numBus - number of bus line
 * and nameLine - City name or name of line that bus goes.
 * 
 * @author amrapoprzanovic
 *
 */
public class Bus {

	private int numBus;
	private String busLine;
	private LinkedList<Bus> busStationLines = new LinkedList<Bus>();

	/**
	 * Constructor for Bus.
	 * 
	 * @param numBus
	 *            - number of bus line.
	 * @param busLine
	 *            - City name or name of line that bus goes.
	 */
	public Bus(int numBus, String busLine) {
		this.numBus = numBus;
		this.busLine = busLine;
	}

	/**
	 * Adds new Bus into linked list called busStationLines.
	 * 
	 * @param bus
	 *            - new Bus that we want to add.
	 */
	public void addBus(Bus bus) {
		this.busStationLines.add(bus);
	}

	/**
	 * Getter for Bus.
	 * 
	 * @return bust line.
	 */
	public String getBus() {
		return busLine;
	}

	/**
	 * Getter for LinkedList busStationLine.
	 * 
	 * @return LInkedList busStatinLines.
	 */
	public LinkedList<Bus> getBusStation() {
		return busStationLines;
	}

	/**
	 * Converts all elements of this class into String;
	 */
	public String toString() {
		String str1 = "";
		str1 += "Number of bus: " + numBus + ", Bus line: " + busLine + "\n";

		String str2 = "";
		Iterator iter = busStationLines.iterator();
		while (iter.hasNext()) {
			str2 += "bus = " + iter.next().toString();
		}

		return str1 + str2;
	}

	/**
	 * Converts list of elements to xml document.
	 * 
	 * @param busStation
	 *            - list of busses.
	 * @param os
	 *            - stream that we use to address file name
	 */
	public static void toXML(List busStation, OutputStream os) {
		PrintWriter pw = new PrintWriter(os);
		pw.println("<?xml version=\"1.0\"?>");
		pw.println("<busStation>");
		Iterator<Bus> it = busStation.iterator();
		while (it.hasNext()) {
			Bus temp = it.next();
			pw.println("<bus number='" + temp.numBus + "'  busLine= '"
					+ temp.busLine + "'>");
			Iterator<Bus> itChild = temp.busStationLines.iterator();
			while (itChild.hasNext()) {
				Bus tempChild = itChild.next();
				pw.println("    <busLine number='" + tempChild.numBus
						+ "'  busLine= '" + tempChild.busLine + "'/>");
			}
			pw.println(" </bus>");
		}
		pw.println("</busStation>");
		pw.flush();
	}

}
// end of class
