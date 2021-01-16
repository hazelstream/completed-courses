
//   Inläsning av tal
//   Sortering
//   Utskrift av jämna unika tal


#include <iostream>
#include <vector>
#include <algorithm>
#include <map>

using namespace std;

bool comp_greater(int lhs, int rhs){
  return lhs < rhs;
}

int main(){

  // cin för inläsning
  vector<int> numbers {};
  int num{};

  /*
  Loop utan STL
  while(cin >> num){
    numbers.push_back(num); 
  }
  */
  

  //For loop med iteratorer
  for(auto it = numbers.begin(); it != numbers.end(); it++){
    cout << *it << " ";
  }


  //Range-based loop
  for(int value : numbers){
    cout << value << " ";
  }

  //[2, 5, 3, 6, 99, 10] -> [2, 3, 5, 6, 10, 99]  Ascending

  //Sortera
  for(int  i{0}; numbers.size(); i++){
    int min{i};

    for(int j{i + 1}; j < numbers.size(); j++){
      if(numbers.at(i) > numbers.at(j)){
        std::swap(numbers.at(i), numbers.at(j));
      }
    }
  }

  //Sortera med STL algoritm
  sort(numbers.begin(), numbers.end());
  //Finns rbegin() och rend() också för reverse

  //Med funktion för reverse
  sort(numbers.begin(), numbers.end(), comp_greater);

  //Med lambda för reverse
  sort(numbers.begin(), numbers.end(), [] (int lhs, int rhs) {
    return lhs > rhs;
  });

  map<int, int> m{};


  int nums{0};
  while(cin >> nums){
    m[nums] += 1;
  }

  return 0;
}



