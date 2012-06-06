package com.cse769.EJB.Service;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cse769.EJB.Entity.FormOfPayment;
import com.cse769.EJB.Entity.PaymentType;
import com.cse769.EJB.Entity.Transaction;
import com.cse769.EJB.Entity.User;

/**
 * Stateless session bean for {@link FormOfPayment}s
 * 
 * @author group3
 */
@Stateless
public class FormOfPaymentService {

	@PersistenceContext(unitName = "examples-769-EJB")
	EntityManager em;

	/**
	 * Creates and stores a new {@link FormOfPayment} with the specified
	 * attributes
	 * 
	 * @param address
	 *            a street address
	 * @param cardNumber
	 *            a card number
	 * @param city
	 *            a city
	 * @param expiration
	 *            an expiration date
	 * @param fullName
	 *            a full name
	 * @param lastFour
	 *            the last four digits of the card number
	 * @param phoneNumber
	 *            a phone number
	 * @param state
	 *            a state
	 * @param transactions
	 *            a {@link List} of {@link Transaction}s (should be null for new
	 *            {@link FormOfPayment})
	 * @param type
	 *            a {@link PaymentType}
	 * @param user
	 *            a {@link User}
	 * @param zipCode
	 *            a zip code
	 */
	public void createFormOfPayment(String address, String cardNumber,
			String city, Date expiration, String fullName, String lastFour,
			String phoneNumber, String state, List<Transaction> transactions,
			PaymentType type, User user, String zipCode) {
		FormOfPayment formOfPayment = new FormOfPayment();
		formOfPayment.setAddress(address);
		formOfPayment.setCardNumber(cardNumber);
		formOfPayment.setCity(city);
		formOfPayment.setExpiration(expiration);
		formOfPayment.setFullName(fullName);
		formOfPayment.setLastFour(lastFour);
		formOfPayment.setPhoneNumber(phoneNumber);
		formOfPayment.setState(state);
		formOfPayment.setTransactions(transactions);
		formOfPayment.setType(type);
		formOfPayment.setUser(user);
		formOfPayment.setZipCode(zipCode);
		em.persist(formOfPayment);
	}

	/**
	 * Returns the {@link FormOfPayment} with the specified id
	 * 
	 * @param id
	 *            the id
	 * @return the {@link FormOfPayment}
	 */
	public FormOfPayment getFormOfPaymentById(Long id) {
		return em.find(FormOfPayment.class, id);
	}

	/**
	 * Deletes the {@link FormOfPayment} with the specified id
	 * 
	 * @param id
	 *            the id
	 */
	public void removeFormOfPayment(Long id) {
		FormOfPayment fop = em.find(FormOfPayment.class, id);
		em.remove(fop);
	}

	/**
	 * Modifies the specified {@link FormOfPayment}. The id should not be
	 * changed and should already exist.
	 * 
	 * @param fop
	 *            the {@link FormOfPayment}
	 */
	public void updateFormOfPayment(FormOfPayment fop) {
		em.getTransaction().begin();
		FormOfPayment newFop = em.find(FormOfPayment.class,
				fop.getFormOfPaymentid());
		newFop.setAddress(fop.getAddress());
		newFop.setCardNumber(fop.getCardNumber());
		newFop.setCity(fop.getCity());
		newFop.setExpiration(fop.getExpiration());
		newFop.setFullName(fop.getFullName());
		newFop.setLastFour(fop.getLastFour());
		newFop.setPhoneNumber(fop.getPhoneNumber());
		newFop.setState(fop.getPhoneNumber());
		newFop.setTransactions(fop.getTransactions());
		em.getTransaction().commit();
	}

}
