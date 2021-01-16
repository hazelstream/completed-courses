#define CATCH_CONFIG_MAIN
#include "catch.hpp"
#include "book.h"

//Testcommit

TEST_CASE("Create book")
{
  book book{};
  REQUIRE(book.author == "");
  REQUIRE(book.title == "");
  REQUIRE(book.year == 0);
  REQUIRE(book.pages == 0);
}

TEST_CASE("Check authors")
{
  book book{};
  book.author = "JK Rowling";
  CHECK(book.author == "JK Rowling");
  CHECK(getAuthor(book) == "JK Rowling");
}

TEST_CASE("Compare authors")
{
  book book1{"Lippman", "C++ primer", 2012, 1000};
  book book2{"Stroustrup", "A tour of C++", 2013, 1000};
  
  CHECK(book1 < book2);

}