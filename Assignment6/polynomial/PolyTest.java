import static org.junit.Assert.*;


import static org.junit.Assert.*;

import org.junit.Test;

public class PolyTest {

	
	@Test
	public void evaluateTest() {
		int[] arr=new int[]{2,0};
		int[] arr1=new int[]{2,1};
		Poly p1 = new Poly(arr,arr1);
		assertEquals(9.0,p1.evaluate(2.0F),0.001);
		
	}
	@Test
	public void degreeTest() {
		int[] arr=new int[]{2,1,0};
		int[] arr1=new int[]{3,2,1};
		Poly p1 = new Poly(arr,arr1);
		assertEquals(2,p1.degreeOfPoly());
		
	}
	@Test
    public void addPolyTest() {
        int[] arr=new int[]{2,1,0};
        int[] arr1=new int[]{3,2,1};
        int[] arr2=new int[]{1,0};
        int[] arr3=new int[]{4,5};
        int[][] arrOut=new int[][] {{2,3},{1,6},{0,6}};
        Poly p1 = new Poly(arr,arr1);
        Poly p2 = new Poly(arr2,arr3);
        Poly p3 = new Poly(new int[] {},new int[] {});
        assertArrayEquals(arrOut,p3.addPoly(p1, p2));
        
    }
	@Test
    public void multipilyPolyTest() {
        int[] arr=new int[]{2,1,0};
        int[] arr1=new int[]{3,2,1};
        int[] arr2=new int[]{1,0};
        int[] arr3=new int[]{4,5};
        int[][] arrOut=new int[][] {{3,12},{2,23},{1,14},{0,5}};
        Poly p1 = new Poly(arr,arr1);
        Poly p2 = new Poly(arr2,arr3);
        Poly p3 = new Poly(new int[] {0},new int[] {0});
        assertArrayEquals(arrOut,p3.multiplyPoly(p1, p2));
        
    }
	@Test
    public void multipilyPolyTest1() {
        int[] arr=new int[]{4,1,0};
        int[] arr1=new int[]{5,3,2};
        int[] arr2=new int[]{2,0};
        int[] arr3=new int[]{7,3};
        int[][] arrOut=new int[][] {{6,35},{4,15},{3,21},{2,14},{1,9},{0,6}};
        Poly p1 = new Poly(arr,arr1);
        Poly p2 = new Poly(arr2,arr3);
        Poly p3 = new Poly(new int[] {0},new int[] {0});
        assertArrayEquals(arrOut,p3.multiplyPoly(p1, p2));
        
    }
}
