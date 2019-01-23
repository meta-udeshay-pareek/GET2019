package spliarray;


import org.junit.Test;


public class SplitArrayNegativeCase {
	SplitArray splitarray=new SplitArray();
	@Test(expected = AssertionError.class)
	public void testSplitArray1() {
	  int[] arr=new int[0];
	  splitarray.splitArray(arr);
	  System.out.println("pls do not enter the empty array");
	}
}
