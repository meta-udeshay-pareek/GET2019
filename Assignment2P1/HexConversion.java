package hexcalc;

public class HexConversion implements ConvertNumber {
	
	//converting hex to decimal
	public static int stringToNumber(String hexNum){
		
		return Integer.parseInt(hexNum,16);
	}
	
	//converting decimal to hexadecimal
	public static String numberToString(int num){
		return Integer.toHexString(num);
	}
	

}
