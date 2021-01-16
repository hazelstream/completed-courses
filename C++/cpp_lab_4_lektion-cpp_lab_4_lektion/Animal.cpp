#include "Animal.h"
#include <iostream>

using namespace std;

Animal::Animal(string Name) : Name{ Name }
{

}

Dog::Dog(string Name, int legs) : Animal(Name), legs{legs}
{

}

void Dog::Make_Sound()
{
  cout << "Bark!" << endl;
}

void Cat::Make_Sound()
{
  cout << "Meow!" << endl;
}