package com.cse769.EJB.Service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cse769.EJB.Entity.Event;
import com.cse769.EJB.Entity.Venue;

@Stateless
public class VenueService {

	@PersistenceContext(unitName = "examples-769-EJB")
	EntityManager em;

	public void createVenue(String name, int size, String description,
			String address, String city, String state, String zipCode,
			List<Event> event) {
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

	public void removeVenue(Long id) {
		Venue ven = em.find(Venue.class, id);
		em.remove(ven);
	}

	public void updateVenue(Venue ven) {
		em.getTransaction().begin();
		Venue newVen = em.find(Venue.class, ven.getVenueId());
		newVen.setAddress(ven.getAddress());
		newVen.setCity(ven.getCity());
		newVen.setDescription(ven.getDescription());
		newVen.setEvent(ven.getEvent());
		newVen.setName(ven.getName());
		newVen.setSize(ven.getSize());
		newVen.setState(ven.getState());
		newVen.setZipCode(ven.getZipCode());
		em.getTransaction().commit();
	}
	
	public List<Venue> getAllVenues() {
		List<Venue> venues = em.createQuery("SELECT v from Venue v").getResultList();
		return venues;
	}
	
	public List<Venue> findVenuesByName(String venue) {
		List<Venue> venues = em.createQuery("SELECT v from Venue v where v.name=" + "'" + venue + "'").getResultList();
		return venues;
	}
}
