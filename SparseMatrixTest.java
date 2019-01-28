package sparsematrix;

import static org.junit.Assert.*;
import org.junit.Test;
public class SparseMatrixTest {

		@Test
		public void getTransposeTestCaseWithInput1()
		{
			int[][] input = {
					{1 , 0 , 0},
					{0 , 1 , 0},
					{0 , 1 , 1},
			};
			int[][] expected = {
					{1 , 0 , 0},
					{0 , 1 , 1},
					{0 , 0 , 1},
			};
			assertEquals(true, new MatrixOperation(expected).equals((new MatrixOperation(input).getTranspose())));
			
		}
		
		@Test
		public void getTransposeTestCaseWithInput2()
		{
			int[][] input = {
					{1 , 0 },
					{0 , 1 },
					{0 , 1 },
			};
			int[][] expected = {
					{1 , 0 , 0},
					{0 , 1 , 1},
			};
			assertEquals(true, new MatrixOperation(expected).equals((new MatrixOperation(input).getTranspose())));
			
		}
		
		@Test
		public void getTransposeTestCaseWithInput3()
		{
			int[][] input = {
					{1 , 0 },
					{0 , 1 },
					{0 , 1 },
			};
			int[][] expected = {
					{1 , 0 , 1},
					{0 , 1 , 1},
			};
			assertEquals(false, new MatrixOperation(expected).equals((new MatrixOperation(input).getTranspose())));
			
		}
		
		@Test
		public void symmetricalTestCaseWithInput1()
		{
			int[][] input = {
					{1 , 0 , 0},
					{0 , 1 , 0},
					{0 , 0 , 1},
			};
			assertEquals(true, new MatrixOperation(input).symmetrical());
			
		}
		
		@Test
		public void symmetricalTestCaseWithInput2()
		{
			int[][] input = {
					{1 , 0 , 0 , 0},
					{0 , 1 , 0 , 0},
					{0 , 0 , 1 , 0},
					{0 , 0 , 0 , 1},
			};
			assertEquals(true, new MatrixOperation(input).symmetrical());
			
		}
		
		@Test
		public void symmetricalTestCaseWithInput3()
		{
			int[][] input = {
					{1 , 0 , 0 , 0},
					{0 , 1 , 0 , 0},
					{0 , 0 , 1 , 0},
					{0 , 1 , 0 , 1},
			};
			assertEquals(false, new MatrixOperation(input).symmetrical());
			
		}
		
		
		@Test
		public void addMatrixTestCaseWithInput1()
		{
			int[][] input1 = {
					{1 , 0 , 0},
					{0 , 1 , 0},
					{0 , 0 , 1},
			};
			int[][] input2 = {
					{1 , 1 , 0},
					{0 , 1 , 0},
					{0 , 0 , 1},
			};
			int[][] expected = {
					{2 , 1 , 0},
					{0 , 2 , 0},
					{0 , 0 , 2},
			};
			MatrixOperation matrixOperation = new MatrixOperation(input1);
			MatrixOperation matrixOperation2 = new MatrixOperation(input2);
			MatrixOperation result = new MatrixOperation(expected);
			assertEquals(true, result.equals(matrixOperation.addMatrix(matrixOperation2)));
			
		}
		
		@Test(expected = AssertionError.class)
		public void addMatrixTestCaseWithInput2()
		{
			int[][] input1 = {
					{1 , 0 , 0},
					{0 , 1 , 0},
					{0 , 0 , 1},
			};
			int[][] input2 = {
					{1 , 1 , 0},
					{0 , 1 , 0},
			};
			int[][] expected = {
					{2 , 1 , 0},
					{0 , 2 , 0},
					{0 , 0 , 2},
			};
			MatrixOperation matrixOperation = new MatrixOperation(input1);
			MatrixOperation matrixOperation2 = new MatrixOperation(input2);
			MatrixOperation result = new MatrixOperation(expected);
			assertEquals(true, result.equals(matrixOperation.addMatrix(matrixOperation2)));
			
		}
		
