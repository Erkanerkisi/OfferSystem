package Model;
import java.sql.*;
import java.sql.Date;
import java.util.*;
public class Offer {

	private int Order_header_id;
	private String order_number;
	private String order_type;
	private java.sql.Date order_date;
	private int customer_id;
	private double Total_amount;

	public Offer() {

	}


	public Offer(String order_number, String order_type, java.sql.Date offerDate, int customer_id, double total_amount) {
		super();
		this.order_number = order_number;
		this.order_type = order_type;
		this.order_date = offerDate;
		this.customer_id = customer_id;
		Total_amount = total_amount;
	}


	public Offer(int order_header_id, String order_number, String order_type, Date order_date, int customer_id,
			double total_amount) {
		super();
		Order_header_id = order_header_id;
		this.order_number = order_number;
		this.order_type = order_type;
		this.order_date = order_date;
		this.customer_id = customer_id;
		Total_amount = total_amount;
	}




	public int getOrder_header_id() {
		return Order_header_id;
	}

	public void setOrder_header_id(int order_header_id) {
		Order_header_id = order_header_id;
	}

	public String getOrder_number() {
		return order_number;
	}

	public void setOrder_number(String order_number) {
		this.order_number = order_number;
	}

	public String getOrder_type() {
		return order_type;
	}

	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}

	public java.sql.Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public double getTotal_amount() {
		return Total_amount;
	}

	public void setTotal_amount(double total_amount) {
		Total_amount = total_amount;
	}

}
