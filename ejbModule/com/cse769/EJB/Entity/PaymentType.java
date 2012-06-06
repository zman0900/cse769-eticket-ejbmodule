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
 * Responsible for representing what "type" of {@link FormOfPayment} a user will
 * use. It is an enumeration class which can take on values like: BuckID,
 * CreditCard, PayPal, etc. Additional Types can be easily defined by a system
 * administrator in the application.
 * 
 * @author group3
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "NAME" }))
public class PaymentType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long paymentId;
	@NotNull
	private String name;
	@OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
	private List<FormOfPayment> formOfPayment;

	/**
	 * Returns the id of the payment type
	 * 
	 * @return the id
	 */
	public Long getPaymentId() {
		return paymentId;
	}

	/**
	 * Set the id of the payment type
	 * 
	 * @param paymentId
	 *            an id
	 */
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	/**
	 * Returns the name of the payment type
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of the payment type. Must be unique.
	 * 
	 * @param name
	 *            a unique name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the {@link List} of all {@link FormOfPayment}s of this type
	 * 
	 * @return the {@link List} of all {@link FormOfPayment}s of this type
	 */
	public List<FormOfPayment> getFormOfPayment() {
		return formOfPayment;
	}

	/**
	 * Set the {@link List} of all {@link FormOfPayment}s of this type
	 * 
	 * @param formOfPayment
	 *            a {@link List} of all {@link FormOfPayment}s of this type
	 */
	public void setFormOfPayment(List<FormOfPayment> formOfPayment) {
		this.formOfPayment = formOfPayment;
	}
}
