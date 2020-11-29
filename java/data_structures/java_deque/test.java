import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int maxUniques = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.push(num);
            if (i >= m - 1){
                ArrayList<Integer> array = new ArrayList<Integer>();
                for (Iterator<Integer> j = deque.iterator(); j.hasNext();) {
                    int value = j.next();
                    if (array.contains(value)){
                        continue;
                    }
                    array.add(value);
                }
                int arraySize = array.size();
                if (maxUniques < arraySize){
                    maxUniques = arraySize;
                }
                deque.removeFirst();
            }
        }
        System.out.println(maxUniques);


    }
}



