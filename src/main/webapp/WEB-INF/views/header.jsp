<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>
<html>

	<head>
	    <meta charset="ISO-8859-1">
	    <% String title = request.getParameter("title"); %>
	    <title><%= title %></title>
	    
		<!-- Bootstrap CSS -->
	    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
	    
	    <!-- Tailwind CSS -->
	    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">    
	    
	    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" />
	    
		<script src="https://kit.fontawesome.com/881e7597bb.js" crossorigin="anonymous"></script>
	</head>

<body>
<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #e3f2fd;">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="/">EMS</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarSupportedContent">
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	        <li class="nav-item">
	          <a class="nav-link active" aria-current="page" href="/">Home</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="/events">Events</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="/contact-us">Contact Us</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="/categories">Categories</a>
	        </li>
	        
	        <!-- 
	        <li class="nav-item dropdown">
	          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	            Categories
	          </a>
	          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
	            <li><a class="dropdown-item" href="#">IT</a></li>
	            <li><a class="dropdown-item" href="#">Business</a></li>
	            <li><hr class="dropdown-divider"></li>
	            <li><a class="dropdown-item" href="#">Other</a></li>
	          </ul>
	        </li>
	         -->
	        
	        <%
				//allow access only if session exists
				int id;
				String role = (String)session.getAttribute("role");
			
				if(session.getAttribute("id") == null){
					//response.sendRedirect("/login");
					out.print("<li class='nav-item'><a class='nav-link' href='/login'>Login</a></li>");
					out.print("<li class='nav-item'><a class='nav-link' href='/add-user'>Register</a></li>");
				}
				else if (role.equals("admin")) {
					out.print("<li class='nav-item'><a class='nav-link' href='/dashboard'>Admin Panel</a></li>");
					out.print("<li class='nav-item'><a class='nav-link' href='/logout'>Logout</a></li>");
				}
				else {
					out.print("<li class='nav-item'><a class='nav-link' href='/dashboard'>Dashboard</a></li>");
					out.print("<li class='nav-item'><a class='nav-link' href='/logout'>Logout</a></li>");
				}
			%>
			
	      </ul>
	      <form class="d-flex" action="/search" method="get">
	        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="q">
	        <button class="btn btn-outline-success" type="submit">Search</button>
	      </form>
	    </div>
	  </div>
	</nav>

	<div class="container">