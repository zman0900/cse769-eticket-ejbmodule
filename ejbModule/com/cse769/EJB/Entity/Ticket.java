package com.cse769.EJB.Entity;

//@Entity
public class Ticket {

	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Event event;
	private boolean soldFlag;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
}
