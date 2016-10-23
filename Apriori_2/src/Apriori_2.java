import java.io.File;
import java.io.FileNotFoundException;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Vector;

public class Apriori_2 {

	private int minSup;
	private int minConf;
	private int hfRange;
	private int maxLeafSize;
	private String inputFile;
	private String outputFile;
	private int k;
	
	TreeMap<String, String> transactionTable = new TreeMap<String, String>();
	TreeMap<String, Integer> itemsetSupportPairs = new TreeMap<String, Integer>();
	TreeMap<Integer, TreeMap<String, Integer>> frequentKItemset = new TreeMap<Integer, TreeMap<String, Integer>>();
	TreeMap<String, Integer> candidateItemset = new TreeMap<String, Integer>();
	
	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}

	public int getMinSup() {
		return minSup;
	}

	public void setMinSup(int minSup) {
		this.minSup = minSup;
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

	public Apriori_2(String[] args){
		this.setMinSup(Integer.parseInt(args[0]));
		this.setMinConf(Integer.parseInt(args[1]));
		this.setInputFile(args[2]);
		this.setOutputFile(args[3]);
		this.setHfRange(Integer.parseInt(args[4]));
		this.setMaxLeafSize(Integer.parseInt(args[5]));
		this.setK(1);
	}
	
	public void createTransactionTable(String[] transaction){
		String itemSet = transactionTable.containsKey(transaction[0]) ? transactionTable.get(transaction[0]) + "," + transaction[1] : transaction[1];
		transactionTable.put(transaction[0], itemSet);
	}
	
	public void createInitialItemset(String[] transaction){
		int supCount = itemsetSupportPairs.containsKey(transaction[1]) ? itemsetSupportPairs.get(transaction[1]) : 0;
		itemsetSupportPairs.put(transaction[1], supCount+1);
	}
	
	public void generateInitialFrequentItemset(){
		for ( Entry<String, Integer> itemSet : itemsetSupportPairs.entrySet()){
			if (itemSet.getValue() >= this.minSup){
				if (frequentKItemset.containsKey(1)){
					frequentKItemset.get(this.k).put(itemSet.getKey(), itemSet.getValue());
				} 
				else {
					TreeMap<String, Integer> ISPair = new TreeMap<String, Integer>();
					ISPair.put(itemSet.getKey(), itemSet.getValue());
					frequentKItemset.put(this.k, ISPair);
				}
			}
		}
		System.out.println("Frequent 1 itemset : " + frequentKItemset);
	}
	
	public void generateFrequentKItemsets(){
		this.k++;
		if(this.k-2 < 1){
			for ( Entry<String, Integer> frequentItemset1 : frequentKItemset.get(1).entrySet()){
				for ( Entry<String, Integer> frequentItemset2 : frequentKItemset.get(1).entrySet()){
					candidateItemset.put(frequentItemset1.getKey() + "," + frequentItemset2.getKey(), 0);
				}
			}
		}
		else {
			
		}
		System.out.println("Candidate : " + candidateItemset);
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
		Apriori_2 aprInst = new Apriori_2(args);
		aprInst.readTransactionFile();
		aprInst.generateInitialFrequentItemset();
		aprInst.generateFrequentKItemsets();
	}

}