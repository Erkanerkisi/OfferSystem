package Model;

public class OfferItems {

	private int Order_header_id;
	private int line_id;
	private int line_num;
	private int quantity;
	private int item_id;
	private String item_number;
	private String item_desc;

	public OfferItems(int order_header_id, int line_id, int line_num, int quantity, int item_id) {
		super();
		Order_header_id = order_header_id;
		this.line_id = line_id;
		this.line_num = line_num;
		this.quantity = quantity;
		this.item_id = item_id;
	}
	


	public OfferItems(int item_id, String item_number, String item_desc) {
		super();
		this.item_id = item_id;
		this.item_number = item_number;
		this.item_desc = item_desc;
	}



	public OfferItems() {
		// TODO Auto-generated constructor stub
	}

	public int getOrder_header_id() {
		return Order_header_id;
	}

	public void setOrder_header_id(int order_header_id) {
		Order_header_id = order_header_id;
	}

	public int getLine_id() {
		return line_id;
	}

	public void setLine_id(int line_id) {
		this.line_id = line_id;
	}

	public int getLine_num() {
		return line_num;
	}

	public void setLine_num(int line_num) {
		this.line_num = line_num;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	
	public String getItem_number() {
		return item_number;
	}

	public void setItem_number(String item_number) {
		this.item_number = item_number;
	}

	public String getItem_desc() {
		return item_desc;
	}

	public void setItem_desc(String item_desc) {
		this.item_desc = item_desc;
	}

}
