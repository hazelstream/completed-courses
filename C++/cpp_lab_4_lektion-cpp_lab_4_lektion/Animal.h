#ifndef ANIMAL_H
#define ANIMAL_H

#include <string>

class Animal
{
public:
  Animal(std::string const& Name = "");
  virtual ~Animal() = default;

  virtual void Make_Sound() = 0;

protected:
  std::string Name;
};

class Dog : public Animal
{
public:
  Dog(std::string const& Name = "", int legs = 0);  
  ~Dog() = default;

  void Make_Sound() override;
  
  int legs;

};

class Cat : public Animal
{
public:
  using Animal::Animal;
  ~Cat() = default;
  
  void Make_Sound() override;

};

#endif ANIMAL_H