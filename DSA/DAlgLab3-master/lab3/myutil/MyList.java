package myutil;


public class MyList<T> {
	
	private Node<T> first, last;
	
	private int size = 0;
	
	public MyList() {
		
	}
	
	/**
	 * Adds an item to the list object, on the last position
	 * @param element - the data which to add to the list
	 */
	public void add(T element) {
		Node<T> temp = new Node<>(element);
		
		if(last == null) {
			last = temp;
		}
		
		if (first == null) {
			first = temp;
		}
		else {
			
			last.setNext(temp);
			last = temp;
			
		}
		
		++size;
	}
	
	public T getElementAt(int i) throws EmptyException {
		
		int counter = 0;
		Node<T> index = first;
		
		if(i >= size) {
			throw new EmptyException("Söktalet är för stort, listan är för liten för det talet.");
		}
		
		while(counter < i) {
			index = index.getNext();
			++counter;
		}
		
		return index.getData();
	}
	
	public boolean isEmpty() {
		
		return size == 0;
	}

	public int size() {
		
		return size;
	}
}