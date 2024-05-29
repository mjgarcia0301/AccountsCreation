package com.accounts.app.domain;

import org.hibernate.annotations.Type;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="Customer_Accounts")
public class AccountsDto {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	int statusId;
	@Column(name="customerName")
	@Size(max = 50)
	private String customerName;
	
	@Column(name="customerMobile")
	@Size(max = 20)
	private String customerMobile;
	
	@Column(name="customerEmail",unique=true)
	@NotBlank(message = "Email is required field")
	@Size(max = 50)
	private String customerEmail;

	@Column(name="address1")
	@Size(max = 100)
	private String address1;

	@Column(name="address2")
	@Size(max = 50)
	private String address2;

	@Column(name="accountTypes")
	@Enumerated(EnumType.STRING)
	private  TypesAccount accountTypes;





	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public TypesAccount getAccountTypes() {
		return accountTypes;
	}

	public void setAccountTypes(TypesAccount accountTypes) {
		this.accountTypes = accountTypes;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public enum TypesAccount {

		Y("Y"), S("Savings"), C("Checking");


		private final String statusId;

		private TypesAccount(String statusId) {
			this.statusId = statusId;
		}

		public String getStatusId() {
			return statusId;
		}
	}
}
