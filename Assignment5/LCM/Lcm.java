package lcmoftwonumber;

public class Lcm {
	//base case assuming lcm of two number is 1
		//in every recursive call lcm value will be common due to static
		private int lcm=1;
		
		/*
		 * @param a,b for finding lcm of them
		 * @return lcm of both number
		 * */
		int findLcm(int n1,int n2) throws ArithmeticException{
			
				//converting negative value into positive
				int a=Math.abs(n1),b=Math.abs(n2);
				
				if(a==0 || b==0) {
					throw new ArithmeticException("0 is invalid for lcm");
				}
				// base case 
				if(lcm%a == 0 && lcm%b == 0)
			    {
			        return lcm;
			    }
			    else
			    {
			    	lcm++;
			        findLcm(a,b);
			        return lcm;
			    }

		}
}
