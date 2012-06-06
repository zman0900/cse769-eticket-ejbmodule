package com.cse769.EJB.Service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cse769.EJB.Entity.FormOfPayment;
import com.cse769.EJB.Entity.PaymentType;

/**
 * Stateless session bean for {@link PaymentType}s
 * 
 * @author group3
 */
@Stateless
public class PaymentTypeService {

	@PersistenceContext(unitName = "examples-769-EJB")
	EntityManager em;

	/**
	 * Creates and stores a new {@link PaymentType} with the specified attributes
	 * 
	 * @param formOfPayment
	 *            a {@link List} of {@link FormOfPayment}s with this
	 *            {@link PaymentType} (should be null for new
	 *            {@link PaymentType})
	 * @param name
	 *            the name
	 */
	public void createPaymentType(List<FormOfPayment> formOfPayment, String name) {
		PaymentType paymentType = new PaymentType();
		paymentType.setFormOfPayment(formOfPayment);
		paymentType.setName(name);
		em.persist(paymentType);
	}

	/**
	 * Returns the {@link PaymentType} with the specified id
	 * 
	 * @param id
	 *            the id
	 * @return the {@link PaymentType}
	 */
	public PaymentType getPaymentTypeById(Long id) {
		return em.find(PaymentType.class, id);
	}

	/**
	 * Deletes the {@link PaymentType} with the specified id
	 * 
	 * @param id
	 *            the id
	 */
	public void removePaymentType(Long id) {
		PaymentType pay = em.find(PaymentType.class, id);
		em.remove(pay);
	}

	/**
	 * Modifies the specified {@link PaymentType}. The id should not be changed
	 * and should already exist.
	 * 
	 * @param pay
	 *            the {@link PaymentType}
	 */
	public void updatePaymentType(PaymentType pay) {
		em.getTransaction().begin();
		PaymentType newPay = em.find(PaymentType.class, pay.getPaymentId());
		newPay.setFormOfPayment(pay.getFormOfPayment());
		newPay.setName(pay.getName());
		em.getTransaction().commit();
	}
}
