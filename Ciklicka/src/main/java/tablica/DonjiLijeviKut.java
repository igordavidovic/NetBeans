/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablica;

/**
 *
 * @author Igor
 */
public class DonjiLijeviKut {
        private static Object[][] niz;
	private static int proizvod;
	private static int d;
	private static int m;

	public static Object[][] smjer(int r, int s) {

		niz = new Object[r][s];
		proizvod = r * s;
		d = 1;
		m = 0;
		smjerKazaljke();
                return niz;
	}

	private static void smjerKazaljke() {
		while (true) {
			if (d > proizvod) {
				break;
			}
			dlLijevoGore();
			if (d > proizvod) {
				break;
			}
			glLijevoDesno();
			if (d > proizvod) {
				break;
			}
			gdDesnoDolje();
			if (d > proizvod) {
				break;
			}
			ddDesnoLijevo();
			m++;
		}

	}


	private static void dlLijevoGore() {
		for (int x = niz.length - (1 + m); x >= m; x--) {
			if (d > proizvod) {
				break;
			}
			niz[x][m] = d;
			d++;
		}
	}

	private static void glLijevoDesno() {
		for (int y = (1 + m); y < niz[0].length - (1 + m); y++) {
			if (d > proizvod) {
				break;
			}
			niz[m][y] = d;
			d++;
		}
	}

	private static void gdDesnoDolje() {
		for (int x = m; x < niz.length - (1 + m); x++) {
			if (d > proizvod) {
				break;
			}
			niz[x][niz[0].length - (1 + m)] = d;
			d++;
		}
	}

	private static void ddDesnoLijevo() {
		for (int y = niz[0].length - (1 + m); y > m; y--) {
			if (d > proizvod) {
				break;
			}
			niz[niz.length - (1 + m)][y] = d;
			d++;
		}
	}

}
