package iCart;

import java.util.*;

class Icart{
	 int t=1;
     double t1,total=0;
	 String str;
     Items s = new Items();
     
	HashMap<Integer,Double> usermp = new HashMap<>();
	
	void AddItem()
	{   int index;
		double quant;
		System.out.println("Enter the ID");
		 Scanner n= new Scanner(System.in);
         index=n.nextInt();
         System.out.println("Enter the quantity");
         quant=n.nextDouble();
         usermp.put(index, quant);
     }
	
	void DeleteItem()
	{
		if(usermp.size()>0){
			int index;
			System.out.println("Enter the ID");
			 Scanner n= new Scanner(System.in);
	         index=n.nextInt();
			usermp.remove(index);
		}
		else{
			System.out.println("Cart Is Empty Now.");
		}
		
	}
	
	void UpdateCart(){
		if(usermp.size()>0){
			int index;
			double quant;
			System.out.println("Enter the ID");
			Scanner n= new Scanner(System.in);
			index=n.nextInt();
			System.out.println("Update the Quantity");
			quant=n.nextDouble();
			usermp.put(index, quant);
		}else{
			System.out.println("Cart Is Empty Now.");
		}
	}
	
	
	
}
