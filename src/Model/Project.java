package Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="xxer_Projects_t")
public class Project {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private int project_id;
	
	@Column(name = "Project_number")
	private String Project_number;
	
	@Column(name = "Project_name")
	private String Project_name;
	
	
	@ManyToOne(fetch=FetchType.EAGER,cascade= {CascadeType.PERSIST,
						 CascadeType.MERGE,
					   	 CascadeType.DETACH,
						 CascadeType.REFRESH})
	@JoinColumn(name = "constructor_id")
	private Constructor constructor;
	
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy = "project",
			 cascade= {CascadeType.PERSIST,
			 CascadeType.MERGE,
		   	 CascadeType.DETACH,
			 CascadeType.REFRESH})
	private List<Contact> contacts;

	@OneToMany(fetch=FetchType.EAGER,mappedBy = "project",
			 cascade= {CascadeType.PERSIST,
			 CascadeType.MERGE,
		   	 CascadeType.DETACH,
			 CascadeType.REFRESH})
	public List<Contact> getContacts() {
		return contacts;
	}

	@OneToMany(fetch=FetchType.EAGER,mappedBy = "project",
			 cascade= {CascadeType.PERSIST,
			 CascadeType.MERGE,
		   	 CascadeType.DETACH,
			 CascadeType.REFRESH})
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}


	public Project() {
		// TODO Auto-generated constructor stub
	}


	public Project(String project_number, String project_name) {
		Project_number = project_number;
		Project_name = project_name;
	}


	public int getProject_id() {
		return project_id;
	}


	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}


	public String getProject_number() {
		return Project_number;
	}


	public void setProject_number(String project_number) {
		Project_number = project_number;
	}


	public String getProject_name() {
		return Project_name;
	}


	public void setProject_name(String project_name) {
		Project_name = project_name;
	}


	public Constructor getConstructor() {
		return constructor;
	}


	public void setConstructor(Constructor constructor) {
		this.constructor = constructor;
	}


	public void add (Contact cont) {
	
	if(contacts ==null)
	{
		contacts = new ArrayList<>();
	}
	
	contacts.add(cont);
	cont.setProject_id(this);
	}
}
