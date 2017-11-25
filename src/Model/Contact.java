package Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="xxer_contacts_t")
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private int id;
	private String name_surname;
	private String email;
	private String phone;
	
	
	
	
	@ManyToOne(fetch=FetchType.EAGER,cascade= {CascadeType.PERSIST,
			 CascadeType.MERGE,
		   	 CascadeType.DETACH,
			 CascadeType.REFRESH})
	@JoinColumn(name = "project_id")
	private Project project;
	
	


	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getName_surname() {
		return name_surname;
	}




	public void setName_surname(String name_surname) {
		this.name_surname = name_surname;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPhone() {
		return phone;
	}




	public void setPhone(String phone) {
		this.phone = phone;
	}




	public Project getProject_id() {
		return project;
	}




	public void setProject_id(Project project_id) {
		this.project = project_id;
	}




	public Contact() {

		
	}

}
