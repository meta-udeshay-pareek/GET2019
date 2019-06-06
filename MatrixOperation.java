package sparsematrix;
import java.util.ArrayList;

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

public final class MatrixOperation 
{
	//array list to store the non zero element of the matrix
	private ArrayList<Element> matrixList = new ArrayList<Element>();
	
	// 
	private int row,column,index;
	
	//to store the object in list
	private Element element;
	private int inputRow,inputColumn;
	
	//store the result of the operation performed on matrix
	private ArrayList<Element> result = new ArrayList<Element>();
	
	//parameterized constructor which store the non zero element of the matrix
	public MatrixOperation(int[][] inputMatrix )
	{
		inputRow = inputMatrix.length;
		inputColumn = inputMatrix[0].length;
		
		for(row=0;row<inputRow;row++)
		{
			for(column = 0; column < inputColumn; column++)
			{
				if(inputMatrix[row][column] != 0)
				{
					element = new Element();
					element.setRowIndex(row);
					element.setColumnIndex(column);
					element.setElementValue(inputMatrix[row][column]);
					matrixList.add(element);
				}
			}
		}
	}
	
	/*
	 * equals() to check the two object are equal or not
	 * @param required the second object to compare
	 * @return true if two object are equal and false if not
	 */
	public boolean equals(MatrixOperation m1)
	{
		//checks for number of elements in the list
		if(matrixList.size() != m1.matrixList.size())
			return false;
		
		//to get the element from the second object
		Element objectElement;
		int count = 0;
		
		//loop to traverse the first object list
		for(index = 0; index < matrixList.size(); index++)
		{
			//loop to traverse second object list
			for(int index2 = 0; index2 < m1.matrixList.size(); index2++)
			{
				element = matrixList.get(index);
				objectElement = m1.matrixList.get(index2);
				
				if(element.getRowIndex() == objectElement.getRowIndex())
				{
					
					if(element.getColumnIndex() == objectElement.getColumnIndex())
					{
						
						if(element.getValue() == objectElement.getValue())
							count++;
						
					}
					
				}
				
			}
			
		}
		//checks for number of matches with the list size to ensure list doesn't contains any extra element
		if(count == matrixList.size() && count ==m1.matrixList.size())
			return true;
		else
			return false;
	}
	
	
	/*
	 * convert the list to the matrix form
	 * @return the 2D array of matrix
	 */
	private int[][] convertMatrix()
	{
		//2D array to store convert the list to matrix
		int[][] converted = new int[inputRow][inputColumn];
		
		//loop to traverse row of the matrix
		for(row = 0; row < inputRow; row++)
		{
			//loop to traverse column of the matrix
			for(column = 0; column< inputColumn; column++)
			{
				//loop to traverse the result list
				for(index=0; index<result.size(); index++)
				{
					element = result.get(index);
					
					if(element.getRowIndex() == row && element.getColumnIndex() == column)
					{
						converted[row][column] = element.getValue();
					}
					
				}
			}
			
			System.out.println();
		}
		
		return converted;
		
	}
	
	/*
	 * getTranspose() to transpose the given input matrix
	 * @return the object of class MatrixOperation which contains the transposed matrix
	 */
	public MatrixOperation getTranspose()
	{
		try
		{
			Element transposeElement;
			
			//if matrix is not a square matrix
			if(inputRow != inputColumn)
			{
				int temp = inputRow;
				inputRow = inputColumn;
				inputColumn = temp;
			}
			
			//loop to transpose the matrix and stores the resultant list into a result list
			for(index = 0; index<matrixList.size(); index++)
			{
				
				element = matrixList.get(index);
				transposeElement = new Element();
				transposeElement.setRowIndex(element.getColumnIndex());
				transposeElement.setColumnIndex(element.getRowIndex());
				transposeElement.setElementValue(element.getValue());
				result.add(transposeElement);
			}
			return new MatrixOperation(convertMatrix());
		}
		catch(AssertionError assertionError)
		{
			throw assertionError;
		}
		catch(Exception exception)
		{
			throw exception;
		}
	}
	
	/*
	 * symmetrical() to check the given matrix is symmetrical or not
	 * @return true if matrix is symmetrical and false if not
	 */
	public boolean symmetrical()
	{
		try
		{
			//first transpose the given matrix
			MatrixOperation transpose = getTranspose();
			//checks for equality
			if(equals(transpose))
			{
				return true;
			}
			return false;	
		}
		catch(AssertionError assertionError)
		{
			throw assertionError;
		}
		catch(Exception exception)
		{
			throw exception;
		}
	}
	
