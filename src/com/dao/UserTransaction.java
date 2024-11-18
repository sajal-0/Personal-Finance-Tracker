package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.user.Transaction;
import com.utility.DataConnection;

public class UserTransaction {

	public boolean addTransaction(Transaction transaction) {
		String sql = "INSERT INTO transactionn_table(userID,amount,type,category,date,desc) VALUES(?,?,?,?,?,?)";

		try {
			Connection con = DataConnection.getConnection();

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, transaction.getUserID());
			ps.setInt(2, transaction.getAmount());
			ps.setString(3, transaction.getType());
			ps.setString(4, transaction.getCategory());
			ps.setDate(5, new java.sql.Date(transaction.getDate().getTime()));
			ps.setString(6, transaction.getDesc());

			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public List<Transaction> allTransaction(int userID) {

		List<Transaction> list = new ArrayList<>();

		String sql = "SELECT * FROM transaction_table WHERE userID = ?";

		try {
			Connection con = DataConnection.getConnection();

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, userID);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Transaction transaction = new Transaction(rs.getInt("traID"), rs.getInt("userID"), rs.getInt("amount"),
						rs.getString("type"), rs.getString("category"), rs.getDate("date"), rs.getString("desc"));

				list.add(transaction);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public boolean updateTransaction(Transaction transaction) {
		String sql = "UPDATE transaction_table SET amount = ? , type = ? , category = ? , date = ? , desc = ? WHERE traID = ? , userID = ?";

		try {
			Connection con = DataConnection.getConnection();

			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, transaction.getAmount());
			ps.setString(2, transaction.getType());
			ps.setString(3, transaction.getCategory());
			ps.setDate(4, new java.sql.Date(transaction.getDate().getTime()));
			ps.setString(5, transaction.getDesc());
			ps.setInt(6, transaction.getUserID());
			ps.setInt(7, transaction.getTraID());
			
			return ps.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteTransaction(int trasactionId, int userId) {
		String sql = "DELETE FROM trasaction_table WHERE traID = ? AND userID = ?";
		
		try {
			Connection con = DataConnection.getConnection();

			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, trasactionId);
			ps.setInt(2, userId);
			
			return ps.executeUpdate()>0;
			
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public double getTotalIncome(int userID) {
        String sql = "SELECT SUM(amount) AS totalIncome FROM Transactions WHERE userID = ? AND type = 'income'";
        double totalIncome = 0.0;

        try (Connection conn = DataConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Set the userID parameter
            stmt.setInt(1, userID);

            // Execute the query and process the result
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    totalIncome = rs.getDouble("totalIncome");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalIncome;
    }
	public double getTotalExpense(int userID) {
	    String sql = "SELECT SUM(amount) AS totalExpense FROM Transactions WHERE userID = ? AND type = 'expense'";
	    double totalExpense = 0.0;

	    try (Connection conn = DataConnection.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setInt(1, userID);

	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                totalExpense = rs.getDouble("totalExpense");
	            }
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return totalExpense;
	}

}
