package sc_utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Utility {
	
	private static Random rand = new Random();
	
	/**
	 * Randomly returns true with a given probability.
	 * 
	 * For example it you call it with an argument of <code>25.0</code> then it will return true 25% of the time.
	 * Will always return true if p>=100 and false if p<=0
	 * 
	 * @param p A probability expressed in percent.
	 * @return true of false randomly, as defined by p.
	 */
	public static boolean prob(double p) {
		if(p >= 100) return true;
		else if(p <= 0) return false;
		double i = rand.nextDouble() * 100 + 1;
		if(i > p) return false;
		else return true;
	}
	
	/**
	 * Randomly selects an object from an array.
	 * 
	 * @param args an array to pick from.
	 * @return a random element from args.
	 */
	public static Object pick(Object[] args) {
		int i = rand.nextInt(args.length);
		return args[i];
	}
	
	/**
	 * Picks a random element from a list.
	 * @param args A list to pick items from
	 * @return an element from args.
	 */
	public static Object pick(List<Object> args) {
		return pick(args.toArray());
	}
	
	public static String file2text(File file) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String toReturn = "";
		while(reader.ready()) {
			toReturn += reader.readLine();
			toReturn += System.getProperty("line.seperator");
		}
		reader.close();
		return toReturn;
	}
	
	/**
	 * Reads the lines from a file and stores them in a list.
	 * Does not include line terminators.
	 * 
	 * @param file A file pointer to read from.
	 * @return A list containing the lines from the file.
	 * @throws IOException
	 */
	public static List<String> file2list(File file) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		List<String> toReturn = new LinkedList<String>();
		while(reader.ready()) {
			toReturn.add(reader.readLine());
		}
		reader.close();
		return toReturn;
	}
	
	public static boolean sleep(long millis, int nanos) {
		try {
			Thread.sleep(millis, nanos);
			return true;
		} catch (InterruptedException e) {
			return false;
		}
	}
	
	/**
	 * Returns an instance of t
	 * @param t The class to instantiate
	 * @return a new instance of t
	 */
	public static Object create(Class<?> t) {
		try {
			return t.newInstance();
		} catch (Exception e) {
			return null;
		}
	}
}
