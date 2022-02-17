/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filmovi.util;

import filmovi.model.Film;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import us.codecraft.xsoup.Xsoup;

/**
 *
 * @author Igor
 */
public class FilmUtil {

    public static Film filmBaza() {
        Film film = new Film();
        String naziv = "";
        String opis = "";
        String zanr = "";
        String temp = "";
        double ocjena = 0;
        try {
            URL url = new URL("https://www.bestrandoms.com/random-movie-generator");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine;
            StringBuilder sb = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine);
            }

            Document d = Jsoup.parse(sb.toString());
            naziv = Xsoup.compile("/html/body/section[2]/div[1]/div[2]/div[2]/ul/li[1]/p[2]/b/span").evaluate(d).get();

            opis = Xsoup.compile("//*[@id=\"main\"]/div[1]/div[2]/div[2]/ul/li[1]/p[5]/a[1]").evaluate(d).get();

            zanr = Xsoup.compile("//*[@id=\"main\"]/div[1]/div[2]/div[2]/ul/li[1]/p[3]/span[2]").evaluate(d).get();

            temp = Xsoup.compile("/html/body/section[2]/div[1]/div[2]/div[2]/ul/li[1]/p[3]/span[1]").evaluate(d).get();

            in.close();
        } catch (Exception e) {
        }
        film.setNaziv(naziv.substring(6, naziv.length() - 7));
        film.setOpis(opis.substring(93, opis.length() - 67));
        film.setZanr(zanr.substring(6, zanr.length() - 7));
        ocjena = Double.parseDouble(temp.substring(6, temp.length() - 7));
        film.setOcjena(new BigDecimal(ocjena));
        return film;
    }

    public static void filmIspis() {
        String naziv = "";
        String opis = "";
        String zanr = "";
        String temp = "";
        try {
            URL url = new URL("https://www.bestrandoms.com/random-movie-generator");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine;
            StringBuilder sb = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine);
            }

            Document d = Jsoup.parse(sb.toString());
            naziv = Xsoup.compile("/html/body/section[2]/div[1]/div[2]/div[2]/ul/li[1]/p[2]/b/span").evaluate(d).get();
            opis = Xsoup.compile("//*[@id=\"main\"]/div[1]/div[2]/div[2]/ul/li[1]/p[5]/a[1]").evaluate(d).get();
            zanr = Xsoup.compile("//*[@id=\"main\"]/div[1]/div[2]/div[2]/ul/li[1]/p[3]/span[2]").evaluate(d).get();
            temp = Xsoup.compile("/html/body/section[2]/div[1]/div[2]/div[2]/ul/li[1]/p[3]/span[1]").evaluate(d).get();

            in.close();
        } catch (Exception e) {
        }
        System.out.println("Naziv : " + naziv.substring(6, naziv.length() - 7));
        System.out.println("Opis : " + opis.substring(93, opis.length() - 67));
        System.out.println("Žanr : " + zanr.substring(6, zanr.length() - 7));
        System.out.println("Ocjena : " + temp.substring(6, temp.length() - 7));
    }
}
