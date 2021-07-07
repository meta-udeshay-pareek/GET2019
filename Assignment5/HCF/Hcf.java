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

			 if (b == 0) 
			        return a; 
			    return findHcf(b, a % b);   
	    } 
}
