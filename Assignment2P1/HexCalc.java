package hexcalc;

import java.util.Scanner;


public class HexCalc {
		
	//input value object for input process 
	static Scanner inputvalue = new Scanner(System.in);
	  
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
     	  System.out.println("8.Number Conversion");     	  
     	  System.out.println("9.Exit");
     	  System.out.print("Enter your choice:-");

     	  
     	  //user choice input for operation
     	
     	  userChoice=inputvalue.nextInt();
     	      return userChoice;
	  }
	
	
	
	public static void main(String args[])
	 {
		
		
	    int decimal;//decimal value input
	    int userChoice;//user choice for operation
	   
	   
		
		
		 while(true)
                  {  
			 //Method calling for Menu Printing
			 userChoice=operationChoiceMenu();
			 
			 if(userChoice>=1&&userChoice<=7){
				 //will take input for operation
				 InputValue.inputValueForOperation();
			 }
	       	  
	                 switch (userChoice) 
	                 { 
		              case 1: 
		              //add two decimal and result of them will convert into hexadecimal
		              System.out.println( HexConversion.numberToString(ArithmeticOperation.add(InputValue.getNumber1(),InputValue.getNumber2()))); 
		              break; 
		             
		              case 2: 
		        	 //subtract two decimal and result of them will convert into hexadecimal
		              System.out.println( HexConversion.numberToString(ArithmeticOperation.subtract(InputValue.getNumber1(),InputValue.getNumber2()))); 
		              break;
		             
		              case 3: 
		        	//multiply two decimal and result of them will convert into hexadecimal
		              System.out.println( HexConversion.numberToString(ArithmeticOperation.multiply(InputValue.getNumber1(),InputValue.getNumber2())));
		              break;
		             
		              case 4: 
		              //divide two decimal and result of them will convert into hexadecimal
		              System.out.println( HexConversion.numberToString(ArithmeticOperation.divide(InputValue.getNumber1(),InputValue.getNumber2())));
		              break;
		             
		              case 5:  
		        	 //comparing two hexadecimal values
		       	      System.out.println(Comparison.compareEqualTo(InputValue.getHexNumber1(), InputValue.getHexNumber2()));
		              break;
		             
		              case 6:
		        	//comparing two hexadecimal values
		       	      System.out.println(Comparison.compareGreaterThan(InputValue.getHexNumber1(), InputValue.getHexNumber2()));
		       	      break;
		       	  
		              case 7:
		        	//comparing two hexadecimal values
		       	      System.out.println(Comparison.compareLesserThan(InputValue.getHexNumber1(), InputValue.getHexNumber2()));
		       	      break;
		       	  
		              case 8:
		        	 System.out.print("1.Hex To Decimal\n2.Decimal to Hex\nEnter Choice:-");
					 userChoice=inputvalue.nextInt();
					 InputValue.inputValueForConversion(userChoice);
					 switch(userChoice){
					 	case 1:
					 		System.out.println("Converted Nuber :-"+InputValue.getNumber1());
					 		break;
					 	case 2:
					 		System.out.println("Converted Nuber :-"+InputValue.getHexNumber1());
					 		break;
					 	default:
					 		System.out.println("Invalied Choice");
					 }
		       	  	 break;
		       	  	 
		         case 9:
		        	 System.exit(0);
		        	 break;
		        	 
		         default: 
		             System.out.println("Invalid choice. Please enter again !");
		             break; 
	         }//End of switch     
         
         }//End of while
	}//End of main method
}//End of class

