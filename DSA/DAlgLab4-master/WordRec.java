class WordRec
{
  String word;
  WordRec father; // pekare till ordposten som skapat detta ord

  public WordRec(String word_, WordRec father_) {
    word = word_;
    father = father_;
  }

  // ChainLength returnerar antalet ord i en kedja av ordposter.
  public int ChainLength()
  {
	  System.out.println("hej");
    int i = 0;
    for (WordRec x = this; x != null; x = x.father) i++;
    return i;
  }

  private void PrintChainHelp()
  {
    if (father != null) father.PrintChainHelp();
    System.out.print(word);
    System.out.print(" -> ");
  }

  // PrintChain skriver ut en kedja av ordposter.
  public void PrintChain()
  {
    if (father != null) father.PrintChainHelp();
    System.out.print(word);
    System.out.println();
  }

  // PrintWord skriver ut ett ord.
  public void PrintWord()
  {
    System.out.print(word);
  }
  
  //Behöver skriva ut kedjan baklänges för att för att vi använder 
  //slutord som startord i checkAllStartWords.
  
  public void PrintChainInReverse() {
	  PrintWord();
	  if (father != null) {
		  System.out.print(" -> ");
		  father.PrintChainInReverse();
	  } else {
		  System.out.println();
	  }
  }

}
