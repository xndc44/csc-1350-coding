import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Scanner;


public class Prog03_llOrderedList {
	
	
    public static Scanner GetInputFile(String UserPrompt) throws FileNotFoundException {

        Scanner fileScanner = null;                       
        boolean needInputFile = true;
        do {
            System.out.print(UserPrompt);
            Scanner in = new Scanner(System.in);
            String fileName = in.nextLine();
            System.out.println();

            try {
                fileScanner = new Scanner(new File(fileName));
                needInputFile = false;
            }//try 
            catch (FileNotFoundException ex) {
                System.out.printf("File specified <%s> does not exist. Would you like to continue? <Y/N> ", fileName);
                if (in.nextLine().toLowerCase().equals("n")) {
                    throw ex;
                }//if
                System.out.println();
            }//catch
        }//do
        while (needInputFile);

        return fileScanner;
    }//inputfile

   
    public static PrintWriter outfile(String userPrompt) throws FileNotFoundException {

        PrintWriter fileWriter = null;                    
        boolean needOutputFile = true;

        do {
            System.out.println("Enter output filename: ");
            Scanner in = new Scanner(System.in);
            String fileName = in.nextLine();
            System.out.println();
            try {
                fileWriter = new PrintWriter(fileName);
                needOutputFile = false;
            } //try
            catch (FileNotFoundException ex) {
                System.out.printf("File specified <%s> does not exist. Would you like to continue? <Y/N>", fileName);
                if (in.nextLine().toLowerCase().equals("n"))
                    throw ex;
                System.out.println();
            }//catch

        } while (needOutputFile);

        return fileWriter;

    }//outfile

	public static void main(String[] args) {
		Scanner in;                     
        PrintWriter fileWriter;                     
        llOrderedList list = new llOrderedList();


        try {

            in = GetInputFile("Enter input filename: ");

           
            while (in.hasNextLine()) {
                String[] elements = in.nextLine().split(",");
                
                if (elements[0].equals("A")) {
                	Car newCar = new Car(elements[1], Integer.parseInt(elements[2]), Integer.parseInt(elements[3]));
                    list.add(newCar);
                }//if 
                else if (elements[0].equals("D")) {
                	Car newCar = new Car(elements[1], Integer.parseInt(elements[2]), 0);
                	boolean carRemoved = false;
                    list.reset();
                    Car finalCar;
                    while(list.hasNext()) {
                    	finalCar = (Car)list.next();
                    	if (finalCar.compareTo(newCar) == 0) {
                    		list.remove();
                    		carRemoved = true;
                    		break;
                    	}//if
                    }//while
                    if (!carRemoved) {
                    	finalCar = (Car)list.next();
                    	if (finalCar.compareTo(newCar) == 0) {
                    		list.remove();
                    	}//if 	
                    }//if
                }//elseif
            }//while
            
            System.out.println();

            
            fileWriter = outfile("Enter output filename: ");
          
            fileWriter.append(String.format("Number of cars:%6s%n", list.size()));
            list.reset();
            for (int i = 0; i < list.size(); i++) {
                Car item = (Car) list.next();
                fileWriter.append(String.format("%nMake:%12s%n", item.getMake()));
                fileWriter.append(String.format("Year:%12d%n", item.getYear()));


                NumberFormat formatter = NumberFormat.getCurrencyInstance();
                String priceString = formatter.format(item.getPrice());
                fileWriter.append(String.format("Price:%11s%n%n", priceString.substring(0, priceString.length() - 3)));
            }//for
            fileWriter.close();
        }//try
        catch (FileNotFoundException ex) {
            System.out.println("User terminated program");
        }//catch

	}//main

}//class
