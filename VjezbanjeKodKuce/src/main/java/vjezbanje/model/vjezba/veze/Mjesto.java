/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vjezbanje.model.vjezba.veze;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import vjezbanje.model.vjezba.nasljedivanje.Dokument;

/**
 *
 * @author Igor
 */
@Entity
public class Mjesto extends Dokument{
    private String naziv;
    
    @ManyToOne
    private Opcina opcina;

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Opcina getOpcina() {
        return opcina;
    }

    public void setOpcina(Opcina opcina) {
        this.opcina = opcina;
    }
    
    
}
