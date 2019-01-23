package arrayfixXY;

public class FixXY {
	int [] fixXY(int [] arr,int x,int y) throws Exception{
		// for throwing Assertion Error if any
		assertionErrorForFixXYMethod(arr,x,y);
		
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
	 * @param arr,x,y integer array ,x and y's value for suffling
	 * will throw exception based on specified condition
	 * 
	 * 		1.If array is empty
	 * 		2.If there are unequal numbers of X and Y in input array.
	 * 		3.If two adjacent X values are there.
	 * 		4.If X occurs at the last index of array.
	 * */
	void assertionErrorForFixXYMethod(int [] arr,int x,int y) {
		int countX=0,countY=0;
		//1.If array is empty
		//4.If X occurs at the last index of array.
		
		 if(arr.length==0||arr[arr.length-1]==x) {
		      throw new AssertionError();
		 }
		
		else{
				for(int i=0;i<arr.length;i++){
					
					if(arr[i]==x){
						countX++;
					}else if(arr[i]==y){
						countY++;
					}
					//3.If two adjacent X values are there.
					else {
						if(i<arr.length-1){
							if(arr[i]==arr[i+1])
								throw new AssertionError("two adjacents X values are there");
						}
					}
				}
				//2.If there are unequal numbers of X and Y in input array.
				if(countX!=countY)
					throw new AssertionError("there are unequal numbers of X and Y in input array");
		}
		
	}
}
