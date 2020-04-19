import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import org.graalvm.compiler.lir.gen.ArithmeticLIRGenerator;

import jdk.vm.ci.meta.Local;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
        try{
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int result = x / y;
            System.out.printf("%d", result);
        } catch (InputMismatchException e) {
            System.out.println("java.util.InputMismatchException");
        } catch (ArithmeticException e){
            System.out.println("java.lang.ArithmeticException: / by zero");
        }
        
    }
}