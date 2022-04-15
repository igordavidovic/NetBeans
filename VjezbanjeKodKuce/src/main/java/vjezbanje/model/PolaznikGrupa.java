/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vjezbanje.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author Igor
 */
@Entity
public class PolaznikGrupa extends Entitet{
    @ManyToOne
    private Grupa grupa;
    
    @ManyToOne
    private Polaznik polaznik;
    
}
