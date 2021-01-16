#include "Component.h"
#include <string>
#include <iostream>
#include <iomanip>

using namespace std;

Component::Component(std::string name, Connection& p, Connection& n)
    : name(name),p(p),n(n)
{}

string Component::getName()
{
    return name;
}

void Component::printSelf() {
    cout << fixed << showpoint << setprecision(2);
    cout << setw(7) << right << getOutput() << setw(7) << right << current;
}

Capacitor::Capacitor(string name, double capacitance, Connection& p, Connection& n)
    : Component{name, p, n}, capacitance{capacitance} {}


void Capacitor::simulate(double number) {

    double difference;

    if (p.x>n.x) {
        difference = p.x-n.x;
    } else {
        difference = n.x-p.x;
    }

    current = capacitance * (difference - charge);
    double result = current * number;

    if(p.x > n.x){
        p.x -= result;
        n.x += result;

    } else if(n.x > p.x){
        n.x -= result;
        p.x += result;
    }
    charge += result;
}

double Capacitor::getOutput(){
    return charge;
}

Battery::Battery(string name, double voltage, Connection& p, Connection& n)
    : Component{name, p, n}, voltage{voltage} {}

void Battery::simulate(double number) {

    p.x = voltage;
    n.x = 0;

    voltage = p.x;
}


double Battery::getOutput(){
    return voltage;
}

Resistor::Resistor(string name, double resistance, Connection& p, Connection& n)
    : Component{name, p, n}, resistance{resistance} {}

void Resistor::simulate(double number) {

    double difference;

    if (p.x>n.x) {
        difference = p.x-n.x;
    } else {
        difference = n.x-p.x;
    }
    
    current = difference / resistance;
    double result = current * number;
 
    if(p.x > n.x){
        p.x -= result;
        n.x += result;
    } else if(n.x > p.x){
        p.x += result;
        n.x -= result;
    }
}

double Resistor::getOutput(){
    return p.x - n.x;
}

