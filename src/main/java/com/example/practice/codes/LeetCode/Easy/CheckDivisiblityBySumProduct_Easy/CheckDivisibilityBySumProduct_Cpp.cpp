#include <iostream>
using namespace std;
int main() {
    int n;
    cin >> n;
    int sum = 0, product = 1, temp = n;

    while (temp > 0) {
        int digit = temp % 10;
        sum += digit;
        product *= digit;
        temp /= 10;
    }

    if ( n %(sum+product) == 0) {
        cout << "Yes" << endl;
    } else {
        cout << "No" << endl;
    }

    return 0;
}