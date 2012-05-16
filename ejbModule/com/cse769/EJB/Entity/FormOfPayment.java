package com.cse769.EJB.Entity;

import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	private Set<Transaction> transactions;

	public Long getFormOfPaymentid() {
		return formOfPaymentid;
	}

	public void setFormOfPaymentid(Long formOfPaymentid) {
		this.formOfPaymentid = formOfPaymentid;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getLastFour() {
		return lastFour;
	}

	public void setLastFour(String lastFour) {
		this.lastFour = lastFour;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public PaymentType getType() {
		return type;
	}

	public void setType(PaymentType type) {
		this.type = type;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}
}
