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
            BufferedReader r = new BufferedReader(new FileReader("input_1_1.txt"));
            String line = r.readLine();

            while (line != null) {
                String[] split = line.split("->");

                workSheet.put(split[1], split[0]);
                answerSheet.put(split[1], null);
                
                line = r.readLine();
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(AOCDAY7.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AOCDAY7.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        for(String key: workSheet.keySet()){
            String[] parts = workSheet.get(key).split(" ");
            
            //if its just a number add it to answerSheet
            if(isNumber(parts[0]) && parts.length == 1){
                int value = Integer.parseInt(parts[0]);
                answerSheet.put(key, value);
            }
            //if there is a number and an operation
            else if (parts.length == 2){
                String operation = parts[0];
                String value = parts[1];
                //case 1: if its a number and opertion that I can emediatly compute then add to the answersheet
                if(isNumber(value)){
                    int intValue = Integer.parseInt(value);
                    answerSheet.put(key, theDoer(operation,intValue));
                }
                //case 2: if its a letter that I need to check if I have the value to in the answersheet
                if(answerSheet.get(value) != null){
                    theDoer(operation,answerSheet.get(value));
                }
                //once i find it, then I can do the computaitons then add it to the answersheet. if I cant then move on.
            }
            //if i get 2 values and an operator
            else if (parts.length == 3){
                String operation = parts[0];
                int value1 = Integer.parseInt(parts[1]);
                int value2 = Integer.parseInt(parts[2]);
                
                //case1: if i get 2 values that are numbers then compute then add to answerSheet
                //case2: if its a letter that I need to check if I have the value to in the answersheet x2
                //once i find both, then I can do the computaitons then add it to the answersheet. if cant then move on.

            }   
                        
        }

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
