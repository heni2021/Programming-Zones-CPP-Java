#include<iostream>
#include<vector>
#include<algorithm>
#include<unordered_map>
using namespace std;

void print_array(int arr[], int n)
{
    for (int i = 0; i < n; i++)
    {
        cout << arr[i] << " ";
    }
    cout << "\n";
}

void print_vector(vector<int> &a)
{
    for (int i = 0; i < a.size(); i++)
    {
        cout << a[i] << " ";
    }
    cout << "\n";
}

void swapElements(vector<int> &arr, int i, int j)
{
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

void reverseElementsInArray(vector<int> &arr, int startIndex, int endIndex)
{
    while (startIndex < endIndex)
    {
        swapElements(arr, startIndex++, endIndex--);
    }
}

/**
 * Brute Force
 * 1. Count Frequency of Each element in a HashMap
 * 2. Fetch the elements with frequency greater than n/3 and put them in a list
 * @timeComplexity : O(n)
 * @spaceComplexity : O(n)
 * */
vector<int> fetchElementsHavingFrequencyGreaterThanNBy3(vector<int> &a){
    unordered_map<int,int> frequencyMap;
    vector<int> result;
    for(int num : a){
        frequencyMap[num]++;
    }
    int expectedFrequency = a.size()/3;
    for(const auto& pair: frequencyMap){
        if(pair.second > expectedFrequency){
            result.push_back(pair.first);
        }
    }

    return result;
}

/**
 * Better Approach
 * Sort the array
 * Without using hashmap count the frequency and add them in list if its greater than n/3
 * @timeComplexity : O(nlogn)
 * @spaceComplexity : O(1)
 * */
vector<int> fetchElementsHavingFrequencyGreaterThanNBy3BetterApproach(vector<int> &a)
{
    sort(a.begin(), a.end());
    int count = 1;
    int n = a.size();
    int exp = n/3;
    vector<int> result;
    for(int i=0;i<a.size()-1;i++){
        if(a[i] == a[i+1]){
            count++;
        }
        else{
            if(count>exp){
                result.push_back(a[i]);
            }
            count = 1;
        }
    }
    if(count > exp){
        result.push_back(a[a.size()-1]);
    }
    return result;
}

/**
 * Optimised Approach : Moore's Algorithm
 * Find 2 potential candidates for the result. As per observation only 2 possible candidates.
 * Then iterate to the array and check for other candidates too.
 * Then get the actual count and check if it is greater than n/3 or not.
 * @timeComplexity : O(n)
 * @spaceComplexity : O(1)
 * */
vector<int> fetchElementsHavingFrequencyGreaterThanNBy3OptimisedApproach(vector<int> &a)
{
    vector<int> result;
    int count1=0, count2=0, candidate1=0, candidate2=1;
    for(int num : a){
        if(num == candidate1){
            count1++;
        }
        else if(num == candidate2){
            count2++;
        }
        else if(count1==0){
            candidate1 = num;
            count1++;
        }
        else if(count2 == 0){
            candidate2 = num;
            count2++;
        }
        else{
            count1--;
            count2--;
        }
    }

    count1=0;
    count2=0;
    for(int num : a){
        if(num == candidate1){
            count1++;
        }
        else if(num == candidate2){
            count2++;
        }
    }

    if(count1>a.size()/3){
        result.push_back(candidate1);
    }
    if(count2>a.size()/3){
        result.push_back(candidate2);
    }
    return result;
}
int main()
{
    vector<int> a = {2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6};
    vector<int> result = fetchElementsHavingFrequencyGreaterThanNBy3(a);
    cout << "Elements with highest votes are  - ";
    print_vector(result);

    vector<int> resultBetterApproach = fetchElementsHavingFrequencyGreaterThanNBy3BetterApproach(a);
    cout << "Elements with highest votes using better approach are  - ";
    print_vector(resultBetterApproach);

    vector<int> resultOptimisedApproach = fetchElementsHavingFrequencyGreaterThanNBy3OptimisedApproach(a);
    cout << "Elements with highest votes using optimised approach are  - ";
    print_vector(resultOptimisedApproach);
    return 0;
}

// 2 1 5 5 5 5 6 6 6 6 6
// 1 2 3 4 5
// 1 3
// 6 6 6 6 6 2 1 5 5 5 5