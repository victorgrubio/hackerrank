import java.io.*;
import java.util.*;
import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

public class Solution {

    public static String createSHA256Pass(String rawPass){
        try{
            // Static getInstance method is called with MD5 hashing
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Digest() method is called to calculate message digest
            // of an input. Return array of bytes
            byte[] MessageDigest = md.digest(rawPass.getBytes(StandardCharsets.UTF_8));

            // Convert byte array into signed num representation
            BigInteger number = new BigInteger(1, MessageDigest);

            // Convert message digest into hex value  
            StringBuilder hexString = new StringBuilder(number.toString(16));  
    
            // Pad with leading zeros 
            while (hexString.length() < 64)  
            {  
                hexString.insert(0, '0');  
            }  
            return hexString.toString();  
        // For specifying wrong message digest algorithms
        }catch (NoSuchAlgorithmException e){
            throw new RuntimeException(e);
        }

    }
    public static void main(String[] args) throws NoSuchAlgorithmException{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        String rawPass = scanner.next();
        String md5Pass = createSHA256Pass(rawPass);
        System.out.println(md5Pass);
    }
}