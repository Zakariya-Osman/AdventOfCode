/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class Lights {

    int x = 1000;
    int y = 1000;
    String state = "on";
    String[][] lightGrid = new String[x][y];
    int[][] darkGrid  = new int[x][y];

    public void makeGrid() {

        int w = 0;
        int q = 0;

        //all of them
        for (int i = 0; i < y; i++) {

            for (int j = 0; j < x; j++) {
                lightGrid[i][j] = w + "," + q + "," + state;
                darkGrid[i][j] = 0;
                w++;
                if (w == x) {
                    w = 0;
                }
            }
            if (q == y) {
                q = 0;
            }
            q++;
        }
    }

    public void printGrid() {
        for (int i = 0; i < y; i++) {
            String line = "";
            for (int j = 0; j < x; j++) {
                line += "[" + lightGrid[i][j] + "]";
            }
            System.out.println(line);
        }
    }

    public void turnAllOn() {
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                lightGrid[i][j] = lightGrid[i][j].replace("of", "on");
            }
        }
    }

    public void turnAllOff() {
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                lightGrid[i][j] = lightGrid[i][j].replace("on", "of");
            }
        }
    }

    public void turnOffRange(String start, String end) {
        // Parsing coordinates of start and end points
        String[] startCoords = start.split(",");
        String[] endCoords = end.split(",");
        int startX = Integer.parseInt(startCoords[0]);
        int startY = Integer.parseInt(startCoords[1]);
        int endX = Integer.parseInt(endCoords[0]);
        int endY = Integer.parseInt(endCoords[1]);

        // Adjusting coordinates to ensure startX <= endX and startY <= endY
        int minX = Math.min(startX, endX);
        int maxX = Math.max(startX, endX);
        int minY = Math.min(startY, endY);
        int maxY = Math.max(startY, endY);

        // Iterating over the specified range and turning off the lights
        for (int i = minY; i <= maxY; i++) {
            for (int j = minX; j <= maxX; j++) {
                darkGrid[i][j] = Math.max(0, darkGrid[i][j] - 1);
            }
        }
    }

    public void turnOnRange(String start, String end) {
        // Parsing coordinates of start and end points
        String[] startCoords = start.split(",");
        String[] endCoords = end.split(",");
        int startX = Integer.parseInt(startCoords[0]);
        int startY = Integer.parseInt(startCoords[1]);
        int endX = Integer.parseInt(endCoords[0]);
        int endY = Integer.parseInt(endCoords[1]);

        // Adjusting coordinates to ensure startX <= endX and startY <= endY
        int minX = Math.min(startX, endX);
        int maxX = Math.max(startX, endX);
        int minY = Math.min(startY, endY);
        int maxY = Math.max(startY, endY);

        // Iterating over the specified range and turning off the lights
        for (int i = minY; i <= maxY; i++) {
            for (int j = minX; j <= maxX; j++) {
                darkGrid[i][j]++;
            }
        }
    }

    public void toggleRange(String start, String end) {

        // Parsing coordinates of start and end points
        String[] startCoords = start.split(",");
        String[] endCoords = end.split(",");
        int startX = Integer.parseInt(startCoords[0]);
        int startY = Integer.parseInt(startCoords[1]);
        int endX = Integer.parseInt(endCoords[0]);
        int endY = Integer.parseInt(endCoords[1]);

        // Adjusting coordinates to ensure startX <= endX and startY <= endY
        int minX = Math.min(startX, endX);
        int maxX = Math.max(startX, endX);
        int minY = Math.min(startY, endY);
        int maxY = Math.max(startY, endY);

        // Iterating over the specified range and toggling the lights
        for (int i = minY; i <= maxY; i++) {
            for (int j = minX; j <= maxX; j++) {
                darkGrid[i][j] += 2;
            }
        }

        // Parsing coordinates of start and end points
//        String[] startCoords = start.split(",");
//        String[] endCoords = end.split(",");
//        int startX = Integer.parseInt(startCoords[0]);
//        int startY = Integer.parseInt(startCoords[1]);
//        int endX = Integer.parseInt(endCoords[0]);
//        int endY = Integer.parseInt(endCoords[1]);
//
//        // Adjusting coordinates to ensure startX <= endX and startY <= endY
//        int minX = Math.min(startX, endX);
//        int maxX = Math.max(startX, endX);
//        int minY = Math.min(startY, endY);
//        int maxY = Math.max(startY, endY);
//
//        // Iterating over the specified range and turning off the lights
//        for (int i = minY; i <= maxY; i++) {
//            for (int j = minX; j <= maxX; j++) {
//                if (lightGrid[i][j].contains("on")) {
//                    lightGrid[i][j] = lightGrid[i][j].replace("of", "on");
//                } else if (lightGrid[i][j].contains("of")) {
//                    lightGrid[i][j] = lightGrid[i][j].replace("on", "of");
//                }
//
//            }
//        }
    }

    public void getState() {
        for (int i = 0; i < y; i++) {
            String line = "";
            for (int j = 0; j < x; j++) {
                int length = lightGrid[i][j].length();
                line += "[" + lightGrid[i][j].substring(length - 2, length) + "]";
            }
            System.out.println(line);
        }

    }

    public void getCoordinates() {
        for (int i = 0; i < y; i++) {
            String line = "";
            for (int j = 0; j < x; j++) {
                int length = lightGrid[i][j].length();
                line += "[" + lightGrid[i][j].substring(0, length - 3) + "]";
            }
            System.out.println(line);
        }

    }

    public void count() {
        int countOn = 0;
        int countOff = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (lightGrid[i][j].contains("on")) {
                    countOn++;
                } else if (lightGrid[i][j].contains("of")) {
                    countOff++;
                }
            }
        }
        System.out.println("off: " + countOff);
        System.out.println("on: " + countOn);
    }

    public int getTotalBrightness() {
        int totalBrightness = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                totalBrightness += darkGrid[i][j];
            }
        }
        return totalBrightness;
    }

}
