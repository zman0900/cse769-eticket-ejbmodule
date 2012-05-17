package com.cse769.EJB.Service;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cse769.EJB.Entity.Event;
import com.cse769.EJB.Entity.EventCategory;
import com.cse769.EJB.Entity.Venue;




@Stateless
public class EventService {

	@PersistenceContext(unitName="examples-769-EJB")
	EntityManager em;
	
	public void createEvent(String name, List<EventCategory> category, String description, double cost, Date date, int quantity, Venue venue) {
		Event event = new Event();
		event.setName(name);
		event.setCategory(category);
		event.setDescription(description);
		event.setCost(cost);
		event.setDate(date);
		event.setQuantity(quantity);
		event.setVenue(venue);
		em.persist(event);
	}
	
	public Event getEventById(Long id) {
		return em.find(Event.class, id);
	}
}