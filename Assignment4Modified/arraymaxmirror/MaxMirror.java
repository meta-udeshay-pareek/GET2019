package arraymaxmirror;

public class MaxMirror {
	/*
	 * @param arr integer array for finding max mirror in it
	 * @return max length mirror in array
	 * e.g. maxMirror([1, 2, 3, 8, 9, 3, 2, 1]) → 3
	 * */
	int maxMirror(int [] arr){
		
		//throwing assertion error if array is empty
		if(arr.length==0) {
		      throw new AssertionError();
		}
		
		int max=0;//max length of clump
		//start from 0th index
		 for(int start = 0; start < arr.length; start++) {
			 //start from reverse order of array
		        for(int begin = arr.length - 1; begin >= 0; begin--) {
		            int size = 0;
		            int i = start;
		            int j = begin;
		                                  
		            while(i < arr.length && j >= 0 && arr[i] == arr[j]) {
		                size++;
		                i++;
		                j--;
		            }
		                                                                              
		            max = Math.max(max, size);
		        }
		    }
		return max;
	}
}
