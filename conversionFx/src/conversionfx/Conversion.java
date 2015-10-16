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
public interface Conversion {
    String toHex(String num); 
    String toOct(String num);
    String toBin(String num);
    String binToD(String num);
    String octToD(String num);
    String hexToD(String num);
}
