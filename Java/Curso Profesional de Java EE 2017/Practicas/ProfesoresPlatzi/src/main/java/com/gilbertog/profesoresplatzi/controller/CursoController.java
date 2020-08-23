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

import com.gilbertog.profesoresplatzi.model.Curso;
import com.gilbertog.profesoresplatzi.service.CursoService;

@Controller
@RequestMapping("/v1")
public class CursoController {

	@Autowired
	CursoService _cursoService;

	//GET
	@RequestMapping(value="/cursos", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Curso>> getCurso(@RequestParam(value="nombre", required = false) String name) {
		
		List<Curso> curso = new ArrayList<>();
		
		if (name == null) {

			curso = _cursoService.buscarCursos();

			if (curso.isEmpty()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<List<Curso>>(curso, HttpStatus.OK);			

		} else {

			Curso curso1 = _cursoService.buscarCursoPorNombre(name);
			
			if (curso1 == null) {
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			}

			curso.add(curso1);
			return new ResponseEntity<List<Curso>>(curso, HttpStatus.OK);
			
		}
		
	}

	//GET
	@RequestMapping(value="/cursos/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Curso> getCursoPorId(@PathVariable("id") Long id_Curso) {

		Curso curso = _cursoService.buscarCursoPorId(id_Curso);
		
		if (curso == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Curso>(curso, HttpStatus.OK);

	}

	//POST
	@RequestMapping(value="/cursos", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createCurso(@RequestBody Curso curso, UriComponentsBuilder uriComponentBuilder) {
		
		if (_cursoService.buscarCursoPorNombre(curso.getNombre()) != null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT); 
		}
		
		_cursoService.salvarCurso(curso);
		Curso curso2 = _cursoService.buscarCursoPorNombre(curso.getNombre());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentBuilder
				.path("/v1/cursos/{id}")
				.buildAndExpand(curso2.getId_Curso())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.OK);

	}

	//PATCH
	@RequestMapping(value="/cursos/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Curso> updateCurso(@PathVariable("id") Long id_Curso, @RequestBody Curso curso) {
		
		Curso currentCurso = _cursoService.buscarCursoPorId(id_Curso);
		
		if (currentCurso == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT); 
		}
		
		currentCurso.setNombre(curso.getNombre());
		currentCurso.setTema(curso.getTema());
		currentCurso.setProyecto(curso.getProyecto());
		
		_cursoService.actualizarCurso(currentCurso);
		return new ResponseEntity<Curso>(currentCurso, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value="/cursos/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<Curso> deleteCurso(@PathVariable("id") Long id_Curso) {

		Curso curso = _cursoService.buscarCursoPorId(id_Curso);

		if (curso == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		_cursoService.borrarCurso(id_Curso);
		return new ResponseEntity<Curso>(curso, HttpStatus.OK);

	}

}