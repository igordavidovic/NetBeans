/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filmovi;

import edunova.util.HibernateUtil;
import filmovi.model.Film;
import filmovi.util.FilmUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;

/**
 *
 * @author Igor
 */
public class StartBaza {
    private Session s;
    public StartBaza() {
        this.s = HibernateUtil.getSession();
        radSBazama();
    }
    
    private void radSBazama(){
        s.beginTransaction();
        Film[] filmovi;
        Set<Film> filmovi2 = new HashSet();
        vanjska:
        while(true){
            filmovi = FilmUtil.filmBaza();
            for(Film f : filmovi){
                if(filmovi2.size() == 100){
                    break vanjska;
                }
                if(f == null){
                    continue;
                }
                filmovi2.add(f);
            }
        }
        for(Film f : filmovi2){
            s.save(f);
        }
        s.getTransaction().commit();
    }

    
    public static void main(String[] args) {
        new StartBaza();
    }
}
