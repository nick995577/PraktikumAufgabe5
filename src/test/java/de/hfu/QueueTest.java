package de.hfu;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class QueueTest {
  
	

	@Test
    public void testEnqueue() {        
		Queue q = new Queue(3);
		for(int i = 0; i < 3; i++) {
			q.enqueue(i+1);
			assertEquals(i+1, q.queue[i]);
		}
    }
	
	@Test
    public void testDequeue() {        
		Queue q = new Queue(3);
		for(int i = 0; i < 3; i++) {
			q.enqueue(i+1);
			assertEquals(i+1, q.queue[i]);
		}
		
		for(int i = 0; i < 3; i++) {
			assertEquals(i+1, q.dequeue());
		}
    }

}
