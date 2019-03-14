package compound;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;



public class Chemical {

	

	//stack for storing atom
	Stack<Character> stack = new Stack<Character>();


	/**
	 * @param d character
	 * @param time,how many time character will push
	 * */
	private void pushn(Character d, int times) {
		while(times>0) {
			stack.push(d);
			times--;
		}
	}


	/**
	 * @param times, 
	 * poping elements and pushing back them in stack 
	 * */
	private void pushBracket(int times) {
		List<Character> listOfCompound= new ArrayList<Character>();
		char d=this.stack.peek();
		while(d!='(') {
			d=this.stack.pop();
			if(d!='(') {
				listOfCompound.add(d); }
		}

		for(Character c:listOfCompound) {
			pushn(c,times);
		}
	}


	public int solveCompound(String formula) {
		
		if(formula == null){
			return 0;
		}
		
		int flag;//using for checking  if we have numeric value after closing bracs or not
		//starting character will compound always
		stack.push(formula.charAt(0));

		for(int index=1;index<formula.length();index++) {

			flag =0;
			char d=formula.charAt(index);

			if(Character.isDigit(d)) {
				int index2=index;

				//fetching numeric part from string
				while(index2<formula.length()) {
					if(Character.isDigit(formula.charAt(index2)))
						index2++;
					else
						break;
				}

				//fetching numeric string
				String s=formula.substring(index,index2);

				//updataing index
				index=index2-1;

				//converting numeric strig into number
				int n=Integer.parseInt(s);

				char firstElement=stack.pop();

				//push n times character into stack
				pushn(firstElement,n);
			}

			else if(d==')') {


				int tempIndex=index+1;

				//fetching numeric part from string
				while(tempIndex<formula.length()) {
					if(Character.isDigit(formula.charAt(tempIndex))) {
						flag =1;
						tempIndex++;
					}
					else
						break;
				}

				//fetching numeric string
				if(flag == 1) {
					String s=formula.substring(index+1,tempIndex);

					//converting numeric strig into number
					int n=Integer.parseInt(s);

					//updataing index
					index=tempIndex-1;

					//poping element and pushing back them n times
					pushBracket(n); 
				}
			}
			else {
				this.stack.push(d);
			}

		}

		return calculate();
	}




	/**
	 * @return result
	 * */
	private int calculate() {
		int result=0;
		while(!this.stack.isEmpty()) {
			char d=this.stack.pop();
			if(d=='C')
				result+=12;
			else if(d=='H')
				result+=1;
			else if(d=='O')
				result+=16;
			else
				result=result;
		}
		return result;
	}

}
