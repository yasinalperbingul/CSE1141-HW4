import java.util.Scanner;

public class Pro3_170517033 {

	public static void main(String[] args) {
		//----------------------------------------------------------------------------------
		//This program takes an input letter from the user and outputs it in a diamond shape.
		//There are some requirements of this diamond shape:
		//	- The first row contains one 'A'.
		//	- The last row contains one 'A'.
		//	- All rows, except the first and last, have exactly two identical letters.
		//	- The diamond is horizontally symmetric.
		//	- The diamond is vertically symmetric.
		// 	- The diamond has a square shape (width equals height).
		//	- The letters form a diamond shape.
		// 	- The top half has the letters in ascending order.
		//	- The bottom half has the letters in descending order.
		//---------------------------------------------------------------------------------
		
		//Student name-surname: Yasin Alper BÝNGÜL
		//Number: 170517033
		
		Scanner input = new Scanner(System.in);
		char[][] diamond;
		//Take an input from the user
		System.out.println("Enter a letter: ");
		String letter = input.nextLine();
		
		//If the given input has more than length or if it is not a letter, then return "Invalid value!"
		if(letter.length() == 1 && Character.isLetter(letter.charAt(0))) {
			//Invoke the method that construct a diamond.
			diamond = constructDiamond(letter.charAt(0));
			
			//Invoke the method that display the constructed diamond.
			printDiamond(diamond);
		}
		else {
			System.out.println("Invalid Input !");
		}
		
	}
	
	//The method that constructing
	public static char[][] constructDiamond(char letter){
		
		//Definitions of diamonds
		letter = Character.toUpperCase(letter);
		int n = (int)(letter - 'A');//n will be used in length of diamond array.
		
		if(n == 0) {
			char[][] diamond = new char[n+1][n+1];
			diamond[0][0] = letter;
			//Return the constructed diamond.
			return diamond;
		}
		else {
			//Create proper diamond array
			char[][] diamond = new char[2*n+1][2*n+1];
			
			//Constructing
			//STAGE 1:
			for(int i=0;i<=n;i++) {
				for(int j=0;j<=n;j++) {
					if(j==n-i) {
						diamond[i][j] = (char) (letter -(n-i));
					}
					else {
						diamond[i][j] = '.';
					}
				}
			}
			
			//STAGE2:
			for(int i=n+1; i<=2*n;i++) {
				for(int j=0;j<=n;j++) {
					if(j==i-n) {
						diamond[i][j] = (char)(letter - j);
					}
					else {
						diamond[i][j] = '.';
					}
				}
			}
			
			//STAGE3:
			for(int i=0; i<=n;i++) {
				for(int j=n;j<=2*n;j++) {
					if(j==n+i) {
						diamond[i][j] = (char)(letter -(n-i));
					}
					else {
						diamond[i][j] = '.';
					}
				}
			}
			//STAGE4:
			for(int i=n+1; i<=2*n;i++) {
				for(int j=n+1;j<=2*n;j++) {
					if(j==3*n-i) {
						diamond[i][j] = (char)(letter -(i-n));
					}
					else {
						diamond[i][j] = '.';
					}
				}
			}
			
			
			//Return the constructed diamond.
			return diamond;
		}
	
		
		
	}
	
	//The method that print the constructed diamond array
	public static void printDiamond(char[][] diamond) {
		//Print the content of constructed diamoond shape.
		for(int i=0;i<diamond.length;i++) {
			for(int j=0; j<diamond[i].length;j++) {
				System.out.print(diamond[i][j]);
			}
			System.out.println();
		}
	}

}
