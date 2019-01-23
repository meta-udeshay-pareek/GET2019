package lcmoftwonumber;



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
public class LcmTest {

	Lcm lcm = new Lcm();
	@Parameter(0)
	public int num1;
	@Parameter(1)
	public int num2;

	@Parameter(2)
	public int expectedResult;

	@Parameter(3)
	public Class<? extends Exception> expectedException;
	@Parameter(4)
	public String expectedExceptionMsg;

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Parameters
	 public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { {5,8,40,null,null},{6,18,18,null,null},{16,0,0,ArithmeticException.class,"0 is invalid for lcm"},{0,10,0,ArithmeticException.class,"0 is invalid for lcm"},{6,10,30,null,null} ,{26,52,52,null,null}});
	 }
	 @Test
	 public void testfindLcm(){

		 //setup expected exception
		    if (expectedException != null) {
		        thrown.expect(expectedException);
		        thrown.expectMessage(expectedExceptionMsg);
		    }
	       assertEquals(expectedResult, lcm.findLcm(num1, num2) );

	 }
}
