import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Apriori {

	public int minSup;
	public int minConf;
	public int hfRange;
	public int maxLeafSize;
	public String inputFile;
	public String outputFile;
	
	public int getMinSup() {
		return minSup;
	}

	public void setMinSup(int minSup) {
		this.minSup = minSup;
		System.out.println(this.minSup);
	}

	public int getMinConf() {
		return minConf;
	}

	public void setMinConf(int minConf) {
		this.minConf = minConf;
	}

	public int getHfRange() {
		return hfRange;
	}

	public void setHfRange(int hfRange) {
		this.hfRange = hfRange;
	}

	public int getMaxLeafSize() {
		return maxLeafSize;
	}

	public void setMaxLeafSize(int maxLeafSize) {
		this.maxLeafSize = maxLeafSize;
	}

	public String getInputFile() {
		return inputFile;
	}

	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}

	public String getOutputFile() {
		return outputFile;
	}

	public void setOutputFile(String outputFile) {
		this.outputFile = outputFile;
	}

	public Apriori(String[] args){
		this.setMinSup(Integer.parseInt(args[0]));
		this.setMinConf(Integer.parseInt(args[1]));
		this.setInputFile(args[2]);
		this.setOutputFile(args[3]);
		this.setHfRange(Integer.parseInt(args[4]));
		this.setMaxLeafSize(Integer.parseInt(args[5]));
	}
	
	public void createTransactionTable(){
		
	}
	
	public static void main(String[] args) {
		
		Apriori aprInst = new Apriori(args);
		
		createTransactionTable();
		try{
			File file = new File();
			Scanner ip = new Scanner(file);
			String l1 = ip.nextLine();
			System.out.println("line" + l1);
		} catch (FileNotFoundException ex){
			System.out.println("File not found");
		}
	}

}
