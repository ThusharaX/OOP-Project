<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param name="title" value="Event Detail"/>
</jsp:include>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.event.Event"%>
<%@page import="model.feedback.Feedback"%>
<%@page import="model.user.User"%>


<%
    Event event = (Event)request.getAttribute("event");
	ArrayList<Feedback> feedbacks = (ArrayList<Feedback>)request.getAttribute("feedbacks");
	User event_manager = (User)request.getAttribute("event_manager");
%>

<div class="bg-white shadow-lg rounded-lg overflow-hidden">
    <div class="px-6 py-4">
        <div class="font-bold text-xl mb-2">
            <a href="#">${event.getName()}</a>
        </div>
        <div class="text-gray-700 text-base">
             ${event.getDescription()}
        </div>
        <div class="text-gray-700 text-base">
             Date : ${event.getDate()}
        </div>
        <div class="text-gray-700 text-base">
             Date : ${event.getTime()}
        </div>
    </div>
    <div class="px-6 py-4">
        <span class="inline-block bg-gray-200 rounded-full px-3 py-1 text-sm font-semibold text-gray-700 mr-2">${event_manager.getFname()}</span>
        <span class="inline-block bg-gray-200 rounded-full px-3 py-1 text-sm font-semibold text-gray-700 mr-2">Tickets : ${event.getAvailableTickets()}</span>
		        <c:choose>
		    <c:when test="${event.getOnlineEvent() == 1}">
        		<span class="inline-block bg-gray-200 rounded-full px-3 py-1 text-sm font-semibold text-green-600 mr-2">Online</span>
		        
		    </c:when>    
		    <c:otherwise>
        		<span class="inline-block bg-gray-200 rounded-full px-3 py-1 text-sm font-semibold text-green-600 mr-2">Venue : ${event.getVenue()}</span>
		        
		    </c:otherwise>
		</c:choose>
    
    
	    <c:choose>
		    <c:when test="${event.getStatus() == 1}">
				<span class="inline-block bg-gray-200 rounded-full px-3 py-1 text-sm font-semibold text-green-600 mr-2">Active</span>
				</br>
				</br>
		        <a href="add-ticket?eid=${event.getId()}" class="btn btn-success">
					<i class="fa fa-ticket-alt"></i> Attend
				</a>
		
				<a href="/add-feedback?eid=${event.getId()}" class="btn btn-primary">
					<i class="fas fa-comments"></i> Give Feedback
				</a>
		    </c:when>    
		    <c:otherwise>
				<span class="inline-block bg-gray-200 rounded-full px-3 py-1 text-sm font-semibold text-red-600 mr-2">Inactive</span>
				</br>
				</br>
		        <a href="#" class="btn btn-success disabled">
					<i class="fa fa-ticket-alt"></i> Attend
				</a>
		    </c:otherwise>
		</c:choose>
	</div>
</div>

</br>
</br>

<h1 class="text-3xl font-bold mb-4">Feedbacks</h1>
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