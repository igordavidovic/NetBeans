/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vjezbanje.util;

import com.github.javafaker.Faker;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import us.codecraft.xsoup.Xsoup;

/**
 *
 * @author Igor
 */
public class Test {

    public static void main(String[] args) {
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

        try {
            URL yahoo = new URL("http://oib.itcentrala.com/oib-generator/");
            BufferedReader in = new BufferedReader(new InputStreamReader(yahoo.openStream()));
            String inputLine;
            StringBuilder sb = new StringBuilder();
            while((inputLine = in.readLine())!= null){
                sb.append(inputLine);
            }
            
            Document d = Jsoup.parse(sb.toString());
            
            System.out.println(Xsoup.compile("/html/body/div[1]/div[1]/text()").evaluate(d).get());
            
            in.close();
        } catch (Exception e) {
        }
    }
}
