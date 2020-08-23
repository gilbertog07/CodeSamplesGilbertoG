package com.gilbertog.profesoresplatzi.service;

import java.util.List;

import com.gilbertog.profesoresplatzi.model.Curso;

public interface CursoService {

	void salvarCurso(Curso curso);

	List<Curso> buscarCursos();

	void borrarCurso(Long id_curso);

	void actualizarCurso(Curso curso);
	
	Curso buscarCursoPorId(Long id_curso);

	Curso buscarCursoPorNombre(String name);
	
	List<Curso> buscarCursoPorProfesorId (Long id_profesor);

}