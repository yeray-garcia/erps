package org.yeraygarcia.hibernate.airlines.dao;

import java.util.List;

import org.yeraygarcia.hibernate.airlines.models.Pilot;



public interface PilotDAOInterface {
	public List<Pilot> selectAll ();
	public void insert (Pilot pilot);
}
