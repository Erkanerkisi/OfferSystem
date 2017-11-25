package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Item;
import Model.Offer;
import Model.OfferItems;
import _JSP.DbConnection;

public class ItemDAO implements IItem {
	
	PreparedStatement  ps= null;
	ResultSet rs= null;
	Connection con= null;

	@Override
	public void addItem(Item i) {
		
		
	}

	@Override
	public List<Item> getListItems() throws Exception {
		
	List<Item> itemList = new ArrayList<>();
		
		
		 
		try {
			con = DbConnection.getConnection();
			String sql = "select item_id,item_desc from xxer_items";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			
			
			while(rs.next()) {
				
				int itemid = rs.getInt("item_id");
				//String item_num=rs.getString("item_number");
				String item_desc=rs.getString("item_desc");
				
				
				Item tempitem = new Item ( itemid, item_desc);
				
				itemList.add(tempitem);
				
				//System.out.println("ADDED - " + rs.getString(2));
			}
		
			
			return itemList;
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		finally {
			
			con.close();
			ps.close();
			rs.close();
		}
		return itemList;
		
	}

	@Override
	public OfferItems getItemInfoById(int itemId) throws Exception {
		
		
		OfferItems tempitem = null;
			try {
				con = DbConnection.getConnection();
				String sql = "select * from xxer_items where item_id = "+itemId;
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				
				
				
				while(rs.next()) {
					
					int itemid = rs.getInt("item_id");
					String item_num=rs.getString("item_number");
					String item_desc=rs.getString("item_desc");
					
					
				    tempitem = new OfferItems ( itemid,item_num, item_desc);
					
					//System.out.println("ADDED - " + rs.getString(2));
				}
			
				
				
			} catch(SQLException e) {
				e.printStackTrace();
				
			}
			
			finally {
				
				con.close();
				ps.close();
				rs.close();
			}
			return tempitem;
		
	}

}
