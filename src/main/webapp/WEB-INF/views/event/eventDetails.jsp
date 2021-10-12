<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param name="title" value="Event Detail"/>
</jsp:include>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.event.Event"%>
<%@page import="model.feedback.Feedback"%>


<%
    Event event = (Event)request.getAttribute("event");
	ArrayList<Feedback> feedbacks = (ArrayList<Feedback>)request.getAttribute("feedbacks");
%>


<h2>Id : ${event.getId()}</h2>
<h2>Name : ${event.getName()}</h2>
<h2>Description : ${event.getDescription()}</h2>
<h2>Date : ${event.getDate()}</h2>
<h2>Time : ${event.getTime()}</h2>
<h2>AvailableTickets : ${event.getAvailableTickets()}</h2>
<h2>EventManagerId : ${event.getEventManagerId()}</h2>
<h2>Category : ${request.getAttribute("category")}</h2>

<c:choose>
    <c:when test="${event.getOnlineEvent() == 1}">
        <h2 class="text-green-600">Online</h2>
        <br />
    </c:when>    
    <c:otherwise>
        <h2 class="text-green-600">${event.getVenue()}</h2>
        <br />
    </c:otherwise>
</c:choose>


<c:choose>
    <c:when test="${event.getStatus() == 1}">
    	<p class="text-green-600">
			<b><i class="fas fa-info-circle"></i> Status : </b>
				Active
		</p>
		</br>
        <a href="add-ticket?eid=${event.getId()}" class="btn btn-success">
			<i class="fa fa-ticket-alt"></i> Attend
		</a>

		<a href="/add-feedback?eid=${event.getId()}" class="btn btn-primary">
			<i class="fas fa-comments"></i> Give Feedback
		</a>
    </c:when>    
    <c:otherwise>
    	<p class="text-red-600">
			<b><i class="fas fa-info-circle"></i> Status : </b>
				Inactive
		</p>
		</br>
        <a href="#" class="btn btn-success disabled">
			<i class="fa fa-ticket-alt"></i> Attend
		</a>
    </c:otherwise>
</c:choose>

</br>
</br>

<h1>Feedbacks</h1>
<%
	for(Feedback feedback : feedbacks)
	{
	    out.print("Id: " + feedback.getDescription());
	    //out.print("<br/>");
	    
	    if ((Integer)session.getAttribute("id") == feedback.getUser_id()) {
	    	out.print("<a class='btn btn-success btn-sm' href='/update-feedback?fid=" + feedback.getId() + "'>Update</a>");
	    	out.print("<a class='btn btn-danger btn-sm' href='/delete-feedback?fid=" + feedback.getId() + "&eid=" + event.getId() + "'>Delete</a>");
	    }
	    
	    out.print("<br/>");
	    out.print("<br/>");
	}
%>


<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>