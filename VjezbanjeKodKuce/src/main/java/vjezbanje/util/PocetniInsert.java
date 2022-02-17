/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vjezbanje.util;

import com.github.javafaker.Faker;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import vjezbanje.model.Polaznik;
import vjezbanje.model.Smjer;

/**
 *
 * @author Igor
 */
public class PocetniInsert {

    public static void izvedi() {
        Session session = HibernateUtil.getSession();
        Faker faker = new Faker();

        List<Polaznik> polaznici = new ArrayList();
        Polaznik p;
        for (int i = 0; i < 3000; i++) {
            p = new Polaznik();
            p.setIme(faker.name().firstName());
            p.setPrezime(faker.name().lastName());
            p.setEmail(faker.name().firstName().substring(0, 1).toLowerCase() + faker.name().lastName().toLowerCase().replace(" ", "") + "@edunova.hr");
            //p.setOib;

        }

        Smjer s = new Smjer();
        s.setNaziv(faker.book().title());
        s.setCertificiran(Math.random() < 0.5 ? true : false);
        s.setTrajanje((int) Math.random() * (200 - 100) + 100);
        s.setCijena(new BigDecimal(Math.random() * (10000 - 5000) + 5000));
    }
}
