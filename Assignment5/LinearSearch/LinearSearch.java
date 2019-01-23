package linearsearch;



public class LinearSearch {
    
    /*
    *@param int [] arr (in which value will search)
    *@param int firstIndex of array
    *@param int lastIndex of array
    *@param int value to be search  int array
    
    *@return array index where value is present in array otherwise return -1
    */
    int linearSearch(int arr[], int firstIndex, int lastIndex, int value) 
     { 
    	//Exception when Array is Null
    	if(arr.length==0){
    		throw new NullPointerException("Array is Empty");
    	}
         //return -1 if value is not present in array
          if (lastIndex < firstIndex) 
             return -1; 
          //if at index first then return index number
          if (arr[firstIndex] == value) 
             return firstIndex; 
          //if at index last then return index number
          if (arr[lastIndex] == value) 
             return lastIndex; 
          //recursively call by incrementing from front and decrementing from back side by covering array serach from both side
          return linearSearch(arr, firstIndex+1, lastIndex-1, value); 
     } 
    
    
    
    
}

