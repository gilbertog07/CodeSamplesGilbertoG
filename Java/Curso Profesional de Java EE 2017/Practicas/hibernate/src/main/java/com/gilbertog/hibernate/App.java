package com.gilbertog.hibernate;

import java.util.List;

import com.gilbertog.hibernate.dao.ProfesorDaoImpl;
import com.gilbertog.hibernate.model.Profesor;

/**
 * Hello world!
 *
 */
public class App 
{

	public static void main( String[] args )
    {

		//Profesor profesor = new Profesor("Gilberto Guerrero", "MiAvatar");
		ProfesorDaoImpl profesorDaoImp = new ProfesorDaoImpl();
		//profesorDaoImp.salvarProfesor(profesor);

		List<Profesor> profesores = profesorDaoImp.buscarProfesores();

		for (Profesor p : profesores) {
			System.out.println("Nombre: " + p.getNombre());
		}

    }

}