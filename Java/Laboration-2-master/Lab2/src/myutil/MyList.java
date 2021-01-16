package myutil;


public class MyList<T> {
	
	private Node<T> first;
	
	private int size = 0;
	
	public MyList() {
		
	}
	
	public void add(T element) {
		Node<T> temp = new Node<>(element);
		
		if (first == null) {
			first = temp;
		}
		else {
			Node<T> resväg = first;
			while(resväg.getNext() != null) {
				resväg = resväg.getNext();
			}
			
			resväg.setNext(temp);
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