#ifndef SORTED_LIST_H
#define SORTED_LIST_H
#include <string>

/* TODO's
*Functions that do not modify the object should be marked as const.

We believe this is fixed.

This is from Sorted_List::operator=(Sorted_List &&)
// TODO: Explain why you use []? 
        delete[] head;
        
        We removed it since it wasn't necessary. Our thought process was flawed and it worked without the brackets, 
        it was just luck that it worked with them too.
*/

/* Comment
    Avoid having pointers that are used to traverse the list
    as data members as this causes confusion and forces you to 
    consider them everytime you are traversing the list. 
    It's more suitable to create the pointers when and where 
    you need them.
*/

class Sorted_List
{
public:
    Sorted_List() = default;
    Sorted_List(Sorted_List const &);
    Sorted_List(Sorted_List &&);
    ~Sorted_List();

    Sorted_List& operator=(const Sorted_List& other);
    Sorted_List& operator=(Sorted_List&& other);


    void add(int const number);
    int at(int const number) const;
    bool is_empty() const;
    bool remove(int const number);
    std::string print();

private:
    struct Node
        {
            int value;
            Node* next;
        };

    Node* head{};
    Node* current{};
    Node* previous{};

    Node* copy(Node const * node) const;

    void findInsertPos(Node* const node);
    void removeFirst();
};

#endif