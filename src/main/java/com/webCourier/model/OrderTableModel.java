package com.webCourier.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class OrderTableModel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	long id; 
 	String trackingNum;
 	String senderName;
 	String senderEmail;
 	String senderPhone;
 	String senderAddress;
	String orderDate;
 	String docType;
	String contents;
	String weight;
	int quantity;
	int amount;
 	String receiveName;
 	String receiveEmail;
 	String receiverPhon;
 	String receiverAddress;
	String status;
	public OrderTableModel() {
		super();
	}
	public OrderTableModel(long id, String trackingNum, String senderName, String senderEmail, String senderPhone,
			String senderAddress, String orderDate, String docType, String contents, String weight, int quantity,
			int amount, String receiveName, String receiveEmail, String receiverPhon, String receiverAddress,
			String status) {
		super();
		this.id = id;
		this.trackingNum = trackingNum;
		this.senderName = senderName;
		this.senderEmail = senderEmail;
		this.senderPhone = senderPhone;
		this.senderAddress = senderAddress;
		this.orderDate = orderDate;
		this.docType = docType;
		this.contents = contents;
		this.weight = weight;
		this.quantity = quantity;
		this.amount = amount;
		this.receiveName = receiveName;
		this.receiveEmail = receiveEmail;
		this.receiverPhon = receiverPhon;
		this.receiverAddress = receiverAddress;
		this.status = status;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTrackingNum() {
		return trackingNum;
	}
	public void setTrackingNum(String trackingNum) {
		this.trackingNum = trackingNum;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getSenderEmail() {
		return senderEmail;
	}
	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}
	public String getSenderPhone() {
		return senderPhone;
	}
	public void setSenderPhone(String senderPhone) {
		this.senderPhone = senderPhone;
	}
	public String getSenderAddress() {
		return senderAddress;
	}
	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getReceiveName() {
		return receiveName;
	}
	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}
	public String getReceiveEmail() {
		return receiveEmail;
	}
	public void setReceiveEmail(String receiveEmail) {
		this.receiveEmail = receiveEmail;
	}
	public String getReceiverPhon() {
		return receiverPhon;
	}
	public void setReceiverPhon(String receiverPhon) {
		this.receiverPhon = receiverPhon;
	}
	public String getReceiverAddress() {
		return receiverAddress;
	}
	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
 
	
	
	
	
	
	
	
	

}
