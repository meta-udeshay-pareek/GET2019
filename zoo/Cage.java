package zoo;

import java.util.List;

public class Cage {
	
	int capacity;//number of animal capacity in a particular cage
	
	Animal animalType;//specific type of animal like Lion,Tiger,Dog,etc.
	
	List<Animal> animal;//list of animal in this cage
	
	/*
	 * @param capacity ,maximum number of animal who can reside in a cage
	 * @param animalType, specific animal type which will be in cage like Lion,Peacock etc
	 * */
	public Cage(int capacity, Animal animalType){
		this.capacity = capacity;
		this.animalType = animalType;
	}
	
	
	/*
	 * @param animal , animal which is going to be add in this cage
	 * */
	void addAnimal(Animal animal){
		//if animal type is correct
		if(this.animalType.getClass()==animal.getClass()){
			//if number of element in cage is under capacity
			if(this.animal.size()<this.capacity){
				this.animal.add(animal);
				this.capacity++;
			}else{
				System.out.println("Cage capacity is full");
			}
			
		}
		else{
			System.out.println("This Animal cann't be added in this cage as type of animal mismatch");
		}
		
	}
	
	
	/*
	 * @param animal , animal which is going to be remove from this cage
	 * */
	void removeAnimal(Animal removeAnimal){
		//status of removal of animal
		boolean removed=false;
		
		//if animal of same type of cage's animal's type
		if(this.animalType.getClass()==animal.getClass()){
			
			//iterating list of animal in this cage
			for(Animal rAnimal : this.animal){
				//if animal exist then animal will remove from this list 
				if(rAnimal== removeAnimal){
					this.animal.remove(removeAnimal);
					removed=true;
					break;
				}
			}
			//if animal not removed i.e. animal not exist in this cage
			if(!removed){
				System.out.println("This Animal doesn't exist in this cage");
			}
			
		}
		else{
			System.out.println("This Animal doesn't exist in this cage");
		}
	}
}
