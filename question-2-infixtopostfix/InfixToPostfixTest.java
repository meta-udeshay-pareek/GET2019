package infixtopostfix;

import static org.junit.Assert.*;

import org.junit.Test;

public class InfixToPostfixTest {

	@Test
	public void testInfixToPostfixConversion() {
		assertEquals("abcd^e-fgh*+^*+i-", InfixToPostfix.infixToPostfixConversion("a + b * ( c ^ d - e ) ^ ( f + g * h ) - i"));
		assertEquals("ab+", InfixToPostfix.infixToPostfixConversion("( a + b )"));
		assertEquals("xy^5z*/10+", InfixToPostfix.infixToPostfixConversion("x ^ y / ( 5 * z ) + 10") );
		assertEquals("AB+CDE/*-F+", InfixToPostfix.infixToPostfixConversion("( ( A + B ) - C * ( D / E ) ) + F") );
		
	}
	
	
	
	@Test(expected = RuntimeException.class)
	public void testInfixToPostfixConversion1() {
		//one bracket is missing so it will throw an Runtime exception
		assertEquals("", InfixToPostfix.infixToPostfixConversion("a + b *  c ^ d - e ) ^ ( f + g * h ) - i"));
		assertEquals("", InfixToPostfix.infixToPostfixConversion(" ( (a + b *  c ^ d - e ) ^ ( f + g * h ) - i"));
		assertEquals("", InfixToPostfix.infixToPostfixConversion("a + b *  c ^ d - e ) ^ ( "));
	}

}
