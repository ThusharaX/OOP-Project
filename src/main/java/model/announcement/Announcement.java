package model.announcement;



public class Announcement {
	    private int id;
	    private String title;
	    private String description;
	    private String created_at;
    
    
	    public Announcement(int id, String title, String description, String created_at) {
			this.id = id;
			this.title = title;
			this.description = description;
			this.created_at = created_at;
	    }
	    
	    

	    /**
		 * @param title
		 * @param description
		 */
		public Announcement(String title, String description) {
			this.title = title;
			this.description = description;
		}

		

		/**
		 * @param id
		 * @param title
		 * @param description
		 */
		public Announcement(int id, String title, String description) {
			this.id = id;
			this.title = title;
			this.description = description;
		}



		public Announcement() {
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
		
