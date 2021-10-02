<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param name="title" value="Profile"/>
</jsp:include>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="model.user.User"%>

<%
    User user = (User)request.getAttribute("user");
%>


<h1>${user.getFname()} ${user.getLname()}</h1>


<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>