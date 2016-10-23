import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Vector;

public class Apriori {

	private int minSup;
	private int minConf;
	private int hfRange;
	private int maxLeafSize;
	private String inputFile;
	private String outputFile;
	
	HashMap<String, Vector<Integer>> transactionTable = new HashMap<String, Vector<Integer>>();
	HashMap<String, Integer> itemsetSupportPairs = new HashMap<String, Integer>();
	HashMap<Integer, Vector<Integer>> frequentKItemset = new HashMap<Integer, Vector<Integer>>();
	
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
	
	public void createTransactionTable(String[] transaction){
		if (transactionTable.containsKey(transaction[0])){
			transactionTable.get(transaction[0]).add(Integer.parseInt(transaction[1]));
		} 
		else {
			Vector<Integer> itemSet = new Vector<Integer>();
			itemSet.add(Integer.parseInt(transaction[1]));
			transactionTable.put(transaction[0], itemSet);
		}
		System.out.println("Here you go :" + transactionTable);
	}
	
	public void createInitialItemset(String[] transaction){
		int supCount = itemsetSupportPairs.containsKey(transaction[1]) ? itemsetSupportPairs.get(transaction[1]) : 0;
		itemsetSupportPairs.put(transaction[1], supCount+1);
		System.out.println("Support :" + itemsetSupportPairs);
	}
	
	public void generateInitialFrequentItemset(){
		for ( Entry<String, Integer> itemset : itemsetSupportPairs.entrySet()){
			System.out.println("Key : " + itemset.getKey());
			System.out.println("Value : " + itemset.getValue());
		}
	}
	
	public void readTransactionFile(){
		try{
			File file = new File(this.inputFile);
			Scanner readInput = new Scanner(file);
			while (readInput.hasNextLine()){
				String trans[] = readInput.nextLine().split("\\s+");
				createTransactionTable(trans);
				createInitialItemset(trans);
			}
			readInput.close();
		} catch (FileNotFoundException ex){
			System.out.println("File not found");
		}
	}
	
	public static void main(String[] args) {
		Apriori aprInst = new Apriori(args);
		aprInst.readTransactionFile();
		aprInst.generateInitialFrequentItemset();
	}

}
