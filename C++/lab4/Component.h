#pragma once
#include <string>

struct Connection
{
    double x = 0;
};

class Component{
public:

    Component(std::string name, Connection& p, Connection& n);
    virtual ~Component() = default;

    virtual void simulate(double number) = 0;

    virtual void printSelf();

    virtual double getOutput() = 0;

    std::string getName();


protected:
    std::string name;
    double current{0};
    Connection& p;
    Connection& n;
};

class Battery : public Component {
public:
    Battery(std::string name, double voltage, Connection& p, Connection& n);
    ~Battery() = default;
    
    void simulate(double number) override;

    double getOutput() override;
   

private:
    double voltage;
};

class Capacitor : public Component{
public:
    Capacitor(std::string name, double capacitance, Connection& p, Connection& n);
    using Component::Component;
    ~Capacitor() = default;

    void simulate(double number) override;

    double getOutput() override;


private:
    double capacitance{0};
    double charge{0};

};

class Resistor : public Component{
public:
    Resistor(std::string name, double resistance, Connection& p, Connection& n);
    ~Resistor() = default;

    void simulate(double number) override;

    double getOutput() override;


private:
    double resistance{0};
};
