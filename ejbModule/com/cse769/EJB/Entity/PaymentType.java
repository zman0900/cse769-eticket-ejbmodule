package com.cse769.EJB.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class PaymentType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long paymentId;
	@NotNull
	private String name;
	@OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
	private List<FormOfPayment> formOfPayment;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
	public List<FormOfPayment> getFormOfPayment() {
		return formOfPayment;
	}
	public void setFormOfPayment(List<FormOfPayment> formOfPayment) {
		this.formOfPayment = formOfPayment;
	}
}
