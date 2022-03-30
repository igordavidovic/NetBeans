/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vjezbanje.view;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;
import vjezbanje.model.Grupa;
import vjezbanje.model.Polaznik;

/**
 *
 * @author Igor
 */
public class GrupaComparator implements Comparator<Grupa>{
    

    
    @Override
    public int compare(Grupa o1, Grupa o2) {
        Integer prvi = o1.getPolaznici() == null ? 0 : o1.getPolaznici().size();
        Integer drugi = o1.getPolaznici() == null ? 0 : o2.getPolaznici().size();
        return drugi.compareTo(prvi);
    }
    
}
