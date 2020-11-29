import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'getMinCost' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY employee_id
     *  2. INTEGER_ARRAY job_id
     */

    public static long getMinCost(List<Integer> employee_id, List<Integer> job_id) {
        long result = 0;
        int i = 0;
        int j = 0;
        while(i < (employee_id.size() - 2) || j < (job_id.size() - 2)){
            int diff1 = Math.abs(employee_id.get(i+1) - job_id.get(j));
            int diff2 = Math.abs(employee_id.get(i) - job_id.get(j+1));
            int difference = diff1 - diff2; 
            if (difference < 0){
                result += diff1;
                i++;
            }
            else{
                result += diff2;
                j++;
            }
            
        }
        return  result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int employee_idCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> employee_id = IntStream.range(0, employee_idCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int job_idCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> job_id = IntStream.range(0, job_idCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        long result = Result.getMinCost(employee_id, job_id);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
