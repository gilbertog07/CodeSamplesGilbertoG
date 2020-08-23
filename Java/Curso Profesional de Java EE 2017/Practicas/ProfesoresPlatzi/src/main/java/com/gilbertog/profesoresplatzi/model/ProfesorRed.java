package com.gilbertog.profesoresplatzi.model;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

/** 
 * Esta clase se tuvo que crear y mapear, debido a que tiene un campo adicional de nickname el cual no forma parte de la llave,
 * si este no hubiese sido el caso no hubiese existido la necesidad de crear la clase.
 * 
 * */

@Entity
@Table(name="profesor_red")
public class ProfesorRed implements Serializable {

	@Id
	@Column(name="id_profesor_red")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_ProfesorRed; // al ser definido con un tipo objeto, la variable se realiza como upper camel case

	@Column(name="nickname")
	private String nickname;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_profesor")
	@JsonIgnore
	private Profesor profesor;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_red")
	private RedSocial redsocial;

	public ProfesorRed() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ProfesorRed(Profesor profesor, RedSocial redsocial, String nickname) {
		super();
		this.profesor = profesor;
		this.redsocial = redsocial;
		this.nickname = nickname;
	}

	public Long getId_ProfesorRed() {
		return id_ProfesorRed;
	}

	public void setId_ProfesorRed(Long id_ProfesorRed) {
		this.id_ProfesorRed = id_ProfesorRed;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public RedSocial getRedsocial() {
		return redsocial;
	}

	public void setRedsocial(RedSocial redsocial) {
		this.redsocial = redsocial;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}