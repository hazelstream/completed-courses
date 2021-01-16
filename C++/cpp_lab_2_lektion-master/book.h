#ifndef BOOK_H //Headerguard
#define BOOK_H

#include <string>

struct book
{
  std::string author;
  std::string title;
  int pages;
  int year;
};

std::string getAuthor(book const& book);
bool operator<(book const& book1, book const& book2);

#endif