package com.cse769.EJB.Service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cse769.EJB.Entity.Event;
import com.cse769.EJB.Entity.Ticket;



@Stateless
public class TicketService {

	@PersistenceContext(unitName="examples-769-EJB")
	EntityManager em;
	
	public void createTicket(Event event, Boolean soldFlag) {
		Ticket ticket = new Ticket();
		ticket.setEvent(event);
		ticket.setSoldFlag(soldFlag);
		em.persist(ticket);
	}
}