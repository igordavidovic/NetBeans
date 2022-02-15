/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vjezbanje.model.vjezba.nasljedivanje;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author Igor
 */
@Entity(name = "`select`")
public class Otpremnica extends Dokument{
    @Column(name = "`user`")
    private String kupac;

    public String getKupac() {
        return kupac;
    }

    public void setKupac(String kupac) {
        this.kupac = kupac;
    }
    
}
