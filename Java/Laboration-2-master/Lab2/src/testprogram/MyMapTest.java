package testprogram;

import myutil.MyMap;

public class MyMapTest {

	public static void main(String[] args) {
		
		MyMap<Integer, Integer> dataMap = new MyMap<>();
		
		System.out.println("| Bör printa true | " + dataMap.isEmpty());
		System.out.println("| Bör printa 0 | " + dataMap.size());
		
		//Puttar (1, 10), (45, 110) och (2, 67).
		dataMap.put(1, 10);
		dataMap.put(45, 110);
		dataMap.put(2, 67);

		
		System.out.println("| Bör printa false | " + dataMap.isEmpty());
		System.out.println("| Bör printa 10 | " + dataMap.get(1));
		System.out.println("| Bör printa 3 | " + dataMap.size());
		System.out.println("| Bör printa 110 | " + dataMap.get(45));
		System.out.println("| Bör printa null | " + dataMap.get(55));
		System.out.println("| Bör printa 67 | " + dataMap.get(2));
	}

}