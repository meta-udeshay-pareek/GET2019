package jobscheduler;

public class calculation {
	
	 int process[][];
	 int completionTime[];
	 int turnAroundTime[];
	 int waitingTime[];
	 int arrivalTimeColumn = 0;
	int burstTimeColumn = 1;
	 int numberOfProcess;
	
	 Scanner sc = new Scanner(System.in);

	public void maximumWaitingTime( )// calculation of maximum waiting time
	{
		
		waitingTime();
		int maxWaitingTime = waitingTime[0];
		int indexOfMaxWaitingTime = 0;
		for(int i = 1; i< numberOfProcess; i++){
			
			if(maxWaitingTime < waitingTime[i]){
				maxWaitingTime = waitingTime[i];
				indexOfMaxWaitingTime = i;
			}
		}
		
		System.out.println("Maximum waiting time : "+maxWaitingTime);
	}

	public void averageWaitingTime() {//calculating  average waiting time
		
		waitingTime();
		int averageWaitingTime = 0;
		int sumOfWaitingTime = 0;
		for(int i = 0; i<numberOfProcess; i++){
			sumOfWaitingTime += waitingTime[i];
		}
		averageWaitingTime = sumOfWaitingTime/numberOfProcess;
		
		System.out.println("Average waiting time is : "+averageWaitingTime);
	}

	public int[]  turnAroundTime() {// calculating turn around time
		
		completionTime();
		for(int i = 0; i< numberOfProcess;i++){
			turnAroundTime[i] = completionTime[i] - process[i][arrivalTimeColumn];
		}
		return turnAroundTime;
	}

	public int[]  waitingTime() {// calculating waiting time
		
		turnAroundTime();
		for(int i = 0; i< numberOfProcess; i++){
			waitingTime[i] = turnAroundTime[i] - process[i][burstTimeColumn];
		}
		return waitingTime;
	}

	public int[] completionTime() {//calculating completion time
		
		completionTime[0] = process[0][burstTimeColumn]; 
		for(int i= 1; i < numberOfProcess; i++){
			
			completionTime[i] = completionTime[i-1] +process[i][burstTimeColumn];
		}
		return completionTime;
	}

	public void initiateOtherArrays(){
		
		completionTime = new int[numberOfProcess];
		waitingTime = new int[numberOfProcess];
		turnAroundTime = new int[numberOfProcess];
	}
	
	public void inputProcess(){
		
		System.out.print("Enter number of process : ");
		numberOfProcess = sc.nextInt();
		
		process = new int[numberOfProcess][2]; //2 columns for Arrival Time  and Burst Time
		
		for(int i = 0; i < numberOfProcess; i++){
			
			System.out.println("Enter AT for Process"+(i+1)+" : ");
			process[i][arrivalTimeColumn] = sc.nextInt();
			
			System.out.println("Enter BT for Process"+(i+1)+" : ");
			process[i][burstTimeColumn] = sc.nextInt();
		}	
	}
	
	public void sortProcess(){
		
		int tempForSwappingAT,tempForSwappingBT;
		for(int i = 0; i< numberOfProcess-1; i++){
			
			for(int j = i+1; j < numberOfProcess; j++){
				
				if(process[i][arrivalTimeColumn] > process[j][arrivalTimeColumn]){
					
					tempForSwappingAT = process[i][arrivalTimeColumn];
					process[i][arrivalTimeColumn] = process[j][arrivalTimeColumn];
					process[j][arrivalTimeColumn] = tempForSwappingAT;
					
					tempForSwappingBT = process[i][burstTimeColumn];
					process[i][burstTimeColumn] = process[j][burstTimeColumn];
					process[j][burstTimeColumn] = tempForSwappingBT;
				}	
			}
		}
	}
	
	public void showOutput(int[] arrayForOutput){
		
		System.out.println("AT\tBT\toutput");
		for(int i = 0; i< numberOfProcess; i++){
			System.out.println(process[i][arrivalTimeColumn]+"\t"+process[i][burstTimeColumn]+"\t"+arrayForOutput[i]);
		}
	}
	

}
