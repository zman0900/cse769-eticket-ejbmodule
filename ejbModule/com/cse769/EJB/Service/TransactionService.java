package com.cse769.EJB.Service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cse769.EJB.Entity.FormOfPayment;
import com.cse769.EJB.Entity.Ticket;
import com.cse769.EJB.Entity.Transaction;
import com.cse769.EJB.Entity.User;

/**
 * Stateless session bean for {@link Transaction}s
 * 
 * @author group3
 */
@Stateless
public class TransactionService {

	@PersistenceContext(unitName = "examples-769-EJB")
	EntityManager em;

	/**
	 * Creates and stores a new {@link Transaction} with the specified attributes
	 * 
	 * @param formOfPayment
	 *            a {@link FormOfPayment}
	 * @param ticket
	 *            a {@link Ticket}
	 * @param user
	 *            a {@link User}
	 * @param isCompleted
	 *            true if the transaction is complete (should be false for new
	 *            transactions)
	 */
	public void createTransaction(FormOfPayment formOfPayment, Ticket ticket,
			User user, Boolean isCompleted) {
		Transaction transaction = new Transaction();
		transaction.setFormOfPayment(formOfPayment);
		transaction.setTicket(ticket);
		transaction.setUser(user);
		transaction.setIsCompleted(isCompleted);
		em.persist(transaction);
	}

	/**
	 * Returns the {@link Transaction} with the specified id
	 * 
	 * @param id
	 *            the id
	 * @return the {@link Transaction}
	 */
	public Transaction getTransactionById(Long id) {
		return em.find(Transaction.class, id);
	}

	/**
	 * Deletes the {@link Transaction} with the specified id
	 * 
	 * @param id
	 *            the id
	 */
	public void removeTransaction(Long id) {
		Transaction trans = em.find(Transaction.class, id);
		em.remove(trans);
	}

	/**
	 * Modifies the specified {@link Transaction}. The id should not be changed
	 * and should already exist.
	 * 
	 * @param trans
	 *            the {@link Transaction}
	 */
	public void updateTransaction(Transaction trans) {
		em.getTransaction().begin();
		Transaction newTrans = em.find(Transaction.class,
				trans.getTransactionId());
		newTrans.setFormOfPayment(trans.getFormOfPayment());
		newTrans.setIsCompleted(trans.getIsCompleted());
		newTrans.setTicket(trans.getTicket());
		newTrans.setUser(trans.getUser());
		em.getTransaction().commit();
	}
}