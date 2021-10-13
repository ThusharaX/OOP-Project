<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param name="title" value="Dashboard"/>
</jsp:include>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%
	String role = (String)session.getAttribute("role");
%>

<!-- <a href="/profile" class="btn btn-primary">Profile</a> -->

<c:choose>
    <c:when test="${role.equals('admin')}">
    	<h1 class="text-3xl font-bold mb-4">Admin Dashboard</h1>
        <jsp:include page="/WEB-INF/views/user/dashboards/adminPanel.jsp"></jsp:include>
    </c:when>
    
    <c:when test="${role.equals('event_manager')}">
    	<h1 class="text-3xl font-bold mb-4">Event Manager Dashboard</h1>
        <jsp:include page="/WEB-INF/views/user/dashboards/eventManagerPanel.jsp"></jsp:include>
    </c:when>
    
    <c:when test="${role.equals('attendee')}">
    	<h1 class="text-3xl font-bold mb-4">Attendee Dashboard</h1>
        <jsp:include page="/WEB-INF/views/user/dashboards/attendeePanel.jsp"></jsp:include>
    </c:when>
</c:choose>



<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>