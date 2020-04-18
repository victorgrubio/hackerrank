#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


class Person {
    public:
        int age;
        string name;
        virtual void getdata() 
        { 
            cin >> this->name >> this->age;
        } 
    
        virtual void putdata() 
        { 
            cout << this->name << this->age << endl; 
        } 
};

class Professor : public Person{
    public:
        // Increases id after creation of object
        Professor() {
            this->cur_id = ++id;
        }
        int publications;
        static int id;
        int cur_id;
        virtual void getdata() 
        { 
        cin >> this->name >> this->age >> this->publications;
        } 
    
        virtual void putdata() 
        { 
            cout << this->name << " "
            << this->age << " " 
            << this->publications << " " 
            << this->cur_id << endl; 
        } 
};

// Initialization of static variable from Professor
int Professor::id = 0;

class Student : public Person {
    
    public:
        // Increases id after creation of object
        Student() {
            this->cur_id = ++id;
        }
        static int id;
        int cur_id;
        int marks[6] = {};
        virtual void getdata() 
        { 
            cin >> this->name >> this->age;
            for (int i = 0;i < 6; i++){
                cin >> marks[i];
            }  
        } 
    
        virtual void putdata() 
        { 
            int result = 0;
            for(int i = 0; i < 6; i++){
                result += this->marks[i];
            }
            cout << this->name << " " 
            << this->age << " " 
            << result << " " 
            << this->cur_id << endl; 
        } 
};
// Initialization of static variable from student
int Student::id = 0;

int main(){

    int n, val;
    cin>>n; //The number of objects that is going to be created.
    Person *per[n];

    for(int i = 0;i < n;i++){

        cin>>val;
        if(val == 1){
            // If val is 1 current object is of type Professor
            per[i] = new Professor;

        }
        else per[i] = new Student; // Else the current object is of type Student

        per[i]->getdata(); // Get the data from the user.

    }

    for(int i=0;i<n;i++)
        per[i]->putdata(); // Print the required output for each object.

    return 0;

}
