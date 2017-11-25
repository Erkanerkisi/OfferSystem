package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Offer;
import Model.OfferLines;
import _JSP.DbConnection;

public class OfferLinesDAO {
	
	
	PreparedStatement  ps= null;
	ResultSet rs= null;
	Connection con= null;
	
	
	public void InsertOfferLines(OfferLines ol) {

//		PreparedStatement  ps= null;
//		ResultSet rs= null;
//		Connection con= null;

		try {
			con = DbConnection.getConnection();
			String sql = "insert into xxer_offers_lines (line_number, item_id, customer_id, quantity) values (?,?,?,?)";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, ol.getLine_number());
			ps.setInt(2, ol.getItem_id());
			ps.setInt(3, ol.getCustomer_id());
			ps.setInt(4, ol.getQuantity());
			
			System.out.println(sql);
			ps.executeUpdate();
			con.close();
			
		} catch(SQLException e) {
			System.out.println(e);
			e.printStackTrace();
			
		}
		
		
	}
	
	

}
