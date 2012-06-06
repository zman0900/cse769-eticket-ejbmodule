package com.cse769.EJB.Entity;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Responsible for capturing all of the elements and attributes of an Event
 * 
 * @author group3
 */
@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long eventId;
	private String name;
	private Date date;
	@ManyToOne
	@JoinColumn(name = "venue_id")
	private Venue venue;
	private String description;
	private int cost;
	private int quantity;
	@ManyToOne
	@JoinColumn(name = "category_id")
	private EventCategory category;
	@OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
	private List<Ticket> tickets;

	/**
	 * Returns the id of the event
	 * 
	 * @return the id
	 */
	public Long getEventId() {
		return eventId;
	}

	/**
	 * Set the id of the event.
	 * 
	 * @param eventId
	 *            an id
	 */
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	/**
	 * Returns the name of the event
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of the event
	 * 
	 * @param name
	 *            a name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the date of the event
	 * 
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Set the date of the event
	 * 
	 * @param date
	 *            a date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Returns the {@link Venue} of the event
	 * 
	 * @return the {@link Venue}
	 */
	public Venue getVenue() {
		return venue;
	}

	/**
	 * Set the {@link Venue} of the event
	 * 
	 * @param venue
	 *            a {@link Venue}
	 */
	public void setVenue(Venue venue) {
		this.venue = venue;
	}

	/**
	 * Returns the description of the event
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the description of the event
	 * 
	 * @param description
	 *            a description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Returns the cost of the event in <b><i>cents</i></b>. Don't forget to
	 * divide by 100!
	 * 
	 * @return the cost in cents
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * Set the cost in <b><i>cents</i></b>. Don't forget to multiply by 100!
	 * 
	 * @param cost
	 *            a cost in cents
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}

	/**
	 * Return the total number of tickets offered for this event
	 * 
	 * @return total number of tickets offered
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Set the total number of tickets offered for this event. If you change
	 * this you also need to create and persist additional {@link Ticket}
	 * objects.
	 * 
	 * @param quantity
	 *            number of tickets
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Returns the {@link EventCategory} of this event
	 * 
	 * @return the {@link EventCategory}
	 */
	public EventCategory getCategory() {
		return category;
	}

	/**
	 * Set this event's {@link EventCategory}
	 * 
	 * @param category
	 *            a {@link EventCategory}
	 */
	public void setCategory(EventCategory category) {
		this.category = category;
	}

	/**
	 * Return all the {@link Ticket}s associated with this event
	 * 
	 * @return the {@link List} of {@link Tickets}
	 */
	public List<Ticket> getTickets() {
		return tickets;
	}

	/**
	 * Set the {@link Ticket}s associated with this event
	 * 
	 * @param tickets
	 *            a {@link List} of {@link Tickets}
	 */
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

}
