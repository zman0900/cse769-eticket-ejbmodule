package com.cse769.EJB.Service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import com.cse769.EJB.Entity.User;

/**
 * Stateless session bean for {@link User}s
 * 
 * @author group3
 */
@Stateless
public class UserService {
	@PersistenceContext(unitName = "examples-769-EJB")
	EntityManager em;

	/**
	 * Creates and stores a new {@link User} with the specified attributes
	 * 
	 * @param username
	 *            a unique username
	 * @param password
	 *            a password
	 * @param email
	 *            an email address
	 * @param address
	 *            a street address
	 * @param city
	 *            a city
	 * @param state
	 *            a state
	 * @param zipCode
	 *            a zip code
	 * @param phone
	 *            a phone number
	 */
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

	/**
	 * Returns the {@link User} with the specified id
	 * 
	 * @param id
	 *            the id
	 * @return the {@link User}
	 */
	public User getUserById(Long id) {
		return em.find(User.class, id);
	}

	/**
	 * Deletes the {@link User} with the specified id
	 * 
	 * @param id
	 *            the id
	 */
	public void removeUser(Long id) {
		User u = em.find(User.class, id);
		em.remove(u);
	}

	/**
	 * Modifies the specified {@link User}. The id should not be changed and
	 * should already exist.
	 * 
	 * @param u
	 *            the {@link User}
	 */
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

	/**
	 * Returns the {@link List} of all {@link User}s
	 * 
	 * @deprecated Shouldn't need all users at once, use
	 *             {@link #findUserByName(String)}
	 * @return the {@link List} of all {@link User}s
	 */
	@Deprecated
	public List<User> getAllUsers() {
		List<User> users = em.createQuery("SELECT u from User u", User.class)
				.getResultList();
		return users;
	}

	/**
	 * Returns the {@link User} with the specified username
	 * 
	 * @param user
	 *            the username
	 * @return the {@link User}
	 */
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
