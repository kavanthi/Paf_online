package com.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.Addproduct;
import com.mysql.jdbc.Statement;
import com.util.dbConnect;

public class  viewproductdetails{
	
Connection conn = null;
	
	public ArrayList updateviewbook(Addproduct Addproduct) throws ClassNotFoundException, SQLException 
	{
		//Connect database
		conn = (Connection)dbConnect.conn();
		
		String name = Addproduct.getUsernam();
		
		ArrayList al=null;
		ArrayList viewDetails =new ArrayList();
		String query = "select * from product where username=?";
		
		Statement st1 = (Statement) conn.createStatement();
		ResultSet  rs = st1.executeQuery(query);
		
			while (rs.next()) {
            al = new ArrayList();
            al.add(rs.getString(1));
            al.add(rs.getString(2));
            al.add(rs.getInt(3));
            al.add(rs.getInt(4));
            al.add(rs.getString(5));
            
            viewDetails.add(al);
          
			}
			
		conn.close();
		System.out.println("Disconnected from database");
		
		return viewDetails;
		
	}

}
