/**
 * 
 */
package com.cse769.EJB.Entity;

import java.util.Date;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	private double cost;
	private int quantity;
	
	@ManyToMany
	private List<EventCategory> category;
	@OneToMany(targetEntity = Ticket.class, mappedBy = "event", cascade = CascadeType.ALL)
	private List<Ticket> tickets;
	
	public Long getId() {
		return eventId;
	}
	public void setId(Long id) {
		this.eventId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Venue getVenue() {
		return venue;
	}
	public void setVenue(Venue venue) {
		this.venue = venue;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public List<EventCategory> getCategory() {
		return category;
	}
	public void setCategory(List<EventCategory> category) {
		this.category = category;
	}
	public List<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	
}
