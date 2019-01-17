package iCart;

import java.util.*;

public class Cart {
   
	public static void main(String[] args) {
	      int t=1;
	      String str;
	      double t1,total=0;//total amount
	      
          Items s = new Items();
          Icart s1 = new Icart();
          
          s.create();
          
          System.out.println("Items with their prices ");
          s.display();
          
          System.out.println("Items with their ids ");
          s.displayp();   
          
          while(t!=0)
          {  
        	  System.out.println("-----------------------------------------------------");
	          System.out.println("1.Add Item");
	          System.out.println("2.Delete Item");
	          System.out.println("3.Update Cart");
	          System.out.println("4.Bill Amount");
	          System.out.println("5.Display Cart");
	          System.out.println("6.Exit");
	          System.out.print("Enter Your Choice:- ");
	          Scanner in = new Scanner(System.in);
	          t=in.nextInt();
	          
	          switch (t) { 
	          case 1: 
	              s1.AddItem(); 
	              break; 
	              
	          case 2: 
	              s1.DeleteItem(); 
	              break; 
	              
	          case 3: 
	              s1.UpdateCart(); 
	              break; 
	              
	          case 4: 
	        	  //Calculating total amount 
	        	  total=0;
	              for(Map.Entry<Integer,Double> entry : s1.usermp.entrySet())
	              {
	            	  int userkey= entry.getKey();
	            	  double userquant = entry.getValue();
	            	  str=s.mapi.get(userkey) ;
	            	  t1= (s.map.get(str)) * userquant;
	            	 
	            	  total+=t1;
	            	  System.out.println(userkey+"  "+str+"  "+userquant+"  "+t1);
	              }
	              System.out.println("Your total amount is "+total);
	              break; 
	              
	          case 5:
	        	 //Displaying all the item in cart 
	        	 total=0;
        		 for(Map.Entry<Integer,Double> entry : s1.usermp.entrySet())
                 {
	               	  int userkey= entry.getKey();
	               	  double userquant = entry.getValue();
	               	  str=s.mapi.get(userkey) ;
	               	  t1= (s.map.get(str)) * userquant;
	               	 
	               	  total+=t1;
	               	  System.out.println(userkey+"  "+str+"  "+userquant+"  "+t1);
                 }
                 if(total==0){
                	 System.out.println("Your cart is empty"); 
                 }
                 System.out.println("Your total amount is "+total);
	             break; 
	             
	          case 6:
	        	  System.exit(0);
	        	  break;
	        	  
	          default: 
	              System.out.println("Invalid choice. Please enter again !");
	              break; 
	          }     
          
          }

          
      }

}