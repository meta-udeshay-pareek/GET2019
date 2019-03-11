package priorityqueue;

import java.util.*;
public class PriorityQueue implements queue
{
	private Integer[] elements;     //The Integer array to store the elements
	private int storedElements;     //An integer denoting the amount of stored elements of the Sorted Array
	private int capacity;           //An integer denoting the capacity of the Sorted Array

	//Default constructor, creates a sorted array with the capacity 10
	public PriorityQueue()
	{
		//Call the second constructor to create a Sorted Array with a capacity of 10
		this(10);      
	}

	//Overloaded constructor, creates a Sorted Array with an user specified capacity
	public PriorityQueue(int capacity)
	{
		//Create the Sorted Array with the user capacity. If capacity is 0 or negative, construct a default Sorted Array
		if(capacity > 0)
		{
			this.capacity = capacity;

			this.elements = new Integer[this.capacity];
		}
		else
		{
			this.capacity = 10;

			this.elements = new Integer[this.capacity];
		}
		this.storedElements = 0;
	}

	//Determine if the SortedArray is full
	public boolean isFull()
	{
		return (storedElements == capacity);
	}

	//Determine if the SortedArray is empty
	public boolean isEmpty()
	{
		return (storedElements == 0);
	}

	//Retrieve the amount of stored elements in the Sorted Array
	public int size()
	{
		return storedElements;
	}

	//Double the capacity of the array and retain the original elements
	private void doubleCapacity()
	{
		capacity = 2 * capacity; //Double the capacity
		this.elements= Arrays.copyOf(elements, capacity);
	}

	//Method to add an element in the sorted array
	public void enqueue(int newElement)
	{
		//Create an Integer object to insert the entry in the Sorted Array
		Integer newEntry = new Integer(newElement);

		//Check if the list is full. If so, double the capacity
		if(this.isFull())
			doubleCapacity();

		//If the array is empty, the new element needs to be added at the first index
		if(this.isEmpty())
		{
			elements[0] = newEntry;
		}
		else
		{
			//Get the amount of stored elements and loop from that element
			int i = this.size();

			//Loop till  the condition is met where the element should be added
			for(;((i >= 1) && (elements[i-1].intValue() < newElement)); i--)
				elements[i] = elements[i-1]; //Swap the elements

			//Add the element at position i
			elements[i] = newEntry;
		}

		//Increment the amount of stored elements
		storedElements++;
	}

	public Integer dequeue(int i)
	{
		//If the index i is outside the regions where the elements are stored or the array is empty we can return null, as no element is apparent to be removed
		if(this.isEmpty() || (i < 0) || (i >= this.size()))
			return null;

		//Store the temp element to return
		Integer deletedElement = elements[i];

		//Start removing the element and shift the subsequent elements to the "empty spot"
		for(; i < this.size() - 1 ; i++)
			elements[i] = elements[i+1];

		//Set the last element at the position of size equal to null
		elements[this.size()-1] = null;

		//Decrease the amount of stored elements
		storedElements--;

		//Return the removed Integer object
		return deletedElement;
	}

	//The string representation of the Sorted Array
	public String toString()
	{
		if(this.isEmpty())
			return "[ ]";
		else
		{
			String representation = "[";

			//Append the string with entries
			for(int i = 0; i < this.size() ; i++)
				representation += elements[i] + ", ";

			//Trim away the last comma and return the string
			return representation.substring(0, representation.length() - 2) +"]";
		}
	}
}