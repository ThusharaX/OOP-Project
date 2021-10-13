<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param name="title" value="Update Ticket"/>
</jsp:include>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="model.ticket.Ticket"%>

<%
	Ticket ticket = (Ticket)request.getAttribute("ticket");
%>

<h1 class="text-3xl font-bold mb-4">Update Ticket</h1>
<form action="/add-ticket" method="post">
    <div class="form-group">	    
	    <label for="tid"><h2><b>Ticket ID</b></h2></label><br>
	    <input readonly value="${ticket.getId()}" type="text" class="form-control" id="tid" name="tid" placeholder="tid"><br><br>

	    <label for="event_id"><h2><b>Event ID</b></h2></label><br>
	    <input value="${ticket.getEvent_id()}" type="text" class="form-control" id="event_id" name="event_id" placeholder="event_id"><br><br>
    
	    <label for="user_id"><h2><b>User ID</b></h2></label><br>
	    <input value="${ticket.getUser_id()}" type="text" class="form-control" id="user_id" name="user_id" placeholder="user_id"> <br><br>
    
	    <label for="expiry_date"><h2><b>Expire Date</b></h2></label><br>
	    <input readonly value="${ticket.getExpiry_date()}" type="date" class="form-control" id="expiry_date" name="expiry_date" placeholder="expiry_date"> <br><br>
	
	    <button type="submit" class="btn btn-primary">Create Ticket</button>  
    </div>
</form>


<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>