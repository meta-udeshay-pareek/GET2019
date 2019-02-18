package zoo;

import static org.junit.Assert.*;

import org.junit.Test;


public class ZooTest {
    
	//different zone 
	Zone zone1 = new Zone(3,"mammal",true,true);    
	Zone zone2 = new Zone(2,"Reptile",false,true);  
	Zone zone3 = new Zone(4,"Bird",true,false);
	
	
	Cage cage1 = new Cage(2,new Lion());
	Cage cage2 = new Cage(1,new Crocodile());
	Cage cage3 = new Cage(3,new Peacock());
	
	
	//different animal
	Animal lion1 = new Lion("lion-1",4,100);
	Animal peacock1 = new Peacock("peacock-1",2,10);
	Animal crocodile1 = new Crocodile("crocodile-1",1,150);
	Animal lion2 = new Lion("lion-2",2.5,40);
	Animal peacock2 = new Peacock("peacock-2",1,8);
	Animal crocodile2 = new Crocodile("crocodile-2",0.5,80);
	
	
	
	
	@Test
	public void addCageTestCaseWithInput1()
	{	
		assertEquals(true, zone1.addCage(cage1));
		assertEquals(false, zone1.addCage(cage2));//this cage animal type are not under in this zone category element
		assertEquals(false, zone1.addCage(cage3));//this cage animal type are not under in this zone category element
		
		assertEquals(false, zone2.addCage(cage1));//this cage animal type are not under in this zone category element
		assertEquals(true, zone2.addCage(cage2));
		assertEquals(false, zone2.addCage(cage3));//this cage animal type are not under in this zone category element
		
		assertEquals(false, zone3.addCage(cage1));//this cage animal type are not under in this zone category element
		assertEquals(false, zone3.addCage(cage2));//this cage animal type are not under in this zone category element
		assertEquals(true, zone3.addCage(cage3));
	
	}
	
	
	@Test
	public void hasParkTestCaseWithInput1()
	{	
		assertEquals(true, zone1.hasPark());
		assertEquals(true, zone2.hasPark());
		assertEquals(false, zone3.hasPark());
		
	}
	
	@Test
	public void hasCanteenTestCaseWithInput1()
	{	
		assertEquals(true, zone1.hasCanteen());
		assertEquals(false, zone2.hasCanteen());
		assertEquals(true, zone3.hasCanteen());
		
	}
	
	@Test
	public void addAnimalTestCaseWithInput1()
	{	
		assertEquals(true, cage1.addAnimal(lion1));
		assertEquals(true, cage1.addAnimal(lion2));


		
		
		assertEquals(false, cage2.addAnimal(lion2));//This Animal cann't be added in this cage as type of animal mismatch
		assertEquals(true, cage2.addAnimal(crocodile1));
		assertEquals(false, cage2.addAnimal(crocodile2));//This Cage capacity is full,Add another cage for this animal
		
		assertEquals(true, cage3.addAnimal(peacock1));
		assertEquals(true, cage3.addAnimal(peacock2));
		assertEquals(false, cage3.addAnimal(lion2));//This Animal cann't be added in this cage as type of animal mismatch
		
	}
}