		@Test
		public void addMatrixTestCaseWithInput3()
		{
			int[][] input1 = {
					{1 , 0},
					{0 , 1},
			};
			int[][] input2 = {
					{1 , 1},
					{0 , 1},
			};
			int[][] expected = {
					{2 , 1},
					{0 , 2},
			};
			MatrixOperation matrixOperation = new MatrixOperation(input1);
			MatrixOperation matrixOperation2 = new MatrixOperation(input2);
			MatrixOperation result = new MatrixOperation(expected);
			assertEquals(true, result.equals(matrixOperation.addMatrix(matrixOperation2)));
			
		}
		
		@Test(expected = AssertionError.class)
		public void mulMatrixTestCaseWithInput1()
		{
			int[][] input1 = {
					{1 , 0 , 0},
					{0 , 1 , 0},
					{0 , 0 , 1},
			};
			int[][] input2 = {
					{1 , 1 , 0},
					{0 , 1 , 0},
			};
			int[][] expected = {
					{2 , 1 , 0},
					{0 , 2 , 0},
					{0 , 0 , 2},
			};
			
			//matrix can't be multiplied as no. of column if first is not equal to no. of row in second
			
			MatrixOperation matrixOperation = new MatrixOperation(input1);
			MatrixOperation matrixOperation2 = new MatrixOperation(input2);
			MatrixOperation result = new MatrixOperation(expected);
			assertEquals(true, result.equals(matrixOperation.addMatrix(matrixOperation2)));
			
		}
		
		@Test
		public void mulMatrixTestCaseWithInput2()
		{
			int[][] input1 = {
					{1 , 0 , 0},
					{0 , 1 , 0},
					{0 , 0 , 1},
			};
			int[][] input2 = {
					{1 , 0 , 0},
					{0 , 1 , 0},
					{0 , 0 , 1},
			};
			int[][] expected = {
					{1 , 0 , 0},
					{0 , 1 , 0},
					{0 , 0 , 1},
			};
			MatrixOperation matrixOperation = new MatrixOperation(input1);
			MatrixOperation matrixOperation2 = new MatrixOperation(input2);
			MatrixOperation result = new MatrixOperation(expected);
			assertEquals(true, result.equals(matrixOperation.mulMatrix(matrixOperation2)));
			
		}
		
		@Test
		public void mulMatrixTestCaseWithInput3()
		{
			int[][] input1 = {
					{1 , 0 , 1},
					{0 , 1 , 0},
					{0 , 0 , 1},
			};
			int[][] input2 = {
					{1 , 0 , 0},
					{0 , 1 , 0},
					{1 , 0 , 1},
			};
			int[][] expected = {
					{2 , 0 , 1},
					{0 , 1 , 0},
					{1 , 0 , 1},
			};
			MatrixOperation matrixOperation = new MatrixOperation(input1);
			MatrixOperation matrixOperation2 = new MatrixOperation(input2);
			MatrixOperation result = new MatrixOperation(expected);
			assertEquals(true, result.equals(matrixOperation.mulMatrix(matrixOperation2)));
			
		}
		
		@Test
		public void mulMatrixTestCaseWithInput4()
		{
			int[][] input1 = {
					{1 , 0 , 1},
					{1 , 0 , 0},
					{0 , 0 , 1},
			};
			int[][] input2 = {
					{1},
					{0},
					{0},
			};
			int[][] expected = {
					{1},
					{1},
					{0},
			};
			MatrixOperation matrixOperation = new MatrixOperation(input1);
			MatrixOperation matrixOperation2 = new MatrixOperation(input2);
			MatrixOperation result = new MatrixOperation(expected);
			assertEquals(true, result.equals(matrixOperation.mulMatrix(matrixOperation2)));
			
		}
		
}
