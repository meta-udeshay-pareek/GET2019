package arraymaxmirror;

import static org.junit.Assert.*;

import org.junit.Test;


import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MaxMirrorTest {
@Parameters
 public static Collection<Object[]> data() {
	return Arrays.asList(new Object[][] { {new int[]{1, 2, 3, 8, 9, 3, 2, 1}, 3} ,{ new int[]{7, 1, 4, 9, 7, 4, 1},2},{new int[]{1,2,1,4},3}});
    }
 private int[] arrayinput;
 private int resultExpected;
 public MaxMirrorTest(int[] input, int expected) {
	this. arrayinput = input;
	this.resultExpected = expected;
    }
MaxMirror maxmirror = new MaxMirror();
@Test
public void test() {
    assertEquals(resultExpected, maxmirror.maxMirror( arrayinput));
}
}
