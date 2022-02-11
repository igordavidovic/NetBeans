/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vjezbanje.model.vjezba;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Igor
 */
@Entity
public class Racunalo {
    @Id
    private Integer id;
    private BigDecimal cijena;
    private Date godinaProizvodnje;
    private String naziv;
    private Boolean garancija;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getCijena() {
        return cijena;
    }

    public void setCijena(BigDecimal cijena) {
        this.cijena = cijena;
    }

    public Date getGodinaProizvodnje() {
        return godinaProizvodnje;
    }

    public void setGodinaProizvodnje(Date godinaProizvodnje) {
        this.godinaProizvodnje = godinaProizvodnje;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Boolean getGarancija() {
        return garancija;
    }

    public void setGarancija(Boolean garancija) {
        this.garancija = garancija;
    }
    
    
}

