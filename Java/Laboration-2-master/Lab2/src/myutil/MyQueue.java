package myutil;

public class MyQueue<T> {
	
	private Node<T> first;
	private Node<T> last;
	private int size = 0;
	
	public MyQueue() {
		
	}

	
	public void enqueue(T element) {
		Node<T> temp = new Node<>(element);
		
		if (first == null) {
			first = temp;
			last = temp;
		}
		
		last.setNext(temp);
		last = temp;
		
		++size;
	}
	
	public T dequeue() throws EmptyException {
		T sum;
		
		if(first == null) {
			throw new EmptyException("Queuen är tom.");
		}
		
		sum = first.getData();
		first = first.getNext();
		
		--size;
				
		return sum;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
	
}