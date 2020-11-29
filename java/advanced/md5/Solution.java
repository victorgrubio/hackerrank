import java.io.*;
import java.util.*;
import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 

public class Solution {

    public static String createMD5Pass(String rawPass){
        String cryptoPass = "";
        try{
            // Static getInstance method is called with MD5 hashing
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Digest() method is called to calculate message digest
            // of an input. Return array of bytes
            byte[] MessageDigest = md.digest(rawPass.getBytes());

            // Convert byte array into signed num representation
            BigInteger number = new BigInteger(1, MessageDigest);

            // COnvert message digest into hex value
            cryptoPass = number.toString(16);
            while (cryptoPass.length() < 32){
                cryptoPass = "0" + cryptoPass;
            }
            return cryptoPass;

        // For specifying wrong message digest algorithms
        }catch (NoSuchAlgorithmException e){
            throw new RuntimeException(e);
        }

    }
    public static void main(String[] args) throws NoSuchAlgorithmException{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        String rawPass = scanner.next();
        String md5Pass = createMD5Pass(rawPass);
        System.out.println(md5Pass);
    }
}