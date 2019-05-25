package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Addproduct;
import com.util.dbConnect;

public class Deleteproduct {
	
	Connection conn = null;
	
	public void Deletebookdb(Addproduct Addproduct) {
		
		conn = (Connection) dbConnect.conn();
		
		try {
			String query2 = "delete from product where no = ?";
			PreparedStatement ps2 = (PreparedStatement) conn.prepareStatement(query2);
			
			ps2.setString(1, Addproduct.getProductId());
			
			ps2.executeUpdate();
			ResultSet rs2 = ps2.executeQuery();
			System.out.println("Successfuly delete product");
			conn.close();
			System.out.println("Disconnected from database");
		
	}catch (SQLException e) {
		e.printStackTrace();
	}
		
		}

}
