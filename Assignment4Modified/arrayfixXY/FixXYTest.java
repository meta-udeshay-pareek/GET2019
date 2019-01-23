package arrayfixXY;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.internal.ArrayComparisonFailure;


public class FixXYTest {	
FixXY fixXYobj=new FixXY();
@Test
public void fixXYtest1() throws ArrayComparisonFailure, Exception {
	int[] arr = new int[]{5, 4, 9, 4, 9, 5};
	int[] expected = new int[]{9, 4, 5, 4, 5, 9};
	assertArrayEquals( "Correct",expected,fixXYobj.fixXY( arr, 4, 5) );
}
@Test
public void fixXYtest2() throws ArrayComparisonFailure, Exception {
	int[] arr = new int[]{1, 4, 1, 5};
	int[] expected = new int[]{1, 4, 5, 1};
	assertArrayEquals( "Correct",expected,fixXYobj.fixXY( arr, 4, 5) );
}
@Test
public void fixXYtest3() throws ArrayComparisonFailure, Exception {
	int[] arr = new int[]{1, 4, 1, 5, 5, 4, 1};
	int[] expected = new int[]{1, 4, 5, 1, 1, 4, 5};
	assertArrayEquals( "Correct",expected,fixXYobj.fixXY( arr, 4, 5) );
}
@Test(expected = AssertionError.class)
public void fixXYtest4() throws Exception
{
	int[] arr =new int[0];
	System.out.println("pls donot enter the empty array");
	fixXYobj.fixXY( arr, 4, 5);
}
@Test(expected = AssertionError.class)
public void fixXYtest5() throws Exception
{
	int[] arr=new int[]{1, 4, 1, 5, 5, 4, 1};
	System.out.println("pls donot the same x and y ");
	fixXYobj.fixXY( arr, 4, 4);
}
@Test(expected = AssertionError.class)
public void fixXYtest6() throws Exception
{
	int[] arr=new int[]{1, 4, 1, 5, 5, 1, 4};
	System.out.println("pls donot enter the last element as x in  array");
	fixXYobj.fixXY( arr, 4, 5);
}
}
