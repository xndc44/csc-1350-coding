import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.PrintWriter;

import javax.swing.JFileChooser;

public class Tokenizer {
	
	/** 
	* <User Chooses the file>
	*
	* CSC 1351 Programming Project No <Prog01>  
	* Section <002>
	* @author <Patrick Adeosun>
	* @since <Feb. 1>
	* 
	*/
	
	public static String EvalFile() throws FileNotFoundException {
		String line = "";
		JFileChooser chooser = new JFileChooser();
		Scanner in = null;
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File inputFile = chooser.getSelectedFile();
			in = new Scanner(inputFile);
		
		}//Jfile
		
		while (in.hasNextLine()) {
			
		line = in.nextLine();
		}//while
		return line;	
		
	}
	
	/** 
	* <Bubble Sorts the files>
	*
	* CSC 1351 Programming Project No <Prog01>  
	* Section <002>
	* @author <Patrick Adeosun>
	* @since <Feb. 1>
	* 
	*/
	
	public static String[] bSort (String line) throws FileNotFoundException {
		String Input = line.toLowerCase().replaceAll("[^a-z0-0'$\\s]","");
		String[] tokens = Input.split(" ");
		
		for (int i = 0; i < tokens.length;i++) {
			for (int j = i + 1; j < tokens.length; j++) {
				if (tokens[i].equals(tokens[j])) {
					String temp = tokens[j-1];
					tokens[j-1] = tokens[j];
					tokens[j] = temp;
				}
			}
		
		}
		return tokens;
	}
	
	/** 
	* <Counts how many words there are in the file>
	*
	* CSC 1351 Programming Project No <Prog01>  
	* Section <002>
	* @author <Patrick Adeosun>
	* @since <Feb. 1>
	* 
	*/
	
	public static int[]WordCounter(String[]Tokens) throws FileNotFoundException {
		int wordcounter = 1;
		String[] arr = Tokens;
		int wordcounter1[] = new int [arr.length];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i].equals(arr[j])) {
					wordcounter = wordcounter + 1;
					arr[j] = "";
				}
			}
			if (arr[i] != "") {
				wordcounter1[i] = wordcounter;
				wordcounter = 1;
			}
		}
		return wordcounter1;
	}
	
	/** 
	* <organizes indexies>
	*
	* CSC 1351 Programming Project No <Prog01>  
	* Section <002>
	* @author <Patrick Adeosun>
	* @since <Feb. 1>
	* 
	*/
	
	public static String[] firstarray(String[] Tokens, int[]wCount) throws FileNotFoundException {
		int dups = 0;
		
		for (int i = 1; i < Tokens.length; i++) {
			if (Tokens[i].equals("")) {
				dups++;
			}
		}
		String[] rArray = new String[Tokens.length - dups];
		rArray[0] = Tokens [0];
		int count = 1;
		for (int i = 1; i < Tokens.length; i++) {
			if (!Tokens[i].equals("")) {
				rArray[count] = Tokens[i];
				count++;
			}
		}
		return rArray;
	}


/** 
* <creates 2 parallel arrays>
*
* CSC 1351 Programming Project No <Prog01>  
* Section <002>
* @author <Patrick Adeosun>
* @since <Feb. 1>
* 
*/

	public static int[] secondarray(String [] Tokens, int[]wCount) throws FileNotFoundException {
		int dups = 0;
	
		for (int i = 1; i < Tokens.length; i++) {
			if (Tokens[i].equals("")) {
			dups++;
			}
		}
	
		String [] rArray = new String[Tokens.length - dups];
		int[] tCount = new int [wCount.length - dups];
		
		rArray[0] = Tokens[0];
		tCount[0] = wCount [0];
		int count =1;
		
		for (int i =1; i < Tokens.length; i++) {
			if (!Tokens[i].equals("")) {
				tCount[count] = wCount[i];
				count++;
			}
		}
		return tCount;
}

/** 
* <Prints data into user's choice location>
*
* CSC 1351 Programming Project No <Prog01>  
* Section <002>
* @author <Patrick Adeosun>
* @since <Feb. 1>
* 
*/

	public static void OutputTokens (String[]finalToken, int[]finalTcount) throws FileNotFoundException {
		JFileChooser chooser = new JFileChooser();
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
		
			File outFile = chooser.getSelectedFile();
			PrintWriter out = new PrintWriter(outFile);
			
			for (int i = 0; i < finalToken.length; i++) {
				out.println(finalToken[i] + "," + finalTcount[i]);
			}
			
			out.close();
		}
	}
}