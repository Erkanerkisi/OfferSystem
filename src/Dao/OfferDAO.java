package Dao;

import java.sql.*;
import java.sql.Date;
import java.text.*;
import java.time.*;
import java.util.*;

import Model.Offer;
import Model.OfferLines;
import _JSP.DbConnection;

public class OfferDAO implements IOfferDAO {
	
	
	PreparedStatement  ps= null;
	ResultSet rs= null;
	Connection con= null;
	
	
	
	@Override
	public void UpdateOffer(Offer o) {
		
		
		try {
			con = DbConnection.getConnection();
			String sql = "update xxer_offers_hdr "
					+ "set ORDER_NUMBER =? , "
					+ "ORDER_TYPE = ?, "
					+ "ORDER_DATE =?, "
					+ "CUSTOMER_ID=? ,"
					+ "TOTAL_AMOUNT=? where order_header_id = ?";
			ps = con.prepareStatement(sql);
			
			
			ps.setString(1, o.getOrder_number());
			ps.setString(2, o.getOrder_type());
			ps.setDate(3, o.getOrder_date());
			ps.setInt(4, o.getCustomer_id());
			ps.setDouble(5, o.getTotal_amount());
			ps.setInt(6, o.getOrder_header_id());
			System.out.println(sql);
			ps.execute();
			con.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		
		
		
	}
	  
	@Override
	public void InsertOffer(Offer o, List <OfferLines> ol) {
		
		try {
			con = DbConnection.getConnection();
			String sql = "insert into xxer_offers_hdr (ORDER_NUMBER, ORDER_TYPE, ORDER_DATE, CUSTOMER_ID, TOTAL_AMOUNT) values (?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			
			
			ps.setString(1, o.getOrder_number());
			ps.setString(2, o.getOrder_type());
			ps.setDate(3, o.getOrder_date());
			ps.setInt(4, o.getCustomer_id());
			ps.setDouble(5, o.getTotal_amount());
			
			
			
			ps.executeUpdate();
			
			for(OfferLines ee : ol) {
			sql = "insert into xxer_offers_lines (line_number, item_id, customer_id, quantity) values (?,?,?,?)";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, ee.getLine_number());
			ps.setInt(2, ee.getItem_id());
			ps.setInt(3, ee.getCustomer_id());
			ps.setInt(4, ee.getQuantity());
			
			System.out.println(sql);
			ps.executeUpdate();
			}
			
			con.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		
		
	}
	
	@Override
	public void InsertOffer(Offer o) {

//		PreparedStatement  ps= null;
//		ResultSet rs= null;
//		Connection con= null;

		try {
			con = DbConnection.getConnection();
			String sql = "insert into xxer_offers_hdr (ORDER_NUMBER, ORDER_TYPE, ORDER_DATE, CUSTOMER_ID, TOTAL_AMOUNT) values (?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			
			
			ps.setString(1, o.getOrder_number());
			ps.setString(2, o.getOrder_type());
			ps.setDate(3, o.getOrder_date());
			ps.setInt(4, o.getCustomer_id());
			ps.setDouble(5, o.getTotal_amount());
			
			
			
			ps.executeUpdate();
			con.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		
	}
	/*
	public static void main(String[] args) throws ParseException {
		
		
		int offerid = 222;

		
			OfferDAO od = new OfferDAO ();
				
			Offer o = od.getOffer(offerid);
			
			System.out.println(o.getOrder_header_id());
			
			System.out.println(o.getOrder_number());
	}
	
	*/

	@Override
	public List<Offer> getListOffers(int pcustomerid) throws Exception {
		
		List<Offer> offerlists = new ArrayList<>();
		
//		PreparedStatement  ps= null;
//		ResultSet rs= null;
//		Connection con= null;
		
		 
		try {
			con = DbConnection.getConnection();
			String sql = "select * from xxer_offers_hdr where customer_id = " + pcustomerid + "";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			
			
			while(rs.next()) {
				
				int order_header_id = rs.getInt("Order_header_id");
				int customer_id=rs.getInt("customer_id");
				Date order_date = rs.getDate("order_date");
				double total_amount=rs.getDouble("Total_amount");
				String order_number=rs.getString("order_number");
				String order_type=rs.getString("order_type");
				
				
				Offer tempoffer = new Offer ( order_header_id,  order_number,  order_type,  order_date,  customer_id,
						 total_amount);
				
				offerlists.add(tempoffer);
				
				//System.out.println("ADDED - " + rs.getString(2));
			}
		
			
			return offerlists;
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		finally {
			
			con.close();
			ps.close();
			rs.close();
		}
		return offerlists;
		

		
	}
	
	
	@Override
	public List<Offer> getApprovedOffers(int pcustomerid) throws Exception {
		
		List<Offer> offerlists = new ArrayList<>();
		

		 
		try {
			con = DbConnection.getConnection();
			String sql = "select * from xxer_offers_hdr where NVL(status,'NOTAPPROVED') = 'APPROVED' and customer_id = " + pcustomerid + "";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			
			
			while(rs.next()) {
				
				int order_header_id = rs.getInt("Order_header_id");
				int customer_id=rs.getInt("customer_id");
				Date order_date = rs.getDate("order_date");
				double total_amount=rs.getDouble("Total_amount");
				String order_number=rs.getString("order_number");
				String order_type=rs.getString("order_type");
				
				
				Offer tempoffer = new Offer ( order_header_id,  order_number,  order_type,  order_date,  customer_id,
						 total_amount);
				
				offerlists.add(tempoffer);
				
				//System.out.println("ADDED - " + rs.getString(2));
			}
		
			
			return offerlists;
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		finally {
			
			con.close();
			ps.close();
			rs.close();
		}
		return offerlists;
		

		
	}

	@Override
	public List<Offer> getListOfferType(String type) {
		

//		PreparedStatement  ps= null;
//		ResultSet rs= null;
//		Connection con= null;
//		
		List<Offer> list = new ArrayList<Offer>();
		
		try {
			//Connection con = DbConnection.connect();
			String sql = "select * from xxer_offers_hdr where order_type = '" + type + "'";
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			
			
			while(rs.next()) {
				
	
				
				list.add(new Offer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4),rs.getInt(5),rs.getDouble(6)));
				
				
			}
			con.close();
			
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		return list;
		
		
	}

	@Override
	public Offer getOffer(int offerId) {
		

//		PreparedStatement  ps= null;
//		ResultSet rs= null;
//		Connection con= null;
		
		
		Offer tempoffer =null;
		try {
			con = DbConnection.getConnection();
			//Connection con = DbConnection.connect();
			String sql = "select * from xxer_offers_hdr where order_header_id = " + offerId;
			
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			
			
			while(rs.next()) {
				
				int order_header_id = rs.getInt("Order_header_id");
				int customer_id=rs.getInt("customer_id");
				Date order_date = rs.getDate("order_date");
				double total_amount=rs.getDouble("Total_amount");
				String order_number=rs.getString("order_number");
				String order_type=rs.getString("order_type");
				
				tempoffer = new Offer ( order_header_id,  order_number,  order_type,  order_date,  customer_id,
						 total_amount);

				
			}
			con.close();
			
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		return tempoffer;
		
		
	}





	

		
	}
	
	
	
	
	

