package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Addproduct;
import com.util.dbConnect;

public class updateproductdb {
	Connection conn = null;
	
	public void updatebookdb(Addproduct Addproduct) throws SQLException {
		
		conn = (Connection)dbConnect.conn();
		
		String no = Addproduct.getProductId();
		
		
			String query3 = "update product set title=?,copyno=?,price=?,description=? where no ="+no+"";
	
			
			
				PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query3);
			    
			    ps.setString(1, Addproduct.getProductId());
				ps.setString(2, Addproduct.getProductTitle());
				ps.setInt(3, Addproduct.getTotalcopy());
				ps.setInt(4, Addproduct.getPrice());
				ps.setString(5, Addproduct.getDescription());
			
			conn.close();
			System.out.println("Disconnected from database");
			
			}
}

