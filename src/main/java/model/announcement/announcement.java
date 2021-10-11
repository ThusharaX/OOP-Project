package model.announcement;



public class announcement {
	    private int id;
	    private String title;
	    private String description;
	    private String created_at;
    
    
	    public announcement(int id, String title, String description, String created_at) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.created_at = created_at;
		
	    }

	    public announcement() {
			// TODO Auto-generated constructor stub
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getCreated_at() {
			return created_at;
		}

		public void setCreated_at(String created_at) {
			this.created_at = created_at;
		}
}
		
