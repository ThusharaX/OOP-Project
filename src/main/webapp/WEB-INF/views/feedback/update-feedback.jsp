<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param name="title" value="Update Feedback"/>
</jsp:include>

<%@page import="model.feedback.Feedback"%>

<%
    Feedback feedback = (Feedback)request.getAttribute("feedback");
%>

<form class="flex justify-center" action="/update-feedback?fid=${feedback.getId()}&eid=${feedback.getEvent_id()}" method="post">
    <div class="form-group">

        <label for="description">Description</label>
        <input value="${feedback.getDescription()}" type="text" class="form-control" id="description" name="description" placeholder="Description">

        <label for="rating">Rating</label>
        <input value="${feedback.getRating()}" type="text" class="form-control" id="rating" name="rating" placeholder="Rating">

        <button type="submit" class="btn btn-success">Update</button>

    </div>
</form>

<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>


