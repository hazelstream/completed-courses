package testprogram;

import myutil.EmptyException;
import myutil.MyList;

public class MyListTest {

	public static void main(String[] args) {
		MyList<Integer> list = new MyList<>();
		
		try {
			System.out.println("| Bör printa true | " + list.isEmpty());
			
			//Throwar exception eftersom stacken inte har några element.
			System.out.println(list.getElementAt(3));											
		}
		catch(EmptyException e) {
			System.out.println(e.getMessage());
		}
		
		//Pushar 3, 5 och 7
		list.add(3);
		list.add(5);
		list.add(7);
		
		System.out.println("| Bör printa false | " + list.isEmpty());
		System.out.println("| Bör printa 3 | " + list.size());
		System.out.println("| Bör printa 7 | " + list.getElementAt(2));
		System.out.println("| Bör printa 3 | " + list.getElementAt(0));
	}

}