package com.gilbertog.amazonviewer.model;

import java.util.ArrayList;

public class Serie extends Film {

	private int id;
	private int sessionQuantity;
	private ArrayList<Chapter> chapters;

	public Serie(String title, String genre, String creator, int duration, int sessionQuantity) {
		super(title, genre, creator, duration);
		setSessionQuantity(sessionQuantity);;
	}

	public int getId() {
		return id;
	}

	public int getSessionQuantity() {
		return sessionQuantity;
	}

	public void setSessionQuantity(int sessionQuantity) {
		this.sessionQuantity = sessionQuantity;
	}

	public ArrayList<Chapter> getChapters() {
		return chapters;
	}

	public void setChapters(ArrayList<Chapter> chapters) {
		this.chapters = chapters;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String data = " :: SERIES :: "                              +
				      "\nTitle: "            + getTitle()           +
	                  "\nGenre: "            + getGenre()           +
	                  "\nCreator: "          + getCreator()         +
	                  "\nDuration: "         + getDuration()        +
	                  "\nSession Quantity: " + getSessionQuantity() +
	                  "\nChapters: ";

		for(Chapter chapter : getChapters()) {
			data += "\n" + chapter;
		}

		return data;
	}

	public static ArrayList<Serie> makeSeriesList () {

		ArrayList<Serie> series = new ArrayList<>();

		for (int i = 1; i <= 7; i++) {
			Serie serie = new Serie(("Serie " + i), ("Genero " + i), ("Creador " + i), 20, i);
			serie.setChapters(Chapter.makeChaptersList(serie));
			series.add(serie);
		}

		return series;

	}

	@Override
	public void view() {
		// TODO Auto-generated method stub
		setViewed(true);
	}

}