# CT2109-Assignment01
CT2109 Lab assignment: A modification of ArrayQueue to make it a CircularArrayQueue.  
The idea is to  to eliminate the “shuffling” if we treated the array as if it were circular,  
so that when you try to add an item past the end, you instead insert it at the start.  
This involves keeping track of the both the current head and the tail of the queue,  
and allowing them to increase continuously as items are added/removed. 
These head and tail positions are not ‘real’ array positions, 
but the corresponding actual array positions are found by computing the head/tail position modulus the array length.  

Details: 
- Keep track of front as well as rear; initially, front = 0 and rear = -1; 
- At each enqueue, increment rear - At each dequeue, increment front 
- When indexing the array, run front/rear values through realindex(), which returns (index % capacity) 
- Therefore, Q[rear] becomes Q[realindex(rear)] and Q[0] becomes Q[realindex(front)]   

Things to test for: 
- Make a queue of fairly small capacity 
- Does it behave correctly when you try to add too many items or remove items when it's full? 
- Does it behave correctly when you've enqueued/dequeued enough items to make front &amp; rear wrap around?
