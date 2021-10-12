package model.message;

public class Message {

	private	int id;
	private	String name;
	private	String email;
	private	String subject;
	private	String message;
	private String create_at;
	
	
	
	/**
	 * 
	 */
	public Message() {
	}

	

	/**
	 * @param id
	 * @param name
	 * @param email
	 * @param subject
	 * @param message
	 */
	public Message(int id, String name, String email, String subject, String message) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.message = message;
	}



	public Message(int id, String name, String email, String subject, String message, String create_at) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.message = message;
		this.create_at = create_at;
	}


	public Message(String name, String email, String subject, String message, String create_at) {
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.message = message;
		this.create_at = create_at;
	}


	public Message(String name, String email, String subject, String message) {
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.message = message;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getCreate_at() {
		return create_at;
	}


	public void setCreate_at(String create_at) {
		this.create_at = create_at;
	}
	
	
	
	
}



