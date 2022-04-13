package controller;//Legge il comando dato dall' interfaccia, prende un oggetto di tipo film e lo restituisce. Si occupa della controller logic

import java.util.ArrayList;
import java.util.List;

import model.Film;

public class FilmController {

	private static List<Film> magazzino = new ArrayList<Film>();
	
	public static void addFilm(Film f) {
		magazzino.add(f); // Dependency injection
	}
	
	public static void addFilm(int codice, String titolo, double prezzo, List<String> genere) {
		Film f = new Film(codice, titolo, prezzo, genere);
		magazzino.add(f); //fatto overload. L' oggetto film � incastrato dentro il controller. 
	}				     //Non abusarne, lega troppo gli oggetti, limita crescita e testabilit� del programma. Pensare come ai componenti del PC, se si possono staccare � meglio.
	
	public Film getFilmByCodice(int codice) {
		
		for (Film film : magazzino) {
			if(film.getCodice()==codice)
				return film;// ritorna il film se il codice passato viene trovato nella lista di film in magazzino
		}
		return null;		// se no ritorna null
	}
	
	public static List<Film> getAll(){// conviene che i metodi applicati a oggetti statici (come la List<Film> magazzino) siano statici anch' essi
		
		return magazzino;
		
	}
	
	
	
}

/* STATIC -> Appartiene alla classe, non agli oggetti. Nell' esempio della lista dei film cos� tutti farebbero riferimento
 alla stessa lista, se non fosse static, tutti avrebbero un "oggetto lista". Quando qualcosa � static non si usa this. 
 perch� appartiene al mondo degli oggetti. Static � nel mondo delle classi.
*/