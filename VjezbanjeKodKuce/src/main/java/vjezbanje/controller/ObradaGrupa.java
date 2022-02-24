/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vjezbanje.controller;

import java.util.List;
import vjezbanje.model.Grupa;
import vjezbanje.util.EdunovaException;

/**
 *
 * @author Igor
 */
public class ObradaGrupa extends Obrada<Grupa>{

    @Override
    public List<Grupa> read() {
        return session.createQuery("from Grupa").list();
    }

    @Override
    protected void kontrolaCreate() throws EdunovaException {

    }

    @Override
    protected void kontrolaUpdate() throws EdunovaException {

    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {

    }
    
}
