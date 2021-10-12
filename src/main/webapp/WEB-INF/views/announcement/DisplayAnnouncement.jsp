<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param name="title" value="Announcements"/>
</jsp:include>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.announcement.Announcement"%>


<%
    ArrayList<Announcement> announcements = (ArrayList<Announcement>)request.getAttribute("Announcement");
%>

<c:forEach var="announcement" items="${announcements}">
	<h1>${announcement.getTitle()}</h1>
</c:forEach>

<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>