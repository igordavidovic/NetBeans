/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vjezbanje.controller;

import java.util.List;
import nl.garvelink.iban.IBAN;
import vjezbanje.model.Predavac;
import vjezbanje.util.EdunovaException;

/**
 *
 * @author Igor
 */
public class ObradaPredavac extends ObradaOsoba<Predavac> {

    @Override
    public List<Predavac> read() {
        return session.createQuery("from Predavac").list();
    }

    @Override
    protected void kontrolaCreate() throws EdunovaException {
        super.kontrolaCreate();
        kontrolaIBAN();
        kontrolaNoviIban();
    }

    @Override
    protected void kontrolaUpdate() throws EdunovaException {
        super.kontrolaUpdate();
        kontrolaPromjenaIban();
    }
    
    private void kontrolaIBAN() throws EdunovaException {
        if (entitet.getIban() == null) {
            throw new EdunovaException("Obavezno IBAN");
        }

        try {
            IBAN iban = IBAN.valueOf(entitet.getIban());
            if (!iban.isSEPA()) {
                throw new EdunovaException("IBAN nije ispravan");
            }
        } catch (Exception e) {
            throw new EdunovaException("IBAN nije ispravan");
        }
    }
        private void kontrolaNoviIban()throws EdunovaException{
         List<Predavac> lista = session.createQuery("from Predavac e "
                + "where e.iban=:iban")
                .setParameter("iban", entitet.getIban()).list();
        
        if(lista!=null && lista.size()>0){
            throw new EdunovaException("IBAN postoji u sustavu, dodijeljen " + lista.get(0).getPrezime());
        }
    }
    
    private void kontrolaPromjenaIban()throws EdunovaException{
         List<Predavac> lista = session.createQuery("from Predavac e "
                + "where e.iban=:iban and e.sifra!=:id")
                .setParameter("iban", entitet.getIban())
                 .setParameter("id", entitet.getSifra()).list();
        
        if(lista!=null && lista.size()>0){
            throw new EdunovaException("IBAN postoji u sustavu, dodijeljen " + lista.get(0).getPrezime());
        }
    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {
        if(entitet.getGrupe()!=null && entitet.getGrupe().size()>0){
            throw new EdunovaException("Predavača ne možete obrisati jer predaje na jednoj ili više grupa");
        }
    }
}
