<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param name="title" value="Update Event"/>
</jsp:include>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.event.Event"%>

<%
	Event event = (Event)request.getAttribute("event");

	//request.setAttribute("event_id", event.getId());
%>

<h1 class="flex justify-center text-3xl font-bold mb-4">Update Event</h1>

<form class="max-w-lg mx-auto" action='/update-event?eid=${event.getId()}' method="post">
    <div class="form-group">
        <label for="name">Event Name</label>
        <input value="${event.getName()}" type="text" class="form-control" id="name" name="name" placeholder="Event Name">

        <label for="description">Event Description</label>
        <input value="${event.getDescription()}" type="text" class="form-control" id="description" name="description" placeholder="Event Description">

        <label for="date">Event Date</label>
        <input value="${event.getDate()}" type="date" class="form-control" id="date" name="date" placeholder="Event Date">

        <label for="time">Event Time</label>
        <input value="${event.getTime()}" type="time" class="form-control" id="time" name="time" placeholder="Event Time">

        <label for="available_tickets">Available Tickets</label>
        <input value="${event.getAvailableTickets()}" type="number" class="form-control" id="available_tickets" name="available_tickets" placeholder="Available Tickets">

        <label for="status">Status</label>
        <select class="form-control" id="status" name="status">
            <option <c:if test="${event.getStatus() == 1}">selected</c:if> value="1">Active</option>
            <option <c:if test="${event.getStatus() == 0}">selected</c:if> value="0">Inactive</option>
        </select>

        <label for="online_event">Online Event</label>
        <select class="form-control" id="online_event" name="online_event">
            <option <c:if test="${event.getOnlineEvent() == 1}">selected</c:if> value="1">Yes</option>
            <option <c:if test="${event.getOnlineEvent() == 0}">selected</c:if> value="0">No</option>
        </select>
		
        <label for="category_id">Category</label>
        <select class="form-control" id="category_id" name="category_id">
        	<c:forEach var="category" items="${categories}">
				<option <c:if test="${event.getCategoryId() == category.getId()}">selected</c:if> value="${category.getId()}">${category.getName()}</option>
			</c:forEach>
        </select>

        <label for="venue">Venue</label>
        <input value="${event.getVenue()}" type="text" class="form-control" id="venue" name="venue" placeholder="Venue">

        <button type="submit" class="btn btn-primary">Update Event</button>

    </div>
</form>

<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>