package com.gilbertog.amazonviewer.model;

import java.util.Date;

public class Magazine extends Publication {

	private int id;

	public Magazine(String title, Date editionDate, String editorial, String[] authors) {
		super(title, editionDate, editorial, authors);
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String data = " :: MAGAZINES :: "                   +
                      "\nTitle: "        + getTitle()       +
	                  "\nEdition Date: " + getEditionDate() +
	                  "\nEditorial: "    + getEditorial()   +
	                  "\nAuthors: ";

		for(String author : getAuthors()) {
			data += "\n" + author;
		}

		return data;
	}

}