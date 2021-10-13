<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param name="title" value="Add Event"/>
</jsp:include>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.category.Category"%>

<%
	ArrayList<Category> categories = (ArrayList<Category>)request.getAttribute("categories");
%>

<h1 class="flex justify-center text-3xl font-bold mb-4">Add Event</h1>

<form class="max-w-lg mx-auto" action="/add-event" method="post">
    <div class="form-group">
        <label for="name">Event Name</label>
        <input type="text" class="form-control" id="name" name="name" placeholder="Event Name">

        <label for="description">Event Description</label>
        <input type="text" class="form-control" id="description" name="description" placeholder="Event Description">

        <label for="date">Event Date</label>
        <input type="date" class="form-control" id="date" name="date" placeholder="Event Date">

        <label for="time">Event Time</label>
        <input type="time" class="form-control" id="time" name="time" placeholder="Event Time">

        <label for="available_tickets">Available Tickets</label>
        <input type="number" class="form-control" id="available_tickets" name="available_tickets" placeholder="Available Tickets">

        <label for="status">Status</label>
        <select class="form-control" id="status" name="status">
            <option value="1">Active</option>
            <option value="0">Inactive</option>
        </select>

        <label for="online_event">Online Event</label>
        <select class="form-control" id="online_event" name="online_event">
            <option value="1">Yes</option>
            <option value="0">No</option>
        </select>
		
        <label for="category_id">Category</label>
        <select class="form-control" id="category_id" name="category_id">
        	<c:forEach var="category" items="${categories}">
				<option value="${category.getId()}">${category.getName()}</option>
			</c:forEach>
        </select>

        <label for="venue">Venue</label>
        <input type="text" class="form-control" id="venue" name="venue" placeholder="Venue">

        <button type="submit" class="btn btn-primary">Add Event</button>

    </div>
</form>


<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>