package com.gilbertog.profesoresplatzi.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.gilbertog.profesoresplatzi.model.ProfesorRed;
import com.gilbertog.profesoresplatzi.model.RedSocial;

@Repository
@Transactional
public class RedSocialDaoImpl extends AbstractSession implements RedSocialDao {

	@Override
	public void salvarRedSocial(RedSocial redsocial) {
		// TODO Auto-generated method stub
		getSession().persist(redsocial);
	}

	@Override
	public List<RedSocial> buscarRedSocial() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from RedSocial").list();
	}

	@Override
	public void borrarRedSocial(Long id_redsocial) {
		// TODO Auto-generated method stub
		RedSocial redsocial = buscarRedSocialPorId(id_redsocial);
		if (redsocial != null) {
			getSession().delete(redsocial);
		}
	}

	@Override
	public void actualizarRedSocial(RedSocial redsocial) {
		// TODO Auto-generated method stub
		getSession().update(redsocial);
	}

	@Override
	public RedSocial buscarRedSocialPorId(Long id_redsocial) {
		// TODO Auto-generated method stub
		return (RedSocial) getSession().get(RedSocial.class, id_redsocial);
	}

	@Override
	public RedSocial buscarRedSocialPorNombre(String name) {
		// TODO Auto-generated method stub
		return (RedSocial) getSession().createQuery("from RedSocial where nombre = :nombre").setParameter("nombre", name).uniqueResult();
	}

	@Override
	public ProfesorRed buscarRedSocialPorIdYNombre(Long id_redsocial, String nickname) {

		// TODO Auto-generated method stub
		List<Object[]> objects = getSession().createQuery(
				"from ProfesorRed prs join prs.redsocial rs "
				+ "where rs.id_Red = :id_Red and prs.nickname = :nickname")
				.setParameter("id_Red", id_redsocial)
				.setParameter("nickname", nickname).list();
		
		if (objects.size() > 0) {
			for (Object[] objects2 : objects) {
				for (Object object : objects2) {
					if (object instanceof ProfesorRed) {
						return (ProfesorRed) object;
					}
				}
			}
		}
		
		return null;

	}

	@Override
	public ProfesorRed buscarRedSocialPorIdProfesorYIdRedSocial(Long id_profesor, Long id_redsocial) {
		// TODO Auto-generated method stub

		List<Object[]> objs = getSession().createQuery(
				"from ProfesorRed tsm join tsm.redsocial sm "
				+ "join tsm.profesor t where sm.id_Red = :id_Red "
				+ "and t.id_Profesor = :id_Profesor")
				.setParameter("id_Red", id_redsocial)
				.setParameter("id_Profesor", id_profesor).list();
		
		if (objs.size()>0) {
			for (Object[] objects : objs) {
				for (Object object : objects) {
					if (object instanceof ProfesorRed) {
						return (ProfesorRed) object;
					}
				}
			}
		}

		return null;
	}
	
}