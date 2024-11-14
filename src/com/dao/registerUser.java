package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.utility.DataConnection;

public class registerUser {

	public boolean regUser(String username, String password) {
		String sql = "INSERT INTO user_table(username, password) VALUES (?,?)";
		try {
			Connection con = DataConnection.getConnection();

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, username);
			ps.setString(2, password);

			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean loginUser(String username, String password) {
		String sql = "SELECT * FROM user_table WHERE username = ? AND password = ?";

		try {
			Connection con = DataConnection.getConnection();

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, username);
			ps.setString(2, password);

			try(ResultSet rs = ps.executeQuery()){
				return rs.next();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}


