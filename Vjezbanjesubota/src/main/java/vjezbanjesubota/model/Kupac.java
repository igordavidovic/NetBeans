/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vjezbanjesubota.model;

/**
 *
 * @author Igor
 */
public class Kupac extends Osoba{
    private String oib;

    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    @Override
    public void ispisPodataka() {
        System.out.println(new StringBuilder().append(ime).append(" ").append(prezime).append(" ").append(email).append(" ").append(oib).toString()); 
    }
    
}
