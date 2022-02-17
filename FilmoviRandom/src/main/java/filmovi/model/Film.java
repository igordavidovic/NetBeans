/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filmovi.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author Igor
 */
@Entity
public class Film extends Entitet{
    @Column(columnDefinition = "varchar(255)",nullable = false)
    private String naziv;
    @Column(columnDefinition = "decimal(2,1)",nullable = true)
    private BigDecimal ocjena;
    @Column(columnDefinition = "varchar(500)", nullable = true)
    private String opis;
    @Column(columnDefinition = "varchar(150)",nullable = true)
    private String zanr;

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public BigDecimal getOcjena() {
        return ocjena;
    }

    public void setOcjena(BigDecimal ocjena) {
        this.ocjena = ocjena;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getZanr() {
        return zanr;
    }

    public void setZanr(String zanr) {
        this.zanr = zanr;
    }
    
    
}
