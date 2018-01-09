package circularArrayQueue;

import javax.swing.JOptionPane;



public class CircularQueueTest {
	public static void main(String[] args) {
		// Create a Queue
		Queue q = new CircularArrayQueue(); 
		
		int counter = 1;	//used to create a difference in words being enqueued
		
		JOptionPane.showMessageDialog(null, "About to fill up the queue"); //tells user what is about to happen

		while(!q.isFull()) { //if the queue isn't full it will continue enqueuing
			q.enqueue("Word " + counter); //call enqueue function and adds a number onto 'word' to show difference between words
			counter++; //updates counter
		}
		
		if(q.isFull()) { //checks if queue is full
			JOptionPane.showMessageDialog(null, "About to dequeue two of the three words"); //tells user two objects will be removed
			String word1 = (String) q.dequeue(); // removes word 1 
			// popped to String
			JOptionPane.showMessageDialog(null, "Word dequeued: " + word1); //tells user what word was removed
			String word2 = (String) q.dequeue(); // removes word two
			// popped to String
			JOptionPane.showMessageDialog(null, "Word dequeued: " + word2); //tells user what word has been removed
			
			JOptionPane.showMessageDialog(null, "About to enqueue an extra word"); //tells user another object will be enqueued
			q.enqueue("Extra word"); //enqueue extra word
		}
		
		q.display(); //prints what elements are in the queue to screen
		
		
		JOptionPane.showMessageDialog(null, "About to empty queue"); //tells user queue is about to emptied
		while (!q.isEmpty()) { //if it is not empty it will continue dequeuing
			String word = (String) q.dequeue(); // Note: have to cast Objects
												// popped to String
			JOptionPane.showMessageDialog(null, "Word dequeued: " + word); //tells user which items are being dequeued
		}
		JOptionPane.showMessageDialog(null, "About to check if the code will stop you from \ndequeuing when there is nothing in the array");
		q.dequeue(); //attempts to dequeue
	}
}
