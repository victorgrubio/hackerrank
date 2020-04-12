#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */   
    int n;
    cin >> n;
    vector<int> numbers(n, 0);
    for (int i = 0; i < n; i++) {
        cin >> numbers[i];
    }
    int j=0;
    sort(numbers.begin(), numbers.end());
    while(j<numbers.size()){
        if (j != numbers.size() - 1){
            cout << numbers[j] << " ";
        }else{
            cout << numbers[j];
        }
        j++;
    }
    return 0;
}
