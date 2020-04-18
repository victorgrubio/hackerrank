#include <iostream>
#include <deque> 
using namespace std;

void printKMax(int arr[], int n, int k){
	//Write your code here.
    deque<int> mydeque;
    for (int i=0; i<n-k; i++){
        for (int j=0; j<k; j++){
            mydeque.push_back(arr[i+j]);   
        }
        for (int l=0; l< mydeque.size(); l++){
            int max; max = 0;
            if (max < mydeque.at(l)){
                max = mydeque.at(l)
            }
            cout << max << " ";
        }
        mydeque.pop_front();
    }
}

int main(){
  
	int t;
	cin >> t;
	while(t>0) {
		int n,k;
    	cin >> n >> k;
    	int i;
    	int arr[n];
    	for(i=0;i<n;i++)
      		cin >> arr[i];
    	printKMax(arr, n, k);
    	t--;
  	}



  	return 0;
}