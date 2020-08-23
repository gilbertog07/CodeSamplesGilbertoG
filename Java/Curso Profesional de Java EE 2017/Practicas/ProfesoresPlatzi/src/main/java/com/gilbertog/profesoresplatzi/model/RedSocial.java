package com.gilbertog.profesoresplatzi.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="red_social")
public class RedSocial implements Serializable {

	@Id
	@Column(name="id_red")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_Red;

	@Column(name="nombre")
	private String nombre;

	@Column(name="icono")
	private String icono;

	@OneToMany
	@JoinColumn(name="id_red")
	@JsonIgnore
	private Set<ProfesorRed> profesorred;

	public RedSocial() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RedSocial(String nombre, String icono) {
		super();
		this.nombre = nombre;
		this.icono = icono;
	}

	public Long getId_Red() {
		return id_Red;
	}

	public void setId_Red(Long id_Red) {
		this.id_Red = id_Red;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public Set<ProfesorRed> getProfesorred() {
		return profesorred;
	}

	public void setProfesorred(Set<ProfesorRed> profesorred) {
		this.profesorred = profesorred;
	}
	
}