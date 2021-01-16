/**********************************************************************
 *  M�nsterigenk�nning readme.txt
 **********************************************************************/

 Ungef�rligt antal timmar spenderade p� labben (valfritt): 18

/**********************************************************************
 *  Empirisk    Fyll i tabellen nedan med riktiga k�rtider i sekunder
 *  analys      n�r det k�nns vettigt att v�nta p� hela ber�kningen.
 *              Ge uppskattningar av k�rtiden i �vriga fall.
 *
 **********************************************************************/
    
      N       brute       sortering
 ----------------------------------
    150			34 ms		  67 ms
    200			56 ms		  29 ms
    300			85 ms		  56 ms
    400		   166 ms		  70 ms
    800		   918 ms		 198 ms
   1600		  7749 ms		 568 ms
   3200		 65767 ms		2179 ms
   6400	    586256 ms	    8765 ms
  12800	   4478351 ms	   41823 ms


/**********************************************************************
 *  Teoretisk   Ge ordo-uttryck f�r v�rstafallstiden f�r programmen som
 *  analys      en funktion av N. Ge en kort motivering.
 *
 **********************************************************************/

Brute: Theta(n⁴) 

4 på varandra nästlade loopar gör att vi går igenom listan 4 gånger alla körningar

Sortering:O(n²log(n)) 

Collections.sort är en modifierad MergeSort med tidskomplexitet O(n*log(n)). 
Sorteringen är den "dyraste" loopen inuti den yttersta loopen, vilket ger tidskomplexiteten O(n²log(n))


