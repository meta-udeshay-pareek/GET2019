class Stack{
    constructor(){
        this.elements=[];
    }

    pushElement(element){
        this.elements.push(element);
        this.display();
    }

    popElement() { 
        // removing element from the queue 
        // returns underflow when called  
        // on empty queue 
        if(this.isEmpty()){ 
            document.getElementById("StackElements").innerHTML= "Stack:Underflow"; 
        }else{
            this.elements.pop(); 
            this.display();
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
}

function popOut(){
    stack.popElement();
}
