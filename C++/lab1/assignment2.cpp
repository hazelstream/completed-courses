#include <iostream>
#include <iomanip>

using namespace std;

double lower{0.0};
double higher{0.0};
double tax{0.0};
double stride{0.0};

int main()
{
    //TODO: Same here with the cin:ignore.
    //TODO: Variable declaration (1-1)
    //TODO: Too long rows (1-3)
    //TODO: Reccuring stick manipulators (4-3)
    //TODO: Errors should not be printed with cout. (1-15)
  
    // [-100.00, +100000.00]
    //Inputs
    cout << "INPUT PART" << "\n==========\nEnter first price: ";
    cin >> lower;

    while (lower <= -100.00)
    {
        cerr << "\tERROR: First price must be at least 0 SEK. Please enter a new first price: ";
        cin >> lower;
    }
    
    cout << "Enter last price : ";
    cin >> higher;
    
    while (higher >= 100000.00 || higher <= lower)
    {
        if(higher >= 100000.00) {
            cerr << "\tERROR: Last price must be less than 100000.00. \n\tPlease enter a new last price: ";
            cin >> higher;
        } else {
            cerr << "\tERROR: Last price cant be less than first price. \n\tPlease enter a new last price: ";
            cin >> higher;
        }
    }

    cout << "Enter stride     : ";
    cin >> stride;

    while (stride <= 0.00 || stride >= 100000.00)
    {
        cerr << "\tERROR: The strides must be bigger than 0 and less than 100000 \n\tPlease enter a new stride: ";
        cin >> stride;
    }

    cout << "Enter tax percent: ";
    cin >> tax;
    
    while (tax <= 0.00 || tax >= 100.00)
    {
        cerr << "\tERROR: The tax percentage must be between 0 and 100: ";
        cin >> tax;
    }
    

    //Calculations and output
    cout << "\nTAX TABLE" << "\n=========" << endl;
    //TODO: Use fillers instead of string as "\n-----...". Sizes can differ from terminal to terminal. 
    cout << setw(20) << "Price" << setw(20) << "Tax" << setw(20) << "Price with tax" << endl; 
    cout << setw(60) << setfill('-') << "-" << endl;
    cout << fixed << showpoint << setprecision(2);
    cout << setfill(' ');

    for (double i = lower; i <= higher; i=i+stride) {
        cout << setw(20) << lower << setw(20) << (lower * tax) / 100 << setw(20) << lower + (lower * tax) / 100 << endl;
        lower = lower + stride;
    }

    

    return 0;
}
