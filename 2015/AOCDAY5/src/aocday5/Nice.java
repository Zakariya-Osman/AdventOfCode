/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aocday5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author osman
 */
public class Nice {

    public static boolean pairNoOverlaps(String word) {

        for (int i = 0; i < word.length() - 1; i++) {

            String pair = word.substring(i, i + 2);

            for (int j = i + 2; j < word.length() - 1; j++) {

                String pair2 = word.substring(j, j + 2);

                if (pair.equals(pair2)) {
                    return true;
                }
            }
        }
        return false;

    }

    public static boolean betweenRepeat(String word) {

        for (int i = 0; i < word.length()-2; i++) {
            char letter = Character.toLowerCase(word.charAt(i));
            char letter2 = Character.toLowerCase(word.charAt(i+2));

            if (letter2 == letter) {
                return true;
            }
        }
        return false;
    }

    public static void niceChecker(String path) {

        int counter = 0;

        try {
            BufferedReader r = new BufferedReader(new FileReader(path));
            String line = r.readLine();

            while (line != null) {
                if (pairNoOverlaps(line) && betweenRepeat(line)) {
                    counter++;
                }
                line = r.readLine();
            }

            System.out.println(counter++);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Naughty.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Naughty.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
