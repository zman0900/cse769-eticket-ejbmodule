package com.cse769.EJB.Entity;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Represents all the details about a user's choice of payment for a
 * {@link Ticket}. By "Form of Payment", we mean that this class represents
 * something such as a single credit card or buckid. Contains no security, so
 * obviously not for use in a production version of this system.
 * 
 * @author group3
 */
@Entity
public class FormOfPayment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long formOfPaymentid;
	private String cardNumber;
	private String lastFour;
	private String fullName;
	private Date expiration;
	private String phoneNumber;
	@ManyToOne
	@JoinColumn(name = "type_id")
	private PaymentType type;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "formOfPayment")
	private List<Transaction> transactions;

	/**
	 * Returns the id of this form of payment
	 * 
	 * @return the id
	 */
	public Long getFormOfPaymentid() {
		return formOfPaymentid;
	}

	/**
	 * Set the id of this form of payment
	 * 
	 * @param formOfPaymentid
	 *            an id
	 */
	public void setFormOfPaymentid(Long formOfPaymentid) {
		this.formOfPaymentid = formOfPaymentid;
	}

	/**
	 * Returns the card number of this form of payment. This should probably be
	 * encrypted...
	 * 
	 * @return the card number
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * Set the card number of this form of payment
	 * 
	 * @param cardNumber
	 *            a card number
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * Returns the last four digits of this form of payment's card number. Could
	 * be useful to display to a user to determine which card is which without
	 * decrypting the credit card number if it were encrypted.
	 * 
	 * @return the last four digits of this form of payment's card number
	 */
	public String getLastFour() {
		return lastFour;
	}

	/**
	 * Set the last four digits of this form of payment's card number
	 * 
	 * @param lastFour
	 *            a string containing four digits
	 */
	public void setLastFour(String lastFour) {
		this.lastFour = lastFour;
	}

	/**
	 * Returns the full name on the card
	 * 
	 * @return the full name
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * Set the full name on the card
	 * 
	 * @param fullName
	 *            a full name
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * Returns the expiration date of this form of payment. Only month and year
	 * are significant, other fields my be anything.
	 * 
	 * @return the expiration date
	 */
	public Date getExpiration() {
		return expiration;
	}

	/**
	 * Set the expiration date of this form of payment. Only month and year are
	 * significant, other fields my be anything.
	 * 
	 * @param expiration
	 *            an expiration date
	 */
	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	/**
	 * Returns the phone number associated with this form of payment
	 * 
	 * @return the phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the phone number associated with this form of payment
	 * 
	 * @param phoneNumber
	 *            a phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Returns the {@link PaymentType} of this form of payment
	 * 
	 * @return the {@link PaymentType}
	 */
	public PaymentType getType() {
		return type;
	}

	/**
	 * Set the {@link PaymentType} of this form of payment
	 * 
	 * @param type
	 *            a {@link PaymentType}
	 */
	public void setType(PaymentType type) {
		this.type = type;
	}

	/**
	 * Returns the {@link User} who owns this form of payment
	 * 
	 * @return the {@link User}
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Set the {@link User} who owns this form of payment
	 * 
	 * @param user
	 *            a {@link User}
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Returns the street address associated with this form of payment
	 * 
	 * @return the street address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Set the address associated with this form of payment
	 * 
	 * @param address
	 *            a street address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Returns the city associated with this form of payment
	 * 
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Set the city associated with this form of payment
	 * 
	 * @param city
	 *            the city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Returns the state (as in place) associated with this form of payment
	 * 
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Set the state associated with this form of payment
	 * 
	 * @param state
	 *            a state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Returns the zip code associated with this form of payment
	 * 
	 * @return the zip code
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * Set the zip code associated with this form of payment
	 * 
	 * @param zipCode
	 *            a zip code
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * Returns the {@link List} of {@link Transaction}s that have used this form
	 * of payment
	 * 
	 * @return the {@link List} of {@link Transaction}s
	 */
	public List<Transaction> getTransactions() {
		return transactions;
	}

	/**
	 * Set the {@link List} of {@link Transaction}s
	 * 
	 * @param transactions
	 *            a {@link List} of {@link Transaction}s
	 */
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
}
