/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vjezbanje.util;

import com.github.javafaker.Faker;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import vjezbanje.controller.ObradaSmjer;
import vjezbanje.model.Smjer;


/**
 *
 * @author Igor
 */
public class Test {
    
    public static void main(String[] args) {
        double n = 1240.35;

        NumberFormat nf = NumberFormat.getInstance(new Locale("hr", "HR"));
        String val = nf.format(n);

        System.out.println(val);
    }
    private void testSmjer(){
        Smjer s = new Smjer();
        s.setNaziv("Java Programiranje");
        s.setTrajanje(130);
        ObradaSmjer os = new ObradaSmjer();
        os.setEntitet(s);
        
        try {
            os.create();
        } catch (EdunovaException ex) {
            System.out.println(ex.getPoruka());
        }
    }
    private void fakerTest() {
        Faker faker = new Faker();

        //Ispisati 25 piva
        for (int i = 0; i < 25; i++) {
            System.out.println(faker.beer().name());
        }

        System.out.println("-----------------------");
        //Ispisati 25 piva bez ponavljanja
        List<String> piva = new ArrayList();
        String pivo;
        while (piva.size() < 25) {
            pivo = faker.beer().name();
            if (!piva.contains(pivo)) {
                piva.add(pivo);
            }
        }
        Collections.sort(piva);
        piva.forEach(p -> System.out.println(p));

        System.out.println("-------------------------");
        //Bolji način
        Set<String> pivaSet = new HashSet();
        while (pivaSet.size() < 25) {
            pivaSet.add(faker.beer().name());
        }
        pivaSet.forEach(p -> System.out.println(p));

        System.out.println("--------------------------");

        Faker hr = new Faker(new Locale("de"));

        for (int i = 0; i < 200; i++) {
            System.out.println(hr.name().fullName());
        }

    }

}
