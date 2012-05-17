package com.cse769.EJB.Service;

import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cse769.EJB.Entity.FormOfPayment;
import com.cse769.EJB.Entity.Transaction;
import com.cse769.EJB.Entity.User;


@Stateless
public class UserService {
	@PersistenceContext(unitName="examples-769-EJB")
	EntityManager em;
	
	public void createUser(String username, String password, String email, String address, String city, String state, String zipCode, String phone, List<FormOfPayment> formOfPayment, Set<Transaction> transactions) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setAddress(address);
		user.setCity(city);
		user.setState(state);
		user.setZipCode(zipCode);
		user.setPhone(phone);
		user.setFormOfPayment(formOfPayment);
		user.setTransactions(transactions);
		em.persist(user);
	}
	
	public User getUserById(Long id) {
		return em.find(User.class, id);
	}
}
