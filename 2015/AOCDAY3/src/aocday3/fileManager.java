/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aocday3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author osman
 */
public class fileManager {
    
    public static void AddChecker(List list, House house){
        
        if(list.contains(house)){
            house.addStops();
            list.remove(house);
        }   
    }
    
    public static void LoadFile(String path){
        try {
            BufferedReader r = new BufferedReader(new FileReader(path));
            //loop var
            int x =0;
            int y =0;
            
            int a = 0, b =0, alt = 0;
           
            
            int s = 0;
            int i = 0;
            int counter = 0;

            ArrayList<String> HouseList = new ArrayList<>();
            ArrayList<String> HouseList2 = new ArrayList<>();
            //f hosue
            HouseList.add(x + "," + y);
            int data;
            while ((data = r.read()) != -1){
                //System.out.println((char) data);
                if(alt%2 == 0){
                    if((char) data == '^'){
                        y+=1;
                    }
                    else if((char) data == 'v'){
                        y-=1;
                    }
                    else if((char) data == '<'){
                        x-=1;
                    }
                    else if((char) data == '>'){
                        x+=1;
                    }
                    String currentHouse = x + "," + y;

                    if(!HouseList2.contains(currentHouse) && !HouseList.contains(currentHouse)){
                        HouseList.add(currentHouse);
                    }
                }
                else{
                    if((char) data == '^'){
                        b+=1;
                    }
                    else if((char) data == 'v'){
                        b-=1;
                    }
                    else if((char) data == '<'){
                        a-=1;
                    }
                    else if((char) data == '>'){
                        a+=1;
                    }
                    String currentHouse2 = a + "," + b;

                    if(!HouseList2.contains(currentHouse2) && !HouseList.contains(currentHouse2)){
                        HouseList2.add(currentHouse2);
                    }
                }
                alt++;
                
            }
            r.close();

            System.out.println(HouseList.size());
            System.out.println(HouseList2.size());
            System.out.println(HouseList.size() + HouseList2.size());
                        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(fileManager.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(fileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
