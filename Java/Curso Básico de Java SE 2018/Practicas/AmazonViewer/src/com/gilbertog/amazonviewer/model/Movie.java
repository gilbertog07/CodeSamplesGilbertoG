package com.gilbertog.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

public class Movie extends Film implements IVisualizable { // Esta se convirtió en subclase de la clase Film

	private int id;
	private int timeViewed;

	public Movie(String title, String genre, String creator, int duration, short year) {
		super(title, genre, creator, duration);
		setYear(year);
	}

	public int getId() {
		return id;
	}

	public int getTimeViewed() {
		return timeViewed;
	}

	public void setTimeViewed(int timeViewed) {
		this.timeViewed = timeViewed;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " :: MOVIES :: "               +
			   "\nTitle: "    + getTitle()    +
               "\nGenre: "    + getGenre()    +
               "\nCreator: "  + getCreator()  +
               "\nDuration: " + getDuration() +
               "\nYear: "     + getYear();
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
			setTimeViewed((int) (dateF.getTime() - dateI.getTime()));
		} else {
			setTimeViewed(0);
		}

	}

	public static ArrayList<Movie> makeMoviesList () {

		ArrayList<Movie> movies = new ArrayList<>();

		for (int i = 1; i <= 5; i++) {
			movies.add(new Movie(("Movie " + i), ("Genero " + i), ("Creador " + i), 120, (short) 2017));
		}

		return movies;
		
	}
	
}