/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filmovi;

import filmovi.model.Film;
import filmovi.util.FilmUtil;

/**
 *
 * @author Igor
 */
public class StartIspis {
    
    public static void main(String[] args) {
        Film[] filmovi = FilmUtil.filmBaza(); 
        double d = Math.random() * 6;

        System.out.println(filmovi[(int)d].getNaziv());
    }
}
