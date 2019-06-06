package sparsematrix;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSparseMatrix {

	
	SparseMatrix s1 = new SparseMatrix(new int[][]{{4,5,6},{0,0,1},{0,4,1},{1,2,1},{2,1,1},{2,4,1},{3,1,1}});
	SparseMatrix s2 = new SparseMatrix(new int[][]{{4,5,5},{0,1,1},{0,2,1},{1,4,1},{2,0,1},{3,2,1}});
	SparseMatrix adds1s2 = new SparseMatrix(new int[][]{{4,5,11},{0,0,1},{0,1,1},{0,2,1},{0,4,1},{1,2,1},{1,4,1},{2,0,1},{2,1,1},{2,4,1},{3,1,1},{3,2,1}});
	
	SparseMatrix s3 = new SparseMatrix(new int[][]{{4,4,4},{0,1,1},{0,2,1},{2,0,1},{3,2,1}});
	SparseMatrix s4 = new SparseMatrix(new int[][]{{4,4,4},{0,0,1},{1,2,1},{2,1,1},{3,1,1}});	
	
	SparseMatrix adds3s4 = new SparseMatrix(new int[][]{{4,4,8},{0,0,1},{0,1,1},{0,2,1},{1,2,1},{2,0,1},{2,1,1},{3,1,1},{3,2,1}});
	
	
	SparseMatrix muls4s3 = new SparseMatrix(new int[][]{{4,4,3},{0,1,1},{0,2,1},{1,0,1}});
	SparseMatrix muls3s1 = new SparseMatrix(new int[][]{{4,5,7},{0,1,1},{0,2,1},{0,4,1},{2,0,1},{2,4,1},{3,1,1},{3,4,1},});
	
	@Test(expected=RuntimeException.class)
	public void sparseMatrixOperationTest() {
		
		//Matrix addition checking
		assertEquals(true , SparseMatrix.equal(s1.addMatrix(s2).getMatrix(),adds1s2.getMatrix()));
		assertEquals(true , SparseMatrix.equal(s3.addMatrix(s4).getMatrix(),adds3s4.getMatrix()));
		
		
		//Matrix multiplication
		assertEquals(true ,s1.multiplyMatrix(s2).getMatrix());//Runtime exception in it
		assertEquals(true ,s1.multiplyMatrix(s4).getMatrix());//Runtime exception in it
		
		
		assertEquals(true ,SparseMatrix.equal(s4.multiplyMatrix(s3).getMatrix(),muls4s3.getMatrix()));
		assertEquals(true ,SparseMatrix.equal(s3.multiplyMatrix(s1).getMatrix(),muls3s1.getMatrix()));
		
	}
	

}
