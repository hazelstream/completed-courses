package testprogram;

import myutil.EmptyException;
import myutil.MyStack;

public class MyStackTest {

	public MyStackTest() {

	}

	public static void main(String[] args) {
		MyStack<Integer> stack = new MyStack<>();


		System.out.println("| Bör printa 0 | " + stack.size());
		
		try {
			System.out.println("| Bör printa true | " + stack.isEmpty());
			//Throwar exception som skriver "Stacken är tom." eftersom stacken inte har några element.
			System.out.println(stack.pop());
		}
		catch(EmptyException e){
			System.out.println(e.getMessage());
		}
		
		//Pushar 5, 10 och 15
		stack.push(5);
		stack.push(10);
		stack.push(15);
		
		System.out.println("| Bör printa 15 | " + stack.pop());
		System.out.println("| Bör printa 2 | " + stack.size());
		System.out.println("| Bör printa false | " + stack.isEmpty());
	}
}