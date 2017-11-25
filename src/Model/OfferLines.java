package Model;

public class OfferLines {
	
	
	private int Order_header_id;
	private int line_number;
	private int quantity;
	private int customer_id;
	private int item_id;
	
	
	
	
	
	
	public OfferLines(int line_number, int quantity, int customer_id, int item_id) {
		super();
		this.line_number = line_number;
		this.quantity = quantity;
		this.customer_id = customer_id;
		this.item_id = item_id;
	}
	
	
	public OfferLines() {
		// TODO Auto-generated constructor stub
	}


	public int getOrder_header_id() {
		return Order_header_id;
	}
	public void setOrder_header_id(int order_header_id) {
		Order_header_id = order_header_id;
	}
	public int getLine_number() {
		return line_number;
	}
	public void setLine_number(int line_number) {
		this.line_number = line_number;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	
	
}
