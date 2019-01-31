package hexcalc;

import java.util.Scanner;


public class HexCalc {
	//input value object for input process 
	static Scanner inputvalue = new Scanner(System.in);
	
	//hexadecimal calculator object
	static HexConversion hexCalc = new HexConversion();
	
	static String hex1,hex2;//Two hexadecimal input value
	
	static int number1,number2;//Two decimal value get from conversion of both hex values respectively

	
	//input two hex value for operation
	static void inputTwoHexValueForOperation(){
		System.out.println("Enter two hexadecimal values.");
		System.out.print("Hexadecimal value 1 :-");
     	hex1= inputvalue.next();
     	System.out.print("Hexadecimal value 2 :-");
     	hex2= inputvalue.next();
     	
     	//conversion into decimal number of both
     	number1=hexCalc.stringToNumber(hex1);
     	number2=hexCalc.stringToNumber(hex2);
     	
	}
	
	//will return userChoice from menu
	static int operationChoiceMenu(){
		  int userChoice;
		  System.out.println("---------------------------------------------------------------------------");
     	  System.out.println("1.Add");
     	  System.out.println("2.Subtract");
     	  System.out.println("3.Multiply");
     	  System.out.println("4.Divide");
     	  System.out.println("5.Check for Equality");
          System.out.println("6.Check for Greater");
     	  System.out.println("7.Check for Lesser");
     	  System.out.println("8.Convert Hexadeciamal to Decimal");
     	  System.out.println("9.Convert Decimal to Hexadecimal");
     	  System.out.println("10.Exit");
     	  System.out.print("Enter your choice:-");

     	  
     	  //user choice input for operation
     	  //Scanner in = new Scanner(System.in);
     	  userChoice=inputvalue.nextInt();
     	  
     	  return userChoice;
	}
	
	public static void main(String args[])
	{
		
		
		//String hex1,hex2;
		int decimal;//decimal value input
		
	    int userChoice;//user choice for operation
		
		
		
		 while(true)
         {  
			 //Method calling for Menu Printing
			 userChoice=operationChoiceMenu();
	       	  
	         switch (userChoice) 
	         { 
		         case 1: 
		        	 inputTwoHexValueForOperation();
		        	 //add two decimal and result of them will convert into hexadecimal
		             System.out.println( hexCalc.numberToString(hexCalc.add(number1,number2))); 
		             break; 
		         case 2: 
		        	 inputTwoHexValueForOperation();
		        	 //subtract two decimal and result of them will convert into hexadecimal
		             System.out.println( hexCalc.numberToString(hexCalc.subtract(number1,number2))); 
		             break; 
		         case 3: 
		        	 inputTwoHexValueForOperation();
		        	//multiply two decimal and result of them will convert into hexadecimal
		             System.out.println( hexCalc.numberToString(hexCalc.multiply(number1,number2)));
		             break; 
		         case 4: 
		        	 inputTwoHexValueForOperation();
		        	//divide two decimal and result of them will convert into hexadecimal
		        	 System.out.println( hexCalc.numberToString(hexCalc.divide(number1,number2)));
		             break; 
		         case 5:  
		        	 inputTwoHexValueForOperation();
		        	 //comparing two hexadecimal values
		       	     System.out.println(hexCalc.compareEqualTo(hex1, hex2));
		             break; 
		         case 6:
		        	 inputTwoHexValueForOperation();
		        	//comparing two hexadecimal values
		       	  	  System.out.println(hexCalc.compareGreaterThan(hex1, hex2));
		       	  break;
		         case 7:
		        	 inputTwoHexValueForOperation();
		        	//comparing two hexadecimal values
		       	  	 System.out.println(hexCalc.compareLesserThan(hex1, hex2));
		       	  break; 
		         case 8:
		        	 System.out.println("Enter the hexadecimal string");
		        	 hex1= inputvalue.next();
		       	  	 System.out.println(hexCalc.stringToNumber(hex1));
		       	  	 break;
		         case 9:
		        	 System.out.println("Enter the decimal value");
		        	 decimal= inputvalue.nextInt();
		        	 System.out.println(hexCalc.numberToString(decimal));
		        	 break;
		         case 10:
		        	 System.exit(0);
		        	 break;
		         default: 
		             System.out.println("Invalid choice. Please enter again !");
		             break; 
	         }//End of switch     
         
         }//End of while
	}//End of main method
}//End of class

