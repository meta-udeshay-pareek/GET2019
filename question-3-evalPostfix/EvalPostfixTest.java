package evalPostfix;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EvalPostfixTest {
	
	
	@Test
	public void testEvalPostfix() {
		assertEquals(757, EvalPostfix.evaluatePostfixExpression("100 200 + 2 / 5 * 7 +"));
		assertEquals(-4, EvalPostfix.evaluatePostfixExpression("2 3 1 * + 9 -"));
		assertEquals(18, EvalPostfix.evaluatePostfixExpression("2 4 5 + *"));
		assertEquals(48, EvalPostfix.evaluatePostfixExpression("5 3 + 8 2 - *"));
		assertEquals(39, EvalPostfix.evaluatePostfixExpression("5 3 + 6 2 / * 3 5 * +"));
		assertEquals(1, EvalPostfix.evaluatePostfixExpression("5 6 7 + 8 - /"));
	}

	@Test(expected = RuntimeException.class)
	public void testEvalPostfixExceptionBased(){
		
		assertEquals(757, EvalPostfix.evaluatePostfixExpression("- 100 200 + 2 / 5 * 7 +"));
		assertEquals(-4, EvalPostfix.evaluatePostfixExpression("2 3 1 * + 9 -"));
		assertEquals(18, EvalPostfix.evaluatePostfixExpression("2 4 5 + *"));
		assertEquals(48, EvalPostfix.evaluatePostfixExpression("5 3 + 8 2 - *"));
		assertEquals(39, EvalPostfix.evaluatePostfixExpression("5 3 + 6 2 / * 3 5 * +"));
		assertEquals(1, EvalPostfix.evaluatePostfixExpression("5 6 7 + 8 - /"));
	}

	@Test(expected = RuntimeException.class)
	public void testEvalPostfixExceptionBased1(){
		assertEquals(-4, EvalPostfix.evaluatePostfixExpression("2 - 3 1 * + 9 -"));
		
	}
	
	@Test(expected = RuntimeException.class)
	public void testEvalPostfixExceptionBased2(){
		assertEquals(18, EvalPostfix.evaluatePostfixExpression("2 4 5 + * + -"));
		
	}
	
	@Test(expected = RuntimeException.class)
	public void testEvalPostfixExceptionBased3(){
		assertEquals(48, EvalPostfix.evaluatePostfixExpression(" + - 5 3 + 8 2 - *"));
		
	}
	
	@Test(expected = RuntimeException.class)
	public void testEvalPostfixExceptionBased4(){
		assertEquals(48, EvalPostfix.evaluatePostfixExpression("5 3"));
		
	}
	
	@Test(expected = RuntimeException.class)
	public void testEvalPostfixExceptionBased5(){
		assertEquals(48, EvalPostfix.evaluatePostfixExpression(" "));
		
	}
}
