#pragma once
#include <string>

class Ingredient
{
public:
    Ingredient(std::string name, int weightInKG) 
        : name(name), weightInKG(weightInKG) {}

    std::string getName();
    int getWeight();

private: 
    std::string name;
    int weightInKG;
};