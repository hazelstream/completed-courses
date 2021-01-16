int main() 
{
  int number{};
  Stack numStack{};


  while(cin >> number) 
  {
    numStack.push(number);
  }

  while(!numStack.empty())
  {
    cout << numStack.pop();
  }

  
}