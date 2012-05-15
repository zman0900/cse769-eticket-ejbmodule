package com.cse769.EJB.Service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cse769.EJB.Entity.FormOfPayment;
import com.cse769.EJB.Entity.Ticket;
import com.cse769.EJB.Entity.Transaction;
import com.cse769.EJB.Entity.User;



@Stateless
public class TransactionService {

	@PersistenceContext(unitName="examples-769-EJB")
	EntityManager em;
	
	public void createEvent(FormOfPayment formOfPayment, Ticket ticket, User user, Boolean isCompleted) {
		Transaction transaction = new Transaction();
		transaction.setFormOfPayment(formOfPayment);
		transaction.setTicket(ticket);
		transaction.setUser(user);
		transaction.setIsCompleted(isCompleted);
		em.persist(transaction);
	}
}