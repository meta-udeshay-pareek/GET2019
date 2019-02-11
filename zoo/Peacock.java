package zoo;

public class Peacock extends Bird {
	
    public Peacock(){}

    public Peacock(String name,double age,double weight){
    	super(name,age,weight);
    }

	@Override
	public String getSound(){
		return "scream";
	}
    
     /*
	 * @return AnimalType animal
	 * */
    public String getAnimalType(){
        return this.getClass().getSimpleName();
    }
    
}
