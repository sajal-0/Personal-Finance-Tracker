package com.service;

import java.util.ArrayList;
import java.util.List;

import com.dao.UserTransaction;
import com.dao.registerUser;
import com.user.Transaction;
import com.user.User;

public class TranService {
	UserTransaction serviceTran = null;
	registerUser serviceReg = null;
	
	
	
	public boolean regUser(String username, String password) {
		serviceReg = new registerUser();
		boolean regUser = serviceReg.regUser(username, password);
		return regUser;
	}
	
	public boolean loginUser(String username, String password) {
		serviceReg = new registerUser();
		boolean loginUser=serviceReg.loginUser(username, password);
		return loginUser;
	}
	
	public boolean updateUser(User user) {
		serviceReg = new registerUser();
		boolean updateUser = serviceReg.updateUser(user);
		return updateUser;
	}
	
	public boolean deleteUser(int userID) {
		serviceReg = new registerUser();
		boolean deleteUser =serviceReg.deleteUser(userID);
		return deleteUser;
	}
	
	//  User Transaction
	
	public boolean addTransaction(Transaction transaction) {
		serviceTran = new UserTransaction();
		boolean addTransaction=serviceTran.addTransaction(transaction);
		return addTransaction;
	}
	
	public List<Transaction> allTransaction(int userID) {
		serviceTran = new UserTransaction();
		List<Transaction> allTransaction = serviceTran.allTransaction(userID);
		
		return allTransaction;
	}
	
	public boolean updateTransaction(Transaction transaction) {
		serviceTran = new UserTransaction();
		boolean updateTransaction = serviceTran.updateTransaction(transaction);
		return updateTransaction;
	}
	
	public boolean deleteTransaction(int trasactionId, int userId) {
		serviceTran = new UserTransaction();
		boolean deleteTransaction = serviceTran.deleteTransaction(trasactionId, userId);
		return deleteTransaction;
	}
	
	//Not sure method
	public List<Transaction> getTransactionById(int transactionID){
		serviceTran = new UserTransaction();
		List<Transaction>  list = serviceTran.allTransaction(transactionID);
		List<Transaction> getTransactionById = new ArrayList<>();
		for(Transaction tra : list) {
			getTransactionById.add(tra);
		}
		return getTransactionById;
	}
	
	public List<Transaction> TranByType(int userID,String type) {
		serviceTran = new UserTransaction();
		List<Transaction> list = serviceTran.allTransaction(userID);
		List<Transaction> TranByType = new ArrayList<>();
		for(Transaction tra : list) {
			if(tra.getType().equalsIgnoreCase(type)) {
				TranByType.add(tra);
			}
		}
		return TranByType;
	}
	
	
}
	
	
