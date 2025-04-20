#include <iostream>
#include <math.h>
using namespace std;
/**
 * Approach:
 * 1. Ignore all leading or trailing whitespaces.
 * 2. Set a flag for negative numbers to identify whether the string is having a valid negative number or not.
 * 3. Once numbers are encountered and after that any other char other number is found then break and return the formed number.
 * 4. To ignore leading zeros initialize the result with 0.
 * 5. As by default int follow circular patter on overflow, whenever while forming the number it becomes negative then based on the negative flag return INT_MIN or INT_MAX value.
 * @timeComplexity:O(n)
 * @spaceComplexity:O(1)
 * @param input
 * @return num
 */

int implementAtoi(string input)
{
    int num = 0;
    bool isNegative = false;
    bool isDigitStarted = false;
    for (int i = 0; i < input.length(); i++)
    {
        if (input[i] == '-' && !isNegative && !isDigitStarted)
        {
            isNegative = true;
        }
        else if (input[i] == '1')
        {
            num = num * 10 + 1;
            isDigitStarted = true;
        }
        else if (input[i] == '2')
        {
            num = num * 10 + 2;
            isDigitStarted = true;
        }
        else if (input[i] == '3')
        {
            num = num * 10 + 3;
            isDigitStarted = true;
        }
        else if (input[i] == '4')
        {
            num = num * 10 + 4;
            isDigitStarted = true;
        }
        else if (input[i] == '5')
        {
            num = num * 10 + 5;
            isDigitStarted = true;
        }
        else if (input[i] == '6')
        {
            num = num * 10 + 6;
            isDigitStarted = true;
        }
        else if (input[i] == '7')
        {
            num = num * 10 + 7;
            isDigitStarted = true;
        }
        else if (input[i] == '8')
        {
            num = num * 10 + 8;
            isDigitStarted = true;
        }
        else if (input[i] == '9')
        {
            num = num * 10 + 9;
            isDigitStarted = true;
        }
        else if (input[i] == '0')
        {
            num *= 10;
            isDigitStarted = true;
        }
        else if (input[i] != ' ')
        {
            break;
        }
        if (num < 0)
        {
            return isNegative ? INT32_MIN : INT32_MAX;
        }
    }
    return isNegative ? num * -1 : num;
}

int main(){
    string input;
    cin >> input;

    cout << "Number in string : " << implementAtoi(input) << endl;
    return 0;
}
// "   -123"
// "325-"
// "    -"
// "000345"
// " --678"
// " -748dhgfd90"