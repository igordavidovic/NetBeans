/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vjezbanjesubota.model;

import java.math.BigDecimal;

/**
 *
 * @author Igor
 */
public class Djelatnik extends Osoba{
    private BigDecimal placa;

    public BigDecimal getPlaca() {
        return placa;
    }

    public void setPlaca(BigDecimal placa) {
        this.placa = placa;
    }

    @Override
  public void ispisPodataka() {
        System.out.println( new StringBuilder().append(ime).append(" ").append(prezime).append(" ").append(email).append(" ").append(placa).toString());
    }

    
    
    
}
