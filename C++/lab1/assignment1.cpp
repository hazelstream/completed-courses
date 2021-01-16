#include <iostream>
#include <string>
#include <iomanip>

using namespace std;

int number{0};
double real{0.00};
char character{'a'};
string str{'a'};


int main()
{
    //TODO: You must the flushing method foor std:cin. In the cases where the user do not enter such nice input, the whole program will not be able to execute as designed. Tip: Take a look at cin.ignore. This must be done often...
    //TODO: There should not be several endl in a sequence (endl << endl). This can be solved in a more readable and general way.
    //TODO: Long rows (1-3)

    //Comment: Good comments.
    //Comment: Nice to add periods at end of printed sentences! 
    //Case 1
    cout << "Enter one integer: ";
    cin >> number;
    cin.ignore();
    cout << "You entered the number: \n" << number << endl;

    //Case 2
    cout << "Enter four integers: ";
    cin >> number;
    cin.ignore();
    cout << "You entered the numbers: " << number;
    cin >> number;
    cin.ignore();
    cout << " " << number;
    cin >> number;
    cin.ignore();
    cout << " " << number;
    cin >> number;
    cin.ignore();
    cout << " " << number << "\n" << endl;

    //Case 3
    cout << "Enter one integer and one real number: ";
    cin >> number;
    cin >> real;
    cin.ignore();
    cout << "The real is: " << setw(10) << setprecision(4) << real;
    cout << "\nThe integer is: \n" << setw(7) << number  << endl;

    //Case 4
    cout << "Enter one real and one integer number: ";
    cin >> real;
    cin >> number;
    cin.ignore();
    cout << "The real is: " << setfill('.') << setw(10) <<  setprecision(4); 
    cout << real << "\nThe integer is: \n" << setfill('.') << setw(7) << number  << endl; 

    //Case 5
    cout << "Enter a character: ";
    cin >> character;
    cin.ignore();
    cout << "You entered: " << character << "\n" << endl;
    
    //Case 6
    cout << "Enter a word: ";
    cin >> str;
    cin.ignore();
    cout << "The word '" << str << "' has " << str.length() << " character(s).\n"  << endl;
    
    //Case 7
    cout << "Enter an integer and a word: ";
    cin >> number >> str;
    cin.ignore();
    cout << "You entered '" << number << "' and '" << str << "'." << "\n" << endl;
    
    //Case 8
    cout << "Enter a character and a word: ";
    cin >> character >> str;
    cin.ignore();
    cout << "You entered the string \"" << str << "\" and the character '" << character << "'." << "\n" << endl;
    
    //Case 9
    cout << "Enter a word and a real number: ";
    cin >> str >> real;
    cin.ignore();
    cout << "You entered \"" << str << "\" and \"" << setprecision(4) << real << "\".\n"  << endl;
    
    //Case 10
    cout << "Enter a text-line: ";
    getline(cin, str);
    cin.ignore();
    cout << "You entered: \"" << str << "\"\n"  << endl;
    
    //Case 11
    cout << "Enter a second line of text: ";
    getline(cin, str);
    cin.ignore();
    cout << "You entered: '" << str << "'" << "\n" << endl;

    //Case 12
    cout << "Enter three words: ";
    cin >> str;
    cout << "You entered the words: " << str;
    cin >> str;
    cout << " " << str;
    cin >> str;
    cin.ignore();
    cout << " \n" << str  << endl;


    return 0;
}
