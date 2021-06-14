import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class DataImport {
	public ArrayList<ArrayList<Double>> importData(String fileName, boolean isReference) throws FileNotFoundException {
		ArrayList<Double> energyData = new ArrayList<Double>(); // seperates data into 2 things
		ArrayList<Double> absorbtionData = new ArrayList<Double>();
		if (isReference) { // reads either reference or cooked data
			File dataFile = new File("src/references/" + fileName);
			Scanner readData = new Scanner(dataFile);
			while (readData.hasNext()) {
				if (readData.hasNextInt()) {
					System.out.println(readData.nextInt());
				}
			}
		} else {
			File dataFile = new File("src/cooked/" + fileName);
			FileReader readData = new FileReader(dataFile);
		}
		ArrayList<ArrayList<Double>> formattedData = new ArrayList<ArrayList<Double>>();
		formattedData.add(energyData);
		formattedData.add(absorbtionData);
		return formattedData;
	}
}
