class Node{
    constructor(element){
        this.element = element;
        this.next = null;
    }
}

class LinkedList{
    
    constructor(){
        this.head=null;
        this.size=0;
    }


    /**
     *  @return size of linked list
     */
    getListSize(){
        return size;
    }

    /**
     * @param element which is going to be added in linked list
     */
    addElement(element){
        // creates a new node 
        var node = new Node(element); 
    
        // to store current node 
        var current; 
    
        // if list is Empty add the element and make it head 
        if (this.head == null) 
            this.head = node; 
        else { 
            current = this.head; 
    
            // iterate to the end of the list 
            while (current.next) { 
                current = current.next; 
            } 
    
            // add node 
            current.next = node; 
        } 
        this.size++; //increasing size after  adding element in list
    }

    /**
     * @param element which is going to be added in linked list
     * @param index at which index element will be add
     */
    insertAt(element,index){
        if(index<0 && index>this.size){
            return false;
        }else{
            var node = new Node(element);
            var cur,prev;

            cur = this.head;

            //adding node at starting
            if(index==0){
                node.next=head;
                head = node;
            }else{
                var nodeNumber = 0;
                 
                //iterating list till given index
                while(nodeNumber<index){
                    nodeNumber++;
                    prev = cur;
                    cur = cur.next;
                }

                //adding node 
                node.next = cur;
                prev.next = node;
            }

            //increasing list size
            this.size++; 
        }
    }

    /**
     * @param index at which index element will be deleted
     */
    removeFrom(index){
        if (index < 0 && index > this.size) 
            return -1; 
        else { 
            var curr, prev, it = 0; 
            curr = this.head; 
            prev = curr; 
    
            // deleting first element 
            if (index == = 0) { 
                this.head = curr.next; 
            } else { 
              //iterating list till given index
                while (it < index) { 
                    it++; 
                    prev = curr; 
                    curr = curr.next; 
                } 
    
                // remove the element 
                prev.next = curr.next; 
            } 
            this.size--; 
    
            // return the remove element 
            return curr.element; 
        } 
    }

    /**
     * @param element which is going to be deleted in linked list
     * @return deleted element if element exist of "-1" if element not exist
     * 
     * will delete all the element similer to passed element in method from the list
     */
    removeElement(element){
        var current = this.head; 
        var prev = null; 
    
        // iterate over the list 
        while (current != null) { 
            // comparing element with current 
            // element if found then remove the 
            // and return true 
            if (current.element == element) { 
                if (prev == null) { 
                    this.head = current.next; 
                } else { 
                    prev.next = current.next; 
                } 
                this.size--; 
                return current.element; 
            } 
            prev = current; 
            current = current.next; 
        } 
        return -1; 
    }

    /**
     * @param element which index is going to be return
     * @return index of the element in list or "-1" if element not exist in list
     * 
     * will return index of first element  found in list
     */
    indexOf(element){
        var count = 0; 
        var current = this.head; 
    
        // iterating list 
        while (current != null) { 
            // compare each element of the list 
            // with given element 
            if (current.element == element) 
                return count; 
            count++; 
            current = current.next; 
        } 
    
        // not found 
        return -1; 
    }

    /**
     *  @return "true" if  size is zero else "false"
     */
    isEmpty() 
    { 
        return this.size == 0; 
    } 
}

