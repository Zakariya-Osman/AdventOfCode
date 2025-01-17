/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aocday7;

/**
 *
 * @author osman
 */
public class CustomBitwizeFunctions {
    
    public static int thisIsNot(int num){
        
        String ans = Integer.toBinaryString(~num);
        if(ans.length() > 15){
            ans = ans.substring(16, ans.length());
        }
        return Integer.parseInt(ans,2);
        
    }
    
    public static int thisIsAnd(int num1, int num2){
        
        String ans = Integer.toBinaryString(num1&num2);
        if(ans.length() > 15){
            ans = ans.substring(16, ans.length());
        }
        return Integer.parseInt(ans,2);
        
    }
    
    public static int thisIsOr(int num1, int num2){
        
        String ans = Integer.toBinaryString(num1|num2);
        if(ans.length() > 15){
            ans = ans.substring(16, ans.length());
        }
        return Integer.parseInt(ans,2);
        
    }
    public static int thisIsLShift(int num, int shift){
        
        String zero = "0000000000000000";
        String numInString = Integer.toBinaryString(num);
        if(numInString.length()!=16){
            numInString = zero.substring(0,16-numInString.length()) + numInString;
        }
        numInString = numInString.substring(shift, numInString.length());
        String end = " ";
        end =  numInString + zero.substring(0,shift);
        
        return Integer.parseInt(end,2);
    }
    
    public static int thisIsRShift(int num, int shift){
        
        String zero = "0000000000000000";
        String numInString = Integer.toBinaryString(num);
        if(numInString.length()!=16){
            numInString = zero.substring(0,16-numInString.length()) + numInString;
        }
        numInString = numInString.substring(0, numInString.length()-shift );
        String end = " ";
        end =  zero.substring(0,shift) + numInString;
        
        return Integer.parseInt(end,2);
    }
    
    public static int theDoer(String op, int...values){
        switch(op){
            case "AND":
                return thisIsAnd(values[0],values[1]);
            case "OR":
                return thisIsOr(values[0],values[1]);
            case "NOT":
                return thisIsNot(values[0]);
            case "LSHIFT":
                return thisIsLShift(values[0],values[1]);
            case "RSHIFT":
                return thisIsRShift(values[0],values[1]);
            default:
                return 99999;
        }
    }
    
    
}
