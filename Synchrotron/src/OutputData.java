import java.io.File;
import java.io.FileNotFoundException;
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
		importData("sample1_spot1_000.e", false);
		return;
	}

	public static ArrayList<ArrayList<Double>> importData(String fileName, boolean isReference) throws FileNotFoundException { // imports the data from a file
		ArrayList<Double> rawData = new ArrayList<Double>(); // all data dumped here
		if (isReference) { // reads either reference or cooked data
			File dataFile = new File(".\\references\\" + fileName);
			rawData = readSomeData(dataFile);
		} else {
			File dataFile = new File(".\\cooked\\" + fileName);
			rawData = readSomeData(dataFile);
		}
		// System.out.println(rawData);
		// organizes data

		ArrayList<Double> energyData = energyData(rawData); // separates data into 2 things
		ArrayList<Double> absorbtionData = absorbtionData(rawData);

		ArrayList<ArrayList<Double>> formattedData = new ArrayList<ArrayList<Double>>();
		formattedData.add(energyData);
		formattedData.add(absorbtionData);
		System.out.println(formattedData);
		return formattedData;
	}

	public static ArrayList<Double> readSomeData(File dataFile) throws FileNotFoundException { // reads in the data from the stuff
		Scanner readData = new Scanner(dataFile);
		ArrayList<Double> dataPoints = new ArrayList<Double>();
		while (readData.hasNext()) {
				dataPoints.add(Double.parseDouble(readData.next()));
		}
		readData.close();
		return dataPoints;
	}

	public static ArrayList<Double> energyData(ArrayList<Double> dataPoints) { // lists out energy data
		ArrayList<Double> energy = new ArrayList<Double>();
		for (int x = 0; x < dataPoints.size(); x++) {
			if (x % 2 == 0) {
				energy.add(dataPoints.get(x));
			}
		}
		return energy;
	}

	public static ArrayList<Double> absorbtionData(ArrayList<Double> dataPoints) { // lists out absorption data
		ArrayList<Double> absorbtion = new ArrayList<Double>();
		for (int x = 0; x < dataPoints.size(); x++) {
			if (x % 2 == 1) {
				absorbtion.add(dataPoints.get(x));
			}
		}
		return absorbtion;
	}
}
