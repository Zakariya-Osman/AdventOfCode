/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aocday8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Synchro
 */
public class AOCDAY8P2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String bigLine = "";
        int charCounter = 0;
        int charMemoryCounter = 0;
        
        try {
            BufferedReader r = new BufferedReader(new FileReader("input.txt"));
            String line = r.readLine();
            while (line != null) {     
                
                //store length of the total counters
                charCounter += line.length();

                //make necessary changes
                bigLine = line.replace("\\","\\\\");
                bigLine = "\"" + bigLine.replace("\"","\\\"") + "\"";
                

                //read next line
                line = r.readLine();
                
                //add to total memory charcount
                charMemoryCounter += bigLine.length();                
             
            }
                        
            System.out.println("Charcter Coutner: " + charCounter);
            System.out.println("Charcter Memory Coutner: " + charMemoryCounter);
            //just being lazy, I should have just swapped the variables
            System.out.println("Answer: " + ((charCounter - charMemoryCounter) * -1));

        } catch (FileNotFoundException ex) {
            Logger.getLogger(AOCDAY8P2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AOCDAY8P2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
