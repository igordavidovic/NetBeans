/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablica.util;

import tablica.DonjiDesniKut;
import tablica.DonjiLijeviKut;
import tablica.GornjiDesniKut;
import tablica.GornjiLijeviKut;

/**
 *
 * @author Igor
 */
public class Provjera {
    
    public static int provjera(String unos){
        int broj;
        try {
            broj = Integer.parseInt(unos);
        } catch (Exception e) {
            return 0;
        }
        return broj;
    }
    
    public static boolean pozitivnost(int r,int s,int p){
        if(r < 1 || s < 1 || (p < 1 || p > 4)){
            return false;
        }else{
            return true;
        }     
    }
    
    public static Object[][] odabir(int r,int s,int p){
        Object[][] objekti;
        if(p == 1){
           objekti = DonjiDesniKut.smjer(r, s);
        }else if(p == 2){
            objekti = DonjiLijeviKut.smjer(r, s);
        }else if(p == 3){
            objekti = GornjiLijeviKut.smjer(r, s);
        }else{
            objekti = GornjiDesniKut.smjer(r, s);
        }
        return objekti;
    }
}
