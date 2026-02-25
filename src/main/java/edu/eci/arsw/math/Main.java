/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.math;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author hcadavid
 */
public class Main {

    static int total = 1000000;
    static int partes = 5;
    static int tramo = total / partes;
    public static void main(String a[]) {
        /*System.out.println(bytesToHex(PiDigits.getDigits(0, 10)));
        System.out.println(bytesToHex(PiDigits.getDigits(1, 100)));
        System.out.println(bytesToHex(PiDigits.getDigits(1, 1000000)));*/

        LinkedList<ThreadForDigits> threadForDigits = new LinkedList<>();
        if(total%partes!=0){
            tramo+=1;
        }
        for (int x=0; x<total;x+=tramo){
            ThreadForDigits currentThread = new ThreadForDigits(x,x+tramo);
            currentThread.start();
        }
    }

    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<hexChars.length;i=i+2){
            //sb.append(hexChars[i]);
            sb.append(hexChars[i+1]);            
        }
        return sb.toString();
    }
}
