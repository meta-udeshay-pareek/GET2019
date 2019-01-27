package jobscheduler;

import java.util.*;

public class JobScheduler {
		
	public static void main(String args[]){
		
		calculation calc =new calculation();
		calc.inputProcess();//taking input of arival time and burst time
		calc.initiateOtherArrays();// initialise the array of waiting time and turn around time
		calc.sortProcess();//sorting of array
		
		while(true){
		
		int choice;
		System.out.println("1.Calculate completion time for each process\r\n"+ 
				"2.Calculate waiting time for each process\r\n"+
				"3.Calculate turn around time for each process\r\n"+
				"4.Average waiting time of processes\r\n"+
				"5.Maximum waiting time period for a process in queue\r\n"+
				"6.Exit");
		System.out.print("Enter your choice : ");
		Scanner input = new Scanner(System.in);
		choice = input.nextInt();
		
		switch(choice){
		case 1: 
			calc.showOutput(calc.completionTime());
			break;
		case 2:
			
			calc.showOutput(calc.waitingTime());
			break;
		case 3:
			calc.showOutput(calc.turnAroundTime());
			break;
		case 4:
			
			calc.averageWaitingTime();
			break;
		case 5:
			
			calc.maximumWaitingTime();
			break;
		case 6:
			System.out.println("Thank you .....");
			System.exit(0);
		default:
			System.out.println("wrong input! Try Again...");
		}
		}	
		
}
}
