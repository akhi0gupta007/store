package com.akhi.store.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.akhi.store.general.User;

@Repository
public class HibernateUtil implements DaoUtils
    {

    private SessionFactory sessionFactory;

    @Autowired
    public HibernateUtil(SessionFactory sessionFactory)
	{
	this.sessionFactory = sessionFactory;
	System.out.println("Session Factory: " + sessionFactory);
	//System.out.println("Session : "+ getSession());
	}

    public SessionFactory getSessionFactory()
	{
	return sessionFactory;
	}

    @Override
    public String toString()
	{
	return "HibernateUtil [sessionFactory=" + sessionFactory + "]";
	}

    @Override
    public Session getSession()
	{
	return sessionFactory.getCurrentSession();
	}

    @Override
    public void insertUser( User user )
	{
	getSession().save(user);

	}

    @Override
    public User getUser( long id )
	{
	return (User)getSession().get(User.class, id);
	}

    }
