/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aocday6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author osman
 */
public class AOCDAY6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Lights light1 = new Lights();
        light1.makeGrid();
        light1.turnAllOff();
        //--------------------------------------------------

//        light1.printGrid();
//
//        //change
//        System.out.println("-------------------------");
//
//        //light1.turnOnRange("1,1", "1,2");
//        //light1.turnOnRange("3,0", "4,0");
//        //light1.turnOnRange("2,0", "3,1");
//        light1.toggleRange("2,0", "3,3");
//        //light1.toggleRange("0,0", "9,0");
//        light1.printGrid();
//
//        light1.count();
        try {
            BufferedReader r = new BufferedReader(new FileReader("C:\\SEMFALLSEP2023-DEC2024\\OBJECTORIENTEDPROGRAMMING-3\\MISC\\AOCDAY6\\src\\aocday6\\message.txt"));
            String line = r.readLine();
            int var = 0;

            while (line != null) {
                String[] split = line.split(" ");

                String start = split[split.length - 3];
                String end = split[split.length - 1];
                System.out.println(start + " - " + end);
                System.out.println("this is the line: " + line);

                if (line.contains(" on")) {
                    light1.turnOnRange(start, end);
                    //var++;
                } else if (line.contains(" off")) {
                    light1.turnOffRange(start, end);
                    //var++;
                } else if (line.contains("toggle")) {
                    light1.toggleRange(start, end);
                    //var++;
                }
                line = r.readLine();
                var++;
            }
            light1.count();
            System.out.println("lines: " + var);
            int totalBrightness = light1.getTotalBrightness();
            System.out.println("Total brightness: " + totalBrightness);
            //light1.printGrid();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(AOCDAY6.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AOCDAY6.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
