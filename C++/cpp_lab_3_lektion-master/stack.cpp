#include stack.h
#include <stdexdexcept>

using namespace std;

Stack::Stack(Stack && other) : head{other.head} {
  other.head = nullptr;
}

Stack::Stack(Stack const& other) : head{copy(other.head)} {}

Stack::Node * Stack::copy(Stack::Node const * node) const
{
  return new Node{n->value, n->next};
}

Stack::~Stack()
{
  while(!empty())
  {
    pop();
  }
}

bool Stack::empty() const
{
  return head == nullptr;
}

int Stack::pop()
{
  if(empty())
  {
    throw logic_error{"Error: No content"};
  }
  int value = head->value;
  Node * tmp = head;
  head = head->next;
  tmp->next = nullptr;
  delete tmp;

  return value;
  //1 new = 1 delete
}

void Stack::push(int number)
{
  head = new Node{value, head};
}