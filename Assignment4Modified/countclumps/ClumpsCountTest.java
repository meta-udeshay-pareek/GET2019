package countclumps;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collection;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
*we parameterized class to run the positive test cases.
* there are three positive test cases in this class.
*/
@RunWith(Parameterized.class)
public class ClumpsCountTest {
  @Parameters
  public static Collection<Object[]> data()
  {
    return Arrays.asList(new Object[][] {{new int[]{1, 2, 2, 3, 4, 4 }, 2 } ,{ new int[]{1, 1, 2, 1, 1},2},{new int[]{1,1,1,1,1},1}});
  }
  private int[] arryInput;
  private int resultExpected;
  public ClumpsCountTest(int[] input, int expected) 
  {
    this.arryInput = input;
    this.resultExpected = expected;
  }
 ClumpsCount clumpscount = new ClumpsCount();
 @Test
 public void testCountClumps() 
 {
   assertEquals(resultExpected, clumpscount.countClumps(arryInput));
 }
}
