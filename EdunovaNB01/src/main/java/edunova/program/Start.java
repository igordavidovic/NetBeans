package edunova.program;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Start {

    private List<Mobitel> mobiteli;
    private Scanner ulaz;
    private Mobitel mobitel;

    public Start() {
        mobiteli = new ArrayList<>();
        ulaz = new Scanner(System.in);
        pocetniPodaci();
        program();
        ulaz.close();
    }

    private void pocetniPodaci() {
        for (int i = 0; i < 10; i++) {
            mobiteli.add(new Mobitel(i + 1, "M" + (i + 1), new BigDecimal(i * 1000)));
        }

    }

    private void program() {
        naslov();
        izbornik();
    }

    private void izbornik() {
        System.out.println("\n1. Unos mobitela");
        System.out.println("2. Promjena mobitela");
        System.out.println("3. Brisanje mobitela");
        System.out.println("4. Pregled mobitela");
        System.out.println("5. Izlaz iz programa");
        System.out.println("6. Spremi na disk");
        //DZ staru switch sintaksu preprevati u novu
        switch (Unos.unesiInt(ulaz, "Odaberite akciju")) {
            case 1:
                unos();
                break;
            case 2:
                promjena();
                break;
            case 3:
                brisanje();
                break;
            case 4:
                pregled();
                izbornik();
                break;
            case 5:
                System.out.println("\nHvala Što ste koristili naš program, doviđenja!");
                break;
            case 6:
                spremiNaDisk();
                break;
            default:
                System.out.println("Nije dobra opcija izbornika");
                izbornik();
        }
    }

    private void pregled() {
        int b = 1;
        for (Mobitel m : mobiteli) {
            System.out.println(b++ + ". " + m);
        }
    }

    private void brisanje() {
        pregled();
        mobiteli.remove(Unos.unesiInt(ulaz, "Odaberi redni broj mobitela koji želiš obrisati") - 1);
        izbornik();
    }

    private void promjena() {
        pregled();
        int i = Unos.unesiInt(ulaz, "Unesi redni broj mobitela kojeg želiš mjenjati");
        mobitel = mobiteli.get(i - 1);
        mobitel.setNaziv(Unos.unesiString(ulaz, "Promjeni naziv (" + mobitel.getNaziv() + ")"));
        // DZ implementirsti promjene šifre i cijene
        izbornik();
    }

    private void unos() {
        mobitel = new Mobitel();
        mobitel.setSifra(Unos.unesiInt(ulaz, "Učitaj šifru mobitela"));
        mobitel.setNaziv(Unos.unesiString(ulaz, "Učitaj naziv mobitela"));
        mobitel.setCijena(Unos.unesiBigDecimal(ulaz, "Učitaj cijenu mobitela"));
        mobiteli.add(mobitel);
        izbornik();
    }

    private void naslov() {
        System.out.println("*****************************");
        System.out.println("**** Program Mobiteli V1 ****");
        System.out.println("*****************************");
    }

    public static void main(String[] args) {
        new Start();
    }

    private void spremiNaDisk() {
        
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println("broj mobitela: " + mobiteli.size());
            
            
            
            FileWriter writer = new FileWriter(new File("podaci.json"));
        gson.toJson(mobiteli, writer);
        writer.flush();
        writer.close();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
