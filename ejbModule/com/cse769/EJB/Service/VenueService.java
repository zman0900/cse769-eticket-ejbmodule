package com.cse769.EJB.Service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cse769.EJB.Entity.User;
import com.cse769.EJB.Entity.Venue;

/**
 * Stateless session bean for {@link Venue}s
 * 
 * @author group3
 */
@Stateless
public class VenueService {

	@PersistenceContext(unitName = "examples-769-EJB")
	EntityManager em;

	/**
	 * Creates and stores a new {@link Venue} with the specified attributes
	 * 
	 * @param name
	 *            a name
	 * @param size
	 *            the total number of seats offered
	 * @param description
	 *            a description
	 * @param address
	 *            a street address
	 * @param city
	 *            a city
	 * @param state
	 *            a state
	 * @param zipCode
	 *            a zip code
	 */
	public void createVenue(String name, int size, String description,
			String address, String city, String state, String zipCode) {
		Venue venue = new Venue();
		venue.setName(name);
		venue.setSize(size);
		venue.setDescription(description);
		venue.setAddress(address);
		venue.setCity(city);
		venue.setState(state);
		venue.setZipCode(zipCode);
		em.persist(venue);
	}

	/**
	 * Returns the {@link Venue} with the specified id
	 * 
	 * @param id
	 *            the id
	 * @return the {@link Venue}
	 */
	public Venue getVenueById(Long id) {
		return em.find(Venue.class, id);
	}

	/**
	 * Deletes the {@link Venue} with the specified id
	 * 
	 * @param id
	 *            the id
	 */
	public void removeVenue(Long id) {
		Venue ven = em.find(Venue.class, id);
		em.remove(ven);
	}

	/**
	 * Modifies the specified {@link Venue}. The id should not be changed and
	 * should already exist.
	 * 
	 * @param ven
	 *            the {@link Venue}
	 */
	public void updateVenue(Venue ven) {
		em.getTransaction().begin();
		Venue newVen = em.find(Venue.class, ven.getVenueId());
		newVen.setAddress(ven.getAddress());
		newVen.setCity(ven.getCity());
		newVen.setDescription(ven.getDescription());
		newVen.setName(ven.getName());
		newVen.setSize(ven.getSize());
		newVen.setState(ven.getState());
		newVen.setZipCode(ven.getZipCode());
		em.getTransaction().commit();
	}

	/**
	 * Returns the {@link List} of all {@link Venue}s
	 * 
	 * @return the {@link List} of all {@link Venue}s
	 */
	public List<Venue> getAllVenues() {
		List<Venue> venues = em.createQuery("SELECT v from Venue v",
				Venue.class).getResultList();
		return venues;
	}

	/**
	 * Returns a single element {@link List} containing the {@link Venue} with
	 * the specified name
	 * 
	 * @param venue
	 *            the name
	 * @deprecated Use {@link #getVenueById(Long)}
	 * @return a single element {@link List} containing the {@link Venue}
	 */
	@Deprecated
	public List<Venue> findVenuesByName(String venue) {
		List<Venue> venues = em.createQuery(
				"SELECT v from Venue v where v.name=" + "'" + venue + "'",
				Venue.class).getResultList();
		return venues;
	}
}
