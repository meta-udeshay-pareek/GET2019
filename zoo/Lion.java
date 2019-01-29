package zoo;

public class Lion extends Mammal{

	public Lion(){}

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

	/*
	* @return AnimalType animal
	* */
	public String getAnimalType(){
		return "LION";
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

	public static void main(String []args){
		Lion l = new Lion("l",5.2,55);
		System.out.println(l.getClass().toString());
		System.out.println(l.getClass().getSuperclass().toString().equals(l.getClass().toString()));
	}
}
