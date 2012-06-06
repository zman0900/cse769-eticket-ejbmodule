package com.cse769.EJB.Service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.cse769.EJB.Entity.EventCategory;

/**
 * Stateless session bean for {@link EventCategory}s
 * 
 * @author group3
 */
@Stateless
public class EventCategoryService {

	@PersistenceContext(unitName = "examples-769-EJB")
	EntityManager em;

	/**
	 * Creates and stores a new {@link EventCategory} with the specified name
	 * 
	 * @param name
	 *            the name of the category
	 */
	public void createEventCategory(String name) {
		EventCategory eventCategory = new EventCategory();
		eventCategory.setCategory(name);
		em.persist(eventCategory);
	}

	/**
	 * Returns the {@link EventCategory} with the specified id
	 * 
	 * @param id
	 *            the id
	 * @return the {@link EventCategory}
	 */
	public EventCategory getEventCategoryById(Long id) {
		return em.find(EventCategory.class, id);
	}

	/**
	 * Deletes the {@link EventCategory} with the specified id
	 * 
	 * @param id
	 *            the id
	 */
	public void removeEventCategory(Long id) {
		EventCategory ec = em.find(EventCategory.class, id);
		em.remove(ec);
	}

	/**
	 * Modifies the specified {@link EventCategory}. The id should not be
	 * changed and should already exist.
	 * 
	 * @param ec
	 *            the {@link EventCategory}
	 */
	public void updateEventCategory(EventCategory ec) {
		em.getTransaction().begin();
		EventCategory newEventCategory = em.find(EventCategory.class,
				ec.getCategoryId());
		newEventCategory.setCategory(ec.getCategory());
		em.getTransaction().commit();
	}

	/**
	 * Returns the {@link List} of all {@link EventCategory}s
	 * 
	 * @return the {@link List} of all {@link EventCategory}s
	 */
	public List<EventCategory> getAllCategories() {
		List<EventCategory> category = em.createQuery(
				"SELECT c from EventCategory c", EventCategory.class)
				.getResultList();
		return category;
	}

	/**
	 * Returns a single element {@link List} with the {@link EventCategory} with
	 * the specified name
	 * 
	 * @param category
	 *            the name
	 * @return the {@link List} containing the {@link EventCategory}
	 */
	public List<EventCategory> findCategoryByName(String category) {
		List<EventCategory> categories = em.createQuery(
				"SELECT c from EventCategory c where c.category=" + "'"
						+ category + "'", EventCategory.class).getResultList();
		return categories;
	}
}
