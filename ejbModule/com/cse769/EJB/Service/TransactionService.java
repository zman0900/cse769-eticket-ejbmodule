package com.cse769.EJB.Service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cse769.EJB.Entity.EventCategory;
import com.cse769.EJB.Entity.FormOfPayment;
import com.cse769.EJB.Entity.Ticket;
import com.cse769.EJB.Entity.Transaction;
import com.cse769.EJB.Entity.User;



@Stateless
public class TransactionService {

	@PersistenceContext(unitName="examples-769-EJB")
	EntityManager em;
	
	public void createTransaction(FormOfPayment formOfPayment, List<Ticket> ticket, User user, Boolean isCompleted) {
		Transaction transaction = new Transaction();
		transaction.setFormOfPayment(formOfPayment);
		transaction.setTicket(ticket);
		transaction.setUser(user);
		transaction.setIsCompleted(isCompleted);
		em.persist(transaction);
	}
	
	public Transaction getTransactionById(Long id) {
		return em.find(Transaction.class, id);
	}
	
	public void removeTransaction(Long id) {
		Transaction trans = em.find(Transaction.class, id);
		em.remove(trans);
	}
	
	public void updateTransaction(Transaction trans) {
		em.getTransaction().begin();
		Transaction newTrans = em.find(Transaction.class, trans.getTransactionId());
		newTrans.setFormOfPayment(trans.getFormOfPayment());
		newTrans.setIsCompleted(trans.getIsCompleted());
		newTrans.setTicket(trans.getTicket());
		newTrans.setUser(trans.getUser());
		em.getTransaction().commit();
	}
}