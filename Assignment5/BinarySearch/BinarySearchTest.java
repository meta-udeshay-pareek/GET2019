package binarySearch;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;



import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BinarySearchTest {

	BinarySearch binarySearch = new BinarySearch();
	@Parameter(0)
	public int arr[];
	@Parameter(1)
	public int firstIndex;
	@Parameter(2)
	public int lastIndex;
	@Parameter(3)
	public int valueForSearch;
	@Parameter(4)
	public int expectedResult;
	@Parameter(5)
	public Class<? extends Exception> expectedException;
	@Parameter(6)
	public String expectedExceptionMsg;

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { {new int[]{1, 1, 1, 2, 1 }, 0,4,2,3,RuntimeException.class,"Array is not sorted"} ,{ new int[]{2, 1, 1, 2, 1},0,4,2,3,RuntimeException.class,"Array is not sorted"},{new int[]{2, 1, 1, 2, 1},0,4,8,-1,RuntimeException.class,"Array is not sorted"}
		, {new int[]{}, 0,4,2,0,NullPointerException.class,"Array is Empty"}, {new int[]{1, 2,3,4,5 }, 0,4,4,3,null,null},{new int[]{8,15,24,69,74,105}, 0,5,69,3,null,null},{new int[]{-8,-3,-1,0,1,4,6,7,9}, 0,8,0,3,null,null}});
	}
	@Test
	 public void testfindLcm(){

		 //setup expected exception
		    if (expectedException != null) {
		        thrown.expect(expectedException);
		        thrown.expectMessage(expectedExceptionMsg);
		    }
	       assertEquals(expectedResult, binarySearch.binarySearch(arr, firstIndex,lastIndex,valueForSearch) );

	 }

}
