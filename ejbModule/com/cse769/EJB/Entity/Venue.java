package com.cse769.EJB.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Represents all of the data and attributes about a single venue in the system.
 * 
 * @author group3
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "NAME" }))
public class Venue {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long venueId;
	private String name;
	private String description;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	private int size;
	@OneToMany(targetEntity = Event.class, mappedBy = "venue", cascade = CascadeType.ALL)
	private List<Event> event;

	/**
	 * Returns the id of the venue
	 * 
	 * @return the id
	 */
	public Long getVenueId() {
		return venueId;
	}

	/**
	 * Set the id of the venue
	 * 
	 * @param venueId
	 *            an id
	 */
	public void setVenueId(Long venueId) {
		this.venueId = venueId;
	}

	/**
	 * Returns the name of the venue
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of the venue. Must be unique.
	 * 
	 * @param name
	 *            a unique name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the description of the venue
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the description of the venue
	 * 
	 * @param description
	 *            a description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Returns the street address of the venue
	 * 
	 * @return the street address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Set the street address of the venue
	 * 
	 * @param address
	 *            a street address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Returns the city of the venue
	 * 
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Set the city of the venue
	 * 
	 * @param city
	 *            a city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Returns the state (as in place) of the venue
	 * 
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Set the state of the user
	 * 
	 * @param state
	 *            a state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Returns the zip code of the venue
	 * 
	 * @return the zip code
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * Set the zip code of the user
	 * 
	 * @param zipCode
	 *            a zip code
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * Returns the total number of seats available in the venue
	 * 
	 * @return the total number of seats
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Set the total number of seats available in the venue
	 * 
	 * @param size
	 *            number of seats
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * Returns the {@link List} of {@link Event}s that have been or will be held
	 * at the venue
	 * 
	 * @return the {@link List} of {@link Event}s
	 */
	public List<Event> getEvent() {
		return event;
	}

	/**
	 * Set the {@link List} of {@link Event}s that have been or will be held at
	 * the venue
	 * 
	 * @param event
	 *            a {@link List} of {@link Event}s
	 */
	public void setEvent(List<Event> event) {
		this.event = event;
	}
}
