#include "Component.h"
#include <vector>
#include <iostream>
#include <iomanip>

using namespace std;

void print(vector<Component *> net)
{

    cout << endl;

    for (Component *element : net)
    {
        element->printSelf();
    }
}

void simulate(vector<Component *> net, int iterations, int linesToPrint, double timeUnit)
{

    int temp = iterations / linesToPrint;
    bool firstIteration{false};

    for (Component *element : net)
    {
        cout << setw(14) << right << element->getName();
    }
    cout << endl;
    for (Component *element : net)
    {
        cout << setw(7) << right << "Volt" << setw(7) << right << "Curr";
    }

    for (iterations; iterations >= 0; iterations--)
    {

        for (Component *element : net)
        {
            element->simulate(timeUnit);
        }

        if (iterations % temp == 0)
        {
            if (firstIteration)
            {
                print(net);
            }
            firstIteration = true;
        }
    }
    cout << endl;
};

void deallocate_components(vector<Component *> &net)
{
    for (Component *element : net)
    {
        delete element;
    }
    net.clear();
};

void simulationOne(int numberOfIterations, int linesToPrint, double timeUnit, double batteryVoltage)
{

    Connection p, n, R124, R23;
    vector<Component *> net;

    net.push_back(new Battery("Bat", batteryVoltage, p, n));
    net.push_back(new Resistor("R1", 6.0, p, R124));
    net.push_back(new Resistor("R2", 4.0, R124, R23));
    net.push_back(new Resistor("R3", 8.0, R23, n));
    net.push_back(new Resistor("R4", 12.0, R124, n));

    simulate(net, numberOfIterations, linesToPrint, timeUnit);
    deallocate_components(net);
}

void simulationTwo(int numberOfIterations, int linesToPrint, double timeUnit, double batteryVoltage)
{
    Connection p, n, l, r;
    vector<Component *> net;

    net.push_back(new Battery("Bat", batteryVoltage, p, n));
    net.push_back(new Resistor("R1", 150.0, p, l));
    net.push_back(new Resistor("R2", 50.0, p, r));
    net.push_back(new Resistor("R3", 100.0, l, r));
    net.push_back(new Resistor("R4", 300.0, l, n));
    net.push_back(new Resistor("R5", 250.0, n, r));
    simulate(net, numberOfIterations, linesToPrint, timeUnit);
    deallocate_components(net);
}

void simulationThree(int numberOfIterations, int linesToPrint, double timeUnit, double batteryVoltage)
{
    Connection p, n, l, r;
    vector<Component *> net;

    net.push_back(new Battery("Bat", batteryVoltage, p, n));
    net.push_back(new Resistor("R1", 150.0, p, l));
    net.push_back(new Resistor("R2", 50.0, p, r));
    net.push_back(new Capacitor("C3", 1.0, l, r));
    net.push_back(new Resistor("R4", 300.0, l, n));
    net.push_back(new Capacitor("C5", 0.75, n, r));
    simulate(net, numberOfIterations, linesToPrint, timeUnit);
    deallocate_components(net);
}

int main(int argc, char *argv[])
{

    try {
        int numberOfIterations = stoi(argv[1]);
        int iterationsToPrint = stoi(argv[2]);
        double timeUnit = stod(argv[3]);
        double batteryVoltage = stod(argv[4]);

        if (argc > 5)
        {
             throw out_of_range("Out of range: Input was out of range");
        }
        
        simulationOne(numberOfIterations, iterationsToPrint, timeUnit, batteryVoltage);
        simulationTwo(numberOfIterations, iterationsToPrint, timeUnit, batteryVoltage);
        simulationThree(numberOfIterations, iterationsToPrint, timeUnit, batteryVoltage);

    } catch(invalid_argument e) {
        cerr << e.what() << endl;
    } catch(out_of_range e){
        cerr << e.what() << endl;
    }
};

