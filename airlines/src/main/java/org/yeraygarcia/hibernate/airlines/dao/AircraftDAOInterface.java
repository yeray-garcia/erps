package org.yeraygarcia.hibernate.airlines.dao;

import java.util.List;

import org.yeraygarcia.hibernate.airlines.models.Aircraft;



public interface AircraftDAOInterface {
	public List<Aircraft> selectAll();
	public void insert (Aircraft aircraft);
}
