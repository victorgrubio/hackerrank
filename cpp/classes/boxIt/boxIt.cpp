#include<bits/stdc++.h>

using namespace std;
//Implement the class Box  
//l,b,h are integers representing the dimensions of the box

// The class should have the following functions : 

// Constructors: 
// Box();
// Box(int,int,int);
// Box(Box);

// int getLength(); // Return box's length
// int getBreadth (); // Return box's breadth
// int getHeight ();  //Return box's height
// long long CalculateVolume(); // Return the volume of the box

//Overload operator < as specified
//bool operator<(Box& b)

//Overload operator << as specified
//ostream& operator<<(ostream& out, Box& B)

class Box{
    private:
        int length, height, breadth;
    public:
        // Constructor with no parameters 
        Box () 
        { 
            length = 0;
            breadth = 0;
            height = 0;
        } 

        // constructor with 3 parameters
        Box(int l, int b, int h){
            length = l;
            breadth = b;
            height = h;
        }
        
        // Constructor with box object 
        Box(Box &box) 
        { 
            length = box.getLength();
            breadth = box.getBreadth();
            height = box.getHeight(); 
        } 

        // operators
        bool operator<(Box& b){
            if(length < b.getLength()){
                return true;
            } else if ( breadth < b.getBreadth() && length == b.getLength()){
                return true;
            } else if ( height < b.getHeight() && length == b.getLength() && breadth == b.getBreadth() ){
                return true;
            }
            return false;
        };

        // getters
        int getLength(){
            return length;
        };
        int getBreadth(){
            return breadth;
        };
        int getHeight(){
            return height;
        };

        // calculate volume
        long CalculateVolume(){
            return (long long)(breadth) * length * height;
        };

        friend ostream& operator<<(ostream &out, const Box &B);

};
        ostream &operator<<(ostream& out, Box & B){
            int length = B.getLength();
            int breadth = B.getBreadth();
            int height = B.getHeight();
            out << length << " " << breadth << " " << height;
            return out;
        };
        



void check2()
{
	int n;
	cin>>n;
	Box temp;
	for(int i=0;i<n;i++)
	{
		int type;
		cin>>type;
		if(type ==1)
		{
			cout<<temp<<endl;
		}
		if(type == 2)
		{
			int l,b,h;
			cin>>l>>b>>h;
			Box NewBox(l,b,h);
			temp=NewBox;
			cout<<temp<<endl;
		}
		if(type==3)
		{
			int l,b,h;
			cin>>l>>b>>h;
			Box NewBox(l,b,h);
			if(NewBox<temp)
			{
				cout<<"Lesser\n";
			}
			else
			{
				cout<<"Greater\n";
			}
		}
		if(type==4)
		{
			cout<<temp.CalculateVolume()<<endl;
		}
		if(type==5)
		{
			Box NewBox(temp);
			cout<<NewBox<<endl;
		}

	}
}

int main()
{
	check2();
}