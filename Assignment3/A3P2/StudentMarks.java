package marksheet;

import java.util.*;
/**
*
* @author Udeshay Pareek
*/

public class StudentMarks {
	private static final int PASS_GRADE = 40;
	private static Scanner sc = new Scanner(System.in);
    private static int noOfStudents;
    private List<Integer> listOfStudentsGrade = new ArrayList<Integer>();
	
    /**
	* User input for no. of students.
	*/
	
	public void studentCount() {
		System.out.println("Enter the no. of Students");
		//for input correctness checking purpose
		boolean success = false;
        while (!success) {
			try {
				noOfStudents = sc.nextInt();
				success = true;
			}
			catch(InputMismatchException e) {
				sc.next();
				System.out.println("Wrong Input Type. Please enter an integer value");
			}
        }
        
		System.out.println("Enter Grades of "+noOfStudents+" Students");
		//method calling for student's grade input
		studentsGrade();
	}
	
	 /**
	    * user input for the grades of students.
	 */
	public void studentsGrade() {
		int grade;
		//for input correctness purpose
		boolean success = false;
		
		//input for student's grades
		for (int student=1;student<=noOfStudents;student++) {
	        while (!success) {
				try {
					while(!success) {
						grade = sc.nextInt();
						if(grade>=0 && grade<=100) {
							//adding grade in listofStudent grade list
							listOfStudentsGrade.add(grade);
							success= true;
						}
						else {
							System.out.println("Please enter grade value between 0 and 100 both inclusive");
						}
					}
				}
				catch(InputMismatchException e) {
					sc.next();
					System.out.println("Wrong Input Type. Please enter an integer value");
				}
	        }
	        success=false;
		}
		//calling menu method for choice after each operation for be continue
		while(true) {
			menu();
		}
	}   
	
	/*
	 * Menu method which will call methods according to user choice for perform specific operation
	 * */
	public void menu() {
		int choice;
		double result;
		System.out.println("Select any one from the following :- \n1.Average of all grades\n2.Maximum of all grades\n3.Minimum of all grades\n4.Percentage of students passed\n5.Exit");
		choice =(int)(sc.next().charAt(0));
		switch(choice){
		case 49:
			result=average();
			System.out.println("Average of all grades is "+result);
			break;
		case 50:
			System.out.println("Maximum of all grade is "+Collections.max(listOfStudentsGrade));
			break;
		case 51:
			System.out.println("Minimum of all grade is "+Collections.min(listOfStudentsGrade));
			break;
		case 52:
			result= percentagePassed();
			System.out.printf("Percentage of students passed are %.2f %%\n", result);
			break;
		case 53:
			System.exit(0);
		default:
			System.out.println("Please enter index in given range(1-5)");
		}	
	}
	
	 /**
	    * @return average of the grades
	    */
	public double average() {
		double average=0;
		for(int grade=0;grade<listOfStudentsGrade.size();grade++) {
			average+=listOfStudentsGrade.get(grade);
		}
		average/=noOfStudents;
		return average;
	}
	
	 /**
	    * @param 
	    * @return Percent of students passed
	    */
	public double percentagePassed() {
		int noOfPassed=0,score;
		double percentagePassed;
		for(int grade=0;grade<listOfStudentsGrade.size();grade++) {
			score= listOfStudentsGrade.get(grade);
			if(PASS_GRADE <= score) {
			noOfPassed++;
			}
		}
		percentagePassed= ((double)noOfPassed/noOfStudents)*100;
		return percentagePassed;
	}		
}


