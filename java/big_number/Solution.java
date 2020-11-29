import java.math.BigDecimal;
import java.util.*;
class Solution{

    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
      	sc.close();

        //Write your code here
        Arrays.sort(s, Collections.reverseOrder(new Comparator<String>() {
            @Override
            public int compare(String a1, String a2){
                if(a1 == null || a2 == null){
                    return 0;
                }
                BigDecimal a11 = new BigDecimal(a1);
                BigDecimal a22 = new BigDecimal(a2);
                return a11.compareTo(a22);
            }
        }));

        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }

}