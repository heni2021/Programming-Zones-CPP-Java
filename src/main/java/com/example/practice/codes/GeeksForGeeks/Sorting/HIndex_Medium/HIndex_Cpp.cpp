#include <iostream>
#include <math.h>
#include <vector>
using namespace std;

int computeHIndex(vector<int> &citations){
    int maxNumber = 0;
    // Find maximum number
    for (int i = 0; i < citations.size(); i++)
    {
        maxNumber = max(maxNumber, citations[i]);
    }

    // Fill the frequency array
    int frequency[maxNumber + 1];
    for (int i = 0; i < maxNumber+1; i++)
    {
        frequency[i] = 0;
    }
    
    for (int i = 0; i < citations.size(); i++)
    {
        frequency[citations[i]]++;
    }

    // Compute H-Index.
    int currentSum = 0;
    for (int i = maxNumber; i >= 0; i--)
    {
        currentSum += frequency[i];
        if (currentSum >= i)
        {
            return i;
        }
    }
    return 0;
}

int main(){
    vector<int> citations = {5,1,2,4,1};

    int hIndex = computeHIndex(citations);
    cout << "Computed HIndex : "<< hIndex << endl;
    return 0;
}
// 3 0 5 3 0
// 5 1 2 4 1
// 0 0