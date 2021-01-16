#include <algorithm>
#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <map>
#include <iterator>
#include <iomanip>
#include <cctype>

using namespace std;



vector<string> validatedWords{};
map<string, int> wordMap{};
int longestWord{};

void readToMap(string &str);
void printPairLeft(const pair<string, int> &pair);
void findLongestWord(string &str);
void sortAndPrintDescending(map<string, int> &map);
void printOriginalOrder(vector<string> &vec, int width);


string leadingJunk(string &word){
    string leadingJunk("\"'(");
    word.erase(0, word.find_first_not_of(leadingJunk));

    return word;
}

string trailingJunk(string &word){
    string trailingJunk("!?;,:.\"')");

    if(word.find_last_not_of(trailingJunk) + 1 == std::string::npos) {
        return word;       
    }

    word.erase(word.find_last_not_of(trailingJunk) + 1);
    
    return word;
}

string possessionRemover(string &word)  {
    string unWanted("\'s");
    
    if(word.rfind(unWanted) == string::npos) {
        return word;
    }
    word.erase(word.rfind(unWanted));
    return word;
}

bool isAlphaOrHyphen(char c){
    return (isalpha(c) || c == '-');
}

bool isHyphen(char c) {
    return (c == '-');
}

void lowerCharacters(char &c) {
    c = tolower(c);
}


bool is_valid(string &word){
    if (all_of(word.begin(), word.end(), isAlphaOrHyphen)){
        if (word.find("--") == word.npos ) {
            if(word.length() > 2){
                if(isalpha(word[0]) && isalpha(word[word.size() - 1])){
                    for_each(word.begin(), word.end(), lowerCharacters);
                    return true;
                }
            }
        }
    }
    return false;
}

/*
TODO:
In your cleanWords function you are currently using 4 for_each. The first 3 are
transforming the word and thus should use an different algorithm and the validate
one wants to copy all valid words if they match a certain criteria which there
is also a better algorithm for.

Also consider max_elements instead of for_each to find longest word.
*/

// replace
void cleanWords(vector<string> wordCollection) {
    transform(wordCollection.begin(), wordCollection.end(), wordCollection.begin(), leadingJunk);
    transform(wordCollection.begin(), wordCollection.end(), wordCollection.begin(), trailingJunk);
    transform(wordCollection.begin(), wordCollection.end(), wordCollection.begin(), possessionRemover);

    copy_if(wordCollection.begin(), wordCollection.end(), back_inserter(validatedWords), is_valid);
}

int main(int argc, char *argv[]){
    try{
        ifstream file{argv[1]};
        string command{argv[2]};
        if((command != "-a") && (command != "-f") && (command != "-o")){
            throw invalid_argument("Wrong command. Available commands are \"-a\", \"-f\", \"-o [number]\""); 
        }
        
        if(command == "-o" && argc > 4){
            throw out_of_range("Too long parameter list.");
        }

        vector<string> wordCollection((istream_iterator<string>(file)),
                        istream_iterator<string>());

        cleanWords(wordCollection);
        for_each(validatedWords.begin(),validatedWords.end(), findLongestWord);
        for_each(validatedWords.begin(), validatedWords.end(), readToMap); 
   
        if(command == "-a"){
            for_each(wordMap.begin(),wordMap.end(), printPairLeft);
        } else if(command == "-f"){
            sortAndPrintDescending(wordMap);
        } else if(command == "-o"){
            int width = stoi(argv[3]);
            printOriginalOrder(validatedWords, width);
        }
    } catch(const invalid_argument &e) {
        cerr << e.what() << endl;
    } catch(const out_of_range &e){
        cerr << e.what() << endl;
    } 
 
    return 0;
   
}

void readToMap(string &str){
    ++wordMap[str];
}
 
void printPairLeft(const pair<string, int> &pair){
    cout << left << setw(longestWord + 1) << pair.first << " " << pair.second << endl;
}

void printPairRight(pair<string, int> &pair){
    cout << right << setw(longestWord) << pair.first << "  " << pair.second << endl;
}

void findLongestWord(string &str) {
    if(str.length() > longestWord){
        longestWord = str.length();
    }
}

bool biggerThan(const pair<string, int> &pair1, const pair<string, int> &pair2){
    return pair1.second > pair2.second;
}

void sortAndPrintDescending(map<string, int> &map){
    vector<pair<string,int>> wordsToSort;
    copy(map.begin(), map.end(), back_inserter(wordsToSort));
    sort(wordsToSort.begin(), wordsToSort.end(), biggerThan);
    for_each(wordsToSort.begin(), wordsToSort.end(), printPairRight);
}

void printOriginalOrder(vector<string> &vec, int width) {

    int currentWidth{0};

    for_each(vec.begin(), vec.end(), [&currentWidth, width](string word){  
        currentWidth += word.length() + 1;
        if(currentWidth > width){
            currentWidth = word.length() + 1;
            cout << endl;
        }
        cout << word << " ";
    });
    cout << endl;
}
