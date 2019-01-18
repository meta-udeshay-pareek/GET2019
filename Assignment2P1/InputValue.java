package hexcalc;

import java.util.Scanner;

public class InputValue {

	//input value object for input process 
	static Scanner inputvalue = new Scanner(System.in);
	static String hex1,hex2;//Two hexadecimal input value
	static int number1,number2;//Two decimal value get from conversion of both hex values respectively
	//hexadecimal calculator object
	static HexConversion hexConversion = new HexConversion();
	
		
	static void setNumber1(int num1){
		number1=num1;
	}
	
	static void setNumber2(int num2){
		number2=num2;
	}
	
	static int getNumber1(){
		return number1;
	}
	
	static int getNumber2(){
		return number2;
	}
	
	static void setHexNumber1(String hex1){
		InputValue.hex1=hex1;
	}
	
	static void setHexNumber2(String hex2){
		InputValue.hex2=hex2;
	}
	
	static String getHexNumber1(){
		return hex1;
	}
	
	static String getHexNumber2(){
		return hex2;
	}
	
	static void inputValueForOperation(){
		
		System.out.println("Enter two hexadecimal values.");
		
		System.out.print("Hexadecimal value 1 :-");
		//input first hex value and assign it to hex1
     	setHexNumber1(inputvalue.next());
     	
     	System.out.print("Hexadecimal value 2 :-");
     	//input second hex value and assign it to hex2
     	setHexNumber2(inputvalue.next());
     	
     	//conversion into decimal number of both
     	setNumber1(hexConversion.stringToNumber(hex1));
    	setNumber2(hexConversion.stringToNumber(hex2));     	
	
		
	}
	
	/*
	 * 
	 * @param userchoice =1 for hex to decimal
	 * 		  userChoice = 2 for decimal to hex 
	 * */
	static void inputValueForConversion(int userChoice){
		//converting value and assigning to number1
		if(userChoice==1){
			System.out.println("Enter hexadecimal values.");
			//input first hex value and assign it to hex1
	     	setHexNumber1(inputvalue.next());
	     	
	     	//converting value into decimal and assigning to number1
			setNumber1(hexConversion.stringToNumber(hex1));
		 }
		//converting value and assigning to hex1
		else if(userChoice==2){
			 System.out.println("Enter decimal values.");
			//input first  value and assign it to number1
		    setNumber1(inputvalue.nextInt());
		    
		  //converting value into hexa decimal and assigning to hex1
			setHexNumber1(hexConversion.numberToString(number1));
		 }
	}
}
