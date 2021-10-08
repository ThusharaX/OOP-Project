<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css" />
	    
		<script src="https://kit.fontawesome.com/881e7597bb.js" crossorigin="anonymous"></script>
	</head>

<body>
	
	<jsp:include page="/WEB-INF/views/nav.jsp"></jsp:include>
	
	<div class="container my-24">