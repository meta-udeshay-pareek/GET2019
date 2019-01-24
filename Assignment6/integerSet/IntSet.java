package integerset;

import java.util.Arrays;

public final class IntSet {
	
	private final int set[];
	
	public IntSet(int []arr){
		// first removing duplicate element then assigning to set
		set = this.removeDuplicateElementIfAny(arr);
	}

	
	/* 
	 * will remove duplicate element in array if any
	 * @param my_array for removing duplicate element in it
	 * @return setArray an array which don't have duplicate value
	 */
	private int [] removeDuplicateElementIfAny(int [] my_array){
		
		//array to be returned after remove duplicate element
		int[] setArray; 
		
		 //Assuming all elements in input array are unique
        
        int no_unique_elements = my_array.length;
         
        //Comparing each element with all other elements
         
        for (int i = 0; i < no_unique_elements; i++) 
        {
            for (int j = i+1; j < no_unique_elements; j++)
            {
                //If any two elements are found equal
                 
                if(my_array[i] == my_array[j])
                {
                    //Replace duplicate element with last unique element
                     
                    my_array[j] = my_array[no_unique_elements-1];
                     
                    no_unique_elements--;
                     
                    j--;
                }
            }
        }
        //Copying only unique elements of my_array into array1
        
        setArray = Arrays.copyOf(my_array, no_unique_elements);
        
        return setArray;
	}
	
	/*
	 * @param value search value in set 
	 * @return "true" if value is member of set otherwise "false"
	 * */
	public boolean isMember(int value){
		
		for(int i=0;i<this.size();i++){
			if(this.set[i]==value)
				return true;
		}
		return false;
	}
	
	/*
	 * @return size of the set object
	 */
	public int size(){
		return this.set.length;
	}
	
	/*
	 * @param subSet object for checking that is subset of the superset
	 * @return "true" if it is subset otherwise "false"
	 * */
	public boolean isSubSet(IntSet subSet){
		//checking status of existence of subset value in superset
		int exist=0;
		
		//checking that all the member of subset are present in superset or not
		for(int i=0;i<subSet.size();i++){
			
			for(int j=0;j<this.size();j++){
				//if value of subset member is found in superset then fix exist status 1 and break because only one similer value will be in super set
				if(subSet.set[i]==this.set[j]){
					exist=1;
					break;
				}
			}
			//if exist status is 1 i.e. value is present and check for another value
			if(exist==1){
				//status change to 0 for another value
				exist=0;
			}
			//if any single value of subset is not present in superset i.e. this is not a subSet of super set
			else{
				return false;
			}
		}
		
		return true;
	}
	
	
	
	/*
	 * assume that 1..1000 is the universal set
	 *@return complementSet of IntSet
	 * */
	public IntSet getComplement(){
		
		int tempCompleMentSet[] = new int[1000],elementInComplementSet=0;
		
		//set has to be return
		int complementSet[];
		
		//checking universal set element existence in set
		int exist=0;
		
		for(int i=1;i<=1000;i++){
			for(int j=0;j<this.size();j++){
				if(i==this.set[j]){
					exist=1;
					break;
				}
			}
			if(exist==1){
				exist=0;
			}
			//if universal set element doesn't exist in set then assign it's value to tempCompleMentSet
			else{
				tempCompleMentSet[elementInComplementSet++]=i;
			}
		}
		
		//initializing complementSet 
		complementSet = Arrays.copyOf(tempCompleMentSet,elementInComplementSet);
		
		
		//returning complementSet which is IntSet type
		return new IntSet(complementSet);
	}
	
	
	/*
	 * @param s1 IntSet type of object
	 * @param s2 IntSet type of object
	 * @return Union of bith set (s1Us2) 
	 * */
	public static IntSet union(IntSet s1, IntSet s2){
		
		//creating an array size of addition of both set size
		int tempUnionSet[] = new int[s1.size()+s2.size()],elementInTempUnionSet=0;
		
		//set has to be return
		int unionSet[];
		
		//Initializing s1 set into unionSet
		for(int i=0;i<s1.size();i++){
			tempUnionSet[elementInTempUnionSet++]=s1.set[i];
		}
		
		for(int i=0;i<s2.size();i++){
			//is s2 set value is not member of s1 set then only it will  assign into union set 
			if(!s1.isMember(s2.set[i])){
				tempUnionSet[elementInTempUnionSet++]=s2.set[i];
			}
		}
		//initializing unionSet
		unionSet = Arrays.copyOf(tempUnionSet,elementInTempUnionSet);
		
		//returning unionSet 
		return new IntSet(unionSet);
		
	}
	
	
	//will return set element in array form 
	public int [] getSetElementInArrayForm(){
		//creating a copy of set and returning it into array form 
		return Arrays.copyOf(this.set, this.size());
	}
	
}
