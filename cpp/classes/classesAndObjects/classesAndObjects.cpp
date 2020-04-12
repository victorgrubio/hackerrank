#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <cassert>
using namespace std;

// Write your Student class here
class Student{
    private:
        int scores[5];
    public:
        int calculateTotalScore(){
            int arraySize = (sizeof(scores)/sizeof(*scores));
            int sum = 0;
            for(int i=0; i<arraySize; i++){
                sum += scores[i];
            }
            return sum;
        }
        void input(){
            int sc = 0; //scanned items
            int n = 5; // no of integers to be scanned from the single line in stdin
            int i = 0;
            while( sc<n )
            {
                sc += scanf("%d",&scores[i++]);
            }
        }

};

int main() {
    int n; // number of students
    cin >> n;
    Student *s = new Student[n]; // an array of n students
    
    for(int i = 0; i < n; i++){
        s[i].input();
    }

    // calculate kristen's score
    int kristen_score = s[0].calculateTotalScore();

    // determine how many students scored higher than kristen
    int count = 0; 
    for(int i = 1; i < n; i++){
        int total = s[i].calculateTotalScore();
        if(total > kristen_score){
            count++;
        }
    }

    // print result
    cout << count;
    
    return 0;
}
