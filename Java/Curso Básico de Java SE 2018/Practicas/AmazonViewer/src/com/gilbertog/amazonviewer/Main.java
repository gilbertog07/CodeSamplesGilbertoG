package com.gilbertog.amazonviewer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.Scanner;

import com.gilbertog.amazonviewer.model.Book;
import com.gilbertog.amazonviewer.model.Chapter;
import com.gilbertog.amazonviewer.model.Movie;
import com.gilbertog.amazonviewer.model.Serie;
import com.gilbertog.makereport.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		showMenu();

	}

	public static void showMenu() {
        int exit = 1;
        int opcion = 1;
        
        do {

        	System.out.println("");
        	System.out.println("BIENVENIDOS A AMAZON VIEWER");
            System.out.println();
            System.out.println("Selecciona el n�mero de la opci�n deseada: ");
            System.out.println();
            System.out.println("1. Movies");
            System.out.println("2. Series");
            System.out.println("3. Books");
            System.out.println("4. Magazines");
            System.out.println("5. Report");
            System.out.println("6. Report Today");
            System.out.println("0. Exit");
            System.out.println();
            
            Scanner sc = new Scanner(System.in);
            opcion = Integer.valueOf(sc.nextLine());

            switch (opcion) {
			case 1:
				System.out.println("Opci�n Movies");
				showMovie();
				break;
			case 2:
				System.out.println("Opci�n Series");
				showSeries();
				break;
			case 3:
				System.out.println("Opci�n Books");
				showBooks();
				break;
			case 4: 
				System.out.println("Opci�n Magazines");
				showMagazines();
				break;
			case 5: 
				System.out.println("Opci�n Report");
				makeReport();
				break;
			case 6: 
				System.out.println("Opci�n Report Today");
				makeReport(new Date());
				break;
			case 0: 
				System.out.println("Saliste del Sistema");
				exit = 0;
				break;
			default:
				System.out.println("Opci�n no valida");
			}

        } while(exit != 0);

	}

	static ArrayList<Movie> movies;
	public static void showMovie() {

		int exit = 1;
		movies = Movie.makeMoviesList(); // Se invoc� de esta forma, ya que el m�todo creado es Static, lo que permite NO tener que instanciar el objeto

		do {

			System.out.println();
			System.out.println(":: MOVIES ::");
			System.out.println();
			
			for (int i = 0; i < movies.size(); i++) {
				System.out.println((i+1) + " " + movies.get(i).getTitle() + " Visto: " + movies.get(i).isViewed());
			}

			System.out.println();
			System.out.println("0. Regresar al Men�");
			System.out.println();
			
			// Leer respuesta del usuario
			Scanner sc = new Scanner(System.in);
			int opcion = Integer.valueOf(sc.nextLine());

			if (opcion == 0) {
				exit = 0;
			} else {
				Movie movieSelected = movies.get(opcion - 1);
				movieSelected.setViewed(true);
				Date dateI = movieSelected.startToSee(new Date());

				for (int i = 0; i < 1000000; i++) {
					System.out.println("........");
				}

				// Cuando termin� la pel�cula
				movieSelected.stopToSee(dateI, new Date());
				System.out.println();
				System.out.println("Viste: " + movieSelected);
				System.out.println("Por: " + movieSelected.getTimeViewed() + " Milisegundos");	
			}

		} while(exit != 0);

	}

	public static void showSeries() {
		int exit = 1;
		ArrayList<Serie> series = Serie.makeSeriesList();
		
		do {
			System.out.println();
			System.out.println(":: SERIES ::");
			System.out.println();

		    for (int i = 0; i < series.size(); i++) {
				System.out.println((i+1) + " " + series.get(i).getTitle() + " Visto: " + series.get(i).isViewed());
			}

			System.out.println();
			System.out.println("0. Regresar al Men�");
			System.out.println();
		
			// Leer respuesta del usuario
			Scanner sc = new Scanner(System.in);
			int opcion = Integer.valueOf(sc.nextLine());

			if (opcion == 0) {
				exit = 0;
			} else {
				showChapters(series.get(opcion - 1).getChapters());
			}

		} while(exit != 0);

	}
	
	public static void showChapters(ArrayList<Chapter> chapters) {
		int exit = 1;
		do {

			System.out.println();
			System.out.println(":: CHAPTERS ::");
			System.out.println();

		    for (int i = 0; i < chapters.size(); i++) {
				System.out.println((i+1) + " " + chapters.get(i).getTitle() + " Visto: " + chapters.get(i).isViewed());
			}

			System.out.println();
			System.out.println("0. Regresar al Men�");
			System.out.println();

			// Leer respuesta del usuario
			Scanner sc = new Scanner(System.in);
			int opcion = Integer.valueOf(sc.nextLine());

			if (opcion == 0) {
				exit = 0;
			} else {
				Chapter chapterSelected = chapters.get(opcion - 1);
				chapterSelected.setViewed(true);
				Date dateI = chapterSelected.startToSee(new Date());

				for (int i = 0; i < 10000; i++) {
					System.out.println("........");
				}

				// Cuando termine el capitulo
				chapterSelected.stopToSee(dateI, new Date());
				System.out.println();
				System.out.println("Viste: " + chapterSelected);
				System.out.println("Por: " + chapterSelected.getTimeViewed());
				System.out.println();
			}

		} while(exit != 0);
	}
	
	public static void showBooks() {
		int exit = 1;
		ArrayList<Book> books = Book.makeBookList();

		do {
			System.out.println();
			System.out.println(":: BOOKS ::");
			System.out.println();

			for (int i = 0; i < books.size(); i++) {
				System.out.println((i+1) + " " + books.get(i).getTitle() + " Leido: " + books.get(i).isReaded());
			}

			System.out.println();
			System.out.println("0. Regresar al Men�");
			System.out.println();
			
			// Leer respuesta del usuario
			Scanner sc = new Scanner(System.in);
			int opcion = Integer.valueOf(sc.nextLine());

			if (opcion == 0) {
				exit = 0;
			} else {
				Book booksSelected = books.get(opcion - 1);
				booksSelected.setReaded(true);
				Date dateI = booksSelected.startToSee(new Date());

				for (int i = 0; i < 1000; i++) {
					System.out.println("........");
				}

				// Cuando termine el libro
				booksSelected.stopToSee(dateI, new Date());
				System.out.println();
				System.out.println("Viste: " + booksSelected);
				System.out.println("Por: " + booksSelected.getTimeReaded() + " Milisegundos");	
			}

		} while(exit != 0);

	}
	
	public static void showMagazines() {
		int exit = 0;
		do {
			System.out.println();
			System.out.println(":: MAGAZINES ::");
			System.out.println();
		} while(exit != 0);
	}

	public static void makeReport() {
		Report report = new Report();
		report.setNamefile("reporte");
		report.setTitle(":: VISTOS ::");
		report.setExtension("txt");
		String contentReport = "";
		
		for (Movie movie : movies) {
			if (movie.getIsViewed()) {
				contentReport += movie.toString() + "\n";
			}
		}
		
		report.setContent(contentReport);
		report.makeReport();
	}
	
	public static void makeReport(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
		String dateString = df.format(date);
		
		Report report = new Report();
		report.setNamefile("reporte " + dateString);
		report.setTitle(":: VISTOS ::");
		report.setExtension("txt");
		String contentReport = "";
		
		for (Movie movie : movies) {
			if (movie.getIsViewed()) {
				contentReport += movie.toString() + "\n";
			}
		}
		
		report.setContent(contentReport);
		report.makeReport();		
	}	
	
}