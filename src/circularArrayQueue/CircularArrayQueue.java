package circularArrayQueue;

import javax.swing.JOptionPane;

public class CircularArrayQueue implements Queue{

	
		 protected Object Q[];				// array used to implement the queue 
		 protected int front = -1, rear = -1;			// index for the rear & front of the queue
		 protected int capacity; 			// The actual capacity of the queue array
		 public static final int CAPACITY = 3;	// capacity set to three for demonstration purposes 
		 protected int counter = 0; //counter is used to keep track of how many items have been added or removed from queue
		 
		 public CircularArrayQueue() {
			   // default constructor: creates queue with default capacity
			   this(CAPACITY);
		 }

		 public CircularArrayQueue(int cap) {
			  // this constructor allows you to specify capacity
			  capacity = (cap > 0) ? cap : CAPACITY; // Conditional Operator
			  Q = new Object[capacity]; 
		 }
		 
		 public void enqueue(Object n) //adds objects to the queue
		 {
			 if (isFull()) { //checks if the array is full
				 JOptionPane.showMessageDialog(null, "Cannot enqueue object; queue is full."); //if it is full it will tell the user
				 return;
			 } else {
				 if(rear == capacity -1 && front!=0){ //checks if the front pointer has moved position
					 rear = -1; //if it has it sets rear back to the beginning of the queue
				 }
				 rear++; //updates rear pointer
				 Q[rear] = n; //stores object in queue
				 if (front == -1){ //if front is at -1 (which doesn't exist) 
					 front = 0; //it assigns it to the first position in the queue (ie points to the first object in queue)
				 }
				 counter++; //updates counter to say there is now one object in the queue
			 }
		 }
		 
		 public Object dequeue() //deletes objects from the queue
		 {
			 // Can't do anything if it's empty
			 Object object = null;
			 if (isEmpty()){ //checks if it is empty
				 JOptionPane.showMessageDialog(null, "Failed to dequeue as queue is empty"); //if it is it tells the user
			 } else { //if it contains objects it will do the following
				 
				 object = Q[front]; //records the object about the be removed
				 Q[front] = null; //removes the object
				 front++; //moves the front pointer to the next object which is now at the front of the queue
				 if(front == capacity){ //checks if the front pointer has gone out of bounds
					 front = 0; //resets it to the first position of the array if it has
				 }
				 counter--; //updates counter to show one object has been removed
				 if (counter == 0){ //checks if there is no items in the queue
					 front = rear = -1; //resets pointers to starting positions
					 //this will show the isEmpty() method that there is nothing left in the queue
				 } 
					 
			 }
			return object; //returns the removed object
		 }
		 
		 public boolean isEmpty()  { //method to check if the queue is empty
			 if (rear == -1 && front == -1){ //checks if pointers are in their starting positions
				 return true; //this will only happen if the queue is empty
			 } else {
				 return false; //otherwise it contains objects
			 }
			 
		     
		 }
		 
		 public boolean isFull() { //method to check if the queue is full
			 if(rear == front-1 || front == 0 && rear == (capacity -1)){ //if the rear pointer is one place behind the front pointer it must be full
				 //or if front is in the start of the array and rear is at the end of the array it is also full (in my example front = 0 and rear = 2)
				 return true; //if either condition is met it is full
			 } else {
				 return false; //otherwise there is more space
			 }
			 
		 }
		 
		 public Object front()
		 {
			 if (isEmpty())
				 return null;
			 
			 return Q[0];
		 }

		@Override
		public void display() { //used to display what is in the queue
			int counter = front; //sets counter to the start of the queue
			for ( int i =0; i < capacity; i++){ //creates another counter to loop through the queue
				String word = (String) Q[counter]; //casts the objects in the queue to a string
				if(word == null) { //checks if there is nothing in the current position of the queue
					JOptionPane.showMessageDialog(null, "Postion number " + (i+1) + " of queue contains no object."); //tells user there is no object here
					break; //ends for loop as there shouldn't be any other objects after this point
				}else { //if there is an object in the current position it will do this
					JOptionPane.showMessageDialog(null, "Word number " + (i+1) + " in queue is " + word); //prints the object & where it is in the queue to screen
				}
				counter++; //updates the counter
				if(counter == capacity){ //used to loop the counter back to the beginning of the 
					counter = 0; //array in case the beginning of the queue isn't at element 0
				}
			}
		}
}
