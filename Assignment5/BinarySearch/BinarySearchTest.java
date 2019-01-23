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
	//parameters for passing
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
	
	//parameters initializing
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { {new int[]{1, 1, 1, 2, 1 }, 0,4,2,3,null,null} ,{ new int[]{2, 1, 1, 2, 1},0,4,2,3,null,null},{new int[]{2, 1, 1, 2, 1},0,4,8,-1,null,null}
		, {new int[]{}, 0,4,2,0,NullPointerException.class,"Array is Empty"}});
	}
	
	//testing
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
