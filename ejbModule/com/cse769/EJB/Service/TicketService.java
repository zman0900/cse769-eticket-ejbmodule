package com.cse769.EJB.Service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cse769.EJB.Entity.Event;
import com.cse769.EJB.Entity.Ticket;
import com.cse769.EJB.Entity.Transaction;

/**
 * Stateless session bean for {@link Ticket}s
 * 
 * @author group3
 */
@Stateless
public class TicketService {

	@PersistenceContext(unitName = "examples-769-EJB")
	EntityManager em;

	/**
	 * Creates and stores a new {@link Ticket} with the specified attributes
	 * 
	 * @param event
	 *            the {@link Event}
	 * @param soldFlag
	 *            is the {@link Ticket} sold (should be false for new
	 *            {@link Ticket}s)
	 * @param transaction
	 *            the {@link Transaction} (should be null for new {@link Ticket}
	 *            s)
	 */
	public void createTicket(Event event, Boolean soldFlag,
			Transaction transaction) {
		Ticket ticket = new Ticket();
		ticket.setEvent(event);
		ticket.setSoldFlag(soldFlag);
		ticket.setTransaction(transaction);
		em.persist(ticket);
	}

	/**
	 * Returns the {@link Ticket} with the specified id
	 * 
	 * @param id
	 *            the id
	 * @return the {@link Ticket}
	 */
	public Ticket getTicketById(Long id) {
		return em.find(Ticket.class, id);
	}

	/**
	 * Deletes the {@link Ticket} with the specified id
	 * 
	 * @param id
	 *            the id
	 */
	public void removeTicket(Long id) {
		Ticket tik = em.find(Ticket.class, id);
		em.remove(tik);
	}

	/**
	 * Modifies the specified {@link Ticket}. The id should not be changed and
	 * should already exist.
	 * 
	 * @param tik
	 *            the {@link Ticket}
	 */
	public void updateTicket(Ticket tik) {
		em.getTransaction().begin();
		Ticket newTik = em.find(Ticket.class, tik.getTicketId());
		newTik.setEvent(tik.getEvent());
		// TODO: newTik.setSoldFlag(tik.getSoldFlag());
		newTik.setTransaction(tik.getTransaction());
		em.getTransaction().commit();
	}
}