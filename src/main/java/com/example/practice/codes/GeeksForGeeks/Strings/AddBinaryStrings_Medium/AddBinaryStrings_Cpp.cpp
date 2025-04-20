#include <iostream>
#include<math.h>
using namespace std;
string appendZeros(string s, int count){
    while(count!=0){
        s.append("0");
        count--;
    }
    return s;
}

int findFirstOne(string s){
    for (int i = 0; i < s.length(); i++) {
        if(s[i] == '1'){
            return i;
        }
    }

    return -1;
}

string reverseString(string s){
    int i =0, j =s.length()-1;
    while(i<j){
        char temp = s[i];
        s[i]= s[j];
        s[j] = temp;
        i++;
        j--;
    }
    return s;
}

/**
 * Brute Force Approach:
 * n - size of string 1
 * m - size of string 2
 * Reverse both string and append 0s to the string which is shorter to make them of equal length.
 * Have one carry variable and perform computations accordingly.
 * After the loop if carry is non-zero append carry to the string;
 * Reverse the result String and return
 * This will give you TLE.
 * @timeComplexity:O(max(n,m))
 * @spaceComplexity:O(max(n,m))
 * @param s1
 * @param s2
 * @return sum
 */
string computeBinaryStringSum(string s1, string s2)
{
    string sum = "";
    int index1 = findFirstOne(s1);
    if (index1 == -1)
    {
        s1 = "0";
    }
    else
    {
        s1 = s1.substr(index1);
    }

    int index2 = findFirstOne(s2);
    if (index2 == -1)
    {
        s2 = "0";
    }
    else
    {
        s2 = s2.substr(index2);
    }
    s1 = reverseString(s1);
    s2 = reverseString(s2);
    if (s1.length() != s2.length())
    {
        int diff = s1.length() - s2.length();
        // s1 is shorter than s2
        if (diff < 0)
        {
            s1 = appendZeros(s1, abs(diff));
        }
        else
        {
            s2 = appendZeros(s2, diff);
        }
    }
    char carry = '0';
    for (int i = 0; i < s1.length(); i++)
    {
        if (s1[i] == '0' && s2[i] == '0')
        {
            if (carry == '0')
            {
                sum += "0";
            }
            else
            {
                sum += "1";
                carry = '0';
            }
        }
        else if ((s1[i] == '0' && s2[i] == '1') || (s1[i] == '1' && s2[i] == '0'))
        {
            if (carry == '0')
            {
                sum += "1";
            }
            else
            {
                sum += "0";
            }
        }
        else
        {
            if (carry == '0')
            {
                sum += "0";
                carry = '1';
            }
            else
            {
                sum += "1";
            }
        }
    }

    if (carry == '1')
    {
        sum += "1";
    }

    sum = reverseString(sum);
    return sum;
}

/**
 * Better Approach:
 * Iterate loops with two pointers pointing at the end of both string till either of them finishes.
 * perform computations till carry is zero for the longer string.
 * @timeComplexity:O(max(n,m)^2)
 * @spaceComplexity:O(n+m)
 * @param s1
 * @param s2
 * @return sum
 */
string computeBinaryStringSumWithoutReversing(string s1, string s2)
{
    string sum = "";
    int index1 = findFirstOne(s1);
    if (index1 == -1)
    {
        s1 = "0";
    }
    else
    {
        s1 = s1.substr(index1);
    }

    int index2 = findFirstOne(s2);
    if (index2 == -1)
    {
        s2 = "0";
    }
    else
    {
        s2 = s2.substr(index2);
    }

    int i = s1.length() - 1, j = s2.length() - 1;
    char carry = '0';
    while (i>=0 && j>=0)
    {
        if (s1[i] == '0' && s2[j] == '0')
        {
            if (carry == '0')
            {
                sum = "0" + sum;
            }
            else
            {
                sum = "1" + sum;
                carry = '0';
            }
        }
        else if ((s1[i] == '0' && s2[j] == '1') || (s1[i] == '1' && s2[j] == '0'))
        {
            if (carry == '0')
            {
                sum = "1" + sum;
            }
            else
            {
                sum = "0" + sum;
            }
        }
        else
        {
            if (carry == '0')
            {
                sum = "0" + sum;
                carry = '1';
            }
            else
            {
                sum = "1" + sum;
            }
        }

        j--;
        i--;
    }

    while (i >= 0)
    {
        if (carry == '1')
        {
            if (s1[i] == '1')
            {
                sum = "0" + sum;
            }
            else
            {
                sum = "1" + sum;
                carry = '0';
            }
        }
        else
        {
            sum = s1[i] + sum;
        }
        i--;
    }
    while (j >= 0)
    {
        if (carry == '1')
        {
            if (s2[j] == '1')
            {
                sum = "0" + sum;
            }
            else
            {
                sum = "1" + sum;
                carry = '0';
            }
        }
        else
        {
            sum = s2[j] + sum;
        }
        j--;
    }

    if (carry == '1')
    {
        sum = "1" + sum;
    }

    return sum;
}

int main(){
    string s1, s2;
    cin >> s1;
    cin >> s2;

    string sum = computeBinaryStringSum(s1, s2);
    cout << "Sum : " << sum << endl;

    string sumWithoutReversing = computeBinaryStringSumWithoutReversing(s1, s2);
    cout << "Sum without reversing : "  << sumWithoutReversing << endl;
    return 0;
}
// 1101 111
// 00100 0011
// 0000 11