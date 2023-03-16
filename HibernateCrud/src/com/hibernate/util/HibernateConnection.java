package com.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConnection {

	public static SessionFactory factory = null;
	public static Session session = null;

	static {
		factory = new Configuration().configure().buildSessionFactory();
	}

	public static Session getSession() {

		if (factory != null) {

			session = factory.openSession();
		}
		return session;
	}

	public static void closeConnection(Session s) {

		if (s != null) {
			s.close();
			factory.close();
		}

	}

}
