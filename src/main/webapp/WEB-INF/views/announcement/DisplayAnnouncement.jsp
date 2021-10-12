<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param name="title" value="Displayannouncement"/>
</jsp:include>

<%@page import="java.util.ArrayList"%>
<%@page import="model.announcement.announcement"%>

<%



	ArrayList<announcement> announcements = (ArrayList<announcement>)request.getAttribute("announcements");
 
    for(announcement announcement : announcements)
    {
        out.print("Id: " + announcement.getId());
        out.print("<br/>");
        out.print("Title: " + announcement.getTitle());
        out.print("<br/>");
        out.print("Description: " + announcement.getDescription());
        out.print("<br/>");
        out.print("Created_at: " + announcement.getCreated_at());
        out.print("<br/>");

    }
%>



















































<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>