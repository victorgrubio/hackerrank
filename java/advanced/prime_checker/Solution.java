import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.reflect.*;

import static java.lang.System.in;

class Prime{
    private boolean isPrime(int number){
        if(number <= 3){
            return number > 1;
        }
        else if (number % 2 == 0 || number % 3 == 0 ){
            return false;
        }
        int i = 5;

        while (i*i <= number){
            if (number % i == 0 || number % (i + 2) == 0){
                return  false;
            }
            i += 6;
        }
        return true;
    }
    public void checkPrime(int... primeList){
        
        for(int i=0; i<primeList.length; i++){
            if(isPrime(primeList[i])){
                System.out.printf("%d ", primeList[i]);
            }
        }
        System.out.println("");
    }
}
public class Solution {

	public static void main(String[] args) {
		try{
		BufferedReader br=new BufferedReader(new InputStreamReader(in));
		int n1=Integer.parseInt(br.readLine());
		int n2=Integer.parseInt(br.readLine());
		int n3=Integer.parseInt(br.readLine());
		int n4=Integer.parseInt(br.readLine());
		int n5=Integer.parseInt(br.readLine());
		Prime ob=new Prime();
		ob.checkPrime(n1);
		ob.checkPrime(n1,n2);
		ob.checkPrime(n1,n2,n3);
		ob.checkPrime(n1,n2,n3,n4,n5);	
		Method[] methods=Prime.class.getDeclaredMethods();
		Set<String> set=new HashSet<>();
		boolean overload=false;
		for(int i=0;i<methods.length;i++)
		{
			if(set.contains(methods[i].getName()))
			{
				overload=true;
				break;
			}
			set.add(methods[i].getName());
			
		}
		if(overload)
		{
			throw new Exception("Overloading not allowed");
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
}

