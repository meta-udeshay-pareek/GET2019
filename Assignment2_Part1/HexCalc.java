package hexcalc;

public class HexCalc implements ConvertNumber {
	
	//converting hex to decimal
	public int stringToNumber(String hexNum){
		
		return Integer.parseInt(hexNum,16);
	}
	
	//converting decimal to hexadecimal
	public String numberToString(int num){
		return Integer.toHexString(num);
	}
	
	/** 
	 * 
	 *@param hexn1 & hexn2 two hexadecimal string for operation
	 * calling two method for converting hex to decimal 
	 * applying operation on decimal numbers
	 * result of operation is passing back to numberToString() Method for hex conversion
	 * 
	 **/
	
	String add(String hexn1,String hexn2){
		return (
				this.numberToString(
						this.stringToNumber(hexn1)
						+
						this.stringToNumber(hexn2)
				)
	    );
	}
	
	String subtract(String hexn1,String hexn2){
		return (
				this.numberToString(
						this.stringToNumber(hexn1)
						-
						this.stringToNumber(hexn2)
				)
	    );
	}
	
	String multiply(String hexn1,String hexn2){
		return (
				this.numberToString(
						this.stringToNumber(hexn1)
						*
						this.stringToNumber(hexn2)
				)
	    );
	}
	
	String divide(String hexn1,String hexn2){
		return (
				this.numberToString(
						this.stringToNumber(hexn1)
						/
						this.stringToNumber(hexn2)
				)
	    );
	}
	
	
	/**
	 * @param hexn1 & hexn2 two hexadecimal string for comparison
	 * compare will return 
	 * 						1:h1>h2
	 * 						0:h1==h2
	 * 					   -1:h1<h2
	 * 	
	 * int compare(String hexn1,String hexn2) is common method which is comparing strings
	 * 
	 * */
	int compare(String hexn1,String hexn2){
		return hexn1.compareTo(hexn2);
	}
	
	boolean compareEqualTo(String hexn1,String hexn2){
		int status;
		status = compare(hexn1,hexn2);
		if(status==0)
			return true;
		return false;
	}
	
    boolean compareGreaterThan(String hexn1,String hexn2){
    	int status;
		status = compare(hexn1,hexn2);
		if(status==1)
			return true;
		return false;		
	}
    
    boolean compareLesserThan(String hexn1,String hexn2){
    	int status;
		status = compare(hexn1,hexn2);
		if(status==-1)
			return true;
		return false;
	}
	

}
