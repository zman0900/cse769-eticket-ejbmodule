package com.cse769.EJB.Service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.cse769.EJB.Entity.EventCategory;

@Stateless
public class EventCategoryService {

	@PersistenceContext(unitName = "examples-769-EJB")
	EntityManager em;

	public void createEventCategory(String name) {
		EventCategory eventCategory = new EventCategory();
		eventCategory.setCategory(name);
		em.persist(eventCategory);
	}

	public EventCategory getEventCategoryById(Long id) {
		return em.find(EventCategory.class, id);
	}

	public void removeEventCategory(Long id) {
		EventCategory ec = em.find(EventCategory.class, id);
		em.remove(ec);
	}

	public void updateEventCategory(EventCategory ec) {
		em.getTransaction().begin();
		EventCategory newEventCategory = em.find(EventCategory.class,
				ec.getCategoryId());
		newEventCategory.setCategory(ec.getCategory());
		em.getTransaction().commit();
	}

	public List<EventCategory> getAllCategories() {
		List<EventCategory> category = em.createQuery(
				"SELECT c from EventCategory c", EventCategory.class)
				.getResultList();
		return category;
	}

	public List<EventCategory> findCategoryByName(String category) {
		List<EventCategory> categories = em.createQuery(
				"SELECT c from EventCategory c where c.category=" + "'"
						+ category + "'", EventCategory.class).getResultList();
		return categories;
	}
}
