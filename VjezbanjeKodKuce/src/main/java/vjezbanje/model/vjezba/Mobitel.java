/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vjezbanje.model.vjezba;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Igor
 */
@Entity
public class Mobitel {
    @Id
    private int sifra;
    private String naziv;
    private BigDecimal cijena;
    private Date datumKupnje;
    private boolean ispravan;
    private String opis;
    private String napomena;

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getSifra() {
        return sifra;
    }

    public void setSifra(int sifra) {
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public BigDecimal getCijena() {
        return cijena;
    }

    public void setCijena(BigDecimal cijena) {
        this.cijena = cijena;
    }

    public Date getDatumKupnje() {
        return datumKupnje;
    }

    public void setDatumKupnje(Date datumKupnje) {
        this.datumKupnje = datumKupnje;
    }

    public boolean isIspravan() {
        return ispravan;
    }

    public void setIspravan(boolean ispravan) {
        this.ispravan = ispravan;
    }
    
    
}
