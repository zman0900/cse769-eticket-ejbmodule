package com.cse769.EJB.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ticketId;
	@ManyToOne
	@JoinColumn(name = "event_id", nullable=false)
	private Event event;
	private boolean soldFlag;
	@ManyToOne
	@JoinColumn(name = "transaction_id", nullable=false)
	private Transaction transaction;
	
	public Long getTicketId() {
		return ticketId;
	}
	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public boolean isSoldFlag() {
		return soldFlag;
	}
	public void setSoldFlag(boolean soldFlag) {
		this.soldFlag = soldFlag;
	}
	public Transaction getTransaction() {
		return transaction;
	}
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
}
