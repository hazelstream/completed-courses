class LongestChain {
	private Queue q; // kö som anänds i breddenförstsökningen
	private String goalWord; // slutord i breddenförstsökningen
	int wordLength;
	final char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
			's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'å', 'ä', 'ö', 'é' };
	int alphabetLength = alphabet.length;

	public LongestChain(int wordLength) {
		this.wordLength = wordLength;
		q = new Queue();
	}

	// IsGoal kollar om w är slutordet.
	private boolean IsGoal(String w) {
		return w.equals(goalWord);
	}

	// MakeSons skapar alla ord som skiljer på en bokstav från x.
	// Om det är första gången i sökningen som ordet skapas så läggs det
	// in i kön q.
	
	/*
	 * Vi valde att använda StringBuilder för att represetera String, den fungerar ungefär som en CharArray med en del redan inbyggda funktioner.
	 */
	private WordRec MakeSons(WordRec x) {
		StringBuilder sb = new StringBuilder(x.word);
		
		//Vi gör en temporär SB för att slippa modifiera originalSB så att vi vet vår utgångsposition. 
		StringBuilder tempSb = new StringBuilder(sb);
		WordRec wr;
		String theWord;
		
		
		for (int i = 0; i < wordLength; i++) {
			for (int c = 0; c < alphabetLength; c++) {
				if (sb.charAt(i) != alphabet[c]) {
					tempSb.setCharAt(i, alphabet[c]);
				}
				//Kollar om ordet som är skapat finns i WordListen som är inläst.
				theWord = WordList.Contains(tempSb.toString());
				
				//Om det finns så returnerar vi det om det är målordet, annars läggs det till i Queuen för att sedan genomgå samma process som vi gör nu.
				if (theWord != null) {
					wr = new WordRec(theWord, x);
					if (IsGoal(theWord))
						return wr;
					q.Put(wr);
				}
			}
			
			//Sätter tempSb tillbaka till ursprunget.
			tempSb.setCharAt(i, sb.charAt(i));
		}
		
		//Kollar om vi har inmataning med ett eller två ord.
		if (goalWord == null) {
			return x;
		}else {
		return null;
		}
		
	}

	// BreadthFirst utför en breddenförstsökning från startWord för att
	// hitta kortaste ägen till endWord. Den kortaste vägen returneras
	// som en kedja av ordposter (WordRec).
	// Om det inte finns något sätt att komma till endWord returneras null.
	public WordRec BreadthFirst(String startWord, String endWord) {
		WordList.EraseUsed();
		WordRec start = new WordRec(startWord, null);
		WordList.MarkAsUsedIfUnused(startWord);
		goalWord = endWord;
		q.Empty();
		q.Put(start);
		try {
			while (!q.IsEmpty()) {
				WordRec wr = MakeSons((WordRec) q.Get());
				//Kollar om vi har inmatning med ett eller två ord. 
				if (endWord == null) {
					if (q.IsEmpty()) {
						return wr;
					}
				} else {
					if (wr != null)
						return wr;
				}
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}

	// CheckAllStartWords hittar den längsta kortaste vägen från något ord
	// till endWord. Den längsta vägen skrivs ut.
	public void CheckAllStartWords(String endWord) {
		//Skickar in null som endWord för att köra igenom alla ord. Det ord som hittas sist är automatiskt det som är längst från startWord.
		//Eftersom vi använder oss av BFS så är den rutt vi hittar till det sista ordet även den rutt som är kortaste vägen dit.
		WordRec x = BreadthFirst(endWord, null);
		System.out.println(endWord + ": " + x.ChainLength() + " ord");
		if (x != null) {
			//Eftersom vi stoppar in endWord som startWord så vill vi byta så att vi skriver ut det sista ordet först, for the sake of consistency.
			x.PrintChainInReverse();
		}

	}
}
