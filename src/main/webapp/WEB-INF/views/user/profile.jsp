<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param name="title" value="Profile"/>
</jsp:include>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="model.user.User"%>

<%
    User user = (User)request.getAttribute("user");
%>


<h1>${user.getFname()} ${user.getLname()}</h1>
<h1>${user.getEmail()}</h1>
<h1>${user.getMobile()}</h1>
<h1>${user.getAddress()}</h1>
<h1>${user.getJoin_date()}</h1>
<h1>${user.getNIC()}</h1>
<h1>${user.getRole()}</h1>

<a href="/update-user" class="btn btn-success">Update</a>
<a href="/delete-user" class="btn btn-danger">Delete</a>

<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>