
public class Test1 {
	
	/*
	 *Efter felsök noterar att hashtabellen fungerar som den ska, dock i fallet med storlek 15 
	 *då man kallar på put(nyckel, NULL) så tas det indexet bort, men efterföljarna förflyttas ej som de skall.
	 * 
	 */

	public static void main(String[] args) {
		char c = 'r';
		String str = "hej";
		
	
		SymbolTable st = new SymbolTable(15);
		
		//Börjar med att fylla tabellen.
		st.put(str, c);
		System.out.println("Bör printa 'r' " + st.get(str));
		st.put("asd", 'p');
		st.put("s", 'q');
		st.put("asad", 'm');
		st.put("astd", 'å');
		st.put("hej", 'v');
		st.put("mitt", 'n');
		st.put("namn", '5');
		st.put("är", 'a');
		st.put("göran", '9');
		st.put("pelle", '6');
		st.put("petra", '4');
		st.put("henke", '3');
		st.put("odd", '2');
		st.put("even", '8');
		st.put("gaiusjuliuscaesar", '1');
		//Försöker stoppa in ett till key-al par när tabellen är full
		st.put("bullar", 'x');
		st.dump();
		
		st.delete("hej");
		
		System.out.println("deletar ''Hej'' och dumpar igen");
		
		st.dump();
		
		//Testar att getta borttagen nyckel
		
		
		System.out.println("skriver över s med nytt värde, skriver över göran med null för att testa att det tas bort...");
		System.out.println(st.get("hej"));
		st.put("s", 'ä');

		st.put("göran", null);
		st.put("namn", null);
		st.dump();
		
		
	}

}
