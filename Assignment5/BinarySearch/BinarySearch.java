package binarySearch;

public class BinarySearch {
	/*
	    *@param int [] arr (in which value will search)
	    *@param int firstIndex of array
	    *@param int lastIndex of array
	    *@param int value to be search  int array
	    
	    *@return array index where value is present in array otherwise return -1
	    */
	    int binarySearch(int arr[], int firstIndex, int lastIndex, int value) 
	    { 
	    	//Exception when Array is Null
	    	if(arr.length==0){
	    		throw new NullPointerException("Array is Empty");
	    	}
	    	
	        if (lastIndex >= firstIndex) { 
	            int mid = firstIndex + (lastIndex - firstIndex) / 2; 
	  
	            // If the element is present at the 
	            // middle itself 
	            if (arr[mid] == value) 
	                return mid; 
	  
	            // If element is smaller than mid, then 
	            // it can only be present in left subarray 
	            if (arr[mid] > value) 
	                return binarySearch(arr, firstIndex, mid - 1, value); 
	  
	            // Else the element can only be present 
	            // in right subarray 
	            return binarySearch(arr, mid + 1, lastIndex, value); 
	        } 
	  
	        // We reach here when element is not present 
	        // in array 
	        return -1; 
	    } 
}
