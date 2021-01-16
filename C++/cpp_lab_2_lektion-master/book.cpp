#include <string>
#include "book.h"

using namespace std;

string getAuthor(book const& book)
{
  return book.author;
}

bool operator<(book const& book1, book const& book2)
{
  if(getAuthor(book1) == getAuthor(book2))
  {
    return book1.title < book2.title;
  }
  return getAuthor(book1) < getAuthor(book2);
}