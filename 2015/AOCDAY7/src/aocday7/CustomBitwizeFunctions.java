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
    
    public static int theDoer(String op, int value1, int value2){
        switch(op){
            case "AND":
                return thisIsAnd(value1,value2);
            case "OR":
                return thisIsOr(value1,value2);
            case "NOT":
                return thisIsNot(value1);
            case "LSHIFT":
                return thisIsLShift(value1,value2);
            case "RSHIFT":
                return thisIsRShift(value1,value2);
            default:
                return 99999;
        }
    }
    
    
}
