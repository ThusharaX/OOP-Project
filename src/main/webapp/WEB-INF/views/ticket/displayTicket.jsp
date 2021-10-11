<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param name="title" value="Display Feedback"/>
</jsp:include>


<%@page import="java.util.ArrayList"%>
<%@page import="model.ticket.Ticket"%>



<%
    ArrayList<Ticket> tickets = (ArrayList<Ticket>)request.getAttribute("tickets");

    for(Ticket ticket : tickets)
  {
    out.print("Id: " + ticket.getId());
    out.print("<br/>");
    
    out.print("Event_id: " + ticket.getEvent_id());
    out.print("<br/>");
    
    out.print("User_id: " + ticket.getUser_id());
    out.print("<br/>");
    
    out.print("Expiry_date: " + ticket.getExpiry_date());
    out.print("<br/><br/>");
    
    
}



%>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
