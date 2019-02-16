class Queue{
    constructor(){
        this.elements=[];
    }

     enque(element){
        this.elements.push(element);
    }

     dequeue() { 
        // removing element from the queue 
        // returns underflow when called  
        // on empty queue 
        if(this.isEmpty()){ 
            throw "Queue:Underflow";//throwing an exception when Queue underflow
        }else{
            this.elements.shift(); 
        }
    } 

     display(){
        
            var str = "Queue:"; 
            for(var i = 0; i < this.elements.length; i++) 
                str += this.elements[i] +" "; 
        
            document.getElementById("QueueElements").innerHTML=str;
    }

        // isEmpty function 
    isEmpty() 
    { 
        // return true if the queue is empty. 
        return this.elements.length == 0; 
    } 
}


var queue = new Queue();

function addElement(){
    	 queue.enque(document.getElementById("queueInput").value);
     	 document.getElementById("queueInput").value="";
	 queue.display();
}

function removeElement(){
	try{
        	queue.dequeue();
		queue.display();
	}catch(err){
		document.getElementById("QueueElements").innerHTML= err; 
	}
}
