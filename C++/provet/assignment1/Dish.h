#pragma once
#include "Ingredient.h"
#include <vector>
#include <string>

class Dish
{
public:
    Dish(std::string name)
        : name(name), listOfIngredients{} {}

    std::string getName() const;
    void addIngredient(Ingredient ingredient);
    int getNumberOfIngredients();

private:
    std::vector<Ingredient> listOfIngredients;
    std::string name;
};