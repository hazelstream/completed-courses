package testprogram;

import myutil.EmptyException;
import myutil.MyQueue;

public class MyQueueTest {

	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<>();

		try {
			System.out.println("| Bör printa 0 | " + queue.size());
			System.out.println("| Bör printa true | " + queue.isEmpty());
			
			//Bör throwa exception som säger "Queuen är tom." eftersom inga element är tillagda.
			System.out.println(queue.dequeue());
		}
		catch(EmptyException e){
			System.out.println(e.getMessage());
		}
		
		//Enqueuar 5, 10 och 15.
		queue.enqueue(5);
		queue.enqueue(10);
		queue.enqueue(15);
		
		System.out.println("| Bör printa 5 | " + queue.dequeue());		
		System.out.println("| Bör printa 2 | " + queue.size());		
		System.out.println("| Bör printa 10 | " + queue.dequeue());	
		System.out.println("| Bör printa false | " + queue.isEmpty());
		System.out.println("| Bör printa 1 | " + queue.size());
	}
}