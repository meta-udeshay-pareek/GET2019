package arrayoperation;

public class Array {
	
	/*
	 * @param arr integer array for finding max mirror in it
	 * @return max length mirror in array
	 * e.g. maxMirror([1, 2, 3, 8, 9, 3, 2, 1]) → 3
	 * */
	int maxMirror(int [] arr){
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
	
	/*
	 * @param arr integer array
	 * @return no of clumps in array
	 * Clump in an array is a series of 2 or more adjacent elements of the same value. For example
	 * countClumps([1, 2, 2, 3, 4, 4]) → 2
	 * countClumps([1, 1, 2, 1, 1]) → 2
	 * */
	
	int countClumps(int [] arr){
		int noOfClumps=0;
		int i=0;
		
		while(i<arr.length){
			int val = arr[i];
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
	
	/*
	 * @param arr integer array,x,y, for fix their position
	 * @return array ,shuffled array with position of it's element according to specification
	 * Return an array that contains exactly the same numbers as the input array, but rearranged so that every X is immediately followed by a Y. Do not move X within array, but every other number may move.
	 * Let’s say value of X is 4 and Y is 5. Then
	 * fixXY([5, 4, 9, 4, 9, 5]) → [9, 4, 5, 4, 5, 9]
	 * */
	int [] fixXY(int [] arr,int x,int y){
		int flag=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==x) {
				for(int j=flag;j<arr.length;j++) {
					//if element is y and it is not placed at immediate right to x then we will swap it with immediate right of x
					if(arr[j]==y && j!=i+1) {
						//Swapping 
						int temp=arr[i+1];
						arr[i+1]=y;
						arr[j]= temp;
						//setting flag to current position so that we can start from in second pass
						flag=j;
					}
					else {
						continue;
					}
				}
			}
			else {
				continue;
			}
		}
		
		return arr;
	}
	
	/*
	 * @param arr integer array
	 * @return Return the index 
	 * if there is a place to split the input array so that the sum of the numbers on one side is equal to the sum of the numbers on the other side else return -1
	 * splitArray([1, 1, 1, 2, 1]) → 3
	 * splitArray([2, 1, 1, 2, 1]) → -1
	 * splitArray([10, 10]) → 1
	 * */
	int splitArray(int [] arr){
		int index=-1;
		int sum1=0,sum2=0;
			for (int i=0;i<arr.length;i++){
				sum1+=arr[i];sum2=0;
				for(int j=i+1;j<arr.length;j++){
					sum2+=arr[j];
				}	
				if(sum1==sum2){
					index=(i+1);
				}
			}
		return index;
	}
	
}
