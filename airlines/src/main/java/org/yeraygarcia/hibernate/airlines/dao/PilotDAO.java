package org.yeraygarcia.hibernate.airlines.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.yeraygarcia.hibernate.airlines.HibernateSession;
import org.yeraygarcia.hibernate.airlines.models.Pilot;

public class PilotDAO implements PilotDAOInterface {

	public List<Pilot> selectAll() {
		 SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		    Session session = sessionFactory.openSession();
		 
		    List<Pilot> pilots = session.createQuery("from Pilot").list();
		    
		    session.close();
		    return pilots;
	}

	public void insert(Pilot pilot) {
		 SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		    Session session = sessionFactory.openSession();
		    session.beginTransaction();
		
		    session.persist(pilot);
		         
		    session.getTransaction().commit();
		    session.close();
		
	}

}
