package spliarray;

public class SplitArray {
	/*
	 * @param arr integer array
	 * @return Return the index 
	 * if there is a place to split the input array so that the sum of the numbers on one side is equal to the sum of the numbers on the other side else return -1
	 * splitArray([1, 1, 1, 2, 1]) → 3
	 * splitArray([2, 1, 1, 2, 1]) → -1
	 * splitArray([10, 10]) → 1
	 * */
	int splitArray(int [] arr){
		
		//throwing assertion error if array is empty
		if(arr.length==0){
			throw new AssertionError();
		}
		
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
