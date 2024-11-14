package com.service;

import java.util.ArrayList;
import java.util.List;

import com.dao.UserTransaction;
import com.user.Transaction;

public class TranService {
	UserTransaction service = null;
	
	
	public boolean addTransaction(Transaction transaction) {
		service = new UserTransaction();
		return true;
	}
	
	public List<Transaction> allTransaction(int userID) {
		service = new UserTransaction();
		List<Transaction> list = service.allTransaction(userID);
		
		return list;
	}
	
	public List<Transaction> TranByType(int userID,String type) {
		service = new UserTransaction();
		List<Transaction> list = service.allTransaction(userID);
		List<Transaction> FilterBytype = new ArrayList<>();
		for(Transaction tra : list) {
			if(tra.getType().equalsIgnoreCase(type)) {
				FilterBytype.add(tra);
			}
		}
		
		
		return FilterBytype;
	}

}
