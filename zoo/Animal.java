package zoo;

public abstract class Animal {
	static int uniqueId=1;
	int getUniqueId(){
		return uniqueId++;
	}
    abstract String getSound();
    abstract String getAnimalType();
    abstract boolean isAnimalInfoNull();
}
