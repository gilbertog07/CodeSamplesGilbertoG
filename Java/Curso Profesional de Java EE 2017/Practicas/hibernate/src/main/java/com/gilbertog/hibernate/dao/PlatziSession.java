package com.gilbertog.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PlatziSession {

	private Session session;

	public PlatziSession() {

		//Flujo de creacion de la sesion a la BD
        Configuration configuracion = new Configuration();
        configuracion.configure();
        SessionFactory sessionFactory = configuracion.buildSessionFactory();
        session = sessionFactory.openSession();
        session.beginTransaction();

	}

	public Session getSession() {

		return session;

	}

}