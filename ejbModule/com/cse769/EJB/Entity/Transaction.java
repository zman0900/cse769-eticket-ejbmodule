package com.cse769.EJB.Entity;

//@Entity
public class Transaction {
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private FormOfPayment formOfPayment;
	private User user;
	private Ticket ticket;
	private Boolean isCompleted;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public FormOfPayment getFormOfPayment() {
		return formOfPayment;
	}
	public void setFormOfPayment(FormOfPayment formOfPayment) {
		this.formOfPayment = formOfPayment;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public Boolean getIsCompleted() {
		return isCompleted;
	}
	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
}
