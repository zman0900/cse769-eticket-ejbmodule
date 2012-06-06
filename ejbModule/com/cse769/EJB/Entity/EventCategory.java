package com.cse769.EJB.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 * Responsible for storing the data associated with an {@link Event}'s category.
 * Events can have categories such as music, sports, theater, comedy, etc.
 * 
 * @author group3
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "CATEGORY" }))
public class EventCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long categoryId;
	@NotNull
	private String category;
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<Event> events;

	/**
	 * Returns the id of the category
	 * 
	 * @return the id
	 */
	public Long getCategoryId() {
		return categoryId;
	}

	/**
	 * Set the id of the category
	 * 
	 * @param categoryId
	 *            an id
	 */
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * Returns the name of the category
	 * 
	 * @return the name
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Set the name of the category. Must be unique.
	 * 
	 * @param category
	 *            a unique name
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Returns the {@link List} of {@link Event}s that have this category
	 * 
	 * @return the {@link List} of {@link Event}s
	 */
	public List<Event> getEvents() {
		return events;
	}

	/**
	 * Set the {@link List} of {@link Event}s that have this category
	 * 
	 * @param events
	 *            a {@link List} of {@link Event}s
	 */
	public void setEvents(List<Event> events) {
		this.events = events;
	}
}
