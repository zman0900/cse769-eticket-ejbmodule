package com.cse769.EJB.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.cse769.EJB.Entity.Event;
import com.cse769.EJB.Entity.EventCategory;
import com.cse769.EJB.Entity.Ticket;
import com.cse769.EJB.Entity.Venue;

/**
 * Stateless session bean for {@link Event}s
 * 
 * @author group3
 */
@Stateless
public class EventService {

	@PersistenceContext(unitName = "examples-769-EJB")
	EntityManager em;

	/**
	 * Creates and stores a new {@link Event} with the specified attributes.
	 * Also generates a number of {@link Ticket}s for the event as specified by
	 * the quantity attribute.
	 * 
	 * @param name
	 *            a name
	 * @param category
	 *            a {@link Category}
	 * @param description
	 *            a description
	 * @param cost
	 *            the cost in <i><b>cents</b></i>
	 * @param date
	 *            the date
	 * @param quantity
	 *            the total number of seats offered
	 * @param venue
	 *            the {@link Venue}
	 */
	public void createEvent(String name, EventCategory category,
			String description, int cost, Date date, int quantity, Venue venue) {
		Event event = new Event();
		event.setName(name);
		event.setCategory(category);
		event.setDescription(description);
		event.setCost(cost);
		event.setDate(date);
		event.setQuantity(quantity);
		event.setVenue(venue);
		List<Ticket> tickets = new ArrayList<Ticket>();
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

	/**
	 * Returns the {@link Event} with the specified id
	 * 
	 * @param id
	 *            the id
	 * @return the {@link Event}
	 */
	public Event getEventById(Long id) {
		return em.find(Event.class, id);
	}

	/**
	 * Deletes the {@link Event} with the specified id
	 * 
	 * @param id
	 *            the id
	 */
	public void removeEvent(Long id) {
		Event ev = em.find(Event.class, id);
		em.remove(ev);
	}

	/**
	 * Modifies the specified {@link Event}. The id should not be changed and
	 * should already exist.
	 * 
	 * @param ev
	 *            the {@link Event}
	 */
	public void updateEvent(Event ev) {
		em.getTransaction().begin();
		Event newEvent = em.find(Event.class, ev.getEventId());
		newEvent.setCategory(ev.getCategory());
		newEvent.setCost(ev.getCost());
		newEvent.setDate(ev.getDate());
		newEvent.setDescription(ev.getDescription());
		newEvent.setName(ev.getName());
		newEvent.setQuantity(ev.getQuantity());
		newEvent.setVenue(ev.getVenue());
		em.getTransaction().commit();
	}

	/**
	 * Returns the {@link List} of all {@link Event}s
	 * 
	 * @return the {@link List} of all {@link Event}s
	 */
	public List<Event> getAllEvents() {
		List<Event> events = em.createQuery("SELECT e from Event e",
				Event.class).getResultList();
		return events;
	}

	// Not used
	/**
	 * Returns the {@link List} of {@link Event}s with a name exactly as
	 * specified. Using {@link #searchEventsByName(String)} is probably a better
	 * idea.
	 * 
	 * @param event
	 *            the event name
	 * @return the {@link List} of {@link Event}s
	 */
	public List<Event> findEventsByName(String event) {
		final String query = "SELECT e FROM Event e WHERE e.name = :name";
		final String name = event;
		TypedQuery<Event> query1 = em.createQuery(query, Event.class);
		query1.setParameter("name", name);
		final List<Event> events = query1.getResultList();
		return events;
	}

	/**
	 * Returns the {@link List} of {@link Event}s with a name containing the
	 * specified search string. Case insensitive.
	 * 
	 * @param search
	 *            the search string
	 * @return the {@link List} of {@link Event}s
	 */
	public List<Event> searchEventsByName(String search) {
		final String query = "SELECT e FROM Event e WHERE upper(e.name) LIKE upper(:name)";
		final String name = "%" + search + "%";
		TypedQuery<Event> query1 = em.createQuery(query, Event.class);
		query1.setParameter("name", name);
		final List<Event> events = query1.getResultList();
		return events;
	}

	/**
	 * Creates some demo {@link Event}s, and the {@link EventCategory}s and
	 * {@link Venue}s necessary to do so
	 * 
	 * @return true if created
	 */
	public boolean createDemoEvents() {
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
		Venue schott = new Venue();
		schott.setAddress("555 Borror Drive");
		schott.setCity("Columbus");
		schott.setDescription("The Jerome Schottenstein Center");
		schott.setName("Value City Arena");
		schott.setSize(18809);
		schott.setState("OH");
		schott.setZipCode("43210");

		try {
			em.persist(sports);
			em.persist(music);
			em.persist(stadium);
			em.persist(schott);
			em.flush();

			Calendar cal = Calendar.getInstance();
			cal.set(2013, 10, 30);
			createEvent("Ohio State vs Michigan Football", sports,
					"A game to end all games", 5324, cal.getTime(), 100,
					stadium);
			cal.set(2070, 8, 18);
			createEvent("Jimi Hendrix Zombie", music,
					"Jimi Hendrix is back to play a concert,"
							+ "but he's hungry for brains...", 66666,
					cal.getTime(), 321, schott);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * Not needed, don't use
	 * 
	 * @deprecated Use {@link #findEventsByCategoryId(Long)}
	 */
	@Deprecated
	public List<Event> findEventsByCategory(String category) {
		final String query = "SELECT e FROM Event e WHERE e.category.category = :categoryName";
		final String categoryName = category;
		TypedQuery<Event> query1 = em.createQuery(query, Event.class);
		query1.setParameter("categoryName", categoryName);
		final List<Event> events = query1.getResultList();
		return events;
	}

	/**
	 * Returns the {@link List} of {@link Event}s with the specified
	 * {@link EventCategory} id
	 * 
	 * @param id
	 *            the {@link EventCategory} id
	 * @return the {@link List} of {@link Event}s
	 */
	public List<Event> findEventsByCategoryId(Long id) {
		final String query = "SELECT e FROM Event e WHERE e.category.categoryId = :categoryId";
		final Long categoryId = id;
		TypedQuery<Event> query1 = em.createQuery(query, Event.class);
		query1.setParameter("categoryId", categoryId);
		final List<Event> events = query1.getResultList();
		return events;
	}

	/**
	 * Not needed, don't use
	 * 
	 * @deprecated Use {@link #findEventsByVenueId(Long)}
	 */
	@Deprecated
	public List<Event> findEventsByVenue(String venue) {
		final String query = "SELECT e FROM Event e WHERE e.venue.name = :venueName";
		final String venueName = venue;
		TypedQuery<Event> query1 = em.createQuery(query, Event.class);
		query1.setParameter("venueName", venueName);
		final List<Event> events = query1.getResultList();
		return events;
	}

	/**
	 * Returns the {@link List} of {@link Event}s with the specified
	 * {@link Venue} id
	 * 
	 * @param id
	 *            the {@link Venue} id
	 * @return the {@link List} of {@link Event}s
	 */
	public List<Event> findEventsByVenueId(Long id) {
		final String query = "SELECT e FROM Event e WHERE e.venue.venueId = :venueId";
		final Long venueId = id;
		TypedQuery<Event> query1 = em.createQuery(query, Event.class);
		query1.setParameter("venueId", venueId);
		final List<Event> events = query1.getResultList();
		return events;
	}

	/**
	 * Returns the number of unsold {@link Ticket}s for the {@link Event} with
	 * the specified id
	 * 
	 * @param id
	 *            the id
	 * @return the number of unsold {@link Ticket}s
	 */
	public Long getNumOfAvailableTickets(Long id) {
		final String query = "SELECT COUNT(t) FROM Ticket t WHERE t.event.eventId = :eventId AND t.soldFlag = false";
		final Long eventId = id;
		TypedQuery<Long> query1 = em.createQuery(query, Long.class);
		query1.setParameter("eventId", eventId);
		return query1.getSingleResult();
	}
}
