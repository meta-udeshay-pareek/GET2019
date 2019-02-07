package sparsematrix;

import java.util.Arrays;

public final class SparseMatrix {
	
	private final int row;//number of rows in matrix
	private final int col;//number of column in matrix
	private final int noOfValue;//number of non zero value in matrix
	
	private final int[][] sparseMatirx;//sparse matrix
	

	
	/*
	 * @param sm  sparse matrix passed by user for operation
	 * sm[noOfNonZeroValue][3]={
	 * 							{numberOfRows,numberOfColumn,numberOfNonZeroValue}
	 * 												............
	 * 							}
	 * First row of matrix will contain information of matrix
	 *  [0][0]=>number of rows
	 *  [0][1]=>number of column
	 *  [0][2]=>number of non zero value in matrix
	 *  
	 *  rest of matrix will contain 
	 *  	--> e.g. {1,2,5}  [i][0]=>row position of non zero value in matrix
	 *  					  [i][1]=>column position of non zero value in matrix
	 *  					  [i][2]=>non zero value in matrix
	 *  	where i:-row number in two dimensional sparse matrix representation array "sm[numberOfNonZeroValue][3]"
	 *  */
	public SparseMatrix(int [][]sm){
		this.row = sm[0][0];
		this.col = sm[0][1];
		this.noOfValue = sm[0][2];
		this.sparseMatirx = sm;
	}
	
	
	
	
	/**************Getter start*****************/
	/*
	 * @return row  number of rows in this matrix
	 * */
	public int  getRow(){
		return this.row;
	}
	
	/*
	 * @return col  number of columns in this matrix
	 * */
	public int  getColumn(){
		return this.col;
	}
	
	/*
	 * @return noOfValue  number of non zero values  in this matrix
	 * */
	public int  getNumberOfValue(){
		return this.noOfValue;
	}
	
	/*
	 * @return noOfValue  size/length os array is same as it
	 * */
	public int getSize(){
		return this.noOfValue+1;
	}
	
	/*
	 * @return sparseMatirx  
	 * */
	public int[][]  getMatrix(){
		return ( Arrays.copyOf(this.sparseMatirx, this.getSize()) );
	}
	
	/**************Getter End*****************/
	
	
	
	
	/*
	 * @param sm  sparse matrix for addition -->this.sparseMatrix+sm.sparseMatirx
	 * @return object of SparseMatrix  after addition
	 * */
	public SparseMatrix addMatrix(SparseMatrix sm){
		
		//creating an array of length of maximum possible no. of non zero value after addition of two matrix +1 extra for information row about matrix
		int [][] result=new int[this.getRow()*this.getColumn()+1][3];;//result after addition of two sparse matrix
		
		//starting both matrix row from 1 because 0th row contain info about matrix
    	int thisRow = 1, smRow = 1; 
    	
    	//row for result matrix
    	int row=0;
		
	
		// if matrices don't have same dimensions 
        if (this.getRow() != sm.getRow() || this.getColumn() != sm.getColumn()) { 
            	throw new RuntimeException("Matrices arn't of same dimension so can't be added");
        }
        else{
        
        	
        	/*******matrix info assigning at 0th row******/
        	result[row][0]=this.getRow();
        	result[row][1]=this.getColumn();
        	//result[row][2]=number of nonzero value will assign at last when we will get all the non zero value in resultant matrix after addition
        	
        	row++;//row increment i.e from first row all the result will store
        	
        	while (thisRow < this.getSize() && smRow < sm.getSize()){ 
        		
	        		// if sm's row and col is smaller 
	                if ( this.sparseMatirx[thisRow][0] > sm.sparseMatirx[smRow][0]
	                									||  
	                		(this.sparseMatirx[thisRow][0] == sm.sparseMatirx[smRow][0] 
	                									&&  
	                		 this.sparseMatirx[thisRow][1] > sm.sparseMatirx[smRow][1])
	                   ){ 
	                	
		                    // insert smaller value into result 
	                		insert(result, row, sm.sparseMatirx[smRow][0], sm.sparseMatirx[smRow][1], sm.sparseMatirx[smRow][2]);                      
		                    row++; //row increment of result matrix
		                    smRow++;//row increment of sm matirx
	                   }
	                
	                // if this's row and col is smaller 
	                else if (this.sparseMatirx[thisRow][0] < sm.sparseMatirx[smRow][0] 
	                									||  
	                			(this.sparseMatirx[thisRow][0] == sm.sparseMatirx[smRow][0] 
	                									&&  
	                			this.sparseMatirx[thisRow][1] < sm.sparseMatirx[smRow][1])
	                	){ 
	  
	                 
	                	// insert smaller value into result 
	                	insert(result, row, this.sparseMatirx[thisRow][0], this.sparseMatirx[thisRow][1], this.sparseMatirx[thisRow][2]);   
	                    row++; //row increment of result matrix
	                    thisRow++;//row increment of this matrix
	                }
	                else { 
	                	  
	                    // add the values as row and col is same 
	                    int addedval = this.sparseMatirx[thisRow][2] +sm.sparseMatirx[smRow][2]; 
	  
	                    if (addedval != 0){
	                    	insert(result, row, this.sparseMatirx[thisRow][0], this.sparseMatirx[thisRow][1], addedval);
		                    row++; //row increment of result matrix
		                    smRow++;//row increment of sm matirx
		                    thisRow++;//row increment of this matrix
	                    }
	                       
	                } 
        	}
        	
        	 // insert remaining elements 
            while (thisRow < this.getSize()){
            	
            	 insert(result, row, this.sparseMatirx[thisRow][0], this.sparseMatirx[thisRow][1], this.sparseMatirx[thisRow][2]);   
        		 row++; //row increment of result matrix
                 thisRow++;//row increment of this matrix
            }
  
            // insert remaining elements 
            while (smRow < sm.getSize()){
            	 insert(result, row, sm.sparseMatirx[smRow][0], sm.sparseMatirx[smRow][1], sm.sparseMatirx[smRow][2]);             		
        		 row++; //row increment of result matrix
        		 smRow++;//row increment of this matrix
            } 	
        	
            
            //assigning number of non zero values to result 0th row 2nd col which contain info
            result[0][2]=row;
        }
        
        return new SparseMatrix(Arrays.copyOf(result, row));
	}
	
	
	
