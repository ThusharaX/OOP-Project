<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param name="title" value="Add Feedback"/>
</jsp:include>

<h1 class="text-3xl font-bold mb-4">Create Feedback</h1>

<form action="/add-feedback" method="post">
    <div class="form-group">
    
    	<%
    		String event_id = request.getParameter("eid");
    	%>
    
        <input type="hidden" id="event_id" name="event_id" value="${event_id}">

        <!-- <input type="hidden" id="user_id" name="user_id" value="${user_id}"> -->

        <label for="description">Description</label>
        <input class="form-control" type="text" name="description" id="description" placeholder="Description" required>
        </br>

        <label for="rating">Rating</label>
        <select class="form-control" name="rating" id="rating">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
        </select>
        </br>

        <button type="submit" class="btn btn-primary">Send</button>

    </div>
</form>


<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>