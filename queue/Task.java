package queue;

 
/** class Task **/
class Task
{
    String job;
    int priority;
 
    /** Constructor **/
    public Task(String job, int priority)
    {
        this.job = job;
        this.priority = priority; 
    }
    
    //Getter Setter//
    public String getJob() {
		return job;
	}
    
	public void setJob(String job) {
		this.job = job;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}
    
    
    
    /** toString() **/
    public String toString() 
    {
        return "Job Name : "+ job +"\nPriority : "+ priority;
    }
	
}
