/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vjezbanje.model.vjezba.veze;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import vjezbanje.model.vjezba.nasljedivanje.Dokument;

/**
 *
 * @author Igor
 */
@Entity
public class Slika extends Dokument{
    
    private String autor;
    
    @ManyToMany
    private List<Oznaka> oznake;

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public List<Oznaka> getOznake() {
        return oznake;
    }

    public void setOznake(List<Oznaka> oznake) {
        this.oznake = oznake;
    }
    
    
}
