/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vjezbanje.model.vjezba.veze;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import vjezbanje.model.vjezba.nasljedivanje.Dokument;

/**
 *
 * @author Igor
 */
@Entity
public class Opcina extends Dokument{
    private String naziv;
    
    @OneToMany(mappedBy = "opcina")
    private List<Mjesto> mjesta;

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public List<Mjesto> getMjesta() {
        return mjesta;
    }

    public void setMjesta(List<Mjesto> mjesta) {
        this.mjesta = mjesta;
    }
    
    
}
