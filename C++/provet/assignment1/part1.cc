#include <iostream>
#include <vector>
#include <string>

using namespace std;

class Ingredient
{
private:
    std::string name;
    int weightInKG;
public:
    Ingredient(string name, int weightInKG);
    ~Ingredient();

    string getName() const;
    int getWeight() const;
};

Ingredient::Ingredient(std::string name, int weightInKG) 
        : name(name), weightInKG(weightInKG) {}

Ingredient::~Ingredient()
{
}

string Ingredient::getName() const
{
    return name;
}

int Ingredient::getWeight() const
{
    return weightInKG;
}

class Dish
{
private:
    std::vector<Ingredient> listOfIngredients;
    std::string name;
public:
    Dish(std::string name, vector<Ingredient> ingredients);
    ~Dish();

    std::string getName() const;
    void addIngredient(Ingredient ingredient);
    int getNumberOfIngredients();
    void print();
};

Dish::Dish(std::string name, vector<Ingredient> ingredients)
        : name(name), listOfIngredients{ingredients} {}

Dish::~Dish(){}

string Dish::getName() const 
{
    return name;
}

void Dish::addIngredient(Ingredient ingredient)
{
    listOfIngredients.push_back(ingredient);
}

int Dish::getNumberOfIngredients()
{
    return listOfIngredients.size();
}

void Dish::print()
{
    for(auto i : listOfIngredients){
        cout << i.getName() << endl;
    }
}



int main()
{
    vector<Ingredient> pastaIngredients{Ingredient{"Pasta", 2}, Ingredient{"Ägg", 3}, Ingredient{"Bacon", 1}};

    Dish pastaCarbonara("Pasta Carbonara", pastaIngredients);

    pastaCarbonara.print();

    pastaCarbonara.addIngredient(Ingredient{"Parmesan", 5});

    pastaCarbonara.print();

    return 0;
}

