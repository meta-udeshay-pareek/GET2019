package evalPostfix;


public class EvalPostfix {


	/*
	 * @param postfixExp,for evaluating expression
	 * @return result, evaluated result
	 * */
	public static int evaluatePostfixExpression(String postfixExp) {

		//create a stack 
		Stack stack = new StackLinkedListImplimentation(); 


		String expressionElements[] = postfixExp.split(" ");

		for(int i=0;i<expressionElements.length;i++) {

			//is element is white space then move forward for next element
			if(expressionElements[i].equals(" ")) {
				continue;
			}

			else if(isNumeric(expressionElements[i])) {
				int operand = Integer.parseInt(expressionElements[i]);
				stack.push(operand);
			}
			// If the scanned character is an operator, pop two 
			// elements from stack apply the operator 
			else
			{ 
				//if stack doesn't have two operand for an operator  then postfix expression is invalid
				if(stack.getSize()<2) {
					throw new RuntimeException("Invalid Postfix  Expression");
				}
				
				int val1 = stack.pop(); 
				int val2 = stack.pop(); 

				//this string contain only one character which is operator so we can access it using Strig.charAt(0) method
				switch(expressionElements[i].charAt(0)) 
				{ 
				case '+': 
					stack.push(val2+val1); 
					break; 

				case '-': 
					stack.push(val2- val1); 
					break; 

				case '/': 
					stack.push(val2/val1); 
					break; 

				case '*': 
					stack.push(val2*val1); 
					break; 
				} 
			}
		}
		
		//at last only one value must be remain
		if(stack.getSize()!=1) {
			throw new RuntimeException("Invalid Postfix  Expression");
		}
		//at last the stack will contain only resultant value
		return stack.pop();
	}

	
	/*
	 * @param string, 
	 * @return "true" is string is a numeric string else "false"
	 * */
	private static boolean isNumeric(String string) {
		try {
			Integer d = Integer.parseInt(string);
		} catch (NumberFormatException | NullPointerException nfe) {
			return false;
		}
		return true;
	}
	

}
