/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vjezbanje.controller;

import java.util.List;
import vjezbanje.model.Smjer;
import vjezbanje.util.EdunovaException;

/**
 *
 * @author Igor
 */
public class ObradaSmjer extends Obrada<Smjer>{
    
    @Override
    public List<Smjer> read() {
        return session.createQuery("from Smjer").list();
    }

    @Override
    protected void kontrolaCreate() throws EdunovaException {
        kontrolaNaziv();
        kontrolaTrajanje();
    }

    @Override
    protected void kontrolaUpdate() throws EdunovaException {
        
    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {
        
    }
    
    private void kontrolaNaziv() throws EdunovaException{
        if(entitet.getNaziv() == null || entitet.getNaziv().trim().isEmpty()){
            throw new EdunovaException("Naziv smjera obavezan");
        }
    }
    
    private void kontrolaTrajanje() throws EdunovaException{
        if(entitet.getTrajanje() == null || entitet.getTrajanje()<0){
            throw new EdunovaException("Trajanje mora biti postavljeno i ne smije biti manje od 0");
        }
    }
}
