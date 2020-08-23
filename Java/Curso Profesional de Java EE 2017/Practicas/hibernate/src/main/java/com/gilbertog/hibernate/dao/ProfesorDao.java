package com.gilbertog.hibernate.dao;

import java.util.List;

import com.gilbertog.hibernate.model.Profesor;

public interface ProfesorDao {

	void salvarProfesor(Profesor profesor);

	List<Profesor> buscarProfesores();

	void borrarProfesor(Long id_profesor);

	void actualizarProfesor(Profesor profesor);

	Profesor buscarProfesorPorId(Long id_profesor);

	Profesor buscarProfesorPorNombre(String name);

}