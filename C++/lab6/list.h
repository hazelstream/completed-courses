#ifndef _LIST_H_
#define _LIST_H_

#include <iostream>
#include <string>

/* using Data = std::string; */

template<typename T>
class List
{
public:
  List();
  ~List() { delete first; }

  void insert(T const& data);
  
  List(List<T> const&);
  List(List<T> &&);
  List& operator=(List<T> const&);
  List& operator=(List<T>&&);
    
private:
  class Link
  {
  public:
    Link(T const& d, Link* n)
      : data(d), next(n) {}
    ~Link() { delete next; }
    
    friend class List;

    static Link* clone(Link const*);

  private:
    
    T data;
    Link* next;
  };

  Link* first;
  
public:

  using value_type = T;

  // Suitable place to add things...

  class Iterator {
  public:
    Iterator& operator++();   
    bool operator==(Iterator comparison) const;
    bool operator!=(Iterator comparison) const;
    T& operator*() const;

    friend class List;

  private:
    Link *current;
    Iterator(Link* pointer) : current(pointer) {}
  };

  
  Iterator begin();
  Iterator end();
};

template<typename T>
std::ostream& operator<<(std::ostream &out, List<T>& list);


#include "list.tcc"
#endif
