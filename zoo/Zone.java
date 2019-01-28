package zoo;

import java.util.List;

public class Zone {
	
	int capacity;//number of cage capacity in zone
	boolean hasCanteen,hasPark;//true and false respectively if exist or not exist
	
	Animal animlalCategoryType;//category of animal in this zone like Mammal,Reptile,Bird etc
	
	List<Cage> cages;//List of cages ,one zone can contain multiple number of cages
	
	

	/*
	 * @param capacity ,maximum number of  cages in this zone
	 * @param animalCategoryType, animal category  type which will be in this zone like Mammal etc.
	 * @param hasCanteen, true if has else false
	 * @param hasPark, true if has else false
	 * */
	Zone(int capacity,Animal animalCategoryType,boolean hasCanteen,boolean hasPark){
		this.capacity = capacity;
		this.animlalCategoryType = animalCategoryType;
		this.hasCanteen = hasCanteen;
		this.hasPark = hasPark;
	}
	
	
	
	void addCage(Cage cage){
		
		//Zone animal category class and super class of cage animal type must be same 
		//e.g. If zone is of Mammal type and cage animal type is Lion then it is OK
		//but if cage animal type is Peacock then it shouldn't be added 
		if(this.animlalCategoryType.getClass()==cage.animalType.getClass().getSuperclass()){
			
			//if number of cages are in under of capacity of zone then cage will be added in this zone
			if(this.cages.size()<this.capacity){
				cages.add(cage);
				this.capacity++;
			}else{
				System.out.println("This Zone is out of capacity");
			}
		}
		else{
			System.out.println("this cage animal type are not under in this zone category element");
		}
		
	}
	
	/*
	 * @return true if has else false
	 * */
	public boolean hasPark(){
		return this.hasPark;
	}
	
	/*
	 * @return true if has else false
	 * */
	public boolean hasCanteen(){
		return this.hasCanteen;
	}
	
	
}
