package org.yeraygarcia.hibernate.airlines.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.yeraygarcia.hibernate.airlines.HibernateSession;
import org.yeraygarcia.hibernate.airlines.models.Aircraft;

public class AircraftDAO implements AircraftDAOInterface {

	public  List<Aircraft> selectAll() {
		 SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		    Session session = sessionFactory.openSession();
		 
		    List<Aircraft> aircrafts = session.createQuery("from Aircraft").list();
		    
		    session.close();
		    return aircrafts;
	}

	public void insert(Aircraft aircraft) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	 
	    session.persist(aircraft);    
	    
	    session.getTransaction().commit();	         
	    session.close();

		
	}

}
