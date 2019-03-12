package counsling;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class CounselingTest {
	StudentCounseling studentcounseling =new StudentCounseling();
	@Test
	public void test() throws IOException {
		Map<String,String> expected = new HashMap<String,String>();
		expected.put("DEEMANSHU","MECHANICAL");
		expected.put("SAURABH","IT");
		expected.put("JEETU","IT");
		expected.put("ANURAG","ECE");
		expected.put("MUJIB","CS");
		Map<String,String> actual = studentcounseling.counselingProcess();
		assertEquals(expected.get("DEEMANSHU"),actual.get("DEEMANSHU"));
		assertEquals(expected.get("SAURABH"),actual.get("SAURABH"));
		assertEquals(expected.get("JEETU"),actual.get("JEETU"));
		assertEquals(expected.get("ANURAG"),actual.get("ANURAG"));
		assertEquals(expected.get("MUJIB"),actual.get("MUJIB"));
	}

}