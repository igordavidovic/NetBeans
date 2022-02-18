/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filmovi.util;

import filmovi.model.Film;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Igor
 */
public class FilmTablicaUtil {
    
    public static int provjera(String unos){
        int broj;
        try {
            broj = Integer.parseInt(unos);
        } catch (Exception e) {
            return 0;
        }
        return broj;
    }
    public static Object[][] filmoviSet(int broj){
        Set <Film> filmovi = new HashSet();
        Film[] filmovi2;
        vanjska:
        while(true){
            filmovi2 = FilmUtil.filmBaza();
            for(Film f : filmovi2){
                if(filmovi.size() == broj){
                    break vanjska;
                }
                if(f == null){
                    continue;
                }
                filmovi.add(f);
            }
        }
        Object[][] objekti = tablicaFilm(filmovi);
        
        return objekti;
    } 
    private static Object[][] tablicaFilm(Set<Film> filmovi){
        Object[][] objekti = new Object[filmovi.size()][4];
        int i = 0;
        BigDecimal bd;
        double d;
        for(Film f : filmovi){
            bd = f.getOcjena();
            d = bd.doubleValue();
            bd = new BigDecimal(Double.toString(d));
            bd = bd.setScale(1, RoundingMode.HALF_UP);
            objekti[i][0] = f.getNaziv();
            objekti[i][1] = f.getZanr();
            objekti[i][2] = bd;
            objekti[i][3] = f.getOpis();           
            i++;
        }
        return objekti;
    }
}
