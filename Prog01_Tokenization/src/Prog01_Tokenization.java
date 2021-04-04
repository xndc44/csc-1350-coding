/** 
* <Main method that parses files>
*
* CSC 1351 Programming Project No <Prog01>  
* Section <002>
* @author <Patrick Adeosun>
* @since <Feb. 1>
* 
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import java.util.StringTokenizer;
public class Prog01_Tokenization {

	public static void main(String[] args) throws FileNotFoundException {

		try {
			String inputline = Tokenizer.EvalFile();
			String [] Tokens = Tokenizer.bSort(inputline);
			int[] TokenCount = Tokenizer.WordCounter(Tokens);
			String[] finalTokens = Tokenizer.firstarray(Tokens, TokenCount);
			int[] finalTcount = Tokenizer.secondarray(Tokens, TokenCount);
			Tokenizer.OutputTokens(finalTokens, finalTcount);
		}
		catch (FileNotFoundException exception) 
		{
			exception.printStackTrace();
		}
		catch (NumberFormatException exception) {
			System.out.println("Input was not a number");
		
		}
		
	
	}//main
	
	
	
}
