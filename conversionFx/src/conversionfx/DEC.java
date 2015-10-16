/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversionfx;

/**
 *
 * @author anorryce
 */
public class DEC implements Conversion{
    public int toDec(String decNum){ //converts string decNum to an int decNum
        try{
            Integer.parseInt(decNum); //tries to parse Int
        }  
        catch(NumberFormatException e) { //if the number isn't in the right format, prints this and exits.
            System.out.println("You do not have a number in the right format. Please correct this."); 
            //System.exit(1);
        }
        return Integer.parseInt(decNum); //else, if the try was successful, it parseInt as normal.
    }
    public String toHex(String decNum){ //converts String to hexadecimal String
        
        String digits = "0123456789ABCDEF"; //the digits used for hexadecimal
        int num = toDec(decNum); //calls toDec to convert to an int value.
        if (num <= 0){ //if the number is a 0 or negative.
            return "0"; 
        } 
        String hex = ""; 
        while (num > 0) {
            int digit = num % 16; //finds the remainder after dividing by 16
            hex = digits.charAt(digit) + hex; //adds the character at the remainder from dividing by 16 plus whatever the hex was previous. 
            num = num / 16; //makes the number / 16 to continue finding digits
        }
        return hex;
    }
    public String toOct(String decNum){
        int rem;
        String oct=""; 
        String digits = "01234567";
        int num = toDec(decNum);
 
        while(num>0)
        {
           rem=num%8; 
           oct = digits.charAt(rem) + oct;
           num=num/8;
        }
        return oct;
    }
    public String toBin(String decNum){
        int num = toDec(decNum);
        if (num == 0) {
           return "0";
       }
       String binary = "";
       while (num > 0) {
           int rem = num % 2;
           binary = rem + binary;
           num = num / 2;
       }
       return binary;
    }
    public String binToD(String binNum){
        int binaryNumber = Integer.parseInt(binNum);
        int decimal = 0;
        int p = 0;
        
        while(true){
            if(binaryNumber == 0){
              break;
            }
            else {
                int temp = binaryNumber%10;
                decimal += temp*Math.pow(2, p);
                binaryNumber = binaryNumber/10;
                p++;
            }
        }
        
        return Integer.toString(decimal);
    }
    public String octToD(String octNum){
        int inputNumber=Integer.parseInt(octNum);
        int remain=0;
        int count=0;
        int decimal=0;
        while(inputNumber>0){
            remain=inputNumber%10;
            decimal=(int) (decimal+remain*Math.pow(8,count));
            count++;
            inputNumber=inputNumber/10;
            }
        return Integer.toString(decimal);
    }
    public String hexToD(String hexNum){
        String digits = "0123456789ABCDEF";
        hexNum = hexNum.toUpperCase();
        int val = 0;
        for (int i = 0; i < hexNum.length(); i++) {
            char c = hexNum.charAt(i);
            int d = digits.indexOf(c);
            val = 16*val + d;
        }
        return Integer.toString(val);
    }
    
}
