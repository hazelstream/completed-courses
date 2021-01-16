package myutil;

public class MyStack<T> {
	
	private Node<T> top;
	private int size = 0;

	public MyStack() {
		
	}
	
	public void push(T data) {
		Node<T> temp = new Node<>(data);
		temp.setNext(top);
		top = temp;
		
		++size;
	}
	
	public T pop() throws EmptyException{
		
		
		if(top == null) {
			throw new EmptyException("Stacken är tom.");
		}
		
		T sum;
		sum = top.getData();
		top = top.getNext();
		
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
