package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.DropDownList;
import Model.Item;
import _JSP.DbConnection;

public class dropDownLists {
	
	  private static final String SQL_DDL_BY_TYPE =
		        "SELECT * FROM Dropdownlists_v WHERE type = ?";
	
	static PreparedStatement  ps= null;
	static ResultSet rs= null;
	static Connection con= null;
	
	
	
	public static List<DropDownList> getDropDownListElementsByType(String type) throws Exception {
        return getDropDownListElementsByType(type,SQL_DDL_BY_TYPE);
    }

	
	
	private static List<DropDownList> getDropDownListElementsByType (String type,String SQL_DDL_BY_TYPE)  throws Exception
	{
		
		 		List <DropDownList> ddl = new ArrayList<>();
		try {
			con = DbConnection.getConnection();
			String sql = SQL_DDL_BY_TYPE;
			ps = con.prepareStatement(sql);
			ps.setString(1, type);
			rs = ps.executeQuery();
			
			
			
			while(rs.next()) {
				
				int id = rs.getInt("id");
				//String item_num=rs.getString("item_number");
				String name=rs.getString("name");
				String Type=rs.getString("type");
				
				DropDownList tempDDL = new DropDownList ( id, name,Type);
				ddl.add(tempDDL);

			}
		
			
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		finally {
			
			con.close();
			ps.close();
			rs.close();
		}
		
		return ddl;

		
	}
	
	
	

}