	/*
	 * @return object of SparseMatrix after transpose of this matrix
	 * */
	public SparseMatrix transpose(){
		
		int [][] result=new int[this.getSize()][3];;//result after transpose of  sparse matrix
		
		// to count number of elements in each column 
        int count[] = new int[this.getColumn() + 1]; 
        
        
        // initialize all to 0 
        for (int i = 1; i <=this.getColumn(); i++) 
            count[i] = 0; 
  
        for (int i = 1; i < this.getSize(); i++) 
            count[this.sparseMatirx[i][1]]++; 
        
        int[] index = new int[this.getColumn() + 1]; 
        
        // to count number of elements having col smaller 
        // than particular i 
  
        // as there is no col with value < 1 
        index[1] = 1; //it would be zero but here our 0th row contain information about matrix that's why we are doing i with 1
  
        // initialize rest of the indices 
        for (int i = 2; i <= this.getColumn(); i++) 
            index[i] = index[i - 1] + count[i - 1]; 
  
        for (int i = 1; i < this.getSize(); i++){ 
  
            // insert a data at rpos and increment its value 
            int rpos = index[this.sparseMatirx[i][1]]++; 
            
            // transpose row=col 
            result[rpos][0] = this.sparseMatirx[i][1]; 
  
            // transpose col=row 
            result[rpos][1] = this.sparseMatirx[i][0]; 
  
            // same value 
            result[rpos][2] = this.sparseMatirx[i][2]; 
        }
        
        result[0][0]=this.getRow();
        result[0][1]=this.getColumn();
        result[0][2]=this.getNumberOfValue();
  
        // the above method ensures 
        // sorting of transpose matrix 
        // according to row-col value 
        return   new SparseMatrix(result); 
	}
	
	
	/*
	 * @param sm  sparse matrix for multiply -->this.sparseMatrix*sm.sparseMatirx
	 * @return object of SparseMatrix  after multiply
	 * */
	public SparseMatrix multiplyMatrix(SparseMatrix sm){
		
		//creating an array of length of maximum possible no. of non zero value after addition of two matrix +1 extra for information row about matrix
		int [][] result=new int[this.getRow()*this.getColumn()+1][3];//result after Multiplication of two sparse matrix
		
		//result array row will start from 1 as 0th row will contain info about matrix
		int resultRow=1;
		
		//row of both matrix
		int thisRow, smRow;
		
		
		
		if (this.getColumn() != sm.getRow()){ 
			  
            // Invalid multiplication 
            throw new RuntimeException("Can't multiply Invalid dimensions");
        }
		else {
			// transpose sm to compare row 
	        // and col values and to add them at the end 
	        sm = new SparseMatrix(sm.transpose().getMatrix()); //transposing and converting returned array into sparse matrix form
	        
	        
	        // iterate over all elements of this 
	        for (thisRow = 1; thisRow < this.getSize();) { 
	  
	            // current row of result matrix 
	            int row = this.sparseMatirx[thisRow][0]; 
	            
	            
	            // iterate over all elements of sm 
	            for (smRow = 1; smRow < sm.getSize();) {
	            	  
	            	// current column of result matrix 
	                // sparseMatirx[][0] used as sm is transposed 
	                int col = sm.sparseMatirx[smRow][0]; 
	                
	                // temporary pointers created to add all 
	                // multiplied values to obtain current 
	                // element of result matrix 
	                int tempThis = thisRow; 
	                int tempSm = smRow; 
	                int sum=0;
	             
	                // iterate over all elements with 
	                // same row and col value 
	                // to calculate result[r] 
	                while (tempThis < this.getSize() && this.sparseMatirx[tempThis][0] == row 
	                       && tempSm < sm.getSize() && sm.sparseMatirx[tempSm][0] == col) { 
	  
	                    if (this.sparseMatirx[tempThis][1] < sm.sparseMatirx[tempSm][1]) 
	                        // skip a 
	                    	tempThis++; 
	  
	                    else if (this.sparseMatirx[tempThis][1] > sm.sparseMatirx[tempSm][1]) 
	                        // skip b 
	                    	tempSm++; 
	                    else
	                        // same col, so multiply and increment 
	                        sum += this.sparseMatirx[tempThis++][2] * sm.sparseMatirx[tempSm++][2]; 
	                }	
	                
	                // insert sum obtained in result[r] 
	                // if its not equal to 0 
	                if (sum != 0){ 
	                	//inserting value into result array
	                    insert(result,resultRow,row, col, sum);
	                    resultRow++;//incrementing result array row as one result has added in one row
	                }
	                
	                while (smRow < sm.getSize() && sm.sparseMatirx[smRow][0] == col) 
	                    // jump to next column 
	                	smRow++; 
	            }//sm matrix element iteration closing
	        
	            while (thisRow < this.getSize() && this.sparseMatirx[thisRow][0] == row) 
	                // jump to next row 
	            	thisRow++;            
	            
	        }//outer loop closing
	        
		}//else part closing 
		
		
		/********************/
		//info of sparse matrix,it will be same as any one of the matrix
		result[0][0]=this.getRow();
        result[0][1]=this.getColumn();
        result[0][2]=this.getNumberOfValue();
		/**********************/
		return new SparseMatrix(Arrays.copyOf(result,resultRow));
	}//method closing 
	
	
	/*
	 * @return status "true" if sparse matrix is symmetric else "false"
	 * */
	boolean isSymmetric(){
		
		boolean status=false;
		if (equal(this.getMatrix(), this.transpose().getMatrix())) {			 
			status=true;
		} 
		return status;
	}
	
	
	/*******private Method***********/
	/*
	 * @param result array in which we need to insert
	 * @param insertAtRow at which row in result array we need to insert
	 * @param rowNumber row number of non zero value in sparse matrix
	 * @param columnNumber column number of non zero value in sparse matrix
	 * @param value non zero value which need to be store
	 * */
	private void insert( int[][] result,int insertAtRow,int rowNumber,int columnNumber,int value){
		
		result[insertAtRow][0]=rowNumber;
		result[insertAtRow][1]=columnNumber;
		result[insertAtRow][2]=value;			
	}
	
	/*
	 * @param arr1 array 1 
	 * @param arr2 array 2
	 * @return "true" if both are equal else "false"
	 * */
	private static boolean equal(final int[][] arr1, final int[][] arr2) {
		 
		  if (arr1 == null) {
		 	return (arr2 == null);
		  }
		 
		  if (arr2 == null) { 
			  return false;
		  }
		 
		 
		  if (arr1.length != arr2.length) {
			  return false;
		 
		  }
		 
		 
		  for (int i = 0; i < arr1.length; i++) {
			  if (!Arrays.equals(arr1[i], arr2[i])) {
				  	return false;
				}
		  }
		 
		  return true;
	}
	
}
