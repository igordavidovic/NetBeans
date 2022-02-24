/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vjezbanje;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import vjezbanje.controller.ObradaGrupa;
import vjezbanje.controller.ObradaPredavac;
import vjezbanje.model.Grupa;
import vjezbanje.model.Polaznik;
import vjezbanje.model.Predavac;
import vjezbanje.model.vjezba.osnovno.Mobitel;
import vjezbanje.model.vjezba.veze.Mjesto;
import vjezbanje.model.vjezba.veze.Opcina;
import vjezbanje.util.EdunovaException;
import vjezbanje.util.HibernateUtil;
import vjezbanje.util.PocetniInsert;

/**
 *
 * @author Igor
 */
public class Start {
    
    private Session session;
    
    public Start(){
        //this.session = HibernateUtil.getSession();
        //PocetniInsert.izvedi();
        
        //primjerRadaSVezama();
        //procitajOpcine();
        tesitranjeUnosaPredavaca();
        /*List<Grupa> grupe = new ObradaGrupa().read();
        for(Grupa g : grupe){
            System.out.println(g.getNaziv() + " - " + g.getSmjer().getNaziv() + " - " + g.getPredavac().getIme() + " " + g.getPredavac().getPrezime());
            for(Polaznik p : g.getPolaznici()){
                System.out.println(p.getIme() + " " + p.getPrezime());
            }
            
        }*/
    }
   
    private void procitajOpcine(){
        List<Opcina> opcine = session.createQuery("from Opcina").list();
        
        for(Opcina o : opcine){
            System.out.println(o.getNaziv());
            o.getMjesta().forEach(m->System.out.println(m.getNaziv()));
        }
    }
    
    private void primjerRadaSVezama(){
        session.beginTransaction();
        Opcina opcina = new Opcina();
        opcina.setNaziv("Bilje");
        session.save(opcina);
        Mjesto mjesto = new Mjesto();
        mjesto.setNaziv("Kopačevo");
        mjesto.setOpcina(opcina);
        session.save(mjesto);
        
        mjesto = new Mjesto();
        mjesto.setNaziv("Bilje");
        mjesto.setOpcina(opcina);
        session.save(mjesto);
        session.getTransaction().commit();
    }
    public static void main(String[] args) {
      new Start();
        /*
        Session s = HibernateUtil.getSession();         
       
       Mobitel m = new Mobitel();
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

    private void tesitranjeUnosaPredavaca() {
        Predavac predavac = new Predavac();
        predavac.setOib("30861771565");
        predavac.setIme("Ana");
        predavac.setPrezime("Osiječka");
        predavac.setIban("HR7224840082418248241");
        predavac.setEmail("ana.o@gmail.com");
        ObradaPredavac op = new ObradaPredavac();
        op.setEntitet(predavac);
        try {
            op.create();
        } catch (EdunovaException ex) {
            System.out.println(ex.getPoruka());
        }
    }
}
