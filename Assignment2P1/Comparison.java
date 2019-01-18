package hexcalc;

public class Comparison {

	
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
	static int compare(String hexn1,String hexn2){
		return hexn1.compareTo(hexn2);
	}
	
	static boolean compareEqualTo(String hexn1,String hexn2){
		int status;
		status = compare(hexn1,hexn2);
		if(status==0)
			return true;
		return false;
	}
	
	static boolean compareGreaterThan(String hexn1,String hexn2){
    	int status;
		status = compare(hexn1,hexn2);
		if(status==1)
			return true;
		return false;		
	}
    
	static boolean compareLesserThan(String hexn1,String hexn2){
    	int status;
		status = compare(hexn1,hexn2);
		if(status==-1)
			return true;
		return false;
	}
}
