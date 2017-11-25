package Model;

public class Customer {
	
	 private String email_address;
	 private int customerId;
	 private String customerName;
	 private String password;
	 private String isenable;
	
	public Customer() {	
	}
	
	
	public  Customer(String email_address, int customerId, String customerName, String password,String isenable) {
		super();
		this.email_address = email_address;
		this.customerId = customerId;
		this.customerName = customerName;
		this.password = password;
		this.isenable = isenable;
	}
	
	
	


	public  String getIsenable() {
		return isenable;
	}


	public void setIsenable(String isenable) {
		this.isenable = isenable;
	}




	public  String getEmail_address() {
		return email_address;
	}
	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}
	public  int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public  String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public  String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
