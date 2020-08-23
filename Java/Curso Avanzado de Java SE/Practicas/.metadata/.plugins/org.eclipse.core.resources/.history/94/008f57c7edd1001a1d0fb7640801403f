package com.gilbertog.makereport;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Report {

	private String namefile;
	private String content;
	private String title;
    private String extension;

	public String getNamefile() {
		return namefile;
	}
	public void setNamefile(String namefile) {
		this.namefile = namefile;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}

	public void makeReport() {
		if ((getNamefile() != null) && (getTitle() != null) && (getContent() != null)) {
			// Crear el archivo
			try {
				File file = new File(getNamefile() + "." + getExtension());
				FileOutputStream fos;
				fos = new FileOutputStream(file);
				OutputStreamWriter osw = new OutputStreamWriter(fos);
				BufferedWriter br = new BufferedWriter(osw);
				br.write(getContent());
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Ingrese los datos del archivo");
		}
	}

}