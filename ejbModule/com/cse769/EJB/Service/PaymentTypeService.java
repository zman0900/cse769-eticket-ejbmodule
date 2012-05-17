package com.cse769.EJB.Service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cse769.EJB.Entity.FormOfPayment;
import com.cse769.EJB.Entity.PaymentType;

@Stateless
public class PaymentTypeService {
	
	@PersistenceContext(unitName="examples-769-EJB")
	EntityManager em;
	
	public void createPaymentType() {
		PaymentType paymentType = new PaymentType();
		//TODO: 
		em.persist(paymentType);
	}
	
	public PaymentType getPaymentTypeById(Long id) {
		return em.find(PaymentType.class, id);
	}
}
