package arraymaxmirror;

import org.junit.Test;

public class MaxMirrorNegativeTest {
   MaxMirror maxmirror = new MaxMirror();
   @Test(expected = AssertionError.class)
   public void negativeTest() {
	int[] arr =new int[0];
	System.out.println("pls donot enter the empty array");
	maxmirror.maxMirror( arr);
}
}