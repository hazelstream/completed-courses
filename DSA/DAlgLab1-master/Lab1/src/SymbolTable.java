public class SymbolTable {
	private static final int INIT_CAPACITY = 7;

	/* Number of key-value pairs in the symbol table */
	private int N;
	/* Size of linear probing table */
	private int M;
	/* The keys */
	private String[] keys;
	/* The values */
	private Character[] vals;

	/**
	 * Create an empty hash table - use 7 as default size
	 */
	public SymbolTable() {
		this(INIT_CAPACITY);
	}

	/**
	 * Create linear probing hash table of given capacity
	 */
	public SymbolTable(int capacity) {
		N = 0;
		M = capacity;
		keys = new String[M];
		vals = new Character[M];
	}

	/**
	 * Return the number of key-value pairs in the symbol table
	 */
	public int size() {
		return N;
	}

	/**
	 * Is the symbol table empty?
	 */
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Does a key-value pair with the given key exist in the symbol table?
	 */
	public boolean contains(String key) {
		return get(key) != null;
	}

	/**
	 * Hash function for keys - returns value between 0 and M-1
	 */
	public int hash(String key) {
		int i;
		int v = 0;

		for (i = 0; i < key.length(); i++) {
			v += key.charAt(i);
		}
		return v % M;
	}

	/**
	 * Insert the key-value pair into the symbol table.
	 */
	public void put(String key, Character val) {
		int hashedKey = hash(key);
		// Kollar eventuella null-värden

		if (val == null) {
			delete(key);
			return;
		}

		if (size() == M || key == null) {
			return;
		}

		// Kollar om keyn redan finns i arrayen och om den gör det så skrivs endast
		// värdet över.
		
		int newKey = hashedKey;
		for (int i = 0; i < M; ++i) {
			if (keys[newKey] != null && keys[newKey].equals(key)) {
				vals[newKey] = val;
				return;
			}
			newKey = next(newKey);
		}

		// Skriver in key och värde i arrayen, kommer inte hit om föregående operation
		// utförs.
		move(key, val);
		++N;
	}

	/**
	 * Return the value connected with a certain key.
	 */

	public Character get(String key) {

		int hashedKey = hash(key);
		int counter = 0;

		// Itererar igenom array och letar efter den matchande keyen och returnerar det
		// värde som är kopplat med den.
		for (int i = hashedKey; counter < M; i = next(i)) {
			if (keys[i] != null) {
				if (keys[i].equals(key)) {
					return vals[i];
				}
			}
			++counter;
		}
		return null;
	}

	/**
	 * Delete the key (and associated value) from the symbol table
	 */
	public void delete(String key) {
		// Om nyckeln är null så händer ingenting.
		if (key == null) {
			return;
		}
		
		int hashedKey = hash(key);
		boolean removed = false;
		int deleteIndex = 0;

		// Om nyckeln matchar på något index så sätts key och val till null och boolean
		// sätts till true.
		for (int i = hashedKey; i < M + 1; i = next(i)) {
			if (keys[i].equals(key)) {
				keys[i] = null;
				vals[i] = null;
				removed = true;
				deleteIndex = i;
				break;
			}
		}

		// Om boolean från föregående operation är true så betyder det att vi har
		// frigjort ett index i tabellen och då behöver vi flytta upp saker så att de
		// kan hittas vid senare sökningar.
		if (removed) {
			int counter = next(deleteIndex);
			while(keys[counter] != null) {
				String temp1 = keys[counter];
				Character temp2 = vals[counter];
				keys[counter] = null;
				vals[counter] = null;
				move(temp1, temp2);
				counter = next(counter);
			}
		}
		--N;
		return;
	}

	// Funktionen vi använder för att öka på ett index, när det når index 6 så
	// snurrar den runt till index 0 och blir cirkulär.
	public int next(int n) {
		if (n < M - 1) {
			return ++n;
		} else {
			return 0;
		}
	}
	

	// Denna kallas då något key-value par behöver stoppas in i tabellen, söker
	// igenom tabellen tills den hittar ett tomt index där den då kan stoppa in
	// key-val paret.
	public void move(String key, char val) {
		int hashedKey = hash(key);
		while (keys[hashedKey] != null) {
			hashedKey = (hashedKey + 1) % M;
		}
		keys[hashedKey] = key;
		vals[hashedKey] = val;
	}

	/**
	 * Print the contents of the symbol table
	 */
	public void dump() {
		String str = "";

		for (int i = 0; i < M; i++) {
			str = str + i + ". " + vals[i];
			if (keys[i] != null) {
				str = str + " " + keys[i] + " (";
				str = str + hash(keys[i]) + ")";
			} else {
				str = str + " -";
			}
			System.out.println(str);
			str = "";
		}
	}
}
