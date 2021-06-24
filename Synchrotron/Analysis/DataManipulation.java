import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

/*
 * OutputData.java
 * 
 * @author: Jackson Shen
 * 
 * Generates data to graph within rstudio.
 * 
 * Library of functions to do to data
 */
public class DataManipulation {

	public static ArrayList<Double> importData(String fileName, boolean isReference) throws FileNotFoundException { // imports the data from a file
		ArrayList<Double> rawData = new ArrayList<Double>(); // all data dumped here
		if (isReference) { // reads either reference or cooked data
			File dataFile = new File(".\\references\\" + fileName);
			rawData = readSomeData(dataFile);
		} else {
			File dataFile = new File(".\\cooked\\" + fileName);
			rawData = readSomeData(dataFile);
		}

		return rawData;
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

	public static Double maxAbsorbtionEnergy(ArrayList<Double> energyData, ArrayList<Double> absorbtionData) { // finds the location of the max energy
		Double maxEnergy = 0.0;
		Double maxAbsorbtion = 0.0;
		for (int x = 0; x < energyData.size(); x++) {
			if (absorbtionData.get(x)>maxAbsorbtion) {
				maxAbsorbtion = absorbtionData.get(x);
				maxEnergy = energyData.get(x);
			}
		}
		return maxEnergy;
	}

	public static Double meanSqDiff(ArrayList<Double> sample, ArrayList<Double> sumOfKnowns) throws ArrayIndexOutOfBoundsException { // finds the average square difference between the sample and the combination of the known samples.
		if (sample.size() != sumOfKnowns.size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		Double mssd = 0.0;
		for (int x = 0; x < sample.size(); x++) {
			mssd = mssd + (sample.get(x)-sumOfKnowns.get(x));
		}
		mssd = mssd/sample.size();
		return mssd;
	}

	public static HashMap<Double, Double> graphingData(ArrayList<Double> energyData, ArrayList<Double> absorbtionData) { // creates an array that has filled in areas
		HashMap<Double, Double> graphThis = new HashMap<Double, Double>();
		for (int i = 0; i < energyData.size(); i++){
			graphThis.put(((int)(energyData.get(i)*10000))/10000.0, absorbtionData.get(i));
		}
		Double x = 2480.0; // change this bound based on cooked data - this basically makes the range 2440 to 2570 - smaller for testing purposes
		Double current = absorbtionData.get(0);
		while (x < 2482.0){
			x = ((int)(x*10000))/10000.0;
			if (graphThis.containsKey(x)){
				current = graphThis.get(x);
			}
			if (!graphThis.containsKey(x)){
				graphThis.put(x, current);
				// add in average or smth
			}
			x = x + 0.0001; // fill in the data in between points
		}
		return graphThis;
	}
}
