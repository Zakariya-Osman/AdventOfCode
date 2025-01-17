/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aocday7;

import static aocday7.CustomBitwizeFunctions.theDoer;
import static aocday7.CustomBitwizeFunctions.thisIsAnd;
import static aocday7.CustomBitwizeFunctions.thisIsLShift;
import static aocday7.CustomBitwizeFunctions.thisIsNot;
import static aocday7.CustomBitwizeFunctions.thisIsOr;
import static aocday7.CustomBitwizeFunctions.thisIsRShift;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author osman
 */
public class AOCDAY7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        HashMap<String, String> workSheet = new HashMap<>();
        HashMap<String, Integer> answerSheet = new HashMap<>();

        try {
            BufferedReader r = new BufferedReader(new FileReader("input.txt"));
            String line = r.readLine();

            while (line != null) {
                String[] split = line.split("->");

                workSheet.put(split[1].trim(), split[0].trim());
                answerSheet.put(split[1].trim(), null);
                
                line = r.readLine();
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(AOCDAY7.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AOCDAY7.class.getName()).log(Level.SEVERE, null, ex);
        }
        answerSheet.put("b", 46065);
        for (String key: workSheet.keySet()) {
            computeValue(key,workSheet,answerSheet);
        }
        
        System.out.println("Computed Wires: " + answerSheet);
        System.out.println(answerSheet.get("a"));
    }

    private static void computeValue(String key, HashMap<String, String> workSheet, HashMap<String, Integer> answerSheet) {
        if (answerSheet.get(key)!=null){
            return;
        }
        
        String[] parts = workSheet.get(key).split(" ");
        int result = 0;
        
        //if its stright up
        if (parts.length == 1){
            if (isNumber(parts[0])){
                result = Integer.parseInt(parts[0]);
            }
            else{
                if(answerSheet.get(parts[0])==null){
                    computeValue(parts[0],workSheet,answerSheet);
                }
                result = answerSheet.get(parts[0]);
            }
        }
        
        //if it has an operation and a singular value
        else if (parts.length == 2){
            if(answerSheet.get(parts[1])== null){
                computeValue(parts[1],workSheet,answerSheet);
            }
            result = theDoer(parts[0],answerSheet.get(parts[1]));
        }
        
        //if there are two values and an operator
        else if (parts.length == 3){
            int left,right =0;
            if(isNumber(parts[0])){
                left = Integer.parseInt(parts[0]);
            }
            else{
                if(answerSheet.get(parts[0])==null){
                    computeValue(parts[0],workSheet,answerSheet);
                }
                left = answerSheet.get(parts[0]);
                
            }
            
            
            if(isNumber(parts[2])){
                right = Integer.parseInt(parts[2]);
            }
            else{
                if(answerSheet.get(parts[2])==null){
                    computeValue(parts[2],workSheet,answerSheet);
                }
                right = answerSheet.get(parts[2]);
            }
            result = theDoer(parts[1],left,right);
            
        }
        answerSheet.put(key, result);
    }
    
    private static boolean isNumber(String str) {
        if (str == null || str.isEmpty()) {
        return false; // Null or empty strings are not numbers
        }
        try {
            Integer.parseInt(str); // Try to parse the string as an integer
            return true; // If successful, it's a number
        } catch (NumberFormatException e) {
            return false; // If parsing fails, it's not a number
        }
    }

}
