/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aocday7;

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

        HashMap<String, String> map = new HashMap<>();
        HashMap<String, Integer> variables = new HashMap<>();

        try {
            BufferedReader r = new BufferedReader(new FileReader("C:\\SEMFALLSEP2023-DEC2024\\OBJECTORIENTEDPROGRAMMING-3\\MISC\\AOCDAY7\\src\\aocday7\\input.txt"));
            String line = r.readLine();

            while (line != null) {
                String[] split = line.split("->");

                map.put(split[1], split[0]);
                variables.put(split[1], null);
                
                line = r.readLine();
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(AOCDAY7.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AOCDAY7.class.getName()).log(Level.SEVERE, null, ex);
        }

        String value1 = " ";
        String value2 = " ";
        String op = " ";

        int counter = 0;
        
        for (String key : map.keySet()) {
            String name = key;
            String value = map.get(key);
            String[] parts = value.split(" ");
            
            if(parts.length ==1){
                
            }
            else if(parts.length ==2){
                
            }
            else if(parts.length ==3){
                
            }
                    
            
            

            System.out.println("Name: " + name + ", Value: " + value);
            counter++;
        }
        System.out.println(counter);

    }

}
