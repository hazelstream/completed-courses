#include "Animal.h"
#include <vector>

int main() {

  Dog dog{"Bosse", 4};
  dog.Make_Sound();

  Cat cat{"Kalle"};
  cat.Make_Sound();

  std::vector<Animal*> animals;

  animals.push_back(new Dog{});
  animals.push_back(new Cat{});

  for(Animal* a : animals)
  {
    a->Make_Sound();
    delete a;
  }

  return 0;
}