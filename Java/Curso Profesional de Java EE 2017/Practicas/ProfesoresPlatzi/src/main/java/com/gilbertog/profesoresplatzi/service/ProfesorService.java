package com.gilbertog.profesoresplatzi.service;

import java.util.List;

import com.gilbertog.profesoresplatzi.model.Profesor;

public interface ProfesorService {

	void salvarProfesor(Profesor profesor);

	List<Profesor> buscarProfesores();

	void borrarProfesor(Long id_profesor);

	void actualizarProfesor(Profesor profesor);

	Profesor buscarProfesorPorId(Long id_profesor);

	Profesor buscarProfesorPorNombre(String name);

}