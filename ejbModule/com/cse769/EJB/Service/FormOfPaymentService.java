package com.cse769.EJB.Service;

import java.util.Date;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cse769.EJB.Entity.FormOfPayment;
import com.cse769.EJB.Entity.PaymentType;
import com.cse769.EJB.Entity.Transaction;
import com.cse769.EJB.Entity.User;

@Stateless
public class FormOfPaymentService {
	
		@PersistenceContext(unitName="examples-769-EJB")
		EntityManager em;
		
		public void createFormOfPayment(String address, String cardNumber, String city, Date expiration, String fullName, String lastFour, String phoneNumber, String state, Set<Transaction> transactions, PaymentType type, User user, String zipCode) {
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
		
		public FormOfPayment getFormOfPaymentById(Long id) {
			return em.find(FormOfPayment.class, id);
		}

	}
