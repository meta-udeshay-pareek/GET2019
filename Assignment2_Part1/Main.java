package hexcalc;

import java.util.Scanner;


public class Main {
	//input value object for input process 
	static Scanner inputvalue = new Scanner(System.in);
	
	static String hex1,hex2;//Two hexadecimal input value
	
	
	
	//input two hex value for operation
	static void inputTwoHexValueForOperation(){
		System.out.println("Enter two hexadecimal values.");
     	hex1= inputvalue.next();
     	hex2= inputvalue.next();
	}
	
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
     	  System.out.print("Enter your choice");

     	  
     	  //user choice input for operation
     	  //Scanner in = new Scanner(System.in);
     	  userChoice=inputvalue.nextInt();
     	  
     	  return userChoice;
	}
	
	public static void main(String args[])
	{
		//hexadecimal calculator object
		HexCalc hexCalc = new HexCalc();
		
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
		             System.out.println( hexCalc.add(hex1,hex2)); 
		             break; 
		         case 2: 
		        	 inputTwoHexValueForOperation();
		             System.out.println(hexCalc.subtract(hex1,hex2)); 
		             break; 
		         case 3: 
		        	 inputTwoHexValueForOperation();
		             System.out.println(hexCalc.multiply(hex1, hex2));
		             break; 
		         case 4: 
		        	 inputTwoHexValueForOperation();
		        	 System.out.println(hexCalc.divide(hex1, hex2));
		             break; 
		         case 5:  
		        	 inputTwoHexValueForOperation();
		       	     System.out.println(hexCalc.compareEqualTo(hex1, hex2));
		             break; 
		         case 6:
		        	 inputTwoHexValueForOperation();
		       	  	  System.out.println(hexCalc.compareGreaterThan(hex1, hex2));
		       	  break;
		         case 7:
		        	 inputTwoHexValueForOperation();
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

