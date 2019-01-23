package assignment5;

public class Hcf {
		
	/*
	 * @param a,b for finding hcf of them
	 * @return hcf of both number
	 * */
	int findHcf(int n1, int n2) 
	    { 
			//converting negative value into positive
			int a=Math.abs(n1),b=Math.abs(n2);

	        // Everything divides 0  
	        if (a == 0 || b == 0) 
	           return 0; 
	       
	        // base case 
	        if (a == b) 
	            return a; 
	       
	        // a is greater 
	        if (a > b) 
	            return findHcf(a-b, b); 
	        return findHcf(a, b-a); 
	    } 
}
