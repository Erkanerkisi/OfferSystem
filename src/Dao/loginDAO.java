package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Customer;
import Model.Offer;
import _JSP.DbConnection;

public class loginDAO implements IloginDAO{

	@Override
	public Customer getCustomerInfo(String p_email_address) {
		
		PreparedStatement  ps= null;
		ResultSet rs= null;
		Connection con= null;
		Customer tempCustomer =null;
		
		try {
			con = DbConnection.getConnection();
			String sql = "select * from xxer_customers where email_address = '" + p_email_address + "'";
			
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			
			
			while(rs.next()) {
				
				int customerid = rs.getInt("customer_id");
				String customername=rs.getString("customer_name");
				String emailaddress=rs.getString("email_address");
				String isenable=rs.getString("is_enable");
				String password=rs.getString("password");
				
				tempCustomer = new Customer ( emailaddress,  customerid,  customername,  password,  isenable );

			}
			con.close();
			
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		return tempCustomer;
		
		
	}

	}

