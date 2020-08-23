package com.gilbertog.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

public class Book extends Publication implements IVisualizable {

	private int id;
	private String isbn;
	private boolean readed;
	private int timeReaded;

	public Book(String title, Date editionDate, String editorial, String[] authors, String isbn) {
		super(title, editionDate, editorial, authors);
		this.isbn = isbn;
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String isReaded() {

		String leido = "";
		
		if (readed == true) {
			leido = "S�";
		} else {
			leido = "No";
		}
		
		return leido;
	}

	public void setReaded(boolean readed) {
		this.readed = readed;
	}

	public int getTimeReaded() {
		return timeReaded;
	}

	public void setTimeReaded(int timeReaded) {
		this.timeReaded = timeReaded;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String data = " :: BOOKS :: "                       +
	                  "\nTitle: "        + getTitle()       +
	                  "\nEdition Date: " + getEditionDate() +
	                  "\nEditorial: "    + getEditorial()   +
	                  "\nISBN: "         + getIsbn()        +
	                  "\nAuthors: ";

		for(String author : getAuthors()) {
			data += "\n" + author;
		}

		return data;
	}

	@Override
	public Date startToSee(Date dateI) {
		// TODO Auto-generated method stub
		return dateI;
	}

	@Override
	public void stopToSee(Date dateI, Date dateF) {
		// TODO Auto-generated method stub

		if (dateF.getTime() > dateI.getTime()) {
			setTimeReaded((int) (dateF.getTime() - dateI.getTime()));
		} else {
			setTimeReaded(0);
		}
	}

	public static ArrayList<Book> makeBookList () {

		ArrayList<Book> books = new ArrayList<>();

		String author[] = new String[2];
		author[0] = "Autor 1";
		author[1] = "Autor 2";

		for (int i = 1; i <= 5; i++) {
			books.add(new Book(("Libro " + i), new Date(), ("Editorial " + i), author, ("Isbn " + i)));
		}

		return books;

	}

}