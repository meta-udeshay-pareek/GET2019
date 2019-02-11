package zoo;

import java.util.ArrayList;
import java.util.List;

public class Cage {
	
	/***********Instance Variables********************************/
	
	int capacity;//number of animal capacity in a particular cage
    int numberOfAnimalsInCage;//number of animal present in cage

	Animal animalType;//specific type of animal like Lion,Tiger,Dog,etc.
	
	List<Animal> animals;//list of animal in this cage
	
	
	
	
	
	/***********************Constructor***************************/
	/*
	 * @param capacity ,maximum number of animal who can reside in a cage
	 * @param animalType, specific animal type which will be in cage like Lion,Peacock etc
	 * */
	public Cage(int capacity, Animal animalType){
		this.capacity = capacity;
		this.animalType = animalType;
		this.animals = new ArrayList<Animal>();
		
	}
	
	
	
	/************************public Methods*************************/
	
	/*
	 * @param animal , animal which is going to be add in this cage
	 * @return "true" if animal successfully added else "false"
	 * */
	public boolean addAnimal(Animal addAnimal){
		boolean isAdded=false;
		
		//checking all basic condition before addition
		if(isAllConditionIsTrue(addAnimal)){
			
				//if number of element in cage is under capacity
				if(this.animals.size()<this.capacity){
					
					//checking is animal already exist in this cage
					if(!isAnimalExistInCage(addAnimal)){
						
						/**************************/
						this.animals.add(addAnimal);
						this.numberOfAnimalsInCage++;
						isAdded=true;
						/**************************/
						
					}else{
						System.out.println("This animal is already exist in this cage you cann't add it");
					}
					
				}else{
					System.out.println("This Cage capacity is full,Add another cage for this animal");
				}
			
		}
		
		return isAdded;
		
	}
	
	
	/*
	 * @param animal , animal which is going to be remove from this cage
	 * */
	public boolean removeAnimal(Animal removeAnimal){
		
		boolean isRemoved=false;
		
		
		//checking all basic condition before addition
		if(isAllConditionIsTrue(removeAnimal)){
			
			//iterating list of animal in this cage
			for(Animal rAnimal : this.animals){
				//if animal exist then animal will remove from this list 
				if(rAnimal.getUniqueId()== removeAnimal.getUniqueId()){
					this.animals.remove(removeAnimal);
	                this.numberOfAnimalsInCage--;
					
	                isRemoved=true;
	                break;
				}
			}
			//if animal not removed i.e. animal not exist in this cage
			if(!isRemoved){
				System.out.println("This Animal doesn't exist in this cage");
				return isRemoved;
			}
			
		}
		
		
		return isRemoved;
	}
    
    /*
    * will return category of animal of this cage
    *           1.this.animalType.getClass()  will return like..... class zoo.Lion
                2.this.animalType.getClass().getSuperclass()   will return like  class zoo.Mammal
                3.(class zoo.Mammal).toString()=> "class zoo.Mammal"
                4."class zoo.Mammal".split(".")=> String []s={"class zoo","Mammal"}
                5.s[1].toUpperCase() = >  "MAMMAL"
                6 animalCategory = "MAMMAL"
                
    *@return animalCategory
    */
    public String getAnimalCategory(){
        
        String animalCategory = this.animalType.getClass().getSuperclass().toString().split("\\.")[1].toUpperCase();
        return animalCategory;
    }
    
    
    
    /*********************private helper method***************/
    
    /*
     * @param existAnimal,for checking that this animal is already exist in this cage or not
     * @return "true" if animal is already exist else "false"
     * */
    private boolean isAnimalExistInCage(Animal existAnimal){
    	
    	//iterating list of animal in this cage
		for(Animal eAnimal : this.animals){
			//if animal exist then will return true 
			if(eAnimal.getUniqueId()== existAnimal.getUniqueId()){
				return true;
			}
		}
		
    	return false;
    }
    
    
    /*
     * @param animal,for checking basic condition for animal object correctness
     * @return "true" if animal object is correct else "false"
     * */
    
    private boolean isAllConditionIsTrue(Animal animal){
    	
    	//is animal info like name ,age ,weight are fulfilled or not
    	if(!animal.isAnimalInfoNull()){
    		
    		//if animal's type is same of  type of cage's animal's type
	    	if(this.animalType.getClass()==animal.getClass()){
	    		
	    			return true;
	    		
	    	}else{
	    		System.out.println("This Animal type mismatch with this cages's animal type");
	    	}
    	}
    	return false;
    }
}
