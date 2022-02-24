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

    @Override
    protected void kontrolaCreate() throws EdunovaException {
        super.kontrolaCreate();
        kontrolaBrojUgovora();
    }

    private void kontrolaBrojUgovora() throws EdunovaException{
        if(entitet.getBrojUgovora() == null || !entitet.getBrojUgovora().contains("/")){
            throw new EdunovaException("Broj ugovora mora imati /");
        }
    }
    
    
}
