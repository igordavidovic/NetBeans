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

    public static Film[] filmBaza() {
        Film[] filmovi = new Film[6];
        Film film;
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
            for (int i = 1; i < 7; i++) {
                film = new Film();
                naziv = Xsoup.compile("/html/body/section[2]/div[1]/div[2]/div[2]/ul/li[" + i + "]/p[2]/b/span").evaluate(d).get();

                opis = Xsoup.compile("//*[@id=\"main\"]/div[1]/div[2]/div[2]/ul/li[" + i + "]/p[5]/a[1]").evaluate(d).get();

                zanr = Xsoup.compile("//*[@id=\"main\"]/div[1]/div[2]/div[2]/ul/li[" + i + "]/p[3]/span[2]").evaluate(d).get();

                temp = Xsoup.compile("/html/body/section[2]/div[1]/div[2]/div[2]/ul/li[" + i + "]/p[3]/span[1]").evaluate(d).get();
                film = filmSet(naziv, opis, zanr, temp);
                filmovi[i - 1] = film;
            }

            in.close();
        } catch (Exception e) {
        }
        return filmovi;
    }

    private static Film filmSet(String naziv, String opis, String zanr, String temp) {
        Film film = new Film();
        double ocjena;
        try {
            film.setNaziv(naziv.substring(6, naziv.length() - 7));
            film.setOpis(opis.substring(93, opis.length() - 67));
            film.setZanr(zanr.substring(6, zanr.length() - 7));
            ocjena = Double.parseDouble(temp.substring(6, temp.length() - 7));
            film.setOcjena(new BigDecimal(ocjena));
        } catch (Exception e) {
            return null;
        }
        return film;
    }
}