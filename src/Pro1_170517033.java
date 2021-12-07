import java.util.Scanner;

public class Pro1_170517033 {

	public static void main(String[] args) {
		//--------------------------------------------------------------------------------------
		// This java program calculates the invoice of each flat in the apartment building. 
		// There are N flats in this building and apartment heating is the central system.
		// 30% of bill will be shared equally among the flats, the rest (70%) will be shared
		//according to the consumption of each flat.
		//--------------------------------------------------------------------------------------
		//Student Name - Surname: Yasin Alper BÝNGÜL
		//Number: 170517033
		
		Scanner input = new Scanner(System.in);
		//Getting the input values from the user
		//N: Number of flats
		int N = input.nextInt();
		//Enter inputs that  consumption of each flat 
		double[] C = new double[N];
		for(int i=0;i<C.length;i++) {
			C[i] = input.nextDouble();
		}
		//TotalBill: The total Bill for the apartment building.
		double totalBill = input.nextDouble();
		
		//Call method and calculate the invoice depends on the input values.
		double[] invoice = calculateTheInvoice(C,totalBill);
		
		//Display the calculated invoice bills that separated each flat.
		printBills(invoice);

	}
	
	//Calculate the invoice method
	public static double[] calculateTheInvoice(double[] flats, double totalBill) {
		double thiPercent;
		double sevPercent;
		double sum = 0;
		double[] invoice = new double[flats.length];
		
		//30% of the totalBill is:
		thiPercent = totalBill*0.3;
		//70% of the totalBill is:
		sevPercent = totalBill*0.7;
		//Total consumption calculation
		for(double i:flats) {
			sum += i;
		}
		
		//Then, the bill for each flat calculated as:
		for(int i=0;i<flats.length;i++) {
			invoice[i] = thiPercent/flats.length + sevPercent*(flats[i]/sum);
		}

		//return the invoice value
		return invoice;
	}
	
	
	//The method that displays results
	public static void printBills(double[] bills) {
		//Display the results
		for(int i=0;i<bills.length;i++) {
			System.out.println("Flat #" + (i+1) + ": " + (int)(bills[i]*100)/100.0);
		}
		
	}

}
