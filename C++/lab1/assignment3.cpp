#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <iomanip>

using namespace std;

int main()
{
    //TODO: Init vars correctly (1-1)
    //TODO: Add cin.iognore as in prev. parts
    //TODO: What happens if the file is empty? Warning or message?
  
    int longest{0};
    int shortest{INT16_MAX};
    double count{0.00};
    double amount{0.00};
    string shortestWord{"fel"};
    string longestWord{"fel"};
    ifstream file ("textfile.txt");
    string input;
    vector<string> words;

    while (file >> input) 
    {
        words.push_back(input);
    }
    
    for (string word : words) 
    
    {
        if(word.length() > longest){
            longest = word.length();
            longestWord = word;         
        }
        if(word.length() < shortest){
            shortest = word.length();
            shortestWord = word;
        }

        count += 1.00;
        amount += (double)word.length();
    }

    if(words.size() == 0)
    { 
        cerr << "Error: Empty file. " << endl;
    }
    else
    {
        cout << fixed << showpoint << setprecision(2);
        cout << "There are " << (int)count << " words in the file." << endl;
        cout << "The shortest word was \"" << shortestWord  << "\" with \"" << shortest << "\" character(s)." << endl;
        cout << "The longest word was \"" << longestWord <<"\" with \"" << longest << "\" character(s)." << endl;
        cout << "The average length was " << amount / count << " character(s)." << endl;
    }

    

    return 0;
}
