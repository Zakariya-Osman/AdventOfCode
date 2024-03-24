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
public class Naughty {

    public static boolean vowelChecker(String word) {
        ArrayList<Character> vowels = new ArrayList<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int counter = 0;

        for (int i = 0; i < word.length(); i++) {
            char letter = Character.toLowerCase(word.charAt(i));
            if (vowels.contains(letter)) {
                counter++;
            }
        }

        return counter >= 3;

    }

    public static boolean reprowChecker(String word) {

        int counter = 0;
        char lastChar = ' ';

        for (int i = 0; i < word.length(); i++) {
            char letter = Character.toLowerCase(word.charAt(i));

            if (lastChar == letter) {
                counter++;
                break;
            }
            lastChar = letter;
        }

        return counter > 0;
    }

    public static boolean badLettersChecker(String word) {
        ArrayList<String> badWords = new ArrayList<>();
        badWords.add("ab");
        badWords.add("cd");
        badWords.add("pq");
        badWords.add("xy");

        int counter = 0;

        for (String i : badWords) {
            if (word.contains(i)) {
                counter++;
            }
        }

        return counter == 0;
    }

    public static void naughtyChecker(String path) {

        int counter = 0;

        try {
            BufferedReader r = new BufferedReader(new FileReader(path));
            String line = r.readLine();

            while (line != null) {
                if (badLettersChecker(line) && reprowChecker(line) && vowelChecker(line)) {
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
