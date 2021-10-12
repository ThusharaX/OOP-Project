<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.announcement.Announcement"%>

<%
	ArrayList<Announcement> announcements = (ArrayList<Announcement>)request.getAttribute("announcements");
%>

<h1>Admin Panel</h1>

<a href="/create-announcement" class="btn btn-primary">Create Announcement</a>

<div class="table-responsive">
	<table class="table table-striped">
	  <thead>
	    <tr>
		    <th scope="col">ID</th>
			<th scope="col">Title</th>
			<th scope="col">Description</th>
			<th scope="col">Created Date</th>
	    </tr>
	  </thead>
	  <tbody>
	    <c:forEach var="announcement" items="${announcements}">
	    	<tr>
	    		<th scope="row">${announcement.getId()}</th>
				<td>${announcement.getTitle()}</td>
				<td>${announcement.getDescription()}</td>
				<td>${announcement.getCreated_at()}</td>
	    		
	    		<td><a href="/update-announcement?aid=${announcement.getId()}" class="btn btn-success btn-sm">Update</a></td>
	    		<td><a href="/delete-announcement?aid=${announcement.getId()}" class="btn btn-danger btn-sm">Delete</a></td>
	    	</tr>
		</c:forEach>
	  </tbody>
	</table>
</div>