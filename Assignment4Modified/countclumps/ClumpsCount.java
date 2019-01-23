package countclumps;

public class ClumpsCount {
	/*
	 * @param arr integer array
	 * @return no of clumps in array
	 * Clump in an array is a series of 2 or more adjacent elements of the same value. For example
	 * countClumps([1, 2, 2, 3, 4, 4]) → 2
	 * countClumps([1, 1, 2, 1, 1]) → 2
	 * */
	
	public int countClumps(int [] arr){
		
		//throwing assertion error if array is empty
		//if array is empty then throw an AssertionError
		 if(arr.length==0)
		 {
		   throw new AssertionError();
		 }
				
		int noOfClumps=0;
		int i=0;
		
		while(i<arr.length){
			int val = arr[i++];
			int len=1;
			
			while(i<arr.length&&arr[i]==val){
				i++;
				len++;
			}
			if(len>1)
				noOfClumps++;
		}
		
		return noOfClumps;
	}
}
