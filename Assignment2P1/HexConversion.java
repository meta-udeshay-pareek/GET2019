package hexcalc;

public class HexConversion implements ConvertNumber {
	
	//converting hex to decimal
	public int stringToNumber(String hexNum){
		
		return Integer.parseInt(hexNum,16);
	}
	
	//converting decimal to hexadecimal
	public String numberToString(int num){
		return Integer.toHexString(num);
	}
	

}
