package com.cse769.EJB.Entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 * Represents data about a single user of the system.
 * 
 * @author group3
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "USERNAME" }))
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	@NotNull
	private String username;
	@NotNull
	private String password;
	@NotNull
	private String email;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	private String phone;
	@OneToMany(targetEntity = FormOfPayment.class, mappedBy = "user", cascade = CascadeType.ALL)
	private List<FormOfPayment> formOfPayment;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Transaction> transactions;

	/**
	 * Returns the user's id
	 * 
	 * @return the id
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * Set the user's id
	 * 
	 * @param userId
	 *            an id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * Returns the username of the user
	 * 
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Set the username of the user. Must be unique.
	 * 
	 * @param username
	 *            a unique username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Returns the password of the user. This should probably be hashed...
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set the password of the user
	 * 
	 * @param password
	 *            a password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Returns the email of the user
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set the email of the user
	 * 
	 * @param email
	 *            an email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Returns the street address of the user
	 * 
	 * @return the street address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Set the street address of the user
	 * 
	 * @param address
	 *            a street address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Returns the city of the user
	 * 
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Set the city of the user
	 * 
	 * @param city
	 *            a city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Returns the state (as in place) of the user
	 * 
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Set the state of the user
	 * 
	 * @param state
	 *            a state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Returns the zip code of the user
	 * 
	 * @return the zip code
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * Set the zip code of the user
	 * 
	 * @param zipCode
	 *            a zip code
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * Returns the phone number of the user
	 * 
	 * @return the phone number
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Set the phone number of the user
	 * 
	 * @param phone
	 *            a phone number
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Returns the {@link List} of the {@link FormOfPayment}s owned by the user
	 * 
	 * @return the {@link List} of the {@link FormOfPayment}s
	 */
	public List<FormOfPayment> getFormOfPayment() {
		return formOfPayment;
	}

	/**
	 * Set the {@link List} of the {@link FormOfPayment}s owned by the user
	 * 
	 * @param formOfPayment
	 *            a {@link List} of the {@link FormOfPayment}s
	 */
	public void setFormOfPayment(List<FormOfPayment> formOfPayment) {
		this.formOfPayment = formOfPayment;
	}

	/**
	 * Returns the {@link List} of the {@link Transaction}s performed by the
	 * user
	 * 
	 * @return the {@link List} of the {@link Transaction}s
	 */
	public List<Transaction> getTransactions() {
		return transactions;
	}

	/**
	 * Set the {@link List} of the {@link Transaction}s performed by the user
	 * 
	 * @param transactions
	 *            a {@link List} of {@link Transaction}s
	 */
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
}
