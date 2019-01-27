import java.util.Arrays;

/*
Implement the immutable class Poly using an array to represent single variable polynomial. 
Note that you should be storing only those terms of polynomial that have non zero coefficient. 
You can assume that the coefficients are integers
It should support methods like - 
evaluate(float) - return the value of the polynomial for the given value of the variable
degree() - return the degree of the polynomial
addPoly(Poly p1, Poly p2) - return the sum of the polynomials p1 and p2
multiplyPoly(Poly p1, Poly p2) - return the product of polynomials p1 and p2
You may use private helper methods. addPoly() and multiplyPoly() can make assumptions 
about size of the resulting polynomial to decide about the size of the array to be created.
*/
public final class Poly {
	private  int[] degree;
	private int[] coefficient;
	private int[][] tempArray = new int[20][2];
	public Poly(int[] degree,int[] coefficient) {
		this.coefficient=coefficient;
		this.degree=degree;
	}
	/**
	 * evaluate the value of polynomial of given value
	 * @param value  as float
	 * @return evaluatevalue 
	 */
	public  float evaluate(float value) {
		float evaluatevalue=0.0F;
		for(int index=0;index<degree.length;index++)
		{
			evaluatevalue+=coefficient[index]*Math.pow(value,degree[index]);
		}
		return evaluatevalue;
	}
	/**
	 * return the highest degree of polynomial
	 * @return maxdegree
	 */
	 public int degreeOfPoly(){
		 int maxdegree = degree[0]; 
		    for(int i=1;i<degree.length;i++){ 
		      if(degree[i] >maxdegree){ 
		    	  maxdegree = degree[i]; 
		      } 
		    } 
		    return maxdegree; 
		  } 
	 /**
	  * Addition of two polynomial
	  * @param p1 as object as polynomial
	  * @param p2 as object as polynomial
	  * @return degreecoefficient int [][] resultant polynomial
	  */
	 public int[][] addPoly(Poly p1,Poly p2){
		 int indexofadd=0;
		 boolean flag=false;
		 for(int index=0;index<p1.degree.length;index++) {
			 for(int indexofp2=0;indexofp2<p2.degree.length;indexofp2++) {
				 if(p1.degree[index]==p2.degree[indexofp2]){
				     tempArray[indexofadd][0]=p1.degree[index];
				     tempArray[indexofadd][1]=p1.coefficient[index]+p2.coefficient[indexofp2];
					 indexofadd++;
					 p1.degree[index]=-1;
					 p2.degree[indexofp2]=-1;
					 flag=true;
					 break;
				 }
			 }
				 if(!flag)
				 {
					 tempArray[indexofadd][0]=p1.degree[index];
					 p1.degree[index]=-1;
				     tempArray[indexofadd][1]=p1.coefficient[index];
					 indexofadd++; 	 
				 }
			 }
		
		 
			 for(int indexofp2=0;indexofp2<p2.degree.length;indexofp2++) {
					 if(p2.degree[indexofp2] != -1){
					     tempArray[indexofadd][0]=p2.degree[indexofp2];
					     tempArray[indexofadd][1]=p2.coefficient[indexofp2];
						 indexofadd++; 
					 }	 
				 }
		 
			 for(int index=0;index<indexofadd-1;index++) {
                 for(int indexofarray=index;indexofarray<indexofadd-1;indexofarray++) { 
                     if(tempArray[index][0] <= tempArray[indexofarray][0]) {
                         
                         int temp = tempArray[indexofarray][0];
                         tempArray[indexofarray][0] = tempArray[index][0];
                         tempArray[index][0] = temp;
                         
                         int tempcoeff = tempArray[indexofarray][1];
                         tempArray[indexofarray][1] = tempArray[index][1];
                         tempArray[index][1] = tempcoeff;
                     }
                 }
			 }
			  int [][] degreecoefficient = new int[tempArray[0][0]+1][2];
	         for(int index=0;index<tempArray[0][0]+1;index++) {
	               degreecoefficient[index][0] = tempArray[index][0];
	                 degreecoefficient[index][1] = tempArray[index][1];
	             
	         }
		 return  degreecoefficient;
	 }
	 /**
	  * multiplication of two polynomial
	  * @param p1 as object of polynomial
	  * @param p2 as object of polynomial
	  * @return degreecoefficient int [][] resultant polynomial
	  */
	 public int[][] multiplyPoly(Poly p1, Poly p2) {
		int[][] tempArrayForMultiply = new int[20][2];
		 int indexofmul=0;
		 boolean flag = false;
		 for(int indexofp1=0;indexofp1<p1.degree.length;indexofp1++) {
			 for(int indexofp2=0;indexofp2<p2.degree.length;indexofp2++) {
			     tempArrayForMultiply[indexofmul][0]=p2.degree[indexofp2]+p1.degree[indexofp1];
			     tempArrayForMultiply[indexofmul][1]=p2.coefficient[indexofp2]*p1.coefficient[indexofp1];
				 indexofmul++;	 
			 }
		 }
		
		 int indexofmultiply=0;
		 for(int indexoftemp=0;indexoftemp<indexofmul;indexoftemp++) {
			 for(int indexoftempnext=indexoftemp+1;indexoftempnext<indexofmul+1;indexoftempnext++) {
				 if(tempArrayForMultiply[indexoftempnext][0] != -1 && tempArrayForMultiply[indexoftemp][0] != -1){
					 if(tempArrayForMultiply[indexoftemp][0]==tempArrayForMultiply[indexoftempnext][0]) {
					     tempArray[indexofmultiply][0]=tempArrayForMultiply[indexoftemp][0];
					     tempArray[indexofmultiply][1]=(tempArrayForMultiply[indexoftemp][1]+tempArrayForMultiply[indexoftempnext][1]);
						 indexofmultiply++;
						 flag=true;
						 tempArrayForMultiply[indexoftemp][0]=-1;
						 tempArrayForMultiply[indexoftempnext][0]=-1;
						 
					 }
			    }
			}
				if(!flag)
				 {
				     tempArray[indexofmultiply][0]=tempArrayForMultiply[indexoftemp][0];
				     tempArray[indexofmultiply][1]=tempArrayForMultiply[indexoftemp][1];
					 indexofmultiply++;
					 tempArrayForMultiply[indexoftemp][0]=-1;
				 }
			 
			 }
		 
		 for(int index=0;index<indexofmultiply-1;index++) {
             for(int indexofarray=index;indexofarray<indexofmultiply-1;indexofarray++) { 
                 if(tempArray[index][0] < tempArray[indexofarray][0]) {
                     
                     int temp = tempArray[indexofarray][0];
                     tempArray[indexofarray][0] = tempArray[index][0];
                     tempArray[index][0] = temp;
                     
                     int tempcoeff = tempArray[indexofarray][1];
                     tempArray[indexofarray][1] = tempArray[index][1];
                     tempArray[index][1] = tempcoeff;
                 }
             }
         }
		 int [][] degreecoefficient = new int[indexofmultiply][2];
		
		 for(int index=0;index<indexofmultiply;index++) {
		
		         degreecoefficient[index][0] = tempArray[index][0];
		         degreecoefficient[index][1] = tempArray[index][1];
		 }
		 return degreecoefficient;
	 }

}
