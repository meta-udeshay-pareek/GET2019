package zoo;

public class Lion extends Mammal{
	
	public Lion(String name,double age,double weight){
		this.name = name;
		this.age = age;
		this.weight= weight;
		this.animalId = getUniqueId();//static method of Animal abstract class which will generate unique id 
	}
	
	
	@Override
	public String getSound(){
		return "Roar";
	}
	
	/*
	 * @return animalId,unique id of animal
	 * */
	public int getAnimalId(){
		return this.animalId;
	}
}
