#include <vector>
#include <iostream>
#include <string>

/*
Expected output:

box containing a box containing a Book wrapped in blue paper wrapped in red paper

This gift was packaged by: 
Eminelf
Elf Mayweather
Mike Elfson
Elfpac

 */

class Elf
{
protected:
    std::string name;
public:
    Elf(std::string name) : name(name) {}
    std::string get_name() const;
    virtual std::string handle(std::string gift) const = 0;
};

std::string Elf::get_name() const
{
    return name;
}

class Wrapper : public Elf
{
private:
    std::string color;
public: 
    Wrapper(std::string name, std::string color) : Elf(name), color(color) {}
    std::string handle(std::string gift) const override;
};

std::string Wrapper::handle(std::string gift) const
{
    return gift + " wrapped in " + color + " paper";
}

class Boxer : public Elf
{
public: 
    Boxer(std::string name) : Elf(name) {}
    std::string handle(std::string gift) const override;
};

std::string Boxer::handle(std::string gift) const 
{
    return "box containing a " + gift;
}


int main()
{
    std::vector<Elf*> elves {
        new Wrapper{"Eminelf", "blue"},
        new Boxer{"Elf Mayweather"},
        new Boxer{"Mike Elfson"},
        new Wrapper{"Elfpac", "red"}
    };

    std::string gift { "Book" };
    for (Elf *elf : elves)
    {
        gift = elf->handle(gift);
    }
    std::cout << gift << std::endl << std::endl;

    std::cout << "This gift was packaged by: " << std::endl;
    for (Elf *elf : elves)
    {
        std::cout << elf->get_name() << std::endl;
    }
}
