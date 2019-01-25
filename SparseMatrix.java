import java.util.Arrays;

 /**
 * Design an immutable class for representing two-dimensional sparse matrices. 
 * Note that for space efficiency you should be storing only non zero elements of a matrix.
a) It should support following methods 
return transpose of the matrix
check whether it is a symmetrical matrix
add two matrices
multiply two matrices
b) What is the time complexity of each of the methods?
Things to keep in mind
Object should be immutable
Write junit test cases
Methods should be efficient
 * @author admin
 * @version 1.0
 * @since 25/1/2019
 */
public class SparseMatrix {
    private int sparse[][];
    private final int sparseCols = 3;
    SparseMatrix(){

     }
    SparseMatrix(int sparse[][]){
        int sparseRows = sparse.length;
        this.sparse = new int[sparseRows][sparseCols];
        for(int row=0; row < sparseRows; row++){
            this.sparse[row][0] = sparse[row][0];
            this.sparse[row][1] = sparse[row][1];
            this.sparse[row][2] = sparse[row][2];
        }
    }
    /**
     * 
     * @param s1
     * @param s2
     * @return
     */
    public int[][] add(SparseMatrix s1,SparseMatrix s2){
        int n1 = s1.sparse.length;
        int n2 = s2.sparse.length;
        int resultMatrix[][] = new int[n1+n2][3];
        int i,j,k;
        for(i = 0, j = 0, k = 0; i < n1 && j < n2; k++){
            if(s1.sparse[i][0] == s2.sparse[j][0]){
                if(s1.sparse[i][1] == s2.sparse[j][1]){
                    resultMatrix[k][0] = s1.sparse[i][0];
                    resultMatrix[k][1] = s1.sparse[i][1];
                    resultMatrix[k][2] = s1.sparse[i][2] + s2.sparse[j][2];
                    i++;
                    j++;
                }
                else if(s1.sparse[i][1] < s2.sparse[j][1]){
                    resultMatrix[k][0] = s1.sparse[i][0];
                    resultMatrix[k][1] = s1.sparse[i][1];
                    resultMatrix[k][2] = s1.sparse[i][2];
                    i++;
                }
                else{
                    resultMatrix[k][0] = s2.sparse[j][0];
                    resultMatrix[k][1] = s2.sparse[j][1];
                    resultMatrix[k][2] = s2.sparse[j][2];
                    j++;
                }
            }
            else if(s1.sparse[i][0] < s2.sparse[j][0]){
                resultMatrix[k][0] = s1.sparse[i][0];
                resultMatrix[k][1] = s1.sparse[i][1];
                resultMatrix[k][2] = s1.sparse[i][2];
                i++;
            }
            else{
                resultMatrix[k][0] = s2.sparse[j][0];
                resultMatrix[k][1] = s2.sparse[j][1];
                resultMatrix[k][2] = s2.sparse[j][2];
                j++;
            }
        }
        if(i >= n1){
            while(j < n2){
                resultMatrix[k][0] = s2.sparse[j][0];
                resultMatrix[k][1] = s2.sparse[j][1];
                resultMatrix[k][2] = s2.sparse[j][2];
                j++;
                k++;
            }
        }
        if(j >= n2){
            while(i < n1){
                resultMatrix[k][0] = s1.sparse[i][0];
                resultMatrix[k][1] = s1.sparse[i][1];
                resultMatrix[k][2] = s1.sparse[i][2];
                i++;
                k++;
            }
        }
        for(int l = 0; l < k; l++){
            for(int m = 0; m < 3; m++)
                System.out.print(resultMatrix[i][j]);
            System.out.println();
        }
        return Arrays.copyOfRange(resultMatrix,0,k);
    }

     public int[][] multiply(int sparse1[][],int sparse2[][]){

         return sparse1;
    }
    /**
     * calculates the transpose of the given sparse matrix
     * @return transposed sparse matrix of the given matrix as 2D array of int
     */
    public int[][] transpose(){
        int sparseRows = sparse.length;
        int transpose[][] = new int[sparseRows][sparseCols];
        for(int row = 0; row < sparseRows; row++){
            transpose[row][0] = sparse[row][1];
            transpose[row][1] = sparse[row][0];
            transpose[row][2] = sparse[row][2];
        }
        return transpose;
    }
    /**
     * checks whether the sparse matrix is symmetric or not
     * @return true if the given sparse matrix is symmetric otherwise return false
     */
    public Boolean isSymmetric(){
        int sparseRows = sparse.length;
        int transpose[][] = transpose();
        Boolean found = false;
        for(int rowForSparse =0; rowForSparse < sparseRows; rowForSparse++){
            found = false;
            for(int rowForTranspose = 0; rowForTranspose < sparseRows; rowForTranspose++){
                if(sparse[rowForSparse][0] == transpose[rowForTranspose][0] &&
                        sparse[rowForSparse][1] == transpose[rowForTranspose][1] &&
                        sparse[rowForSparse][2] == transpose[rowForTranspose][2]){
                    found = true;
                }
            }
            if(found == false)
                return false;
        }
        return true;
    }
}