#include <algorithm>
#include <iostream>

/* #include "list.h" */

template<typename T>
void List<T>::insert(T const &data)
{
  first = new Link(data, first);
}

//-----------------------------------------------------//
// Important copy and assignment stuff

template<typename T>
typename List<T>::Link*

List<T>::Link::clone(Link const *dolly)
{
  if ( dolly != nullptr )
    return new Link(dolly->data, clone(dolly->next));
  else
    return nullptr;
}

template<typename T>
List<T>::List() : first(nullptr)
{
  std::clog << "***Default construction" << std::endl;
}

template<typename T>
List<T>::List(List<T> const &l)
{
  std::clog << "***Copy construction" << std::endl;
  first = Link::clone(l.first);
}

template<typename T>
List<T>::List(List<T> &&l)
{
  std::clog << "***Move construction" << std::endl;
  first = l.first;
  l.first = nullptr;
}

template<typename T>
List<T> &List<T>::operator=(List<T> const &rhs)
{
  std::clog << "***Copy assignment" << std::endl;
  if (&rhs != this)
  {
    List copy(rhs);
    std::swap(first, copy.first);
  }
  return *this;
}

template<typename T>
List<T> &List<T>::operator=(List<T> &&rhs)
{
  std::clog << "***Move assignment" << std::endl;
  if (&rhs != this)
  {
    std::swap(first, rhs.first);
  }
  return *this;
}


template<typename T>
bool List<T>::Iterator::operator!=(Iterator comparison) const {
  return current != comparison.current;
}

template<typename T>
bool List<T>::Iterator::operator==(Iterator comparison) const {
  return current == comparison.current;
}

//Prefixinkrement
template<typename T>
typename List<T>::Iterator &List<T>::Iterator::operator++() {
  current = current->next;
  return *this;
}

//Deref
template<typename T>
T &List<T>::Iterator::operator*() const {
  return current->data;
}


//begin
template<typename T>
typename List<T>::Iterator List<T>::begin(){
  return Iterator(first);
}

//end
template<typename T>
typename List<T>::Iterator List<T>::end() {
  return Iterator(nullptr);
}

//ostreamoverload

template<typename T>
std::ostream& operator<<(std::ostream &out, List<T>& list){
 
  for(auto i : list){
    out << i << " "; 
  }

  return out;
}
  
