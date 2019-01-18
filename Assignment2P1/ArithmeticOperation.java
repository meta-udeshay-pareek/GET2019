package hexcalc;

public class ArithmeticOperation {
	
	/** 
	 * 
	 *@param hexn1 & hexn2 two hexadecimal string for operation
	 * calling two method for converting hex to decimal 
	 * applying operation on decimal numbers
	 * result of operation is passing back to numberToString() Method for hex conversion
	 * 
	 **/
	public int add(int num1,int num2){
		return (num1+num2 );
	}
	
	public int subtract(int num1,int num2){
		return (num1-num2);
	}
	
	public int  multiply(int num1,int num2){
		return (num1*num2);
	}
	
	public int  divide(int num1,int num2){
		int divison=0;
		try{
			divison = num1/num2;
			
		}catch(ArithmeticException ae){
			System.out.println(ae+" Give proper Input");
			
		}
		return divison;
		
	}

}
