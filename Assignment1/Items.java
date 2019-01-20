package iCart;

import java.util.HashMap;

class Items{
	
	HashMap<String, Integer> map = new HashMap<>(); 
	HashMap<Integer, String> mapi = new HashMap<>(); 
	
	void create(){
	
		map.put("Ball", 80);
		map.put("Bat", 450);
		map.put("Sugar", 40);
		map.put("Mango", 60);
		map.put("Banana", 40);
		
		mapi.put(1, "Ball");
		mapi.put(2, "Bat");
		mapi.put(3, "Sugar");
		mapi.put(4, "Mango");
		mapi.put(5, "Banana");
	}
	void display(){
		System.out.println(map);
	}
	
	void displayp(){
		System.out.println(mapi);
	}
}



