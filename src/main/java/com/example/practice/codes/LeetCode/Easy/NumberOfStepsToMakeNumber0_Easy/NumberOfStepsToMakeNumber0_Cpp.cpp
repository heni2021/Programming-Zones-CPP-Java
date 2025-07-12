// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/description/
#include <iostream>
using namespace std;
/**
 * @timeComplexity : O(n)
 * @spaceComplexity : O(1)
 */
int computeNumberOfSteps(int n)
{
    int count = 0;
    while (n != 0)
    {
        if (n % 2 == 0)
        {
            n /= 2;
        }
        else
        {
            n -= 1;
        }
        count++;
    }
    return count;
}
int main(){
    int n;
    cin >> n;

    int steps = computeNumberOfSteps(n);
    cout << "Number of steps required - " << steps << endl;
     return 0;
}