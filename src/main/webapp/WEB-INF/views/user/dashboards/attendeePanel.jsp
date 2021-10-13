<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.ticket.Ticket"%>

<%
	ArrayList<Ticket> tickets = (ArrayList<Ticket>)request.getAttribute("tickets");
%>

<h1>Attendee Panel</h1>