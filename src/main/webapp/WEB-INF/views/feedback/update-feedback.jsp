<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param name="title" value="Update User"/>
</jsp:include>

<%@page import="model.feedback.Feedback"%>

<%
    Feedback feedback = (Feedback)request.getAttribute("feedback");
%>

<form class="flex justify-center" action="/update-feedback" method="post">
    <div class="form-group">
        <label for="id">ID</label>
        <input value="${feedback.getId()}" type="text" class="form-control" id="id" name="id" placeholder="ID">

        <label for="event_id">Event_id</label>
        <input value="${feedback.getEvent_id()}" type="text" class="form-control" id="event_id" name="event_id" placeholder="Event_id">

        <label for="user_id">User_id</label>
        <input value="${feedback.getUser_id()}" type="text" class="form-control" id="user_id" name="user_id" placeholder="User_id">

        <label for="description">Description</label>
        <input value="${feedback.getDescription()}" type="text" class="form-control" id="description" name="description" placeholder="Description">

        <label for="rating">Rating</label>
        <input value="${feedback.getRating()}" type="text" class="form-control" id="rating" name="rating" placeholder="Rating">

        <label for="created_at">Created_at</label>
        <input value="${feedback.getCreated_at()}" type="text" class="form-control" id="created_at" name="created_at" placeholder="Created_at"><br>

		

        <button type="submit" class="btn btn-success">Update</button>

    </div>
</form>

<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>


