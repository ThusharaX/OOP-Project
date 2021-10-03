<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param name="title" value="Event Detail"/>
</jsp:include>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="model.event.Event"%>


<%
    Event event = (Event)request.getAttribute("event");
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
        <a href="bookTicket?id=${event.getId()}" class="btn btn-success">
			<i class="fa fa-ticket-alt"></i> Attend
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



<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>