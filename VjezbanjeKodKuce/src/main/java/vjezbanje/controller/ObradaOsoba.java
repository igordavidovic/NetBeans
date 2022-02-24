/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vjezbanje.controller;

import java.util.List;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import org.apache.commons.validator.routines.EmailValidator;
import vjezbanje.model.Osoba;
import vjezbanje.util.EdunovaException;
import vjezbanje.util.OibValidation;

/**
 *
 * @author Igor
 */
public abstract class ObradaOsoba<T extends Osoba> extends Obrada<T> {
    
    @Override
    protected void kontrolaCreate() throws EdunovaException {
        kontrolaOib();
        kontrolaEmail();
    }
    
    @Override
    protected void kontrolaUpdate() throws EdunovaException {
        
    }
    
    @Override
    protected void kontrolaDelete() throws EdunovaException {
        
    }
    
    private void kontrolaOib() throws EdunovaException {
        if (!OibValidation.checkOIB(entitet.getOib())) {
            throw new EdunovaException("OIB nije formalno ispravan");
        }
    }
    
    private void kontrolaEmail() throws EdunovaException {
        boolean valid = EmailValidator.getInstance().isValid(entitet.getEmail()); 
        if(valid == false){
            throw new EdunovaException("Email nije valjan");
        }
        
        /*try {
            InternetAddress emailAddr = new InternetAddress(entitet.getEmail());
            emailAddr.validate();
        } catch (AddressException ex) {
            throw new EdunovaException("Email nije formalno ispravan");
        }*/
    }
    
}
