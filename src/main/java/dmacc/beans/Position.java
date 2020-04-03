package dmacc.beans;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Position {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long position_id;
	private String title;
	
	public Position() {
		super();}
	/**
	 * @param position_id
	 */
	public Position(long position_id) {
		super();
		this.position_id = position_id;
	}
	/**
	 * @param title
	 */
	public Position( String title) {
		super();
		this.title = title;
	}
	/**
	 * @param position_id
	 * @param title
	 */
	public Position(long position_id, String title) {
		super();
		this.position_id = position_id;
		this.title = title;
	}



	/**
	 * @return the position_id
	 */
	public long getPosition_id() {
		return position_id;
	}



	/**
	 * @param position_id the position_id to set
	 */
	public void setPosition_id(long position_id) {
		this.position_id = position_id;
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
		return "Position [title=" + title + "]";
	}

}
