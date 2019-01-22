package arrayoperation;

import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

public class TestJunit {
	
   
   Array array = new Array();
   
   @Test
   public void testMaxMirrortest1() {	  
      assertEquals(3,array.maxMirror(new int[]{1, 2, 3, 8, 9, 3, 2, 1}));
      
   }
   @Test
   public void testMaxMirrortest2() {	  
      assertEquals(7,array.maxMirror(new int[]{1, 4, 5, 3, 5, 4, 1}));
   }
   
   @Test
   public void testMaxMirrortest3() {	  
      assertEquals(3,array.maxMirror(new int[]{1, 2, 1, 4}));
   }
   
   @Test
   public void testMaxMirrortest4() {	  
      assertEquals(2,array.maxMirror(new int[]{7, 1, 4, 9, 7, 4, 1}));
   }
   
   @Test(expected=NullPointerException.class)
   public void testMaxMirrortest5() {	  
      assertEquals("Array is Empty",array.maxMirror(null));
   }
   /*****************************************************************************/
   @Test
   public void testCountClumps1() {	  
      assertEquals(2,array.countClumps(new int[]{1, 2, 2, 3, 4, 4}));
   }
   @Test
   public void testCountClumps2() {	  
      assertEquals(2,array.countClumps(new int[]{1, 1, 2, 1, 1}));
   }
   @Test
   public void testCountClumps3() {	  
      assertEquals(1,array.countClumps(new int[]{1, 1, 1, 1, 1}));
   }
   
   @Test(expected=NullPointerException.class)
   public void testCountClumps4() {	  
      assertEquals("Array is Empty",array.countClumps(null));
   }
  
   /*******************************************************************************/
   @Test
   public void testSplitArray1() {	  
      assertEquals(-1,array.splitArray(new int[]{2, 1, 1, 2, 1}));
   }
   @Test
   public void testSplitArray2() {	  
	      assertEquals(3,array.splitArray(new int[]{1, 1, 1, 2, 1}));
   }
   
   @Test
   public void testSplitArray3() {	  
	      assertEquals(1,array.splitArray(new int[]{10, 10}));
   }
   
   @Test(expected=NullPointerException.class)
   public void testSplitArray4() {	  
      assertEquals("Array is Empty",array.splitArray(null));
   }
   
   /******************************************************************************/
   @Test
   public void testFixXY1() throws Exception {	
	   int returnedArray[] = array.fixXY(new int[]{5, 4, 9, 4, 9, 5},4,5);
	   int []expectedArr = new int[]{9, 4, 5, 4, 5, 9};
	   Assert.assertArrayEquals( expectedArr, returnedArray );
   }
   
   @Test
   public void testFixXY2() throws Exception {	
	   int returnedArray[] = array.fixXY(new int[]{1, 4, 1, 5},4,5);
	   int []expectedArr = new int[]{1, 4, 5, 1};
	   Assert.assertArrayEquals( expectedArr, returnedArray );
   }
   
   @Test
   public void testFixXY3() throws Exception {	
	   int returnedArray[] = array.fixXY(new int[]{1, 4, 1, 5, 5, 4, 1},4,5);
	   int []expectedArr = new int[]{1, 4, 5, 1, 1, 4, 5};
	   Assert.assertArrayEquals( expectedArr, returnedArray );
   }
   
   @Test(expected=NullPointerException.class)
   public void testFixXY4() throws Exception {	
	   int returnedArray[] = array.fixXY(null,4,5);
   }
   
   //unequal numbers of X and Y in input array.
   @Test(expected=Exception.class)
   public void testFixXY5() throws Exception {	
	   int returnedArray[] = array.fixXY(new int[]{1, 3, 1, 5, 5, 4, 1},4,5);
   }
   
   // adjacents X values are there
   @Test(expected=Exception.class)
   public void testFixXY6() throws Exception {	
	   int returnedArray[] = array.fixXY(new int[]{1, 4, 4, 5, 5, 4, 1},4,5);
   }
   
// X occurs at the last index of array
   @Test(expected=Exception.class)
   public void testFixXY7() throws Exception {	
	   int returnedArray[] = array.fixXY(new int[]{1, 4, 1, 5, 5, 4, 4},4,5);
   }
}
