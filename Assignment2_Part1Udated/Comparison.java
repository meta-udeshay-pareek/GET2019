package hexcalc;

public interface Comparison {
	int compare(String hexn1,String hexn2);
	boolean compareEqualTo(String hexn1,String hexn2);
	boolean compareGreaterThan(String hexn1,String hexn2);
	boolean compareLesserThan(String hexn1,String hexn2);
}
