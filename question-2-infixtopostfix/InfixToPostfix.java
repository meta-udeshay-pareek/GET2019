package infixtopostfix;

import java.util.Stack;

public class InfixToPostfix {

	/*
	 * @param expression, the infix expression which we are converting into postfix
	 * @return result, converted postfix expression 
	 * */
	public static String infixToPostfixConversion(String expression) {

		//resultant postfix expression will store here
		String result = new String("");

		//stack using for conversion
		Stack<String> stack = new Stack<String>();

		
		String expressionElements[] = expression.split(" ");
		
		for(String st : expressionElements) {
			System.out.println(st);
		}
		for(int i=0;i<expressionElements.length;i++) {

			String element = expressionElements[i];

			
			// If the scanned character is an operand, add it to output. 
			if(isElementNumeric(element) || isElementLetter(element))
				result = result + element;

			// If the scanned character is an '(', push it to the stack. 
			else if (element.equals("(")) 
				stack.push(element); 

			//  If the scanned character is an ')', pop and output from the stack  
			// until an '(' is encountered. 
			else if (element.equals(")")) 
			{ 
				while (!stack.isEmpty() && !(stack.peek().equals("("))) 
					result += stack.pop(); 

				//will throw an exception when infix expression will be invalid
				if (!stack.isEmpty() && !(stack.peek().equals("("))) 
					throw new RuntimeException("Invalid Expression"); // invalid expression                 
				else
					stack.pop(); 
			}

			else // an operator is encountered 
			{ 
				//if current operator is has less precedence then pop from stack 
				while (!stack.isEmpty() && Prec(element) <= Prec(stack.peek())) 
					result += stack.pop(); 
				stack.push(element); 
			} 
		}

		// pop all the operators from the stack 
		while (!stack.isEmpty()) 
			result += stack.pop(); 

		return result; 
	}

	/*
	 * @param element,for checking is String a Letter
	 * @return "true" if it contain only one latter
	 * */
	private static boolean isElementLetter(String element) {
		if(Character.isLetter(element.charAt(0))) {
			return true;
		}
		return false;
	}

	/*
	 *  @param element,for checking is String Numeric
	 *  @return "true" if it contain only numeric value
	 *  */
	private static boolean isElementNumeric(String element) {
		try {
			Integer d = Integer.parseInt(element);
		} catch (NumberFormatException | NullPointerException nfe) {
			return false;
		}
		return true;
	}

	// A utility function to return precedence of a given operator 
	// Higher returned value means higher precedence 
	static int Prec(String element) 
	{ 
		switch (element) 
		{
		
		case "=":
			return 1;
		case "||":
			return 2;
		case "&&":
			return 3;
		case "|":
			return 4;
		case "&":
			return 5;
		case "==":
		case "!=":
			return 6;
		case "<":
		case ">":
		case "<=":
		case ">=":
			return 7;
		case "+": 
		case "-": 
			return 8; 
		case "*": 
		case "/": 
			return 9; 
		case "^": 
			return 10; 
		} 
		return -1; 
	} 
	
	

}
