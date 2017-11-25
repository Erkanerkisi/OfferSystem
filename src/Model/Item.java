package Model;

public class Item {

	public Item(int itemId, String itemDesc) {
		super();
		this.itemId = itemId;
		this.itemDesc = itemDesc;
	}
	private int itemId;
	private String itemNumber;
	private String itemDesc;
	
	
	
	public Item () {
		
	};
	
	
	public Item(int itemId, String itemNumber, String itemDesc) {
		super();
		this.itemId = itemId;
		this.itemNumber = itemNumber;
		this.itemDesc = itemDesc;
		
		
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemNumber() {
		return itemNumber;
	}
	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	
	
	
}
