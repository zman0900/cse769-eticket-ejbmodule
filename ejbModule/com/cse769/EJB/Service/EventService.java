package com.cse769.EJB.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cse769.EJB.Entity.Event;
import com.cse769.EJB.Entity.EventCategory;
import com.cse769.EJB.Entity.Ticket;
import com.cse769.EJB.Entity.Venue;

@Stateless
public class EventService {

	@PersistenceContext(unitName = "examples-769-EJB")
	EntityManager em;

	public void createEvent(String name, List<EventCategory> categories,
			String description, int cost, Date date, int quantity, Venue venue) {
		Event event = new Event();
		event.setName(name);
		event.setCategories(categories);
		event.setDescription(description);
		event.setCost(cost);
		event.setDate(date);
		event.setQuantity(quantity);
		event.setVenue(venue);
		Set<Ticket> tickets = new HashSet<Ticket>();
		for (int i = 0; i < quantity; i++) {
			Ticket t = new Ticket();
			t.setEvent(event);
			t.setSoldFlag(false);
			t.setTransaction(null);
			// em.persist(t);
			tickets.add(t);
		}
		event.setTickets(tickets);
		em.persist(event);
	}

	public Event getEventById(Long id) {
		return em.find(Event.class, id);
	}

	public void removeEvent(Long id) {
		Event ev = em.find(Event.class, id);
		em.remove(ev);
	}

	public void updateEvent(Event ev) {
		em.getTransaction().begin();
		Event newEvent = em.find(Event.class, ev.getEventId());
		newEvent.setCategories(ev.getCategories());
		newEvent.setCost(ev.getCost());
		newEvent.setDate(ev.getDate());
		newEvent.setDescription(ev.getDescription());
		newEvent.setName(ev.getName());
		newEvent.setQuantity(ev.getQuantity());
		newEvent.setTickets(ev.getTickets());
		newEvent.setVenue(ev.getVenue());
		em.getTransaction().commit();
	}

	public List<Event> getAllEvents() {
		List<Event> events = em.createQuery("SELECT e from Event e",
				Event.class).getResultList();
		return events;
	}

	public List<Event> findEventsByName(String event) {
		List<Event> events = em.createQuery(
				"SELECT e from Event e where e.name=" + "'" + event + "'",
				Event.class).getResultList();
		return events;
	}

	public void createDemoEvents() {
		EventCategory sports = new EventCategory();
		sports.setCategory("Sports");
		EventCategory music = new EventCategory();
		music.setCategory("Music");
		Venue stadium = new Venue();
		stadium.setAddress("411 Woody Hayes Drive");
		stadium.setCity("Columbus");
		stadium.setDescription("The Horseshoe");
		stadium.setName("Ohio Stadium");
		stadium.setSize(102329);
		stadium.setState("OH");
		stadium.setZipCode("43210");

		try {
			em.persist(sports);
			em.persist(music);
			em.persist(stadium);
			em.flush();

			List<EventCategory> temp = new ArrayList<EventCategory>();
			temp.add(sports);
			Calendar cal = Calendar.getInstance();
			cal.set(2013, 10, 30);
			createEvent("Ohio State vs Michigan Football", temp,
					"A game to end all games", 5324, cal.getTime(), 100,
					stadium);
		} catch (Exception e) {
			// ignore
		}
	}

}
