#include <iostream>
#include <deque> 
using namespace std;

int max(deque<int> myDeque){
    
    int maximo = myDeque[0];
    for (int i=0; i<myDeque.size(); i++){
        if(maximo<myDeque[i]){
            maximo = myDeque[i];
        }
    }
    return maximo;
}

void printKMax(int arr[], int n, int k){
    deque<int> myDeque;
    int maxActual;
    // First part, before getting to the k limit
    for (int i=0; i < k; i++){
        myDeque.push_back(arr[i]);        
    }
    maxActual=max(myDeque);
    cout << maxActual<< " ";
    // When we have already introduced k elements
    for(int i=0; i<n-k; i++){
        // if max not in front and current max over last element
        if(maxActual!= myDeque.front() && maxActual > arr[i+k]){
            cout << maxActual << " "; // print max
            myDeque.pop_front(); // pops front
            myDeque.push_back(arr[i+k]); // pushback last element
        }
        // if max not in front and current max less than last element
        else if(maxActual!= myDeque.front() && maxActual < arr[i+k]){
            // max = last element
            maxActual = arr[i+k];
            cout << maxActual << " ";
            // pops front
            myDeque.pop_front();
            // push back last element
            myDeque.push_back(arr[i+k]);
        }
        // max in front
        else{
            // removes front
            myDeque.pop_front();
            // includes last element
            myDeque.push_back(arr[i+k]);
            // calculate max
            maxActual =  max(myDeque);
            cout << maxActual << " ";
        }
    }
    cout << endl;
}

int main(){
	int t;
	cin >> t;
	while(t>0) {
		int n,k;
    	cin >> n >> k;
    	int i;
        int x;
    	int arr[n];
    	for(i=0;i<n;i++)
      		cin >> arr[i];
    	printKMax(arr, n, k);
    	t--;
  	}
  	return 0;
}