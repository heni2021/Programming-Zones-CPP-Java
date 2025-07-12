#include <iostream>
#include <vector>
using namespace std;
vector<string> createFizzBuzzArray(int n){
    vector<string> result;
    for (int i = 1; i <= n; i++)
    {
        if (i % 3 == 0 && i % 5 == 0)
        {
            result.push_back("FizzBuzz");
        }
        else if (i % 5 == 0)
        {
            result.push_back("Buzz");
        }
        else if (i % 3 == 0)
        {
            result.push_back("Fizz");
        }
        else
        {
            result.push_back(to_string(i));
        }
    }
    return result;
}

void print_Vector_string_Array(vector<string> result){
    for (int i = 0; i < result.size(); i++)
    {
       cout << result[i] << " ";
    }
    cout << endl;
}

int  main()
{
    int n;
    cin >> n;

    vector<string> result = createFizzBuzzArray(n);
    print_Vector_string_Array(result);
     return 0;
}