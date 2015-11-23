package org.yeraygarcia.hibernate.airlines;

import java.util.List;

import org.yeraygarcia.hibernate.airlines.dao.AircraftDAO;
import org.yeraygarcia.hibernate.airlines.models.Aircraft;
import org.yeraygarcia.hibernate.airlines.models.Pilot;




/**
 * Hello world!
 *
 */
public class App 



{
	public static void showAll(AircraftDAO aircraftDAO) {
		List<Aircraft> aircrafts = aircraftDAO.selectAll();
		System.out.println("--- AIRCRAFT ----- table contents-----------");
		for (Aircraft aircraft : aircrafts) {
			System.out.println("Id: " + aircraft.getId());
			System.out.println(" - Model: " + aircraft.getModel());
			System.out.println(" - Autonomy: " + aircraft.getAutonomy());
			
		}
	
	}
	
    public static void main( String[] args )
    {
        AircraftDAO aircraftDAO = new AircraftDAO();
        Aircraft aircraft1 = new Aircraft();
        Aircraft aircraft2 = new Aircraft();
        aircraft1.setAutonomy(2f);
        aircraft1.setModel("ss");
        Pilot pilot = new Pilot();
        pilot.setLicense(2);
        pilot.setName("ss");
        aircraft1.setPilot(pilot);
        aircraft2.setAutonomy(3f);
        aircraft2.setModel("ssa");
        Pilot pilot2 = new Pilot();
        pilot2.setLicense(3);
        pilot.setName("ssa");
        aircraft2.setPilot(pilot2);
        aircraftDAO.insert(aircraft1);
        aircraftDAO.insert(aircraft2);
        showAll(aircraftDAO);
        
        
        
   
        
        
        
        
        
        
    }
}
