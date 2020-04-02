package dmacc.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Position {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String title;
	
	
	public Position() {
		super();}

	/**
	 * @param title
	 */
	public Position(String title) {
		super();
		this.title = title;
	}

	/**
	 * @return the id
	 */
	public long getid() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setid(long id) {
		this.id = id;
	}



	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}



	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}



	@Override
	public String toString() {
		return "Position [title=" + title +"]";
	}

}
