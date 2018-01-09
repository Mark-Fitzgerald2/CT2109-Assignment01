/** M Madden, M Schukat, 2005 - 2015: Abstract Stack interface */

package QueueArray;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class QueueTest {
	public static void main(String[] args) {
		
		String[] stringArray;
		
		
	    JFrame frame = new JFrame("Number of Strings in Queue");
	    //creates a frame for us to ask the user to input a value
	    String noStrings = JOptionPane.showInputDialog(frame, "How many strings do you want in the queue?");
	    //makes a input box and question appear
	    int n = Integer.parseInt(noStrings); 
	    //converts the inputed value to an int
	    
	    stringArray = new String[n];
	    //creates an array of this size
	    
	    for(int i = 0; i < n; i++){
	    	//creates an incrementer which allows us to loop n times
	    	stringArray[i] = "word number " + (i+1);
	    	//stores words in the array
	    }
	    
	 	Queue q = new ArrayQueue(n); 
	    // Create a Queue
	    
	 	long startEnqueue = System.nanoTime(); 
		//starts a timer
	    
	    for(int i = 0; i < n; i++){ 
	    	//creates an incrementer which allows us to loop n times
	    	q.enqueue(stringArray[i]); 
	    	//calls the enqueue method and passes in the ith value of the array
	    }
	    
	    long stopEnqueue = System.nanoTime(); //ends timer
	    
	    long startDequeue = System.nanoTime(); //starts a new timer

	    while(! q.isEmpty()) { 
	    	//loops until the queue is empty
	    	q.dequeue();
	    	//calls the dequeue method
	    }
	    
	    long stopDequeue = System.nanoTime(); //ends the timer
	    
	    JOptionPane.showMessageDialog(null, "The time taken the enqueue was:\n" + (stopEnqueue - startEnqueue) + "nS");
	    //calculates time taken by taking away the two timer values and prints to screen
	    JOptionPane.showMessageDialog(null, "The time taken the dequeue was:\n" + (stopDequeue - startDequeue) + "nS");
	  //calculates time taken by taking away the two timer values and prints to screen
		System.exit(0);
	}

}
