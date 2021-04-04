/**
 * <Prog03_PayCalc>
 *
 * CSC 1350 Programming project No 3
 * Section 7
 *
 * @author <Patrick Adeosun>
 * @since 10/1/2018
 *
 */
import java.util.Scanner;

class Prog03_PayCalc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	boolean Y = true;
	
	boolean N = false;
	Scanner in = new Scanner (System.in);

	String a = "Sunday";
	String b = "Tuesday";
	String c = "Wednesday";
	String d = "Thursday";
	String e = "Friday";
	String f = "Saturday";
	String g = "Monday";
	double Sunday =0.0;
	double Monday =0.0;
	double Tuesday =0.0;
	double Wednesday =0.0;
	double Thursday =0.0;
	double Friday =0.0;
	double Saturday =0.0;
	String day;
	double salesAmount = 0.0;
	double total;
	
	
		//ask for day of sale
		do
		{
			System.out.println("Enter the day of sale (Sunday, Monday, Tuesday, etc.): ");
			day = in.nextLine();
			
			if ((day.equals(a)) || (day.equals(b)) || (day.equals(c)) || (day.equals(d)) || (day.equals(e)) || (day.equals(f)) || (day.equals(g))) 
				
			{}
			else { 
				do 
				{
				System.out.println("Invalid value!");
				System.out.println("Enter the day of sale (Sunday, Monday, Tuesday, etc.): ");
				day = in.nextLine();
				} 
				while(!(day.equals("Monday")) && (day.equals("Tuesday")) && (day.equals("Wednesday")) && (day.equals("Thursday")) && (day.equals("Friday")) && (day.equals("Saturday")) && (day.equals("Sunday")));
				}
		//ask for salesAmount
			System.out.println("Enter sales amount: ");
			salesAmount = in.nextDouble();
			in.nextLine();
			if ((salesAmount < 0.0)) {
				do 
				{
				System.out.println("Invalid value!");
				System.out.println("Enter the sales amount: ");
				salesAmount = in.nextDouble();
				} 
				while(salesAmount >= 0.0);
			}
			//ask is entry is finished & loop
			System.out.println("Are you finished entering sales? (Y/N)");
			String answer = in.nextLine();
			
			if (day.equals("Sunday")) 
			{
				Sunday=+salesAmount;
				
			}
				
				else if (day.equals("Monday")) 
				{
					Monday=+salesAmount;
					
				}
					
					else if (day.equals("Tuesday")) 
					{
						Tuesday=+salesAmount;
						
					}
					else if (day.equals("Wednesday")) 
					{
						Wednesday=+salesAmount;
						
					}
					else if (day.equals("Thursday")) 
					{
						Thursday=+salesAmount;
						
					}
					else if (day.equals("Friday")) 
					{
						Friday=+salesAmount;
						
					}
					else if (day.equals("Saturday")) 
					{
						Saturday=+salesAmount;
						
					}
					else 
					{
						System.out.print("Invalid Input!");
					}
			if (answer.equals("Y")) { 
				;break;
			}
				else if (!answer.equals("N")) {
					System.out.print("Invalid input!");
				answer = in.nextLine();
				}
			}
		

		
		while (N == false);
	
		
		//system.out.print statements

		total = Monday+Tuesday+Wednesday+Thursday+Friday+Saturday+Sunday;
		double commission = 200 + (0.09 * total);
		System.out.printf("Day             Sales\n");
	
		
		System.out.printf("Sunday       $" + "%,10.2f\n", Sunday);
		System.out.printf("Monday       $" + "%,10.2f\n", Monday);
		System.out.printf("Tuesday      $" + "%,10.2f\n", Tuesday);
		System.out.printf("Wednesday    $" + "%,10.2f\n", Wednesday);
		System.out.printf("Thursday     $" + "%,10.2f\n", Thursday);
		System.out.printf("Friday       $" + "%,10.2f\n", Friday);
		System.out.printf("Saturday     $" + "%,10.2f\n", Saturday);
		System.out.println("            ------------");
		
        System.out.printf("Sum is:      $" + "%,10.2f\n", total);
		System.out.printf("Average sale value: " + " $%,1.2f\n ", total/7);
		// commission part
		if(total >15000) 
		{
			commission =+ 1000;
		}
			else
			{}
		
		
		if(total >= 60000) 
		{
			System.out.printf("Commission on sales: " + " $%,1.2f ***", commission);
		} 
			else 
			{
				System.out.printf("Commission on sales: " + " $%,1.2f", commission);
			}
	
	}
	
}
	