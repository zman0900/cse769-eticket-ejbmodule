package com.cse769.EJB.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Represents data about a single transaction produced by the system when a user
 * purchased a {@link Ticket}
 * 
 * @author group3
 */
@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transactionId;
	@ManyToOne
	@JoinColumn(name = "formOfPaymentid", nullable = false)
	private FormOfPayment formOfPayment;
	@ManyToOne
	@JoinColumn(name = "USER_ID", nullable = false)
	private User user;
	@OneToOne(optional = false, mappedBy = "transaction")
	private Ticket ticket;
	private Boolean isCompleted;

	/**
	 * Returns the id of the transaction
	 * 
	 * @return the id
	 */
	public Long getTransactionId() {
		return transactionId;
	}

	/**
	 * Set the id of the transaction
	 * 
	 * @param transactionId
	 *            an id
	 */
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * Returns the {@link FormOfPayment} used for the transaction
	 * 
	 * @return the {@link FormOfPayment}
	 */
	public FormOfPayment getFormOfPayment() {
		return formOfPayment;
	}

	/**
	 * Set the {@link FormOfPayment} used for the transaction
	 * 
	 * @param formOfPayment
	 *            a {@link FormOfPayment}
	 */
	public void setFormOfPayment(FormOfPayment formOfPayment) {
		this.formOfPayment = formOfPayment;
	}

	/**
	 * Returns the {@link User} who performed this transaction
	 * 
	 * @return {@link User}
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Set the {@link User} who performed this transaction
	 * 
	 * @param user
	 *            a {@link User}
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Returns the {@link Ticket} purchased with this transaction
	 * 
	 * @return the {@link Ticket}
	 */
	public Ticket getTicket() {
		return ticket;
	}

	/**
	 * Set the {@link Ticket} purchased with this transaction
	 * 
	 * @param ticket
	 *            a {@link Ticket}
	 */
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	/**
	 * Boolean value representing if this transaction has been successfully
	 * completed
	 * 
	 * @return true if completed
	 */
	public Boolean getIsCompleted() {
		return isCompleted;
	}

	/**
	 * Set if this transaction completed successfully. This should be set by the
	 * ESB after it contacts the payment processing system.
	 * 
	 * @param isCompleted
	 *            true if completed
	 */
	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
}
