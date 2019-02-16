class Stack{
    constructor(){
        this.elements=[];
    }

    pushElement(element){
        this.elements.push(element);
    }

    popElement() { 
        // removing element from the queue 
        // returns underflow when called  
        // on empty queue 
        if(this.isEmpty()){ 
						throw "Stack:Underflow";//throwing an exception when stack underflow
        }else{
            this.elements.pop(); 
        }
    } 

     display(){
        
            var str = "Stack:"; 
            for(var i = 0; i < this.elements.length; i++) 
                str += this.elements[i] +" "; 
        
            document.getElementById("StackElements").innerHTML=str;
    }

        // isEmpty function 
    isEmpty() 
    { 
        // return true if the queue is empty. 
        return this.elements.length == 0; 
    } 
}


var stack = new Stack();

function pushIn(){
     stack.pushElement(document.getElementById("stackInput").value);
     document.getElementById("stackInput").value="";
	 stack.display() ;
}

function popOut(){
	try{
    stack.popElement();
		stack.display() ;
	}catch(err){
		document.getElementById("StackElements").innerHTML= err; 
	}
}
