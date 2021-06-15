import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

/* 
 * Superclass of data
 * 
 * Brings in data from files, finds linear combinations 
 * 
 * import known species, given species, find linear combinations that match
 * 
 * @author: Jackson Shen
 * 
 * Methods: 
 * https://www.tutorialspoint.com/How-to-read-a-2d-array-from-a-file-in-java
 */
public class DataAnalysis {
	HashMap<Double, Double[]> knownSpecies = new HashMap<Double, Double[]>(); // known species to compare
	ArrayList<Integer[][]> givenSpecies = new ArrayList<Integer[][]>(); // given species to analyze
	
	
	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<Double> sample1 = DataManipulation.importData("sample1_spot1_000.e", false);
		ArrayList<Double> energyS1 = DataManipulation.energyData(sample1);
		ArrayList<Double> absS1 = DataManipulation.absorbtionData(sample1);
		System.out.println(DataManipulation.maxAbsorbtionEnergy(energyS1, absS1));
		return;
	}
}
