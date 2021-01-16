#ifndef _STACK_H_
#define _STACK_H_

class Stack
{
public:
  Stack() = default;
  Stack(Stack const &);
  Stack(Stack &&);
  ~Stack();
  
  void push(int number);
  boolean empty();
  int pop();

private:
  struct Node
  {
    int value;
    Node * next;
  };
  Node * head{};
};

#endif;