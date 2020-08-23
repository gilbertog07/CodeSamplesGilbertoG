package com.gilbertog.profesoresplatzi.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gilbertog.profesoresplatzi.dao.ProfesorDao;
import com.gilbertog.profesoresplatzi.model.Profesor;

@Service("profesorService")
@Transactional
public class ProfesorServiceImpl implements ProfesorService {

	@Autowired
	private ProfesorDao _profesorDao;
	
	@Override
	public void salvarProfesor(Profesor profesor) {
		// TODO Auto-generated method stub
		_profesorDao.salvarProfesor(profesor);
	}

	@Override
	public List<Profesor> buscarProfesores() {
		// TODO Auto-generated method stub
		return _profesorDao.buscarProfesores();
	}

	@Override
	public void borrarProfesor(Long id_profesor) {
		// TODO Auto-generated method stub
		_profesorDao.borrarProfesor(id_profesor);
	}

	@Override
	public void actualizarProfesor(Profesor profesor) {
		// TODO Auto-generated method stub
		_profesorDao.actualizarProfesor(profesor);
	}

	@Override
	public Profesor buscarProfesorPorId(Long id_profesor) {
		// TODO Auto-generated method stub
		return _profesorDao.buscarProfesorPorId(id_profesor);
	}

	@Override
	public Profesor buscarProfesorPorNombre(String name) {
		// TODO Auto-generated method stub
		return _profesorDao.buscarProfesorPorNombre(name);
	}

}