/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablica.util;

/**
 *
 * @author Igor
 */
public class Ispis {

    public static void ispisMatrice(int[][] niz) {

        for (int i = 0; i < niz.length; i++) {
            for (int j = 0; j < niz[0].length; j++) {
                if (niz[i][j] <= 9) {
                    System.out.print("   " + niz[i][j] + " ");
                } else if (niz[i][j] >= 10 && niz[i][j] <= 99) {
                    System.out.print("  " + niz[i][j] + " ");
                } else if (niz[i][j] >= 100 && niz[i][j] <= 999) {
                    System.out.print(" " + niz[i][j] + " ");
                } else if (niz[i][j] >= 1000 && niz[i][j] <= 10000) {
                    System.out.print(niz[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
