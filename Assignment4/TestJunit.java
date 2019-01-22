package arrayoperation;

import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

public class TestJunit {
	
   
   Array array = new Array();
   
   @Test
   public void testMaxMirror() {	  
      //assertEquals(3,array.maxMirror(new int[]{1, 2, 3, 8, 9, 3, 2, 1}));
      //assertEquals(7,array.maxMirror(new int[]{1, 4, 5, 3, 5, 4, 1}));
      assertEquals(7,array.maxMirror(null));
   }
   
   @Test
   public void testCountClumps() {	  
      assertEquals(2,array.countClumps(new int[]{1, 2, 2, 3, 4, 4}));
   }
   
   @Test
   public void testSplitArray() {	  
      assertEquals(-1,array.splitArray(new int[]{2, 1, 1, 2, 1}));
   }
   
   @Test
   public void testFixXY() {	
	   int returnedArray[] = array.fixXY(new int[]{5, 4, 9, 4, 9, 5},4,5);
	   int []expectedArr = new int[]{9, 4, 5, 4, 5, 9};
	   Assert.assertArrayEquals( expectedArr, returnedArray );
   }
}