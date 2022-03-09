package gioco;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class EstrattoreGiochi2 {

	public static ArrayList<Gioco> estraifile() {
		
		ArrayList<Gioco> giochi = new ArrayList<>();
		//1) leggi file riga per riga 
		
			File f = new File("giochi.txt");
			try {
				Scanner scn = new Scanner(f);
				
				while(scn.hasNextLine()) { 
		//2) per ogni riga splitto la riga in due parti
					String riga = scn.nextLine();
					String[] pezzi = riga.split(";");
					
		//3) assegno la prima stringa a nome e la seconda a genere
				    String nome= pezzi[0];
					String genere= pezzi[1];
					
		//4) creo un pezzo random 
					double prezzo = Math.random()*100;
					
		//5) costruisco l' oggetto di tipo gioco
					Gioco g = new Gioco(nome, genere, prezzo);
					//System.out.println(g);
		//6)metto l'oggetto nel contenitore di giochi
					giochi.add(g);
					
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		//7) ritorno all'araay di giochi
		
		return giochi;
	}
}
