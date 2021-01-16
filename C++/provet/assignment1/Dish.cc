#include "Dish.h"
#include <string>
#include <vector>

using namespace std;

string getName()
{
    return name;
}

void addIngredient(Ingredient ingredient)
{
    listOfIngredients.add(ingredient);
}

int getNumberOfIngredients()
{
    return listOfIngredients.size();
}