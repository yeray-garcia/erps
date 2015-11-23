package org.yeraygarcia.hibernate.airlines.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Aircraft {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String model;
	private Float autonomy;
	@OneToOne(mappedBy="aircraft", cascade = CascadeType.ALL)
	private Pilot pilot;
	public Aircraft() {
		
	}
	public Aircraft(Long id, String model, Float autonomy) {
	
		this.id = id;
		this.model = model;
		this.autonomy = autonomy;
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Float getAutonomy() {
		return autonomy;
	}
	public void setAutonomy(Float autonomy) {
		this.autonomy = autonomy;
	}
	public Pilot getPilot() {
		return pilot;
	}
	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
		pilot.setAircraft(this);
	}

	
	
}
