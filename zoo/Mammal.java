package zoo;

public abstract class Mammal extends Animal{
	String name;
	double weight;
	double age;
	int animalId;
	
	
	public Mammal(){}
	
	public Mammal(String name,double age,double weight){
		this.name= name;
		this.age = age;
		this.weight = weight;
		this.animalId = getUniqueId();//static method of Animal abstract class which will generate unique id 
	}
	/*
	 * *@return name of the bird 
	 */
	public String getName(){
		return this.name;
	}
	

	/*
	 * *@return weight of the bird 
	 */
	public double getWeight(){
		return this.weight;
	}
	

	/*
	 * *@return animalId of the bird 
	 */
	public double getAnimalId(){
		return this.animalId;
	}
	
	/*
	 * *@return age of the bird 
	 */
	public double getAge(){
		return this.age;
	}
	
	
	/*
	 * *@return name of the bird 
	 */
	public void setName(String name){
		this.name=name;
	}
	

	/*
	 * *@return weight of the bird 
	 */
	public void setWeight(double weight){
		this.weight = weight;
	}
	
	/*
	 * *@return age of the bird 
	 */
	public void setAge(double age){
		this.age = age;;
	}


    /*
     * @return "true" if any of the information of animal is null or 0 else return "false"
     * */
    public boolean isAnimalInfoNull(){
    	if(this.name==null || this.age==0 || this.weight==0){
    		return true;
    	}
    	return false;
    }
}
