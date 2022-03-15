/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vjezbanje.controller;

import java.util.List;
import vjezbanje.model.Polaznik;
import vjezbanje.util.EdunovaException;

/**
 *
 * @author Igor
 */
public class ObradaPolaznik extends ObradaOsoba<Polaznik> {

    @Override
    public List<Polaznik> read() {
        return session.createQuery("from Polaznik").list();
    }
     public List<Polaznik> read(String uvjet) {
        return session.createQuery("from Polaznik p "
                + " where concat(p.ime,' ',p.prezime,' ',ifnull(p.oib,'')) "
                + " like :uvjet order by p.prezime, p.ime").setParameter("uvjet", "%" + uvjet + "%").setMaxResults(50)
                .list();
    }
     public List<Polaznik> readPocetakPrezimena(String uvjet) {
        return session.createQuery("from Polaznik p "
                + " where p.prezime "
                + " like :uvjet order by p.prezime, p.ime").setParameter("uvjet", uvjet + "%").setMaxResults(50)
                .list();
    }
    @Override
    protected void kontrolaCreate() throws EdunovaException {
        super.kontrolaCreate();
        kontrolaBrojUgovora();
    }

    private void kontrolaBrojUgovora() throws EdunovaException {
        if (entitet.getBrojUgovora() == null || !entitet.getBrojUgovora().contains("/")) {
            throw new EdunovaException("Broj ugovora mora imati /");
        }
    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {
        if (entitet.getGrupe() != null && entitet.getGrupe().size() > 0) {
            throw new EdunovaException("Polaznik ne možete obrisati jer pohađa jednu ili više grupa");
        }
    }
}
