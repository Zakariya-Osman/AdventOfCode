/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aocday9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Synchro
 */
public class AOCDAY9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<String> allCities = new ArrayList<>();
        
        try {
            BufferedReader r = new BufferedReader(new FileReader("input.txt"));
            String line = r.readLine();
            HashSet<String> set = new HashSet<>();
            while (line != null) {     
                String[] l = line.split("=");
                String[] a = l[0].split(" to ");
                set.addAll(Arrays.asList(a));
                
                
                //read next line
                line = r.readLine();
            }
            System.out.println(set);
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(AOCDAY9.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AOCDAY9.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
