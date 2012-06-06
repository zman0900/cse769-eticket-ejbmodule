package com.cse769.EJB.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Responsible for retaining information about a single {@link Ticket} to an
 * event. Tickets to events are generated automatically by the system at the
 * time of Event creation.
 * 
 * @author group3
 */
@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ticketId;
	@ManyToOne
	@JoinColumn(name = "event_id")
	private Event event;
	private boolean soldFlag;
	@OneToOne
	@JoinColumn(name = "transaction_id", unique = true)
	private Transaction transaction;

	/**
	 * Returns the id of the ticket
	 * 
	 * @return the id
	 */
	public Long getTicketId() {
		return ticketId;
	}

	/**
	 * Set the id of this ticket
	 * 
	 * @param ticketId
	 *            an id
	 */
	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	/**
	 * Returns the {@link Event} this ticket is for
	 * 
	 * @return the {@link Event}
	 */
	public Event getEvent() {
		return event;
	}

	/**
	 * Set the {@link Event} this ticket is for
	 * 
	 * @param event
	 *            an {@link Event}
	 */
	public void setEvent(Event event) {
		this.event = event;
	}

	/**
	 * A boolean value representing if the ticket has been sold
	 * 
	 * @return true if the ticket is sold
	 */
	public boolean isSoldFlag() {
		return soldFlag;
	}

	/**
	 * Set the ticket to sold
	 * 
	 * @param soldFlag
	 *            true if the ticket is sold
	 */
	public void setSoldFlag(boolean soldFlag) {
		this.soldFlag = soldFlag;
	}

	/**
	 * Returns the {@link Transaction} used to purchase this ticket or null if
	 * not sold
	 * 
	 * @return the {@link Transaction} or null
	 */
	public Transaction getTransaction() {
		return transaction;
	}

	/**
	 * Set the {@link Transaction} used to purchase this ticket
	 * 
	 * @param transaction
	 *            a {@link Transaction}
	 */
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
}
