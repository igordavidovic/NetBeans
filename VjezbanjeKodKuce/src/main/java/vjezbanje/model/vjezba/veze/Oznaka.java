/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vjezbanje.model.vjezba.veze;

import javax.persistence.Entity;
import vjezbanje.model.vjezba.nasljedivanje.Dokument;

/**
 *
 * @author Igor
 */
@Entity
public class Oznaka extends Dokument{
    private String vrijednost;

    public String getVrijednost() {
        return vrijednost;
    }

    public void setVrijednost(String vrijednost) {
        this.vrijednost = vrijednost;
    }
    
    
}
