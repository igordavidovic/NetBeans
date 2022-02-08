package edunova.program;

import java.math.BigDecimal;
import java.util.Scanner;

public class Unos {
	
	public static int unesiInt( Scanner ulaz, String poruka) {
		int i=0;
		while(true) {
			System.out.print(poruka + ": ");
			i = Integer.parseInt(ulaz.nextLine());
			if(i<1) {
				System.out.println("Broj mora biti pozitivan");
				continue;
			}
			return i;
		}
	}
	
	public static BigDecimal unesiBigDecimal(Scanner ulaz,String poruka) {
		BigDecimal i=BigDecimal.ZERO;
		while(true) {
			System.out.print(poruka + ": ");
			i = new BigDecimal(ulaz.nextLine());
			if(i.compareTo(BigDecimal.ONE) < 0) {
				System.out.println("Broj mora biti pozitivan");
				continue;
			}
			return i;
		}
	}
	
	
	public static String unesiString(Scanner ulaz, String poruka) {
		String s="";
		while(true) {
			System.out.print(poruka + ": ");
			s = ulaz.nextLine();
			if(s.length()==0) {
				System.out.println( "Obavezan unos");
				continue;
			}
			return s;
		}
	}

}
