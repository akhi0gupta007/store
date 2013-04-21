package com.akhi.store.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateUtil {

	private SessionFactory sessionFactory;

	@Autowired
	public HibernateUtil(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	
		
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	public String toString() {
		return "HibernateUtil [sessionFactory=" + sessionFactory + "]";
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
