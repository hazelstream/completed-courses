// Given the wishlist:
// Book, Bicycle, Laptop, Socks, Decorations and Candy

// A possible output would be (the order of the entries doesn't
// matter, here they are sorted but they don't have to be):

// What did you get? Book Bicycle
// Candy
// Decorations
// Laptop
// Socks

#include <vector>
#include <string>
#include <iostream>
#include <iterator>
#include <algorithm>

std::vector<std::string> wishlist{"Book", "Bicycle", "Laptop", "Decorations", "Candy"};
std::vector<std::string> gifts{};
std::istream istream;


int main() 
{
    std::cout << "What did you get?" << std::endl;

    std::cin >> istream;

    std::copy(std::istream_iterator<std::string>(cin), std::istream_iterator<std::string>(), std::back_inserter(gifts));




    return 0;
}

/*  
Incomplete due to time restrictions and not really figuring out how to read all of the words into the vector without using a loop.

The next part is done though.
*/