	/*
	 * addMatrix method to add the two sparse matrix
	 * @param requires the object of MatrixOperation class which contains the second sparse matrix
	 * @return the object of MatrixOperation class which contain the addition of two sparse matrix or @throws an exception if two matrix are not of equal size
	 */
	public MatrixOperation addMatrix(MatrixOperation m1)
	{
		try
		{
			Element secondObject,resultElement;
			if(inputRow != m1.inputRow && inputColumn != m1.inputColumn)
			{
				throw new AssertionError();
			}
			else
			{
				int index2;
				int firstMatrixLength,secondMatrixLength;
				firstMatrixLength = matrixList.size();
				secondMatrixLength = m1.matrixList.size();
				boolean flag;
				
				//loop to iterate all elements of first sparse matrix
				for(index = 0; index < firstMatrixLength; index++)
				{
					element = matrixList.get(index);
					flag = false;
					
					
					//loop to iterate all elements of second sparse matrix
					for(index2 = 0; index2 <secondMatrixLength; index2++)
					{
						secondObject = m1.matrixList.get(index2);
						
						//to check for the element whether present in both matrix or not by checking value of row and column of both matrix
						if(element.getRowIndex() == secondObject.getRowIndex())
						{
							
							//both row and column matches then add the two values and store into result array list
							if(element.getColumnIndex() == secondObject.getColumnIndex())
							{
								resultElement = new Element();
								resultElement.setColumnIndex(element.getColumnIndex());
								resultElement.setRowIndex(element.getRowIndex());
								resultElement.setElementValue(element.getValue()+secondObject.getValue());
								result.add(resultElement);
								flag=true;
								break;
							}
						}
					}
					
					//if column not matches then add the first matrix elements
					if(!flag)
					{
						resultElement = new Element();
						resultElement.setColumnIndex(element.getColumnIndex());
						resultElement.setRowIndex(element.getRowIndex());
						resultElement.setElementValue(element.getValue());
						result.add(resultElement);
					}
				}
				
				//add the second matrix elements which are not in the first matrix
				for(index = 0; index <secondMatrixLength; index++)
				{
					element = m1.matrixList.get(index);
					flag=false;
					
					//checks for already present elements
					for(index2 = 0; index2 <result.size(); index2++)
					{
						secondObject = result.get(index2);
						if(element.getRowIndex() == secondObject.getRowIndex())
						{
							if(element.getColumnIndex() == secondObject.getColumnIndex())
							{
								flag=true;
								break;
							}
						}
					
					}
					
					//if not present in result list then add the element in result list.  
					if(!flag)
					{
						resultElement = new Element();
						resultElement.setColumnIndex(element.getColumnIndex());
						resultElement.setRowIndex(element.getRowIndex());
						resultElement.setElementValue(element.getValue());
						result.add(resultElement);
					}
				}
			}
				return new MatrixOperation(convertMatrix());
		}
		
		catch(AssertionError assertionError)
		{
			throw assertionError;
		}
		catch(Exception exception)
		{
			throw exception;
		}
	}
	
	/*
	 * mulMatrix method is used to multiply two sparse matrix
	 * @param requires object of Matrix Operation class which contains the second sparse matrix
	 * @return the object of MatrixOperation class which contains the multiplied matrix or @throws ans exception if two matrix can't be multiplied 
	 */
	public MatrixOperation mulMatrix(MatrixOperation m1)
	{
		try
		{
			//throw an exception if two matrix can't be multiplied
			if(inputColumn != m1.inputRow)
			{
				throw new AssertionError();
			}
			else
			{
				Element secondElement,tempSecondElement,tempFElement,resultElement;
				int index2,r,c;
				int firstMatrixLength,secondMatrixLength;
				
				MatrixOperation m = m1.getTranspose();
				
				firstMatrixLength = matrixList.size();
				secondMatrixLength = m.matrixList.size();
				
				//changes the size of the matrix
				inputColumn = m.inputRow;
				
				//loop to iterate all elements of first matrix
				for(index = 0; index < firstMatrixLength; )
				{
					
					element = matrixList.get(index);
					r=element.getRowIndex();		//taking row
					
					//loop to iterate all elements of second matrix
					for(index2 = 0; index2 < secondMatrixLength; )
					{
						
						secondElement = m.matrixList.get(index2);
						c=secondElement.getRowIndex();		//taking column (row as the matrix is transposed)
						
						int tempIndex,tempIndex2;
						tempIndex = index;
						tempIndex2 = index2;
						int sum=0;
						
						//loop to calculate the sum of the particular position of the resultant matrix
						for(; tempIndex < firstMatrixLength && tempIndex2 < secondMatrixLength ; )
						{
							tempFElement = matrixList.get(tempIndex);
							tempSecondElement = m.matrixList.get(tempIndex2);
							if(tempFElement.getRowIndex() == r && tempSecondElement.getRowIndex() == c)
							{
								if(tempFElement.getColumnIndex() < tempSecondElement.getColumnIndex())
								{
									tempIndex++; 
								}
								else if(tempFElement.getColumnIndex() > tempSecondElement.getColumnIndex())
								{
									tempIndex2++;
								}
								else
								{
									sum += tempFElement.getValue() * tempSecondElement.getValue();
									tempIndex++;
									tempIndex2++;
								}
							}
							else
								break;
						}
						//store the non zero sum for the resultant matrix
						if(sum != 0)
						{
							resultElement = new Element();
							resultElement.setElementValue(sum);
							resultElement.setRowIndex(r);
							resultElement.setColumnIndex(c);
							result.add(resultElement);
						}
						
						//loop to skip the same column of the second matrix
						while(index2 < secondMatrixLength && secondElement.getRowIndex() == c)
						{
							index2++;	//next column
							if(index2<secondMatrixLength)
							secondElement  = m.matrixList.get(index2);
							
						}
					}
					
					//loops to skip the same row of the first matrix 
					while(index < firstMatrixLength && element.getRowIndex() == r)
					{
						index++;	//next row;
						if(index<firstMatrixLength)
						element = matrixList.get(index);
						
					}
				}
				
				return new MatrixOperation(convertMatrix());
			}
		}
		catch(AssertionError assertionError)
		{
			throw assertionError;
		}
		catch(Exception exception)
		{
			throw exception;
		}
	}
	

}
