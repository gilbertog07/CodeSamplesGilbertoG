package com.gilbertog.profesoresplatzi.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gilbertog.profesoresplatzi.dao.RedSocialDao;
import com.gilbertog.profesoresplatzi.model.ProfesorRed;
import com.gilbertog.profesoresplatzi.model.RedSocial;

@Service("redSocialService")
@Transactional
public class RedSocialServiceImpl implements RedSocialService {

	@Autowired
	private RedSocialDao _redSocialDao;
	
	@Override
	public void salvarRedSocial(RedSocial redsocial) {
		// TODO Auto-generated method stub
		_redSocialDao.salvarRedSocial(redsocial);
	}

	@Override
	public List<RedSocial> buscarRedSocial() {
		// TODO Auto-generated method stub
		return _redSocialDao.buscarRedSocial();
	}

	@Override
	public void borrarRedSocial(Long id_redsocial) {
		// TODO Auto-generated method stub
		_redSocialDao.borrarRedSocial(id_redsocial);
	}

	@Override
	public void actualizarRedSocial(RedSocial redsocial) {
		// TODO Auto-generated method stub
		_redSocialDao.actualizarRedSocial(redsocial);
	}

	@Override
	public RedSocial buscarRedSocialPorId(Long id_redsocial) {
		// TODO Auto-generated method stub
		return _redSocialDao.buscarRedSocialPorId(id_redsocial);
	}

	@Override
	public RedSocial buscarRedSocialPorNombre(String name) {
		// TODO Auto-generated method stub
		return _redSocialDao.buscarRedSocialPorNombre(name);
	}

	@Override
	public ProfesorRed buscarRedSocialPorIdYNombre(Long id_redsocial, String nickname) {
		// TODO Auto-generated method stub
		return _redSocialDao.buscarRedSocialPorIdYNombre(id_redsocial, nickname);
	}

	@Override
	public ProfesorRed buscarRedSocialPorIdProfesorYIdRedSocial(Long id_profesor, Long id_redsocial) {
		// TODO Auto-generated method stub
		return _redSocialDao.buscarRedSocialPorIdProfesorYIdRedSocial(id_profesor, id_redsocial);
	}

}