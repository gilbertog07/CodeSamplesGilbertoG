package com.gilbertog.profesoresplatzi.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gilbertog.profesoresplatzi.dao.CursoDao;
import com.gilbertog.profesoresplatzi.model.Curso;

@Service("cursoService")
@Transactional
public class CursoServiceImpl implements CursoService {

	@Autowired
	private CursoDao _cursoDao;
	
	@Override
	public void salvarCurso(Curso curso) {
		// TODO Auto-generated method stub
		_cursoDao.salvarCurso(curso);
	}

	@Override
	public List<Curso> buscarCursos() {
		// TODO Auto-generated method stub
		return _cursoDao.buscarCursos();
	}

	@Override
	public void borrarCurso(Long id_curso) {
		// TODO Auto-generated method stub
		_cursoDao.borrarCurso(id_curso);
	}

	@Override
	public void actualizarCurso(Curso curso) {
		// TODO Auto-generated method stub
		_cursoDao.actualizarCurso(curso);
	}

	@Override
	public Curso buscarCursoPorId(Long id_curso) {
		// TODO Auto-generated method stub
		return _cursoDao.buscarCursoPorId(id_curso);
	}

	@Override
	public Curso buscarCursoPorNombre(String name) {
		// TODO Auto-generated method stub
		return _cursoDao.buscarCursoPorNombre(name);
	}

	@Override
	public List<Curso> buscarCursoPorProfesorId(Long id_profesor) {
		// TODO Auto-generated method stub
		return _cursoDao.buscarCursoPorProfesorId(id_profesor);
	}

}