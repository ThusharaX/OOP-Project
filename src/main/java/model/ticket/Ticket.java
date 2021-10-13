package model.ticket;

public class Ticket {

	protected int id;
	protected int event_id;
	protected int user_id;
	protected String expiry_date;
	
	
	public Ticket() {}


	/**
	 * @param id
	 * @param event_id
	 * @param user_id
	 * @param expiry_date
	 */
	public Ticket(int id, int event_id, int user_id, String expiry_date) {
		this.id = id;
		this.event_id = event_id;
		this.user_id = user_id;
		this.expiry_date = expiry_date;
	}


	/**
	 * @param event_id
	 * @param user_id
	 * @param expiry_date 
	 */
	public Ticket(int event_id, int user_id, String expiry_date) {
		this.event_id = event_id;
		this.user_id = user_id;
		this.expiry_date = expiry_date;
	}

	

	/**
	 * @param id
	 * @param event_id
	 * @param user_id
	 */
	public Ticket(int id, int event_id, int user_id) {
		this.id = id;
		this.event_id = event_id;
		this.user_id = user_id;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the event_id
	 */
	public int getEvent_id() {
		return event_id;
	}


	/**
	 * @param event_id the event_id to set
	 */
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}


	/**
	 * @return the user_id
	 */
	public int getUser_id() {
		return user_id;
	}


	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	/**
	 * @return the expiry_date
	 */
	public String getExpiry_date() {
		return expiry_date;
	}


	/**
	 * @param expiry_date the expiry_date to set
	 */
	public void setExpiry_date(String expiry_date) {
		this.expiry_date = expiry_date;
	}
	





}
