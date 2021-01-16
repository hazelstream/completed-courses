#include "Sorted_List.h"
#include <stdexcept>
#include <iostream>
#include <string>

using namespace std;

//Move constructor
Sorted_List::Sorted_List(Sorted_List && other) 
    : head(nullptr)
{
    head = other.head;
    other.head = nullptr;
}

//Move assignment operator
Sorted_List& Sorted_List::operator=(Sorted_List&& other){
    if(this != &other){
        delete head;

        head = other.head;
        other.head = nullptr;
    }
    return *this;
}

//Copy constructor
Sorted_List::Sorted_List(Sorted_List const& other) 
{
    Node* current = nullptr;
    Node* nextnode = nullptr;

    if(other.head == nullptr){
        head = nullptr;
    }
    else {
        head = new Node;
        head->value = other.head->value;

        current = head;
        nextnode = other.head->next;
    }

// Comment: Great condition!
    while(nextnode){
// Comment: current->next = new Node{nextnode->value, nextnode->next};
        current->next = new Node;
        current = current->next;
        current->value = nextnode->value;
    
        nextnode = nextnode->next;
    }
current->next = nullptr;
}

// Assignment operator
Sorted_List& Sorted_List::operator=(Sorted_List const &other)
{
    Node * copy = nullptr;
    Node * temp = nullptr;
    //check for self-copy
    if(&other == this)
    {
        return *this;
    }
    
    if(other.head == nullptr)
    {
        head = nullptr;
        return *this;
    }
    else
    { 
        head = new Node;
        head->value = other.head->value;

        copy = head;
        temp = other.head -> next;
        }

        while (temp) 
        {
            copy->next = new Node;
            copy = copy->next;
            copy->value = temp->value;
            
            temp = temp->next;
        }
        copy->next = nullptr;

    return *this;
};

//Destructor. Iterates until the list is empty.
Sorted_List::~Sorted_List()
{
    while (!is_empty())
    {
        removeFirst();
    }
}

//Adds an element in the listed, sorted in ascending order.
void Sorted_List::add(int number){

    Node* tempNode = new Node{number, nullptr};

    //Tom lista
    if(is_empty()){
        head = tempNode;
    }
    else {
        
        current = head;
        previous = nullptr;

        //Körs tills den hittar en plats där current är större
        //än den nya noden.
        findInsertPos(tempNode);

        //Först
        if(current == head){
            tempNode->next = head;
            head = tempNode;
        }
        //Inte först
        else {
            tempNode->next = current;
            previous->next = tempNode;
        }

        //Resettar värdena inför nästa add
        current = head;
        previous = nullptr;
        
    }
}

void Sorted_List::findInsertPos(Node* node){
    if(current != nullptr){
        //Stannar när current->value är större än temp->value.
        //Sätter previous och current för att senare kunna stoppa in temp.
        if(node->value > current->value){
            previous = current;
            current = current->next;
            findInsertPos(node);
        }else{
            return;
        }
    }
}

std::string Sorted_List::print(){
    current = head;
    std::string listOfValues = "STRING: ";
    if(is_empty()){
        return "STRING: ";
    } else {
        while (current != nullptr) {
            //cout << current->value;
            listOfValues = listOfValues + to_string(current->value) + " ";
            current = current->next;
        }
        //cout << endl;
    }
    return listOfValues;
}


//Returns true if the list has no elements.
bool Sorted_List::is_empty() const
{
    return head == nullptr;
}



//Removes a specific number in the list
bool Sorted_List::remove(int number)
{   
    if(head == nullptr){
        return false;
    }
    Node* currentNode = head;
    Node* previousNode = head;
    
    if(currentNode->value == number) {
        previousNode = previousNode->next;
        head = previousNode;
        delete currentNode;
        return true;
    }

    while(currentNode != nullptr && currentNode->value != number) {
        if (currentNode == head) {
            currentNode = currentNode->next;
        } else {
            currentNode = currentNode->next;
            previousNode = previousNode->next;
        }
    }
    

    if (currentNode != nullptr) {
        previousNode->next = currentNode->next;
        delete currentNode;
        return true;
    } else {
        //cout << "The number to be removed is not in the list" << endl;
    
        return false;
    }
    return false;
}


//Used to destruct the entire list when destructor is called. 
//Removes the first element and removes the allocated space.
void Sorted_List::removeFirst()
{
    if(is_empty())
    {
        return;
    }

    Node* temp = head;
    head = head->next;
    temp->next = nullptr;
    delete temp;
}

int Sorted_List::at(int const number) const {

    if(is_empty()){
        return 0;
    }
    Node* temp = head;
    for(int i = 0; i < number; i++){
        if(temp->next == nullptr){
            return 0;
        }
        temp = temp->next;
    }
    return temp->value;
}
