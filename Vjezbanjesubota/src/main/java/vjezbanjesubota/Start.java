/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vjezbanjesubota;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import vjezbanjesubota.model.Djelatnik;
import vjezbanjesubota.model.Kupac;
import vjezbanjesubota.model.Osoba;
import vjezbanjesubota.view.Vjezba;

/**
 *
 * @author Igor
 */
public class Start {

    public Start() {
        /*List<Integer> brojevi = new ArrayList<>();
        brojevi.add(0);
        brojevi.add(5);
        brojevi.add(4);
        int a = najmanjiBroj(brojevi);
        System.out.println(a);*/
        //new Vjezba().setVisible(true);
        osobe();
    }
    private static void osobe(){
        List<Osoba> osobe = new ArrayList<>();
        Kupac kupac = new Kupac();
        kupac.setIme("Igor");
        kupac.setPrezime("Davidović");
        kupac.setOib("12345678901");
        kupac.setEmail("id@gmail.com");
        osobe.add(kupac);
        Djelatnik djelatnik = new Djelatnik();
        djelatnik.setIme("Pero");
        djelatnik.setPrezime("Perič");
        djelatnik.setEmail("pp@gmail.com");
        djelatnik.setPlaca(new BigDecimal(5000));
        osobe.add(djelatnik);
        for(Osoba o : osobe){
            o.ispisPodataka();
        }
    }
    public static void main(String[] args) {
        new Start();
    }

    private int najmanjiBroj(List<Integer> b) {
        int min = Integer.MAX_VALUE;
        for (int i : b) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }
}
