/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vjezbanje.util;

import com.github.javafaker.Faker;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.mindrot.jbcrypt.BCrypt;
import vjezbanje.model.Grupa;
import vjezbanje.model.Operater;
import vjezbanje.model.Polaznik;
import vjezbanje.model.Predavac;
import vjezbanje.model.Smjer;

/**
 *
 * @author Igor
 */
public class PocetniInsert {
    public static void incijalniPodaci(){
        unosOperatera();
        izvedi();
    }
    public static void unosOperatera() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Operater o = new Operater();
        o.setIme("Eduard");
        o.setPrezime("Kuzma");
        o.setEmail("edunova@edunova.hr");
        o.setLozinka(BCrypt.hashpw("e",BCrypt.gensalt()));
        session.save(o);
        session.getTransaction().commit();

    }

    public static void izvedi() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Faker faker = new Faker();

        List<Polaznik> polaznici = generirajPolaznike(faker, session);
        List<Predavac> predavaci = generirajPredavace(faker, session);
        List<Smjer> smjerovi = generirajSmjerove(faker, session);
        Smjer s;
        Grupa g;
        for (int i = 0; i < smjerovi.size() - 2; i++) {
            s = smjerovi.get(i);
            for (int j = 0; j < ((int) Math.random() * (5 - 2) + 2); j++) {
                g = new Grupa();
                g.setSmjer(s);
                g.setNaziv(faker.animal().name());
                g.setPredavac(predavaci.get((int) Math.random() * (predavaci.size() - 1)));
                g.setDatumPocetka(new Date());
                Collections.shuffle(polaznici);
                g.setPolaznici(new ArrayList());
                for (int k = 0; k < ((int) Math.random() * (20 - 10) + 10); k++) {
                    g.getPolaznici().add(polaznici.get(k));
                }
                session.save(g);
                System.out.println("Kreirao grupu : " + g.getNaziv());
            }
        }
        session.getTransaction().commit();
    }

    private static List<Smjer> generirajSmjerove(Faker faker, Session session) {
        List<Smjer> smjerovi = new ArrayList();
        Smjer s;
        for (int i = 0; i < 10; i++) {
            s = new Smjer();
            s.setNaziv(faker.book().title());
            s.setCertificiran(Math.random() < 0.5 ? true : false);
            s.setTrajanje((int) Math.random() * (200 - 100) + 100);
            s.setCijena(new BigDecimal(Math.random() * (10000 - 5000) + 5000));
            session.save(s);
            smjerovi.add(s);
            System.out.println("Kreirao smjer : " + s.getNaziv());
        }
        return smjerovi;
    }

    private static List<Polaznik> generirajPolaznike(Faker faker, Session session) {
        List<Polaznik> polaznici = new ArrayList();
        Polaznik p;
        for (int i = 0; i < 3000; i++) {
            p = new Polaznik();
            p.setIme(faker.name().firstName());
            p.setPrezime(faker.name().lastName());
            p.setEmail(faker.name().firstName().substring(0, 1).toLowerCase() + faker.name().lastName().toLowerCase().replace(" ", "") + "@edunova.hr");
            p.setOib(EdunovaUtil.generirajOib());
            p.setBrojUgovora((i + 1) + "/2022");
            session.save(p);
            polaznici.add(p);
            System.out.println("Kreirao polaznika : " + p.getIme() + p.getOib());
        }
        return polaznici;
    }

    private static List<Predavac> generirajPredavace(Faker faker, Session session) {
        List<Predavac> predavaci = new ArrayList();
        Predavac p;
        for (int i = 0; i < 12; i++) {
            p = new Predavac();
            p.setIme(faker.name().firstName());
            p.setPrezime(faker.name().lastName());
            p.setEmail(faker.name().firstName().substring(0, 1).toLowerCase() + faker.name().lastName().toLowerCase().replace(" ", "") + "@edunova.hr");
            p.setOib(EdunovaUtil.generirajOib());
            p.setIban("");
            session.save(p);
            predavaci.add(p);
            System.out.println("Kreirao predavača : " + p.getIme() + p.getOib());
        }
        return predavaci;
    }
}
