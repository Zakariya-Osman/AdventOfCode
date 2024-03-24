/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aocday4;

import static aocday4.MD5.getMd5;
import static aocday4.MD5.md5Validator5;
import static aocday4.MD5.md5Validator6;

/**
 *
 * @author osman
 */
public class AOCDAY4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //String lol = getMd5("abcdef609043");
        int num = md5Validator5("yzbqklnj");
        int num2 = md5Validator6("yzbqklnj");
        System.out.println("num1 " + num);
        System.out.println("num2 " + num2);
        // TODO code application logic here
    }
    
}
