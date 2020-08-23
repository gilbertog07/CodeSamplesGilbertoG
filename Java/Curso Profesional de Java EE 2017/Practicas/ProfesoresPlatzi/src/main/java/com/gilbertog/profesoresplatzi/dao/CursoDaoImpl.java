package com.gilbertog.profesoresplatzi.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.gilbertog.profesoresplatzi.model.Curso;

@Repository
@Transactional
public class CursoDaoImpl extends AbstractSession implements CursoDao {

	@Override
	public void salvarCurso(Curso curso) {
		// TODO Auto-generated method stub
		getSession().persist(curso);
	}

	@Override
	public List<Curso> buscarCursos() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Curso").list();
	}

	@Override
	public void borrarCurso(Long id_curso) {
		// TODO Auto-generated method stub
		Curso curso = buscarCursoPorId(id_curso);

		if (curso != null) {
			getSession().delete(curso);
		}
	}

	@Override
	public void actualizarCurso(Curso curso) {
		// TODO Auto-generated method stub
		getSession().update(curso);
	}

	@Override
	public Curso buscarCursoPorId(Long id_curso) {
		// TODO Auto-generated method stub
		return (Curso) getSession().get(Curso.class, id_curso);
	}

	@Override
	public Curso buscarCursoPorNombre(String name) {
		// TODO Auto-generated method stub
		return (Curso) getSession().createQuery("from Curso where nombre = :nombre").setParameter("nombre", name).uniqueResult();
	}

	@Override
	public List<Curso> buscarCursoPorProfesorId(Long id_profesor) {
		// TODO Auto-generated method stub
		// Se realiza un join de Curso con Profesor, a traves del atributo "profesor" que se encuentra en la clase "Curso", ya que el atributo "profesor"
        // hace referencia a la clase Profesor
		return (List<Curso>) getSession().createQuery(
				"from Curso c join c.profesor t where t.id_Profesor = :id_Profesor").setParameter("id_Profesor", id_profesor).list();
	}

}