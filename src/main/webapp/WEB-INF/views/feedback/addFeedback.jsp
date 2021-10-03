<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param name="title" value="Add Feedback"/>
</jsp:include>


<form action="/add-feedback" method="post">
    <fieldset>
        <h1>Create Feedback</h1>

        <label for="event_id">Event ID</label>
        <input type="text" name="event_id" id="event_id" required>

        <label for="user_id">User ID</label>
        <input type="text" name="user_id" id="user_id" required>

        <label for="description">Description</label>
        <input type="text" name="description" id="description" required>

        <label for="rating">Rating</label>
        <input type="text" name="rating" id="rating" required>

        <button type="submit" class="btn btn-primary">Create</button>
	    
	    
    </fieldset>
</form>


<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>