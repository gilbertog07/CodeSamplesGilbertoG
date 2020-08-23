package com.gilbertog.profesoresplatzi.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="profesor")
public class Profesor implements Serializable {

	@Id
	@Column(name="id_profesor")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_Profesor;

	@Column(name="nombre")
	private String nombre;

	@Column(name="avatar")
	private String avatar;

	@OneToMany(mappedBy = "profesor") //indica el nombre de la entidad en la clase hija (curso) que los está uniendo
	@JsonIgnore
	private Set<Curso> cursos;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL) //cascade: que si se afecta (borra) los registros de esta clase (tabla) que se afecten en cascada los de la clase relacionada
	@JoinColumn(name="id_profesor")
	private Set<ProfesorRed> profesorred;

	public Profesor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Profesor(String nombre, String avatar) {
		super();
		this.nombre = nombre;
		this.avatar = avatar;
	}

	public Long getId_Profesor() {
		return id_Profesor;
	}

	public void setId_profesor(Long id_Profesor) {
		this.id_Profesor = id_Profesor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Set<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}

	public Set<ProfesorRed> getProfesorred() {
		return profesorred;
	}

	public void setProfesorred(Set<ProfesorRed> profesorred) {
		this.profesorred = profesorred;
	}

}