package com.gilbertog.profesoresplatzi.dao;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.gilbertog.profesoresplatzi.model.Profesor;
import com.gilbertog.profesoresplatzi.model.ProfesorRed;

@Repository
@Transactional
public class ProfesorDaoImpl extends AbstractSession implements ProfesorDao {

	@Override
	public void salvarProfesor(Profesor profesor) {

		getSession().persist(profesor);

	}

	@Override
	public List<Profesor> buscarProfesores() {

		return getSession().createQuery("from Profesor").list();

	}

	@Override
	public void borrarProfesor(Long id_profesor) {
		// TODO Auto-generated method stub
		Profesor profesor = buscarProfesorPorId(id_profesor);

		if (profesor != null) {
			
			//Se crea un objeto Iterator, el cual nos servira para recorrer las redes sociales ligadas a un determinado profesor
			//Se recorre este iterador para ir registro por registro eliminando cada red social del profesor que se esta eliminando.
			Iterator<ProfesorRed> i = profesor.getProfesorred().iterator();
			
			while (i.hasNext()) {

				ProfesorRed profesorRed = i.next();
				i.remove();
				getSession().delete(profesorRed);
				
			}

			profesor.getProfesorred().clear();
			getSession().delete(profesor);

		}
	}

	@Override
	public void actualizarProfesor(Profesor profesor) {
		// TODO Auto-generated method stub
		getSession().update(profesor);
	}

	@Override
	public Profesor buscarProfesorPorId(Long id_profesor) {
		// TODO Auto-generated method stub
		return (Profesor) getSession().get(Profesor.class, id_profesor);
	}

	@Override
	public Profesor buscarProfesorPorNombre(String name) {
		// TODO Auto-generated method stub
		return (Profesor) getSession().createQuery("from Profesor where nombre = :nombre").setParameter("nombre", name).uniqueResult();
	}

}