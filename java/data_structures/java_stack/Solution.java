import java.util.*;

class Solution {

    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();
            // Complete the code
            Stack<Character> stack = new Stack<Character>();
            boolean error = false;
            for (int i = 0; i < input.length(); i++) {
                char currentChar = input.charAt(i);
                if(currentChar == '}'){
                    if (stack.empty() || stack.pop() != '{') {
                        error = true;
                        break;
                } }else if(currentChar == ')'){
                    if (stack.empty() || stack.pop() != '(') {
                        error = true;
                        break;
                } }else if(currentChar == ']'){
                    if (stack.empty() || stack.pop() != '[') {
                        error = true;
                        break;
                } }else {
                    stack.add(currentChar);
                }
            }
            System.out.printf("%b\n", !error && stack.empty());
        }
    }

}
