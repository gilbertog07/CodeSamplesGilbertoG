package com.gilbertog.profesoresplatzi.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.gilbertog.profesoresplatzi.model.RedSocial;

public abstract class ValidateData {

	protected ResponseEntity<RedSocial> validaIdRedSocial(Long id_redSocial) {
		if (id_redSocial == null || id_redSocial <= 0) {
			return new ResponseEntity(new CustomErrorType("El Id de la Red Social es Requerido"), HttpStatus.CONFLICT);
		}
		
		return null;
	}

	protected ResponseEntity<RedSocial> validaNombreRedSocial(String nombre) {
		if (nombre.equals(null) || nombre.isEmpty()) {
			return new ResponseEntity(new CustomErrorType("El Nombre de la Red Social es Requerido"), HttpStatus.CONFLICT);
		}
		
		return null;
	}
	
}