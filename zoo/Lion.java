package zoo;

public class Lion extends Mammal{
	
    public Lion(){}
    
	public Lion(String name,double age,double weight){
		super(name,age,weight);
	}




	@Override
	public String getSound(){
		return "Roar";
	}
    
    /*
     * @return AnimalType animal
     * */
    public String getAnimalType(){
        return this.getClass().getSimpleName();
    }
    
}
