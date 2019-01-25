mport static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

 public class SparseMatrixTest {
    private static SparseMatrix sparse1;
    private static SparseMatrix sparse2;
    private static int matrix1[][];
    private static int matrix2[][];

     @BeforeClass
    public static void init(){
        matrix1 = new int[][]{{1,2,10},{1,4,12},{3,3,5},{4,1,15},{4,2,12}};
        sparse1 = new SparseMatrix(matrix1);
        matrix1 = new int[][]{{2,1,10},{4,1,12},{3,3,6},{1,4,5},{0,1,4}};
        sparse2 = new SparseMatrix(matrix2);
    }
    @Test
    public void transposeTest() {
        int transposeResult[][] = {{2,1,10},{4,1,12},{3,3,5},{1,4,15},{2,4,12}};
        assertArrayEquals(transposeResult,sparse1.transpose());
    }
    @Test
    public void isSymmetricFalseTest() {
        assertEquals(false,sparse1.isSymmetric());
    }
    @Test
    public void isSymmetricTrueTest() {
        SparseMatrix sparse = new SparseMatrix(new int[][]{{1,1,4},{2,2,8},{3,3,12},{4,4,0},{1,2,4},{2,1,4}});
        assertEquals(true,sparse.isSymmetric());
    }
}