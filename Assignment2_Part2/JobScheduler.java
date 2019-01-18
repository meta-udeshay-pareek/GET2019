package jobscheduler;

import java.util.Scanner;

public class JobScheduler {
	//object for input process
    static Scanner input = new Scanner(System.in);
    
    //number of process will give input by user
    static int  numberOfProcess;
    
    //Two dimension array process[0][0]=Arrival time
    //                    process[0][1]=burst time
    // will be input by user
    static int process[][];
    
    // All these time will calculate in JobScheduler class in respective method
    static int completionTime[];
    static int turnAroundTime[];
    static int waitingTime[];
    static int averageWaitingTime;
    static int maximumWaitingTime;
    
    //will initialize all the arrays according to number of process
    static void initializeAllArrays(){
        process = new int[numberOfProcess][2];
        completionTime = new int[numberOfProcess];
        turnAroundTime = new int[numberOfProcess];
        waitingTime = new int[numberOfProcess];
    }
    
    //will do input process for all data regarding processess
    static void userInputProcessData(){
    		//input from user
            System.out.print("Enter Number of Process : ");
            numberOfProcess = input.nextInt();
	
            //method call for initializing all the array according to number of Processess
            initializeAllArrays();
            
            System.out.println("Enter Arrival time and Burst time for each process:");
	
            //assigning Arrival and burst time for each process in two dimensional array
			for(int i=0;i<numberOfProcess;i++){
				System.out.print("Process-"+(i+1)+":");
				for(int j=0;j<2;j++){
					process[i][j]=input.nextInt();
				}
			}
            
    }
    
    
    //will printing process of ALL calculated time of each process which is stored in array 
    static void printProcessAllTime(){
    	for(int i=0;i<process.length;i++){
    		System.out.println("process : "+(i+1)+" completionTime: "+completionTime[i]+" turnAroundTime: "+turnAroundTime[i]+" waitingTime: "+waitingTime[i]);	
    	}
    	System.out.println("averageWaitingTime : "+averageWaitingTime);
    	System.out.println("maximumWaitingTime : "+maximumWaitingTime);


    }
    //Main Flow of the Program
	public static void main(String []args){	
	            //object creation for calling method for calculating time
	            JobSchedulerProcedure jobSchedulerProcedure = new JobSchedulerProcedure();
	        
	        
	            //Method Calling for Input data about Processess
	            userInputProcessData();
	            
	            //calculate completion time for each process and will store in array
	            completionTime=jobSchedulerProcedure.completionTime(process);
	            
	            //calculate turnAround time for each process and will assign into array
	            turnAroundTime =jobSchedulerProcedure.turnAroundTime(completionTime, process);
		
	            //waiting time for each process and store in array
	            waitingTime=jobSchedulerProcedure.waitingTime(turnAroundTime, process);
	            
	            
	            //calculate average waiting for all processess
	            averageWaitingTime=jobSchedulerProcedure.averageWaitingTime(waitingTime, numberOfProcess);
	            
	            //find maximum waiting time among all
	            maximumWaitingTime=jobSchedulerProcedure.maximumWaitingTime(process,waitingTime);
	            
	            //will print all the information with all their data like completion time..etc.
	            printProcessAllTime();

	}
}
