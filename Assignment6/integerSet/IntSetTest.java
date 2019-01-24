package integerset;


import static org.junit.Assert.*;

import org.junit.Test;

public class IntSetTest {
    private IntSet intset;
    private int arr1[];
    private int arr2[];

    @Test(timeout = 1000)
    public void isMemberTest(){
    	//set created
        intset = new IntSet(new int[]{5,2,6,8,3,1,7,4}); 
        
        assertEquals(true,intset.isMember(5));
        assertEquals(true,intset.isMember(7));
        assertEquals(false,intset.isMember(18));
        assertEquals(false,intset.isMember(99));


    }

    @Test(timeout = 1000)
    public void sizeTest(){
    	//set created
        intset = new IntSet(new int[]{5,2,6,8,3,1,7,4}); 
        assertEquals(8,intset.size());
        
    	//null set created and size will be 0
        intset = new IntSet(new int[]{}); 
        assertEquals(0,intset.size());

    }

    @Test(timeout = 1000)
    public void isSubSetTest(){
    	//set created
        intset = new IntSet(new int[]{5,2,6,8,3,1,7,4}); 
        
        //passing a subset 
        assertEquals(false,intset.isSubSet(new IntSet(new int[]{8,3,52,42,6,7,5})));
        assertEquals(true,intset.isSubSet(new IntSet(new int[]{8,3,5,1})));
        //a null set is sub set of all set
        assertEquals(true,intset.isSubSet(new IntSet(new int[]{})));


    }
    
   
    
    @Test(timeout = 1000)
    public void unionTest(){
    	//set 1
        IntSet s1 = new IntSet(new int[]{1,2,3,4,5});
        //set 2
        IntSet s2 = new IntSet(new int[]{6,7,8,2,10});
        //union of both set
        IntSet unionSet = new IntSet(new int[]{1,2,3,4,5,6,7,8,10});
        //will check in array form 
        //set is first converting into array then comparing
        assertArrayEquals(unionSet.getSetElementInArrayForm(),(IntSet.union(s1,s2)).getSetElementInArrayForm());
    }
}