<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param name="title" value="Display Feedback"/>
</jsp:include>


<%@page import="java.util.ArrayList"%>
<%@page import="model.feedback.Feedback"%>



<%
    ArrayList<Feedback> feedbacks = (ArrayList<Feedback>)request.getAttribute("feedbacks");

    for(Feedback feedback : feedbacks)
  {
    out.print("Id: " + feedback.getId());
    out.print("<br/>");
    
    out.print("Event_id: " + feedback.getEvent_id());
    out.print("<br/>");
    
    out.print("User_id: " + feedback.getUser_id());
    out.print("<br/>");
    
    out.print("Description: " + feedback.getDescription());
    out.print("<br/>");
    
    out.print("Rating: " + feedback.getRating());
    out.print("<br/>");
    
    out.print("Created_at: " + feedback.getCreated_at());
    out.print("<br/><br/>");
}



%>


<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>




