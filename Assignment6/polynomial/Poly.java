package polynomial;

public final class Poly {
	final int [] coefficient;
	final int degree;
	
	//creating a polynomial from arr
	public Poly(int []arr){
		//degree will be size of aray 
		this.degree = arr.length;
		this.coefficient=arr;
	}
	
	//returning degree of polynomial 
	int degree(){
		return this.degree;
	}
	
	/*
	 * @param value  the value of constant for calculation
	 * @return  result   after calculation the result
	 * */
	float evaluate(float value){
		float result=0;
		for(int i=0;i<this.degree;i++){
			result+=this.coefficient[i]*(Math.pow(value, i)); //coef*X^i
		}
		return result;
	}
	
	/*
	 * @param p1  polynomial object 1
	 * @param p2  polynomial object 2
	 * @return sumPoly  addition of both polynomial i.e. a new polynomial*/
	Poly addPoly(Poly p1, Poly p2){
		//creating sumPoly of sizeof max of p1 and p2 size
		int maxSize = Math.max(p1.degree(), p2.degree());
		int sumPoly[] = new int[maxSize];
		
		//p1 coefficient addition
		for(int i=0;i<p1.degree();i++){
			sumPoly[i]+=p1.coefficient[i];
		}
		
		//p2 coefficient addition with respective degree
		for(int i=0;i<p2.degree();i++){
			sumPoly[i]+=p2.coefficient[i];
		}
		
		//creating a polynomial from sumPoly and then returning a polynomial
		return new Poly(sumPoly);
		
	}
	
	/*
	 * @param p1  polynomial object 1
	 * @param p2  polynomial object 2
	 * @return mulPoly  multiplication of both polynomial i.e. a new polynomial*/
	Poly multiplyPoly(Poly p1, Poly p2){
		
		//creating mulPoly array size of p1.size+p2.size
		int mulPoly[] = new int[p1.degree()+p2.degree()-1]; 

		// Take ever term of first polynomial 
		for (int i=0; i<p1.degree(); i++) 
		{ 
		   // Multiply the current term of first polynomial 
		   // with every term of second polynomial. 
		   for (int j=0; j<p2.degree(); j++) 
			   mulPoly[i+j] += p1.coefficient[i]*p2.coefficient[j]; 
		} 

		return new Poly(mulPoly);
	}
}
