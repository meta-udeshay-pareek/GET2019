package jobscheduler;

import java.util.Scanner;

public class JobSchedulerProcedure {
	 //object Creation of jobscheduer for using userinput data for operation
		JobScheduler jobScheduler = new JobScheduler();
	        
		/**
		 * @param two dimensional array which contain
		 *		process[i][0]=Arrival time
		 * 		process[i][1]=Burst time
		 * 						 where i= number of process
		 * 
		 * 		completion time = arrivalTime+burstTime 
		 * will return array which contain completion time of each process respective to index number
		 * */
		int[] completionTime(int process[][])
		{
			int completionTime[] = new int[process.length];
			for(int j=0;j<process.length;j++)
				{
					for(int k=0;k<2;k++)
					{
						completionTime[j] += process[j][k];
					}
				}
			return completionTime;
		}
		
		/**
		 * @param two dimensional array which contain
		 *		process[i][0]=Arrival time
		 * 		process[i][1]=Burst time
		 * 						 where i= number of process
		 *@param completionTime[] which contain completion time of each process respective to index number
		 * will return array which contain turnAroundTime  of each process respective to index number
		 * */
		int [] turnAroundTime(int completionTime[], int process[][])
		{
			int turnAroundTime[] = new int[process.length];
			for(int i=0;i<process.length;i++)
			{
				turnAroundTime[i]= completionTime[i]-process[i][0];
			}
			return turnAroundTime;
		}
		
		
		/**
		 * @param two dimensional array which contain
		 *		process[i][0]=Arrival time
		 * 		process[i][1]=Burst time
		 * 						 where i= number of process
		 *@param  turnAroundTime[] which contain  turnAroundTime of each process respective to index number
		 * will return array which contain  waitingTime  of each process respective to index number
		 * */
		int [] waitingTime(int turnAroundTime[],int process[][])
		{
			int waitingTime[] = new int[process.length];
			//waiting time for first process will be 0
			waitingTime[0]=0;
			
			for(int m=1;m<process.length;m++)
			{
				
				waitingTime[m]=turnAroundTime[m]+process[m][1];
			}
			return waitingTime;
		}
		
	
		int averageWaitingTime(int waitingTime[],int numberOfProcesses)
		{
			int averageWaitingTime,sum=0;
			for(int i=0;i<numberOfProcesses;i++)
			{
				sum+=waitingTime[i];
			}
			averageWaitingTime= sum/numberOfProcesses;
			return averageWaitingTime;
		}
		
		int maximumWaitingTime(int process[][],int waitingTime[])
		{
			int maximumWaitingTime=0;
			
            for(int i=0;i<process.length;i++){
                if(maximumWaitingTime<waitingTime[i])
                	maximumWaitingTime=waitingTime[i];
            }
            return maximumWaitingTime;
		}
		


}
