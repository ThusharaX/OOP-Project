<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param name="title" value="Events"/>
</jsp:include>

<%@page import="java.util.ArrayList"%>
<%@page import="model.event.Event"%>

<%
	ArrayList<Event> events = (ArrayList<Event>)request.getAttribute("events");
 
    for(Event event : events)
    {
        out.print("Id: " + event.getId());
        out.print("<br/>");
        out.print("Name: " + event.getName());
        out.print("<br/>");
    }
%>

<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>