package binarySearch;

public class BinarySearch {
		
	/*
	 * @param arr for checking is it sorted or not
	 * @return boolean "true" if it is sorted or "false" if it is not sorted
	 * */
	public static boolean isSorted(int[] a) {
	     for (int i = 0; i < a.length - 1; i++) {
		if (a[i] > a[i + 1]) {
		    return false; // It is proven that the array is not sorted.
		}
    	     }

   `	     return true;
	 }

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
	}else if(!isSorted(arr)){
		throw new RuntimeException("Array is not sorted");
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
