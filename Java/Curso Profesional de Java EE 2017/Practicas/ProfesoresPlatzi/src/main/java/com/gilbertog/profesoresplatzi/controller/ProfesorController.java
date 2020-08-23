package com.gilbertog.profesoresplatzi.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.gilbertog.profesoresplatzi.model.Profesor;
import com.gilbertog.profesoresplatzi.model.ProfesorRed;
import com.gilbertog.profesoresplatzi.model.RedSocial;
import com.gilbertog.profesoresplatzi.service.ProfesorService;
import com.gilbertog.profesoresplatzi.service.RedSocialService;
import com.gilbertog.profesoresplatzi.utils.CustomErrorType;

@Controller
@RequestMapping("/v1")
public class ProfesorController {

	@Autowired
	ProfesorService _profesorService;
	
	@Autowired
	private RedSocialService _redSocialService;
	

	//GET
	@RequestMapping(value="/profesores", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Profesor>> getProfesor(@RequestParam(value="nombre", required = false) String name) {

		List<Profesor> profesor = new ArrayList<>();

		if (name == null) {

			profesor = _profesorService.buscarProfesores();

			if (profesor.isEmpty()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<List<Profesor>>(profesor, HttpStatus.OK);			

		} else {

			Profesor profesor1 = _profesorService.buscarProfesorPorNombre(name);

			if (profesor1 == null) {
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			}

			profesor.add(profesor1);
			return new ResponseEntity<List<Profesor>>(profesor, HttpStatus.OK);

		}

	}

	//GET
	@RequestMapping(value="/profesores/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Profesor> getProfesorPorId(@PathVariable("id") Long id_Profesor) {
		
		Profesor profesor = _profesorService.buscarProfesorPorId(id_Profesor);
		
		if (profesor == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Profesor>(profesor, HttpStatus.OK);

	}

	//POST
	@RequestMapping(value="/profesores", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createProfesor(@RequestBody Profesor profesor, UriComponentsBuilder uriComponentBuilder) {

		if (_profesorService.buscarProfesorPorNombre(profesor.getNombre()) != null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		_profesorService.salvarProfesor(profesor);
		Profesor profesor2 = _profesorService.buscarProfesorPorNombre(profesor.getNombre());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentBuilder
				.path("/v1/profesores/{id}")
				.buildAndExpand(profesor2.getId_Profesor())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.OK);

	}

	//PATCH
	@RequestMapping(value="/profesores/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Profesor> updateProfesor(@PathVariable("id") Long id_Profesor, @RequestBody Profesor profesor) {
		
		Profesor currentProfesor = _profesorService.buscarProfesorPorId(id_Profesor);
		
		if (currentProfesor == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		currentProfesor.setNombre(profesor.getNombre());
		currentProfesor.setAvatar(profesor.getAvatar());
		
		_profesorService.actualizarProfesor(currentProfesor);
		return new ResponseEntity<Profesor>(currentProfesor, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value="/profesores/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<Profesor> deleteProfesor(@PathVariable("id") Long id_Profesor) {
		
		Profesor profesor = _profesorService.buscarProfesorPorId(id_Profesor);

		if (profesor == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		_profesorService.borrarProfesor(id_Profesor);
		return new ResponseEntity<Profesor>(profesor, HttpStatus.OK);

	}

	public static final String TEACHER_UPLOADED_FOLDER = "img/profesores/";

	//CREATE TEACHER IMAGE
	@RequestMapping(value="/profesores/image", method = RequestMethod.POST, headers = ("content-type=multipart/form-data"))
	public ResponseEntity<byte[]> uploadProfesorImagen(@RequestParam("id_Profesor") Long id_Profesor,
             @RequestParam("file") MultipartFile multipartFile,
             UriComponentsBuilder uriComponentBuilder) {
		
		if (id_Profesor == null) {
			return new ResponseEntity(new CustomErrorType("Por favor coloque el ID del profesor"), HttpStatus.NO_CONTENT);
		}
		
		if (multipartFile.isEmpty()) {
			return new ResponseEntity(new CustomErrorType("Por favor seleccione un archivo para subir"), HttpStatus.NO_CONTENT);
		}
		
		Profesor profesor = _profesorService.buscarProfesorPorId(id_Profesor);
		
		if (profesor == null) {
			return new ResponseEntity(new CustomErrorType("ID del Profesor " + id_Profesor + " No Encontrado"), HttpStatus.NO_CONTENT);
		}
		
		if (!profesor.getAvatar().isEmpty() || profesor.getAvatar() != null) {

			String filename = profesor.getAvatar();
			Path path = Paths.get(filename);
			File f = path.toFile();
			
			if (f.exists()) {
				f.delete();
			}
			
		}
		
		try {

			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			String dateName = dateFormat.format(date);
			
			String fileName = String.valueOf(id_Profesor) + "-imagenProfesor-" + dateName + "." + multipartFile.getContentType().split("/")[1];
			profesor.setAvatar(TEACHER_UPLOADED_FOLDER + fileName);
			
			byte[] bytes = multipartFile.getBytes();
			Path path = Paths.get(TEACHER_UPLOADED_FOLDER + fileName);
            Files.write(path, bytes);
            
            _profesorService.actualizarProfesor(profesor);
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity(new CustomErrorType("Error durante la carga del archivo " + multipartFile.getOriginalFilename()),HttpStatus.CONFLICT);
		}
	
	}

	//GET IMAGE
	@RequestMapping(value="/profesores/{id}/images", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getProfesorImagen(@PathVariable("id") Long id_Profesor) {
		
		if (id_Profesor == null) {
			return new ResponseEntity(new CustomErrorType("Por favor coloque el ID del profesor"), HttpStatus.NO_CONTENT);
		}
		
		Profesor profesor = _profesorService.buscarProfesorPorId(id_Profesor);
		
		if (profesor == null) {
			return new ResponseEntity(new CustomErrorType("ID del Profesor " + id_Profesor + " No Encontrado"), HttpStatus.NO_CONTENT);
		}

		try {

			String fileName = profesor.getAvatar();
			Path path = Paths.get(fileName);

			File f = path.toFile();

			if (!f.exists()) {
				return new ResponseEntity(new CustomErrorType("La imagen no existe"),HttpStatus.CONFLICT);
			}

			byte[] image = Files.readAllBytes(path);
			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity(new CustomErrorType("Error al mostrar la imagen"),HttpStatus.CONFLICT);
			
		}
		
	}
	
	//DELETE IMAGE
	@RequestMapping(value="/profesores/{id}/images", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteProfesorImagen(@PathVariable("id") Long id_Profesor) {
		
		if (id_Profesor == null) {
			return new ResponseEntity(new CustomErrorType("Por favor coloque el ID del profesor"), HttpStatus.NO_CONTENT);
		}
		
		Profesor profesor = _profesorService.buscarProfesorPorId(id_Profesor);
		
		if (profesor == null) {
			return new ResponseEntity(new CustomErrorType("ID del Profesor " + id_Profesor + " No Encontrado"), HttpStatus.NO_CONTENT);
		}
	
		if (profesor.getAvatar().isEmpty() || profesor.getAvatar() == null) {
			return new ResponseEntity(new CustomErrorType("El profesor no tiene imagen asignada"),HttpStatus.NO_CONTENT);
		}
		
		String fileName = profesor.getAvatar();
		
		Path path = Paths.get(fileName);
		File file = path.toFile();
		
		if (file.exists()) {
			file.delete();
		}
		
		profesor.setAvatar("");
		_profesorService.actualizarProfesor(profesor);
		return new ResponseEntity<Profesor>(HttpStatus.NO_CONTENT);

	}
	
	@RequestMapping(value="/profesores/redsocial", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<?> assignProfesorRedSocial(@RequestBody Profesor profesor, UriComponentsBuilder uriComponentBuilder) {
		

		if (profesor.getId_Profesor() == null) {
			return new ResponseEntity(new CustomErrorType("Se necesita el ID del profesor, red social y el nickname"), HttpStatus.NO_CONTENT);
		}

		Profesor profesorSalvado = _profesorService.buscarProfesorPorId(profesor.getId_Profesor());

		if (profesorSalvado == null) {
			return new ResponseEntity(new CustomErrorType("ID del Profesor: " + profesor.getId_Profesor() + " No Encontrado"), HttpStatus.NO_CONTENT);
		}

		if (profesor.getProfesorred().size() == 0) {
			return new ResponseEntity(new CustomErrorType("Se necesita el ID del profesor, red social y el nickname"), HttpStatus.NO_CONTENT);
		} else {
	
			Iterator<ProfesorRed> i = profesor.getProfesorred().iterator();
			
			while (i.hasNext()) {

				ProfesorRed profesorRed = i.next();
				
				if (profesorRed.getRedsocial().getId_Red() == null || profesorRed.getNickname() == null) {
					return new ResponseEntity(new CustomErrorType("Se necesita el ID del profesor, red social y el nickname"), HttpStatus.NO_CONTENT);
				} else {
					
					ProfesorRed profRedAux = _redSocialService.buscarRedSocialPorIdYNombre(profesorRed.getRedsocial().getId_Red(), profesorRed.getNickname());

					if (profRedAux != null 
							&& profesorRed.getRedsocial().getId_Red() == profRedAux.getRedsocial().getId_Red()
			                && profesorRed.getNickname().equals(profRedAux.getNickname())) {
						return new ResponseEntity(new CustomErrorType("El ID de la red social " + profesorRed.getRedsocial().getId_Red() + " " + 
								profesorRed.getNickname() + " ya existe"), HttpStatus.NO_CONTENT);
					}

					RedSocial redSocial = _redSocialService.buscarRedSocialPorId(profesorRed.getRedsocial().getId_Red());

					if (redSocial == null) {
						return new ResponseEntity(new CustomErrorType("El ID de la red social " + profesorRed.getRedsocial().getId_Red() + " no encontrado"), HttpStatus.NO_CONTENT);
					}
				
					profesorRed.setRedsocial(redSocial);
					profesorRed.setProfesor(profesorSalvado);
					
					if (profRedAux == null) {

						profesorSalvado.getProfesorred().add(profesorRed);

					} else {

						LinkedList<ProfesorRed> profesorRedesSoc = new LinkedList<>();
						
						profesorRedesSoc.addAll(profesorSalvado.getProfesorred());
						
						for (int j = 0; j < profesorRedesSoc.size(); j++) {
							ProfesorRed profesorRedesSoc2 = profesorRedesSoc.get(j);
							
							if (profesorRed.getProfesor().getId_Profesor() == profesorRedesSoc2.getProfesor().getId_Profesor()
									&&  profesorRed.getRedsocial().getId_Red() == profesorRedesSoc2.getRedsocial().getId_Red()) {

								profesorRedesSoc2.setNickname(profesorRed.getNickname());
								profesorRedesSoc.set(j, profesorRedesSoc2);

							} else {
								
								profesorRedesSoc.set(j, profesorRedesSoc2);
								
							}
							
						}

						profesorSalvado.getProfesorred().clear();
						profesorSalvado.getProfesorred().addAll(profesorRedesSoc);

					}

				}

			}

		}

		_profesorService.actualizarProfesor(profesorSalvado);
		return new ResponseEntity<Profesor>(profesorSalvado, HttpStatus.OK);

	}

}