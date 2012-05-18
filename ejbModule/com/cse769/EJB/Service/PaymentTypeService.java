package com.cse769.EJB.Service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cse769.EJB.Entity.FormOfPayment;
import com.cse769.EJB.Entity.PaymentType;

@Stateless
public class PaymentTypeService {

	@PersistenceContext(unitName = "examples-769-EJB")
	EntityManager em;

	public void createPaymentType(List<FormOfPayment> formOfPayment, String name) {
		PaymentType paymentType = new PaymentType();
		paymentType.setFormOfPayment(formOfPayment);
		paymentType.setName(name);
		em.persist(paymentType);
	}

	public PaymentType getPaymentTypeById(Long id) {
		return em.find(PaymentType.class, id);
	}

	public void removePaymentType(Long id) {
		PaymentType pay = em.find(PaymentType.class, id);
		em.remove(pay);
	}

	public void updatePaymentType(PaymentType pay) {
		em.getTransaction().begin();
		PaymentType newPay = em.find(PaymentType.class, pay.getPaymentId());
		newPay.setFormOfPayment(pay.getFormOfPayment());
		newPay.setName(pay.getName());
		em.getTransaction().commit();
	}
}
