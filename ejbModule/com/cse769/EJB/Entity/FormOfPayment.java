package com.cse769.EJB.Entity;

import java.util.Date;

public class FormOfPayment {
	
	protected Integer formOfPaymentid;
	protected String cardNumber;
	protected String lastFour;
	protected String fullName;
	protected Date expiration;	
	protected String phoneNumber;
	protected PaymentType type;
	protected User user;
	//protected Address billingAddress;

}
