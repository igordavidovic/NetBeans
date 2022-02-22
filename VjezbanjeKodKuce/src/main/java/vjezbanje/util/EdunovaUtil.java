/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vjezbanje.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import javax.swing.JOptionPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import us.codecraft.xsoup.Xsoup;

/**
 *
 * @author Igor
 */
public class EdunovaUtil {

    public static String generirajOib() {
        // DZ
        // Umjesto spajanja na web stranicu napraviti generiranje u java programskom jeziku
        // https://regos.hr/app/uploads/2018/07/KONTROLA-OIB-a.pdf
        try {
            URL url = new URL("http://oib.itcentrala.com/oib-generator/");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine;
            StringBuilder sb = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine);
            }
            in.close();
            Document d = Jsoup.parse(sb.toString());

            return Xsoup.compile("/html/body/div[1]/div[1]/text()").evaluate(d).get();
        } catch (Exception e) {
        }
        return "";
    }

    public static String oibGeneriraj() {
        StringBuilder sb = new StringBuilder();
        Integer[] niz = new Integer[11];
        for (int i = 0; i < 10; i++) {
            niz[i] = (int) (Math.random() * 9);
            sb.append(niz[i]);
        }
        int c = niz[0] + 10;
        for (int i = 1; i <= 10; i++) {
            if (c % 10 == 0) {
                c = 10;
            } else {
                c = c % 10;
            }
            c = c * 2;
            c = c % 11;
            if (i == 10) {
                break;
            }
            c = c + niz[i];
        }
        if (11 - c == 10) {
            niz[10] = 0;
        } else {
            niz[10] = 11 - c;
        }
        sb.append(niz[10]);
        return sb.toString();
    }
}
