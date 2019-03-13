package dictionary;

import static org.junit.Assert.*;

import org.junit.Test;

public class DictionaryTest {

	BST bst = new BST("C:\\Users\\admin\\eclipse-workspace\\DS-5\\src\\dictionary\\map.json");
	
	@Test
	public void testGetSortedList() {
		String expected = "[1 : ud, 2 : sh, 3 : neha, 4 : soham, 5 : sakshi, 6 : versha, city : London, first name : udeshay, mobile : 847339282, name : John]";
		assertEquals(expected, bst.getSortedList().toString());
		
	}
	
	@Test
	public void testGetSortedListBoundKey() {
		String exp1="[2 : sh, 3 : neha, 4 : soham, 5 : sakshi]";
		String exp2="[1 : ud, 2 : sh, 3 : neha, 4 : soham, 5 : sakshi, 6 : versha, city : London, first name : udeshay, mobile : 847339282]";
		String exp3 ="[4 : soham, 5 : sakshi, 6 : versha, city : London]";
		String exp4 = "[6 : versha, city : London, first name : udeshay, mobile : 847339282, name : John]";
		String exp5 = "[3 : neha, 4 : soham, 5 : sakshi, 6 : versha, city : London, first name : udeshay, mobile : 847339282]";

		assertEquals(exp1, bst.getSortedList("2", "5").toString());
		assertEquals(exp2, bst.getSortedList("1", "mobile").toString());
		assertEquals(exp3, bst.getSortedList("4", "city").toString());
		assertEquals(exp4, bst.getSortedList("6", "name").toString());
		assertEquals(exp5, bst.getSortedList("3", "mobile").toString());
	}
	
	@Test
	public void testGetValue() {
		assertEquals("ud", bst.getValue("1"));
		assertEquals("sh", bst.getValue("2"));
		assertEquals("neha", bst.getValue("3"));
		assertEquals("soham", bst.getValue("4"));
		assertEquals("sakshi", bst.getValue("5"));
		assertEquals("versha", bst.getValue("6"));
		assertEquals("London", bst.getValue("city"));
		assertEquals("udeshay", bst.getValue("first name"));
		assertEquals("847339282", bst.getValue("mobile"));
		assertEquals("John", bst.getValue("name"));
	}

}
