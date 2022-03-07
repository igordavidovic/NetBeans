/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vjezbanje.model;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author Igor
 */
@Entity
public class Smjer extends Entitet{
    private String naziv;
    private Integer trajanje;
    private BigDecimal cijena;
    private Boolean certificiran;
    @OneToMany(mappedBy = "smjer")
    private List<Grupa> grupe;
    
    public String getNaziv() {
        return naziv;
    }

    public List<Grupa> getGrupe() {
        return grupe;
    }

    public void setGrupe(List<Grupa> grupe) {
        this.grupe = grupe;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Integer getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(Integer trajanje) {
        this.trajanje = trajanje;
    }

    public BigDecimal getCijena() {
        return cijena;
    }

    public void setCijena(BigDecimal cijena) {
        this.cijena = cijena;
    }

    public Boolean getCertificiran() {
        return certificiran;
    }

    public void setCertificiran(Boolean certificiran) {
        this.certificiran = certificiran;
    }

    @Override
    public String toString() {
        return naziv;
    }
    
    
}
