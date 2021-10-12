/**
 * 
 */
package model.event;

/**
 * @author ThusharaThiwanka
 *
 */
public class Attendee {
	
	private int id;
	private int event_id;
	private int attendee_id;

	public Attendee() {}

	/**
	 * @param id
	 * @param event_id
	 * @param attendee_id
	 */
	public Attendee(int id, int event_id, int attendee_id) {
		this.id = id;
		this.event_id = event_id;
		this.attendee_id = attendee_id;
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
	 * @return the attendee_id
	 */
	public int getAttendee_id() {
		return attendee_id;
	}

	/**
	 * @param attendee_id the attendee_id to set
	 */
	public void setAttendee_id(int attendee_id) {
		this.attendee_id = attendee_id;
	}
	
	
	
}
