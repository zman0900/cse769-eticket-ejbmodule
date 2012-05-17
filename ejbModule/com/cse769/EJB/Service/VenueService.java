package com.cse769.EJB.Service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cse769.EJB.Entity.Event;
import com.cse769.EJB.Entity.Venue;


@Stateless
public class VenueService {

	@PersistenceContext(unitName="examples-769-EJB")
	EntityManager em;
	
	public void createVenue(String name, int size, String description, String address, String city, String state, String zipCode, List<Event> event) {
		Venue venue = new Venue();
		venue.setName(name);
		venue.setSize(size);
		venue.setDescription(description);
		venue.setAddress(address);
		venue.setCity(city);
		venue.setState(state);
		venue.setZipCode(zipCode);
		venue.setEvent(event);
		em.persist(venue);
	}
	
	public Venue getVenueById(Long id) {
		return em.find(Venue.class, id);
	}
}
