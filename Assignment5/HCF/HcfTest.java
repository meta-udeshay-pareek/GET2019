package assignment5;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class HcfTest {

	Hcf hcf = new Hcf();
	@Parameter(0)
	public int num1;
	@Parameter(1)
	public int num2;

	@Parameter(2)
	public int expectedResult;

	
	@Parameters
	 public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { {6,10,2} ,{26,52,26},{5,8,1},{6,18,6},{16,0,0},{0,10,0}});
	 }
	 @Test
	 public void testfindHcf(){

	       assertEquals(expectedResult, hcf.findHcf(num1, num2) );

	 }
}
