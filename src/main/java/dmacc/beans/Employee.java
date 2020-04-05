package dmacc.beans;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String badgeNum;
	private String firstName;
	private String lastName;
	

	public Employee() {
		super();
	}
	
	/**
	 * @param id
	 * @param badgeNum
	 * @param firstName
	 * @param lastName
	 */
	public Employee(long id, String badgeNum, String firstName, String lastName) {
		super();
		this.id = id;
		this.badgeNum = badgeNum;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	/**
	 * @param badgeNum
	 * @param firstName
	 * @param lastName
	 */
	public Employee(String badgeNum, String firstName, String lastName) {
		super();
		this.badgeNum = badgeNum;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Employee(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Employee(long id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}


	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the badgeNum
	 */
	public String getBadgeNum() {
		return badgeNum;
	}

	/**
	 * @param badgeNum the badgeNum to set
	 */
	public void setBadgeNum(String badgeNum) {
		this.badgeNum = badgeNum;
	}



	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + firstName + " " + lastName+"]"; // , position = "+position.getTitle()+"]";
	}
}
