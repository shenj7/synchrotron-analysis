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

 */
public class DataAnalysis {
	HashMap<Double, Double[]> knownSpecies = new HashMap<Double, Double[]>(); // known species to compare
	ArrayList<Integer[][]> givenSpecies = new ArrayList<Integer[][]>(); // given species to analyze
	
	String[] knownSampleFileNames = {"4-acetamidothiophenol TEY",
	"4-aminothiophenol TEY",
	"4-nitrobenzenethiol TEY",
	"Aromatic-SH1",
	"Aromatic-SH2",
	"Cyclohexane sulfonic acid sodium TEY_AM_bs",
	"Cysteine",
	"Cystine",
	"DibenzoThiophene",
	"Dibenzyl_Disulfide",
	"Dibenzyl_Sulfide",
	"dihydrodibenzothiepin",
	"Dothiepin",
	"gypsum ref TEY",
	"HOPhSPhOH",
	"Met-methylsulfonium",
	"Methionine",
	"Octoclothepin",
	"PhCH2SPh",
	"Phenothiazine",
	"PolyPhenyleneSulfide",
	"pyrite TEY SBOC_AM_bs",
	"Pyrrhotite TEY S XANES ave2",
	"S elemental",
	"S metal TEY SBOC_AM_bs",
	"S standard TEY SBOC_AM_bs",
	"Sulfate_Na",
	"Sulfite",
	"Sulfonate",
	"Sulfone",
	"Sulfoxide",
	"Thianthrene",
	"Trimethylsulfonium",
	"ZnSO3_SXANES_dma",
	"ZnSO4_SXANES_dma"
	};
	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<Double> sample1 = DataManipulation.importData("sample1_spot1_000.e", false);
		ArrayList<Double> energyS1 = DataManipulation.energyData(sample1);
		ArrayList<Double> absS1 = DataManipulation.absorbtionData(sample1);
		System.out.println(DataManipulation.maxAbsorbtionEnergy(energyS1, absS1));
		return;
	}
}
