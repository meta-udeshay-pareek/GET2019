package countclumps;


import org.junit.Test;
/**
*Negative testcase 
*Array was empty
*/

public class ClumpsCountNegativeTest {
	ClumpsCount clumpscount = new ClumpsCount();
	@Test(expected = AssertionError.class)
	public void negativeTest()
	{
	  int[] arr =new int[0];
	  System.out.println("pls donot enter the empty array");
	  clumpscount.countClumps( arr);
	}
}
