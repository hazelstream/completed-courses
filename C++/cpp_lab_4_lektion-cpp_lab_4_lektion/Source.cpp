#include "Header.h"
#include <vector>

using namespace std;

int main() {

  vector <Component*> Net;
  Connection p, n;
  Net.push_back(new Battery{ "Battery", 24.0, p, n });

  for(auto Component : Net)
  {
    Component->Simulate();
  }
}