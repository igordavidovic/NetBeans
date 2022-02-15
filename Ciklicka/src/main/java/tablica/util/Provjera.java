/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablica.util;

/**
 *
 * @author Igor
 */
public class Provjera {
    public static void main(String[] args) {
        String s = "S";
        int a;
        try {
            a = Integer.parseInt(s);
            System.out.println(a);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public static int provjeraRijedka(String rijedak){
        int r;
        try {
            r = Integer.parseInt(rijedak);
        } catch (Exception e) {
            System.out.println("Greška : " + e.getMessage());
            return 0;
        }
        return r;
    }
    
    public static int provjeraStupca(String stupac){
        int s;
        try {
            s = Integer.parseInt(stupac);
        } catch (Exception e) {
            System.out.println("Greška : " + e.getMessage());
            return 0;
        }
        return s;
    }
    
    public static boolean pozitivnost(int r,int s){
        if(r < 1 || s < 1){
            return false;
        }else{
            return true;
        }     
    }
}
