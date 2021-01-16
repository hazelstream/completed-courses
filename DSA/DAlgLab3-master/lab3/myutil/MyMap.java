package myutil;

public class MyMap<K, V> {
	
	private Node<MyPair<K, V>> first, last;
	private MyPair<K, V> par;
	private int size = 0;
	
	
	public void put(K key, V value) {
		par = new MyPair<K, V>(key, value);
		Node<MyPair<K, V>> temp = new Node<>(par);
		
		if(last == null) {
			last = temp;
		}
		
		if(first == null) {
			first = temp;
		}
		else {
			
			last.setNext(temp);
			last = temp;
//			
//			Node<MyPair<K, V>> travel = first;
//			
//			  while(travel.getNext() != null) { 
//				  travel = travel.getNext(); }
//			  travel.setNext(temp);
			 
			
		}
		
		++size;
	}
	
	public V get(K key) {
		
		Node<MyPair<K, V>> search = first;
		
		if(search == null) {
			return null;
		}
		
		while(search.getData().getKey() != key && search.getNext() != null) {
			search = search.getNext();
		}
		
		if(search.getData().getKey() != key) {
			return null;
		}
		
		
		return (V) search.getData().getValue();
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
}
