// This test program uses a test framework supporting TDD and BDD.
// You are not required to use the framework, but encouraged to.
// Code:
// https://github.com/philsquared/Catch.git
// Documentation:
// https://github.com/philsquared/Catch/blob/master/docs/tutorial.md

// You ARE however required to implement all test cases outlined here,
// even if you do it by way of your own function for each case.  You
// are recommended to solve the cases in order, and rerun all tests
// after you modify your code.

// This define lets Catch create the main test program
// (Must be in only one place!)
#define CATCH_CONFIG_MAIN
#include "catch.hpp"
#include "Sorted_List.h"
#include <iostream>
#include <string>

#include <random>

//=======================================================================
// Test cases
//=======================================================================


//Sorted_List(Sorted_List &&); 
TEST_CASE( "Test Move constructor" ) 
{
  Sorted_List l{};
  l.add(1);
  l.add(2);
  Sorted_List l2{std::move(l)};

  CHECK(l.is_empty());
  CHECK(l2.print() == "STRING: 1 2 ");
  
}

//~Sorted_List(); - Destructor
TEST_CASE( "Test Destructor" ) 
{
  Sorted_List l{};
  l.add(1);
  l.add(3);
  l.print();
  l.~Sorted_List();
  l.print();

}

//Sorted_List& operator=(const Sorted_List& other); - Copy assignment
TEST_CASE( "Test Copy operator" ) 
{
  Sorted_List l1{};
  Sorted_List l2{};

  l1.add(5);
  l1.add(81);
  l1.add(3);

  l2 = l1;

  l2.remove(3);
  l1.remove(5);


  CHECK(l2.print() == "STRING: 5 81 ");
  CHECK(l1.print() == "STRING: 3 81 ");

}

//Sorted_List& operator=(Sorted_List&& other); -Move assignment
TEST_CASE( "Test move operator" ) 
{
  Sorted_List l1{};
  Sorted_List l2{};

  l1.add(5);
  l1.add(81);
  l1.add(3);

  CHECK(l2.is_empty());

  l2 = std::move(l1);

  CHECK_FALSE(l2.is_empty());
  CHECK(l1.is_empty());
  
  CHECK(l2.print() == "STRING: 3 5 81 ");

}

// Sorted_List() = default;
TEST_CASE( "Create an empty list" ) 
{
  Sorted_List l{};
  REQUIRE(l.is_empty());
}

//Sorted_List(Sorted_List const &);
TEST_CASE("Copy constructor"){
  Sorted_List l{};
  l.add(1);
  l.add(2);
  Sorted_List l2{l};

  CHECK(l.print() == l2.print());
  l.remove(1);
  l.print();
  l2.print();

  CHECK_FALSE(l.print() == l2.print());
}

// bool is_empty();
TEST_CASE( "Test empty_list()" ) 
{
  Sorted_List l{};
  CHECK(l.is_empty());
  l.add(1);
  CHECK_FALSE(l.is_empty());
}

//void add(int number);
//std::string print();
TEST_CASE("Add to list & Print") 
{
  Sorted_List l{};

  l.add(5);
  l.add(3);
  l.add(1);
  l.add(2);
  l.add(3);
  l.add(5);
  l.add(8);
  l.add(7);
  // 1 2 3 3 5 5 7 8

  CHECK(!l.is_empty());
  CHECK(l.print() == "STRING: 1 2 3 3 5 5 7 8 ");
}

//bool remove(int number);
TEST_CASE("Remove from list & Print") {

Sorted_List l{};

  CHECK_FALSE(l.remove(2));

  l.add(5);
  l.add(3);
  l.add(1);
  l.add(2);
  l.add(3);
  l.add(5);
  l.add(8);
  l.add(7);
  // 1 2 3 3 5 5 7 8

  CHECK_FALSE(l.remove(10));
  
  l.remove(5);
  CHECK(l.print() == "STRING: 1 2 3 3 5 7 8 ");
 
  CHECK(l.remove(2));
  CHECK(l.print() == "STRING: 1 3 3 5 7 8 ");

  CHECK(l.remove(1));
  CHECK(l.print() == "STRING: 3 3 5 7 8 ");

}

TEST_CASE("Iterate and use at()"){
  Sorted_List l{};

  l.add(5);
  l.add(3);
  l.add(1);


  CHECK(l.at(2) == 5);
  l.remove(5);
  CHECK(l.at(2) == 0);

}
