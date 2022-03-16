/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vjezbanje.controller;

import java.util.Calendar;
import java.util.List;
import vjezbanje.model.Grupa;
import vjezbanje.util.EdunovaException;

/**
 *
 * @author Igor
 */
public class ObradaGrupa extends Obrada<Grupa> {

    @Override
    public List<Grupa> read() {
        return session.createQuery("from Grupa").list();
    }

    @Override
    protected void kontrolaCreate() throws EdunovaException {
        kontrolaSmjer();
        kontrolaDatumPocetka();
    }

    @Override
    protected void kontrolaUpdate() throws EdunovaException {

    }

    @Override
    protected void kontrolaDelete() throws EdunovaException {

    }

    private void kontrolaDatumPocetka() throws EdunovaException {
        if (entitet.getDatumPocetka() != null) {
            Calendar c = Calendar.getInstance();
            c.setTime(entitet.getDatumPocetka());
            if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                throw new EdunovaException("Datum ne može biti na vikend (subota ili vikend");
            }
        }
    }

    private void kontrolaSmjer() throws EdunovaException {
        if (entitet.getSmjer() == null || entitet.getSmjer().getSifra().equals(Long.valueOf(0))) {
            throw new EdunovaException("Obavezno odabir smjera");
        }
    }

}
