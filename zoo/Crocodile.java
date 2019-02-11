package zoo;

public class Crocodile extends Reptile {

    public Crocodile(){}

	public Crocodile(String name,double age,double weight){
		super(name,age,weight);
	}
	
	@Override
	public String getSound(){
		return "hiss";
	}
	

	/*
	* @return AnimalType animal
	* */
	public String getAnimalType(){
	     return "CROCODILE";
	}
      
	
}
