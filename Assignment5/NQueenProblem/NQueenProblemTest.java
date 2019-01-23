package nqueenproblem;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class NQueenProblemTest {

	 NQueenProblem Queen = new NQueenProblem(); 
	@Parameter(0)
	public int noOfQueen;
	
	@Parameter(1)
	public boolean expectedStatus;
	
	@Parameters
	public static Collection<Object[]> data() {
	  return Arrays.asList(new Object[][] { {0,true} ,{1,true},{2,false},{3,false},{4,true},{5,true},{6,true},{7,true},{8,true}});
	}
	@Test
	 public void testfindHcf(){

	       assertEquals(expectedStatus, Queen.solveNQ(noOfQueen) );

	 }
}
