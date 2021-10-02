<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param name="title" value="Event Detail"/>
</jsp:include>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="model.event.Event"%>


<%
    Event event = (Event)request.getAttribute("event");
%>


<h1>${event.getName()}</h1>


<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>