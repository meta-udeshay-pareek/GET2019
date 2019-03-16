package string;

import static org.junit.Assert.*;

import org.junit.Test;

public class UniqueCharacterTest {

	
	UniqueCharacter uc= new UniqueCharacter();
	@Test
	public void testUniqueCharacter() {
		assertEquals(1, uc.numberOfUniqueCharacter("aqwe@#$qwea@#"));
		assertEquals(6, uc.numberOfUniqueCharacter("paravijay"));
		assertEquals(9, uc.numberOfUniqueCharacter("paravijaythu"));
		assertEquals(0, uc.numberOfUniqueCharacter("pppppppppppp"));
	}

}
