package compound;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChemicalTest {

	Chemical chemical = new Chemical();
	@Test
	public void test() {
		assertEquals(198, chemical.solveCompound("CO(OH)10"));
		assertEquals(398, chemical.solveCompound("CO(O2H5)10"));
		assertEquals(172, chemical.solveCompound("CO10"));
		assertEquals(182, chemical.solveCompound("C(OH)10"));
		assertEquals(16, chemical.solveCompound("CH4"));
		assertEquals(28, chemical.solveCompound("CO"));
	}

}
