package com.gilbertog.profesoresplatzi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.gilbertog.profesoresplatzi.model.RedSocial;
import com.gilbertog.profesoresplatzi.service.RedSocialService;
import com.gilbertog.profesoresplatzi.utils.ValidateData;

@Controller
@RequestMapping("/v1")
public class RedSocialController extends ValidateData {

	@Autowired
	RedSocialService _redSocialService;

	//GET
	@RequestMapping(value="/redSocial", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<RedSocial>> getRedSocial(@RequestParam(value="nombre", required = false) String name) {

		List<RedSocial> redSocial = new ArrayList<>();

		if (name == null) {

			redSocial = _redSocialService.buscarRedSocial();

			if (redSocial.isEmpty()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<List<RedSocial>>(redSocial, HttpStatus.OK);

		} else {
			RedSocial redSocial1 = _redSocialService.buscarRedSocialPorNombre(name);
			
			if (redSocial1 == null) {
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			}

			redSocial.add(redSocial1);
			return new ResponseEntity<List<RedSocial>>(redSocial, HttpStatus.OK);

		}

	}
	
	//GET
	@RequestMapping(value="/redSocial/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<RedSocial> getRedSocialPorId(@PathVariable("id") Long id_redSocial) {

		ResponseEntity<RedSocial> validar = validaIdRedSocial(id_redSocial);

		if (validar != null) {
			return validar;
		}

		RedSocial redSocial = _redSocialService.buscarRedSocialPorId(id_redSocial);
		if (redSocial == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		
		return new ResponseEntity<RedSocial>(redSocial,HttpStatus.OK);

	}
	
	
	//POST
	@RequestMapping(value="/redSocial", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createRedSocial(@RequestBody RedSocial redSocial, UriComponentsBuilder uriComponentBuilder) {
		
		ResponseEntity<RedSocial> validar = validaNombreRedSocial(redSocial.getNombre());

		if (validar != null) {
			return validar;
		}

		if (_redSocialService.buscarRedSocialPorNombre(redSocial.getNombre()) != null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		_redSocialService.salvarRedSocial(redSocial);
		RedSocial redSocial2 = _redSocialService.buscarRedSocialPorNombre(redSocial.getNombre());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(
				uriComponentBuilder
				.path("/v1/redSocial/{id}")
				.buildAndExpand(redSocial2.getId_Red())
				.toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}
	
	//PATCH (Update)
	@RequestMapping(value="/redSocial/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<RedSocial> updateRedSocial(@PathVariable("id") Long id_redSocial, @RequestBody RedSocial redSocial) {

		ResponseEntity<RedSocial> validar = validaIdRedSocial(id_redSocial);

		if (validar != null) {
			return validar;
		}

		RedSocial currentRedSocial = _redSocialService.buscarRedSocialPorId(id_redSocial);
		
		if (currentRedSocial == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		currentRedSocial.setNombre(redSocial.getNombre());
		currentRedSocial.setIcono(redSocial.getIcono());

		_redSocialService.actualizarRedSocial(currentRedSocial);
        return new ResponseEntity<RedSocial>(currentRedSocial, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value="/redSocial/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<RedSocial> deleteRedSocial(@PathVariable("id") Long id_redSocial) {

		ResponseEntity<RedSocial> validar = validaIdRedSocial(id_redSocial);

		if (validar != null) {
			return validar;
		}

		RedSocial redSocial = _redSocialService.buscarRedSocialPorId(id_redSocial);
		
		if (redSocial == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		_redSocialService.borrarRedSocial(id_redSocial);
		return new ResponseEntity<RedSocial>(redSocial, HttpStatus.OK);

	}

}