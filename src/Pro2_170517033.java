import java.util.Scanner;

public class Pro2_170517033 {

	public static void main(String[] args) {
		//---------------------------------------------------------------------------------
		// This program determines whether or not it is valid for a variety of identification numbers,
		//such as credit card numbers per the Luhn formula. The Luhn algorithm is a simple checksum 
		//formula used to validate. The validation process belongs to 3 rules:
		// 1. Strings of length 1 or less are not valid.
		// 2. Spaces are allowed in the input.
		// 3. All other non-digit characters are disallowed.
		//----------------------------------------------------------------------------------
		
		//Student Name-Surname : Yasin Alper BÝNGÜL
		//Number: 170517033
		
		Scanner input = new Scanner(System.in);
		//Getting the card number from user
		String number = input.nextLine();
		
		
		//Spaces are allowed. So we can get rid of the space characters and get a new string value that without spaces.
		int k = number.indexOf(" "); ;
		String newNumber = " ";
		if(k != -1) {
			newNumber = number.substring(0,k) + number.substring(k+1);
			k = newNumber.indexOf(" ");
			int i=0;
			while(k!=-1){
				
				newNumber = newNumber.substring(0,k) + newNumber.substring(k+1);
				k = newNumber.indexOf(" ");
		
			}
		}
		else {
			newNumber = number;
		}
		
		//Checking the card number which without the spaces.
		boolean isValid = false;
		boolean isValid2 = true;
		//Firstly, check each character of the card number digit or not.
		for(int i=0;i<newNumber.length();i++) {
			if(!(Character.isDigit(newNumber.charAt(i)))) {
				isValid2 = false;
			}
		}
		if(isValid2 && newNumber.length()>1) {
			//If each character of the card number is digit and its length is greater than 1, then check the Luhn Algorithm.
			isValid = validateNumber(newNumber);
		}
		

		//Preparing the DNumber and LNumber values.
		String lNumber = "";
		String dNumber = "";
		int numberCount = 0;
		
		if(newNumber.length() % 2 == 0) {
			for(int i=0;i<newNumber.length();i++) {
				numberCount ++;
				if(numberCount % 2 !=0) {
					int a = (int)(newNumber.charAt(i))-48; // the ASCII value of '0' is 48.
					a *= 2;
					if(a>9) {
						a -= 9;
					}
					lNumber += ""  + (a);
					dNumber += "" + newNumber.charAt(i);
					
				}
				else {
					lNumber += ""  + newNumber.charAt(i);
					dNumber += "_";
				}
			}
		}
		else {
			for(int i=0;i<newNumber.length();i++) {
				numberCount++;
				if(numberCount %2 == 0) {
					int a = (int)(newNumber.charAt(i))-48; // the ASCII value of '0' is 48.
					a *= 2;
					if(a>9) {
						a -= 9;
					}
					lNumber += ""  + (a);
					dNumber += "" + newNumber.charAt(i);
					
				}
				else {
					lNumber += ""  + newNumber.charAt(i);
					dNumber += "_";
				}
			}
		}
		
		
		
		//Checking the card number is valid or not.
		if(isValid2 && newNumber.length()>1) {
			if(isValid) {
				System.out.println("DNumber:" + dNumber);
				System.out.println("LNumber:" + lNumber);
				System.out.println("Number is Valid");
			}
			else {
				System.out.println("DNumber:" + dNumber);
				System.out.println("LNumber:" + lNumber);
				System.out.println("Number is Invalid");
			}
		}
		else {
			System.out.println("Invalid Input !");
		}
	}
	
	//Check if a given number is valid or not with this module
	public static boolean validateNumber(String number) {
		// According to the Luhn algorithm:
		//a) Double every second digit and sum them, starting from the right.
		int numberCount = 0;
		int sum = 0;
		
		for(int i=number.length()-1;i>=0;i--) {
			numberCount++;
			if(numberCount % 2 == 0) {
				//If the doubled number is greater than 9, then subtract 9 from the doubled number.
				if((int)((number.charAt(i))-48)*2 > 9) {
					sum += (((int)(number.charAt(i))-48)*2 - 9);
				}
				else {
					sum += ((int)(number.charAt(i))-48)*2;
				}
			}
			else {
				sum += (int)(number.charAt(i))-48;
			}			
		}
		//b) Is calculated sum divisible by 10?
		if(sum % 10 != 0)
			return false;
		
		//Return the result(boolean)
		return true;
	}

}
