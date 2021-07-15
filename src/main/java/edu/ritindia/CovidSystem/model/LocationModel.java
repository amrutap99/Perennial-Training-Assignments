package edu.ritindia.CovidSystem.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "location1")
public class LocationModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int serialNo;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "total_cases")
	private int newTotalCases;
	
	@Column(name = "total_new_cases")
	private int diffFromPrevDay;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="timestamp")
	private Date timestamp;


	//@PrePersist is a JPA annotation and therefore should work in all compatible persistence frameworks.
	// It indicates a method that should be invoked on particular entity lifecycle event.
	@PrePersist
	private void onCreate() {
		timestamp = new Date();      //inserting current date to db for every time browser refreshes to fetch data
	}
	
	
	
	
	public LocationModel() {
		super();
	}


	public LocationModel(String country, int newTotalCases, int diffFromPrevDay) {
		super();
		this.country = country;
		this.newTotalCases = newTotalCases;
		this.diffFromPrevDay = diffFromPrevDay;
	}
	
	
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getNewTotalCases() {
		return newTotalCases;
	}
	public void setNewTotalCases(int newTotalCases) {
		this.newTotalCases = newTotalCases;
	}
	
	
	
	public int getDiffFromPrevDay() {
		return diffFromPrevDay;
	}
	public void setDiffFromPrevDay(int diffFromPrevDay) {
		this.diffFromPrevDay = diffFromPrevDay;
	}
	@Override
	public String toString() {
		return "LocationModel [country=" + country + ", newTotalCases=" + newTotalCases + "]";
	}
	
	
	
	
	
	

	

}
