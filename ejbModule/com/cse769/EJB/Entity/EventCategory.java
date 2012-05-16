package com.cse769.EJB.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

@Entity
public class EventCategory {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long categoryId;
	@NotNull
	private String category;
	@ManyToMany
	@JoinTable(name = "JOIN_EVENT_EVENTCATEGORY", joinColumns = {@JoinColumn(name="eventId")}, inverseJoinColumns = {@JoinColumn(name="categoryId")})
	private List<Event> events;
	
	
	public Long getId() {
		return categoryId;
	}
	public void setId(Long id) {
		this.categoryId = id;
	}
	public String getName() {
		return category;
	}
	public void setName(String name) {
		this.category = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List<Event> getEvents() {
		return events;
	}
	public void setEvents(List<Event> events) {
		this.events = events;
	}
}
