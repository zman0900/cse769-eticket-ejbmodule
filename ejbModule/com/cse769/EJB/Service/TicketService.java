package com.cse769.EJB.Service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cse769.EJB.Entity.Event;
import com.cse769.EJB.Entity.EventCategory;
import com.cse769.EJB.Entity.Ticket;
import com.cse769.EJB.Entity.Transaction;



@Stateless
public class TicketService {

	@PersistenceContext(unitName="examples-769-EJB")
	EntityManager em;
	
	public void createTicket(Event event, Boolean soldFlag, Transaction transaction) {
		Ticket ticket = new Ticket();
		ticket.setEvent(event);
		ticket.setSoldFlag(soldFlag);
		ticket.setTransaction(transaction);
		em.persist(ticket);
	}
	
	public Ticket getTicketById(Long id) {
		return em.find(Ticket.class, id);
	}

	public void removeTicket(Long id) {
		Ticket tik = em.find(Ticket.class, id);
		em.remove(tik);
	}
	
	public void updateTicket(Ticket tik) {
		em.getTransaction().begin();
		Ticket newTik = em.find(Ticket.class, tik.getTicketId());
		newTik.setEvent(tik.getEvent());
		//TODO: newTik.setSoldFlag(tik.getSoldFlag());
		newTik.setTransaction(tik.getTransaction());
		em.getTransaction().commit();
	}
}