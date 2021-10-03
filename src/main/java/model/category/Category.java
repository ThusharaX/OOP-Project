package model.category;


public class Category {


	private	int	id;
	private	String	name;
	private	String	discription;
	
	
	
	public Category(String name, String discription) {
		this.name = name;
		this.discription = discription;
	}


	/**
	 * @param id
	 * @param name
	 * @param discription
	 */
	public Category(int id, String name, String discription) {
		super();
		this.id = id;
		this.name = name;
		this.discription = discription;
		
		
		
		
	}
	
	

	public int getId() {
		return id;
	}
	public Category() {
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

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}
	
	
	
	}


