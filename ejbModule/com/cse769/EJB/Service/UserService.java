package com.cse769.EJB.Service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import com.cse769.EJB.Entity.User;

@Stateless
public class UserService {
	@PersistenceContext(unitName = "examples-769-EJB")
	EntityManager em;

	public void createUser(String username, String password, String email,
			String address, String city, String state, String zipCode,
			String phone) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setAddress(address);
		user.setCity(city);
		user.setState(state);
		user.setZipCode(zipCode);
		user.setPhone(phone);
		em.persist(user);
	}

	public User getUserById(Long id) {
		return em.find(User.class, id);
	}

	public void removeUser(Long id) {
		User u = em.find(User.class, id);
		em.remove(u);
	}

	public void updateUser(User u) {
		em.getTransaction().begin();
		User newU = em.find(User.class, u.getUserId());
		newU.setAddress(u.getAddress());
		newU.setCity(u.getCity());
		newU.setEmail(u.getEmail());
		newU.setPassword(u.getPassword());
		newU.setPhone(u.getPhone());
		newU.setState(u.getState());
		newU.setUsername(u.getUsername());
		newU.setZipCode(u.getZipCode());
		em.getTransaction().commit();
	}

	public List<User> getAllUsers() {
		List<User> users = em.createQuery("SELECT u from User u", User.class)
				.getResultList();
		return users;
	}

	public User findUserByName(String user) {
		User result = null;
		try {
			result = em
					.createQuery(
							"SELECT u from User u where u.username=" + "'"
									+ user + "'", User.class).getSingleResult();
		} catch (NoResultException e) {
			// Ignore, return null
		}
		return result;
	}
}
