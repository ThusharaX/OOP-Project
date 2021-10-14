<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.announcement.Announcement"%>
<%@page import="model.category.Category"%>
<%@page import="model.message.Message"%>
<%@page import="model.user.User"%>

<%
	ArrayList<Announcement> announcements = (ArrayList<Announcement>)request.getAttribute("announcements");
	ArrayList<Category> categories = (ArrayList<Category>)request.getAttribute("categories");	
	ArrayList<Message> messages = (ArrayList<Message>)request.getAttribute("messages");	
	ArrayList<User> users = (ArrayList<User>)request.getAttribute("users");	
%>


<a href="/add-user" class="btn btn-primary">Create User</a>

<div class="table-responsive">
	<table class="table table-striped">
	  <thead>
	    <tr>
		    <th scope="col">ID</th>
			<th scope="col">Fname</th>
			<th scope="col">Lname</th>
			<th scope="col">Email</th>
			<th scope="col">Mobile</th>
			<th scope="col">Address</th>
			<th scope="col">Join Date</th>
			<th scope="col">NIC</th>
			<th scope="col">Role</th>
	    </tr>
	  </thead>
	  <tbody>
	    <c:forEach var="user" items="${users}">
	    	<tr>
	    		<th scope="row">${user.getId()}</th>
				<td>${user.getFname()}</td>
				<td>${user.getLname()}</td>
				<td>${user.getEmail()}</td>
				<td>${user.getMobile()}</td>
				<td>${user.getAddress()}</td>
				<td>${user.getJoin_date()}</td>
				<td>${user.getNIC()}</td>
				<td>${user.getRole()}</td>
	    		
	    		<td><a href="/update-user?id=${user.getId()}" class="btn btn-success btn-sm">Update</a></td>
	    		<td><a href="/delete-user?id=${user.getId()}" class="btn btn-danger btn-sm">Delete</a></td>
	    	</tr>
		</c:forEach>
	  </tbody>
	</table>
</div>


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

<a href="/AddCategory" class="btn btn-primary">Create Category</a>

<div class="table-responsive">
	<table class="table table-striped">
	  <thead>
	    <tr>
		    <th scope="col">ID</th>
			<th scope="col">Name</th>
			<th scope="col">Description</th>
	    </tr>
	  </thead>
	  <tbody>
	    <c:forEach var="category" items="${categories}">
	    	<tr>
	    		<th scope="row">${category.getId()}</th>
				<td>${category.getName()}</td>
				<td>${category.getDiscription()}</td>
	    		
	    		<td><a href="/update-category?cid=${category.getId()}" class="btn btn-success btn-sm">Update</a></td>
	    		<td><a href="/delete-category?cid=${category.getId()}" class="btn btn-danger btn-sm">Delete</a></td>
	    	</tr>
		</c:forEach>
	  </tbody>
	</table>
</div>


<h1 class="flex justify-center text-3xl font-bold mb-4">Messages</h1>

<div class="table-responsive">
	<table class="table table-striped">
	  <thead>
	    <tr>
		    <th scope="col">ID</th>
			<th scope="col">Name</th>
			<th scope="col">Email</th>
		    <th scope="col">Subject</th>
			<th scope="col">Message</th>
			<th scope="col">Created at</th>
	    </tr>
	  </thead>
	  <tbody>
	    <c:forEach var="message" items="${messages}">
	    	<tr>
	    		<th scope="row">${message.getId()}</th>
				<td>${message.getName()}</td>
				<td>${message.getEmail()}</td>
				<td>${message.getSubject()}</td>
				<td>${message.getMessage()}</td>
				<td>${message.getCreate_at()}</td>
	    		
	    		<td><a href="/update-message?mid=${message.getId()}" class="btn btn-success btn-sm">Update</a></td>
	    		<td><a href="/delete-message?mid=${message.getId()}" class="btn btn-danger btn-sm">Delete</a></td>
	    	</tr>
		</c:forEach>
	  </tbody>
	</table>
</div>