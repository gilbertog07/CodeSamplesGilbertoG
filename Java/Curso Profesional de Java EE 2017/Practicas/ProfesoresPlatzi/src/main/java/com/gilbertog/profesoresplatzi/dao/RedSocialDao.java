package com.gilbertog.profesoresplatzi.dao;

import java.util.List;

import com.gilbertog.profesoresplatzi.model.ProfesorRed;
import com.gilbertog.profesoresplatzi.model.RedSocial;

public interface RedSocialDao {

	void salvarRedSocial(RedSocial redsocial);

	List<RedSocial> buscarRedSocial();

	void borrarRedSocial(Long id_redsocial);

	void actualizarRedSocial(RedSocial redsocial);

	RedSocial buscarRedSocialPorId(Long id_redsocial);

	RedSocial buscarRedSocialPorNombre(String name);

	ProfesorRed buscarRedSocialPorIdYNombre (Long id_redsocial, String nickname);

	ProfesorRed buscarRedSocialPorIdProfesorYIdRedSocial (Long id_profesor, Long id_redsocial);
	
}