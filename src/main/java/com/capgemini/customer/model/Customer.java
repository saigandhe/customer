package com.capgemini.customer.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")

public class Customer {
	
	@Id
	private int customerId;
	private String customerPassword;
	private String customerName;
	private String customerAddress;
	private String customerEmailId;
	private long mobileNo;
	public Customer() {
		super();
		
	}
	public Customer(int customerId, String customerPassword, String customerName, String customerAddress,
			String customerEmailId, int mobileNo) {
		super();
		this.customerId = customerId;
		this.customerPassword = customerPassword;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerEmailId = customerEmailId;
		this.mobileNo = mobileNo;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public  String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCustomerEmailId() {
		return customerEmailId;
	}
	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerPassword=" + customerPassword + ", customerName="
				+ customerName + ", customerAddress=" + customerAddress + ", customerEmailId=" + customerEmailId
				+ ", mobileNo=" + mobileNo + "]";
	}
	

}
