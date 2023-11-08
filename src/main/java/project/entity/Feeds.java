package project.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "notes")  
public class Feeds {

	@Column
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
 
	private String entrydate;
	
 
	private String desc;

	public Feeds() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Feeds(int id, String entrydate, String desc) {
		super();
		this.id = id;
		this.entrydate = entrydate;
		this.desc = desc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEntrydate() {
		return entrydate;
	}

	public void setEntrydate(String entrydate) {
		this.entrydate = entrydate;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	/*@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user")
	private User  user;*/
	
	
}
	
	

