import static org.junit.Assert.*;

import org.junit.Test;


public class PolyTest {
    private Poly poly;
    private static final int pow[] = {2,1,0};
    private static final int coeff[] = {3,2,4};

    @Test
    public void evaluateTest() {
        poly = new Poly(pow,coeff);
        assertEquals(20.0,poly.evaluate(2.0f),0);
    }
    
    @Test
    public void degreeTest() {
        poly = new Poly(pow,coeff);
        assertEquals(2,poly.degree());
    }
    
    @Test
    public void addPolyTest() {
        poly = new Poly();
        int pow1[] = {2,1,0};
        int coeff1[] ={3,2,4};
        Poly poly1 = new Poly(pow1,coeff1);
        int pow2[] = {1,2,3,4};
        int coeff2[] ={4,1,2,3};
        Poly poly2 = new Poly(pow2,coeff2);
        int result_pow[] = {4,3,2,1,0};
        int result_coeff[] ={3,2,4,6,4};
        assertArrayEquals(result_pow,poly.addPoly(poly1,poly2).getPower());
        assertArrayEquals(result_coeff,poly.addPoly(poly1,poly2).getCoeff());
    }
    
    @Test
    public void multiplyPolyTest() {
        poly = new Poly();
        int pow1[] = {2,1,0};
        int coeff1[] ={3,2,4};
        Poly poly1 = new Poly(pow1,coeff1);
        int pow2[] = {2,4};
        int coeff2[] ={1,3};
        Poly poly2 = new Poly(pow2,coeff2);
        int result_pow[] = {6,5,4,3,2};
        int result_coeff[] ={9,6,15,2,4};
        assertArrayEquals(result_pow,poly.multiplyPoly(poly1,poly2).getPower());
        assertArrayEquals(result_coeff,poly.multiplyPoly(poly1,poly2).getCoeff());
    }
}