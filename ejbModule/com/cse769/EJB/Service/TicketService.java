package com.cse769.EJB.Service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cse769.EJB.Entity.Event;
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
}