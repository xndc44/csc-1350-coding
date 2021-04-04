import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.text.NumberFormat;

public class Prog04_bstOrderedList {

	private static boolean accept;
    private static String sorter;
	
	public static Scanner GetInputFile(String UserPrompt) throws FileNotFoundException {
		
		Scanner fSc = null;                     
		boolean	needInputFile = true;
		
        do {
            System.out.print(UserPrompt);
            Scanner Location = new Scanner(System.in);
            String fileName = Location.nextLine();
            System.out.println();
            
            try {
                fSc = new Scanner(new File(fileName));
                needInputFile = false;
            } 
            catch (FileNotFoundException ex) {
                System.out.printf("File specified <%s> does not exist. Would you like to continue? <Y/N> ", fileName);
                if (Location.nextLine().toLowerCase().equals("n")) {
                    throw ex;
                }
                System.out.println();
            }
        }
        while (needInputFile);
        
        return fSc;
	}//getstheinputfile
	
	public static PrintWriter outFile(String userPrompt) throws FileNotFoundException {

        PrintWriter fileWriter = null;                   
        boolean outfilebool = true;

     
        do {
            System.out.println("Enter output filename: ");
            Scanner in = new Scanner(System.in);
            String fileName = in.nextLine();
            System.out.println();
            try {
                fileWriter = new PrintWriter(fileName);
                outfilebool = false;
            } //try
            catch (FileNotFoundException ex) {
                System.out.printf("File specified <%s> does not exist. Would you like to continue? <Y/N>", fileName);
                if (in.nextLine().toLowerCase().equals("n"))
                    throw ex;
                System.out.println();
            }//catch

        } while (outfilebool);

        return fileWriter;

    }//outFile
	
	public static void main(String[] args) {
		Scanner fSc;                        
        PrintWriter fileWriter;                   
        bstOrderedList list = new bstOrderedList();     


        //open input file
        try {

            fSc = GetInputFile("Enter input filename: ");

            
            while (fSc.hasNextLine()) {
                String[] elements = fSc.nextLine().split(",");
                Movie newMovie;
                if (elements[0].equals("A")) {
                    newMovie = new Movie(elements[1], Integer.parseInt(elements[2]), elements[3], Integer.parseInt(elements[4]));
                   
                    list.add(newMovie);
                }
                else if (elements[0].equals("D")) {
                    newMovie = new Movie(elements[1], Integer.parseInt(elements[2]), "", 0);
                    
                    list.remove(newMovie);
                }
            }

            System.out.println();

            boolean moreOutput = false;
            do {
                
                fileWriter = outFile("Enter output filename: ");

               
                if (accept) {
                 
                    fileWriter.append(String.format("Number of movies: %d\n", list.size()));

                    Comparable[] contents = list.toArray(sorter);
                    for(int i = 0; i < contents.length; i++) {
                        Movie movie = (Movie)contents[i];
                        fileWriter.append(String.format("\nTitle:%10s%-20s\nYear:%11s%-20d\nRating:%9s%-20s\nReview:%9s%-20d\n", "",
                                movie.getTitle(), "", movie.getYear(), "", movie.getRating(), "", movie.getReview()));
                    }
                } else {
                    fileWriter.append(list.toString());
                }

                fileWriter.close();

                Scanner in = new Scanner(System.in);
                System.out.print("Would you like to add more output files? <Y/N> ");
                if (in.hasNext() && in.next().equals("Y")) {
                    moreOutput = true;
                }

            } while (moreOutput);
        }//try
        catch (FileNotFoundException ex) {
            System.out.println("User terminated program");
        }//catch

    }
}
