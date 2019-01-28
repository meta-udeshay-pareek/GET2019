package zoo;

public class Crocodile extends Reptile {

	public Crocodile(String name,double age,double weight){
		this.name= name;
		this.age = age;
		this.weight = weight;
		this.animalId = getUniqueId();//static method of Animal abstract class which will generate unique id 
	}
	
	@Override
	public String getSound(){
		return "hiss";
	}
	
	/*
	 * @return animalId,unique id of animal
	 * */
	public int getAnimalId(){
		return this.animalId;
	}
}
