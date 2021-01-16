#pragma once
#include <string>

struct Connection
{
  
};

class Component
{
public: 
  Component(std::string name, Connection& p, Connection& n);
  virtual ~Component() = default;

  virtual void Simulate() = 0;

  std::string name;

  Connection& p;
  Connection& n;
};

class Battery : public Component
{
  Battery();
  ~Battery();

  void Simulate() override;

  float voltage;
};

class Resistor : public Component
{
  Resistor();
  ~Resistor();

  void Simulate() override;

  float ohm;
};

class Capacitor : public Component
{
  Capacitor();
  ~Capacitor();

  void Simulate() override;
  
  float capacitance;
};
