<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.event.Event"%>

<%
	ArrayList<Event> events = (ArrayList<Event>)request.getAttribute("events");
%>

<a href="/add-event" class="btn btn-primary">Add event</a>

<div class="table-responsive">
	<table class="table table-striped">
	  <thead>
	    <tr>
		    <th scope="col">ID</th>
			<th scope="col">Name</th>
			<th scope="col">Description</th>
			<th scope="col">Date</th>
			<th scope="col">Time</th>
			<th scope="col">Available Tickets</th>
			<th scope="col">Event Manager ID</th>
			<th scope="col">Status</th>
			<th scope="col">Online Event</th>
			<th scope="col">Category ID</th>
			<th scope="col">Venue</th>
	    </tr>
	  </thead>
	  <tbody>
	    <c:forEach var="event" items="${events}">
	    	<tr>
	    		<th scope="row">${event.getId()}</th>
				<td>${event.getName()}</td>
				<td>${event.getDescription()}</td>
				<td>${event.getDate()}</td>
				<td>${event.getTime()}</td>
				<td>${event.getAvailableTickets()}</td>
				<td>${event.getEventManagerId()}</td>
				<td>${event.getStatus()}</td>
				<td>${event.getOnlineEvent()}</td>
				<td>${event.getCategoryId()}</td>
				<td>${event.getVenue()}</td>
	    		
	    		<td><a href="/update-event?eid=${event.getId()}" class="btn btn-success btn-sm">Update</a></td>
	    		<td><a href="/delete-event?eid=${event.getId()}" class="btn btn-danger btn-sm">Delete</a></td>
	    	</tr>
		</c:forEach>
	  </tbody>
	</table>
</div>