/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aocday3;

/**
 *
 * @author osman
 */
public class House implements Comparable<House>{
    
    private int x;
    private int y;
    private int stops;

    public House() {
    }

    public House(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    
    public House(int x, int y, int stops) {
        this.stops = stops;
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setStops(int stops) {
        this.stops = stops;
    }
    public void addStops() {
        this.stops++;
    }

    public int getStops() {
        return stops;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    

    public void printCoordinates(){
        System.out.println("x: " + this.getX() + ", y: " + this.getY() + ", Stops: " + this.getStops());
              
    }
    public int getCoordinates(){
        return this.x * 1000 + this.y;
    }

    @Override
    public int compareTo(House o) {
        int result = Integer.compare(this.x, o.x);
        
        if (result == 0) {
            result = Integer.compare(this.y, o.y);
        }
        
        return result;
    }
    
    
    
    
    
}
