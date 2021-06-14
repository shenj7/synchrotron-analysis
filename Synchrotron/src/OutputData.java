import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * OutputData.java
 * 
 * @author: Jackson Shen
 * 
 * Generates data to graph within rstudio.
 */
public class OutputData {
	public static void main(String[] args) throws FileNotFoundException {
		importData("sample1_spot1_000.r", false);
	}
	
	public static ArrayList<ArrayList<Double>> importData(String fileName, boolean isReference) throws FileNotFoundException {
		ArrayList<Double> energyData = new ArrayList<Double>(); // seperates data into 2 things
		ArrayList<Double> absorbtionData = new ArrayList<Double>();
		if (isReference) { // reads either reference or cooked data
			File dataFile = new File(".\\references\\" + fileName);
			readSomeData(dataFile);
		} else {
			File dataFile = new File(".\\cooked\\" + fileName);
			readSomeData(dataFile);
		}
		ArrayList<ArrayList<Double>> formattedData = new ArrayList<ArrayList<Double>>();
		formattedData.add(energyData);
		formattedData.add(absorbtionData);
		return formattedData;
	}
	
	public static void readSomeData(File dataFile) throws FileNotFoundException {
		Scanner readData = new Scanner(dataFile);
		while (readData.hasNext()) {
			if (readData.hasNextInt()) {
				System.out.println(readData.nextInt());
			}
		}
		readData.close();
	}
}
