<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.feedback.Feedback"%>
<%@page import="model.ticket.Ticket"%>

<%
	ArrayList<Feedback> feedbacks = (ArrayList<Feedback>)request.getAttribute("feedbacks");
	ArrayList<Ticket> tickets = (ArrayList<Ticket>)request.getAttribute("tickets");
%>

<h1 class="flex justify-center text-3xl font-bold mb-4">Feedbacks</h1>

<div class="table-responsive">
	<table class="table table-striped">
	  <thead>
	    <tr>
		    <th scope="col">ID</th>
			<th scope="col">Event ID</th>
			<th scope="col">User ID</th>
			<th scope="col">Description</th>
			<th scope="col">Rating</th>
			<th scope="col">Created at</th>
	    </tr>
	  </thead>
	  <tbody>
	    <c:forEach var="feedback" items="${feedbacks}">
	    	<tr>
	    		<th scope="row">${feedback.getId()}</th>
				<td>${feedback.getEvent_id()}</td>
				<td>${feedback.getUser_id()}</td>
				<td>${feedback.getDescription()}</td>
				<td>${feedback.getRating()}</td>
				<td>${feedback.getCreated_at()}</td>
	    		
	    		<td><a href="/update-feedback?fid=${feedback.getId()}" class="btn btn-success btn-sm">Update</a></td>
	    		<td><a href="/delete-feedback?fid=${feedback.getId()}&eid=${feedback.getEvent_id()}" class="btn btn-danger btn-sm">Delete</a></td>
	    	</tr>
		</c:forEach>
	  </tbody>
	</table>
</div>

<h1 class="flex justify-center text-3xl font-bold mb-4">Tickets</h1>

<div class="table-responsive">
	<table class="table table-striped">
	  <thead>
	    <tr>
		    <th scope="col">ID</th>
			<th scope="col">Event ID</th>
			<th scope="col">User ID</th>
			<th scope="col">Expiry Date</th>
	    </tr>
	  </thead>
	  <tbody>
	    <c:forEach var="ticket" items="${tickets}">
	    	<tr>
	    		<th scope="row">${ticket.getId()}</th>
				<td>${ticket.getEvent_id()}</td>
				<td>${ticket.getUser_id()}</td>
				<td>${ticket.getExpiry_date()}</td>
	    		
	    		<td><a href="/update-ticket?tid=${ticket.getId()}" class="btn btn-success btn-sm">Update</a></td>
	    		<td><a href="/delete-ticket?tid=${ticket.getId()}" class="btn btn-danger btn-sm">Delete</a></td>
	    	</tr>
		</c:forEach>
	  </tbody>
	</table>
</div>