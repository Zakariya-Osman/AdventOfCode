/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aocday4;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author osman
 */
public class MD5 {
    public static String getMd5(String input)
    {
        try {
 
            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
 
            // digest() method is called to calculate message digest
            // of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());
 
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);
 
            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
 
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static int md5Validator5(String s){
        int z = 0;
        
        
        while(true){
            String curr = getMd5(s + z);
            if(curr.startsWith("00000")){
                break;
            }
            z++;
        }
        
        return z;
        
        
    }
    public static int md5Validator6(String s){
        int z = 0;
        
        
        while(true){
            String curr = getMd5(s + z);
            if(curr.startsWith("000000")){
                break;
            }
            z++;
        }
        
        return z;
        
        
    }
    
}
