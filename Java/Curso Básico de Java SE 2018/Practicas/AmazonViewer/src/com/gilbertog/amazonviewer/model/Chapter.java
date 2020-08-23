package com.gilbertog.amazonviewer.model;

import java.util.ArrayList;

public class Chapter extends Movie {

	private int id;
	private int sessionNumber;

	public Chapter(String title, String genre, String creator, int duration, short year, int sessionNumber) {
		super(title, genre, creator, duration, year);
		this.sessionNumber = sessionNumber;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	public int getSessionNumber() {
		return sessionNumber;
	}

	public void setSessionNumber(int sessionNumber) {
		this.sessionNumber = sessionNumber;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " :: CHAPTERS :: "             +
               "\nTitle: "    + getTitle()    +
               "\nGenre: "    + getGenre()    +
               "\nCreator: "  + getCreator()  +
               "\nDuration: " + getDuration() +
               "\nYear: "     + getYear();
	}

	public static ArrayList<Chapter> makeChaptersList () {

		ArrayList<Chapter> chapters = new ArrayList<>();

		for (int i = 1; i <= 10; i++) {
			chapters.add(new Chapter(("Capitulo " + i), ("Genero " + i), ("Creador " + i), 60, (short) 2020, i));
		}

		return chapters;
		
	}

}