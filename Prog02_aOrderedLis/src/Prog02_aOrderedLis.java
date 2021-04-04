

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Main class that reads a file, puts the elements into a sorted list, and then writes the results to a file.
 *
 * CSC 1351 Programming Project No 2
 * Section NA
 *
 * @author Roman Jones
 * @since 2/19/2019
 */
public class Prog02_aOrderedLis {
	
	
    /**
     * Opens the file located at the provided directory and returns a Scanner for that file.
     *
     * CSC 1351 Programming Project No 2
     * Section NA
     *
     * @author Roman Jones
     * @since 2/19/2019
     */
	public static Scanner GetInputFile(String UserPrompt) throws FileNotFoundException {
		
		Scanner fileScanner = null;                        // Scanner to read input file.
		boolean	needInputFile = true;
		
		// Prompts the user for a file location and loops until a file that can be opened by fileScanner is provided.
        // If the user chooses not to continue, stop looping and end the program.
        do {
            System.out.print(UserPrompt);
            Scanner fileLocationScanner = new Scanner(System.in);
            String fileName = fileLocationScanner.nextLine();
            System.out.println();
            
            try {
                fileScanner = new Scanner(new File(fileName));
                needInputFile = false;
            } catch (FileNotFoundException ex) {
                System.out.printf("File specified <%s> does not exist. Would you like to continue? <Y/N> ", fileName);
                if (fileLocationScanner.nextLine().toLowerCase().equals("n")) {
                    throw ex;
                }
                System.out.println();
            }
        }
        while (needInputFile);
        
        return fileScanner;
	}
	
    /**
     * Opens the file located at the provided directory and returns a PrintWriter to write to that file.
     *
     * CSC 1351 Programming Project No 2
     * Section NA
     *
     * @author Roman Jones
     * @since 2/19/2019
     */
    public static PrintWriter GetOutputFile(String userPrompt) throws FileNotFoundException {

    	PrintWriter fileWriter = null;                     // PrintWriter to write results to a file.
    	boolean	needOutputFile = true;
        
        // Prompts the user for a file location and loops until a file that can be opened by fileWriter is provided.
        // If the user chooses not to continue, stop looping and end the program.
        do {
            System.out.println("Enter output filename: ");
            Scanner fileLocationScanner = new Scanner(System.in);
            String fileName = fileLocationScanner.nextLine();
            System.out.println();
            try {
                fileWriter = new PrintWriter(fileName);
                needOutputFile = false;
            } //try
            catch (FileNotFoundException ex) {
                System.out.printf("File specified <%s> does not exist. Would you like to continue? <Y/N>", fileName);
                if (fileLocationScanner.nextLine().toLowerCase().equals("n"))
                    throw ex;
                System.out.println();
            }//catch
            
        } while (needOutputFile);
        
        return fileWriter;
        
    }//GetOutputFile

    public static void main(String[] args) {

        Scanner fileScanner;                        // Scanner to read input file.
        PrintWriter fileWriter;                     // PrintWriter to write results to a file.
        aOrderedList list = new aOrderedList();     // Ordered list to hold sorted elements.
        
        
        //open input file
        try {
        	
        	fileScanner = GetInputFile("Enter input filename: ");

	        // Goes through each line of the input file and performs operations on the ordered list.
	        while(fileScanner.hasNextLine()) {
	            String[] elements = fileScanner.nextLine().split(",");
	            if (elements[0].equals("A")) {
	                list.add(new Car(elements[1], Integer.parseInt(elements[2]), Integer.parseInt(elements[3])));
	            } else if (elements[0].equals("D")) {
	                for(int i = 0; i < list.size(); i++) {
	                    Car element = (Car)list.get(i);
	                    if (element.getMake().equals(elements[1]) && element.getYear() == Integer.parseInt(elements[2])) {
	                        list.remove(i);
	                    }
	                }
	            }
	        }
	
	        
	        //open output file
	        fileWriter = GetOutputFile("Enter output filename: ");
	
	        // Writes the contents of the ordered list to an output file.
	        fileWriter.append(String.format("Number of cars:%6s%n", list.size()));
	        for(int i = 0; i < list.size(); i++) {
	            Car item = (Car)list.get(i);
	            fileWriter.append(String.format("%nMake:%12s%n", item.getMake()));
	            fileWriter.append(String.format("Year:%12d%n", item.getYear()));
	
	
	            NumberFormat formatter = NumberFormat.getCurrencyInstance();
	            String priceString = formatter.format(item.getPrice());
	            fileWriter.append(String.format("Price:%11s%n%n", priceString.substring(0, priceString.length() - 3)));
	        }
	        fileWriter.close();
	    }//try
	    catch (FileNotFoundException ex) {
	    	System.out.println("User terminated program");
	    }//catch


    }//main


}//Prog02_aOrderedList class

