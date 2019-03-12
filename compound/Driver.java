package compound;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);//input object

		
		Chemical chemical = new Chemical();

		System.out.println("Enter the string");

		String formula=in.nextLine();
	
		
		System.out.println(chemical.solveCompound(formula));
	}
}
