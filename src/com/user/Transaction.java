package com.user;

import java.sql.Date;

public class Transaction {
private int traID;
private int userID;
private double amount;
private String type;
private String category;
private Date date;
private String desc;

public Transaction() {
	super();
}

public Transaction(int traID, int userID, int amount, String type, String category, Date date, String desc) {
	super();
	this.traID = traID;
	this.userID = userID;
	this.amount = amount;
	this.type = type;
	this.category = category;
	this.date = date;
	this.desc = desc;
}

public int getTraID() {
	return traID;
}

public void setTraID(int traID) {
	this.traID = traID;
}

public int getUserID() {
	return userID;
}

public void setUserID(int userID) {
	this.userID = userID;
}

public double getAmount() {
	return amount;
}

public void setAmount(double d) {
	this.amount = d;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public String getCategory() {
	return category;
}

public void setCategory(String category) {
	this.category = category;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public String getDesc() {
	return desc;
}

public void setDesc(String desc) {
	this.desc = desc;
}

@Override
public String toString() {
	return "Transaction [traID=" + traID + ", userID=" + userID + ", amount=" + amount + ", type=" + type
			+ ", category=" + category + ", date=" + date + ", desc=" + desc + "]";
}




}
