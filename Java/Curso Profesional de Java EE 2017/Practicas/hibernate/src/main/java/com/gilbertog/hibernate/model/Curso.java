package com.gilbertog.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="curso")
public class Curso implements Serializable {

	@Id
	@Column(name="id_curso")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_Curso;

	@Column(name="nombre")
	private String nombre;

	@Column(name="tema")
	private String tema;
	
	@Column(name="proyecto")
	private String proyecto;

	@ManyToOne(optional=true, fetch = FetchType.EAGER) //optional: se puede tener curso sin profesor fetch: forzar que al momento de traer cursos se traigan los datos del profesor
	@JoinColumn(name="id_profesor")
	private Profesor profesor;

	public Curso() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Curso(String nombre, String tema, String proyecto) {
		super();
		this.nombre = nombre;
		this.tema = tema;
		this.proyecto = proyecto;
	}

	public Long getId_Curso() {
		return id_Curso;
	}

	public void setId_Curso(Long id_Curso) {
		this.id_Curso = id_Curso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getProyecto() {
		return proyecto;
	}

	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

}