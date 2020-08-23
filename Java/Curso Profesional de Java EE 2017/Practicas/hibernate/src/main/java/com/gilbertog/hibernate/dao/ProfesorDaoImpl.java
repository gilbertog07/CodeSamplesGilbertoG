package com.gilbertog.hibernate.dao;

import java.util.List;

import com.gilbertog.hibernate.model.Profesor;

public class ProfesorDaoImpl implements ProfesorDao {

	private PlatziSession platziSession;

	public ProfesorDaoImpl() {

		platziSession = new PlatziSession();

	}

	@Override
	public void salvarProfesor(Profesor profesor) {

		platziSession.getSession().persist(profesor); //es lo mismo que save, la documentación de Hibernate recomienda persist
		platziSession.getSession().getTransaction().commit();
		platziSession.getSession().close();

	}

	@Override
	public List<Profesor> buscarProfesores() {

		return platziSession.getSession().createQuery("from Profesor").list();

	}

	@Override
	public void borrarProfesor(Long id_profesor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarProfesor(Profesor profesor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Profesor buscarProfesorPorId(Long id_profesor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Profesor buscarProfesorPorNombre(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}