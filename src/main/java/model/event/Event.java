/**
 * 
 */
package model.event;


/**
 * @author ThusharaThiwanka
 *
 */
public class Event {
	
	protected int id;
	protected String name;
	protected String description;
	protected String date;
	protected String time;
	protected int availableTickets;
	protected int eventManagerId;
	protected int status;
	protected int onlineEvent;
	protected int categoryId;
	protected String venue;
	
	
	public Event() {}
	
	
	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param date
	 * @param time
	 * @param availableTickets
	 * @param eventManagerId
	 * @param status
	 * @param onlineEvent
	 * @param categoryId
	 * @param venue
	 */
	public Event(int id, String name, String description, String date, String time, int availableTickets,
			int eventManagerId, int status, int onlineEvent, int categoryId, String venue) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.date = date;
		this.time = time;
		this.availableTickets = availableTickets;
		this.eventManagerId = eventManagerId;
		this.status = status;
		this.onlineEvent = onlineEvent;
		this.categoryId = categoryId;
		this.venue = venue;
	}
	
	
	
	/**
	 * @param name
	 * @param description
	 * @param date
	 * @param time
	 * @param availableTickets
	 * @param eventManagerId
	 * @param status
	 * @param onlineEvent
	 * @param categoryId
	 * @param venue
	 */
	public Event(String name, String description, String date, String time, int availableTickets, int eventManagerId,
			int status, int onlineEvent, int categoryId, String venue) {
		this.name = name;
		this.description = description;
		this.date = date;
		this.time = time;
		this.availableTickets = availableTickets;
		this.eventManagerId = eventManagerId;
		this.status = status;
		this.onlineEvent = onlineEvent;
		this.categoryId = categoryId;
		this.venue = venue;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * @return the availableTickets
	 */
	public int getAvailableTickets() {
		return availableTickets;
	}
	/**
	 * @param availableTickets the availableTickets to set
	 */
	public void setAvailableTickets(int availableTickets) {
		this.availableTickets = availableTickets;
	}
	/**
	 * @return the eventManagerId
	 */
	public int getEventManagerId() {
		return eventManagerId;
	}
	/**
	 * @param eventManagerId the eventManagerId to set
	 */
	public void setEventManagerId(int eventManagerId) {
		this.eventManagerId = eventManagerId;
	}
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * @return the onlineEvent
	 */
	public int getOnlineEvent() {
		return onlineEvent;
	}
	/**
	 * @param onlineEvent the onlineEvent to set
	 */
	public void setOnlineEvent(int onlineEvent) {
		this.onlineEvent = onlineEvent;
	}
	/**
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * @return the venue
	 */
	public String getVenue() {
		return venue;
	}
	/**
	 * @param venue the venue to set
	 */
	public void setVenue(String venue) {
		this.venue = venue;
	}
	
	
}
