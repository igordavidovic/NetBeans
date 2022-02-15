/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vjezbanje;

import java.math.BigDecimal;
import java.util.Date;
import org.hibernate.Session;
import vjezbanje.model.vjezba.osnovno.Mobitel;
import vjezbanje.util.HibernateUtil;

/**
 *
 * @author Igor
 */
public class Start {
   
    
    public static void main(String[] args) {
       Session s = HibernateUtil.getSession();         
       
       /* Mobitel m = new Mobitel();
        m.setCijena(new BigDecimal(5999.99));
        m.setNaziv("iPhone");
        m.setDatumKupnje(new Date());
        m.setIspravan(true);
        m.setOpis("Mobitel je dobar");
        m.setNapomena("Sve je ok");
        
        s.beginTransaction();
        s.save(m);
        s.getTransaction().commit();
            */
        
    }
}
