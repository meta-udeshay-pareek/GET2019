package zoo;

public class Peacock extends Bird {

	public Peacock(){}

	public Peacock(String name,double age,double weight){
		this.name = name;
		this.age = age;
		this.weight= weight;
		this.animalId = getUniqueId();//static method of Animal abstract class which will generate unique id 
	}

	@Override
	public String getSound(){
		return "scream";
	}

	/*
	 * @return animalId,unique id of animal
	 * */
	public int getAnimalId(){
		return this.animalId;
	}

	/*
	 * @return AnimalType animal
	 * */
	public String getAnimalType(){
		return "PEACOCK";
	}

	/*
	* @return "true" if any of the information of animal is null or 0 else return "false"
	* */
	public boolean isAnimalInfoNull(){
		if(this.name==null){
			return true;
		}else if (this.age==0){
			return true;
		}else if (this.weight==0){
			return true;
		}
	   return false;
	}
}
