<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param name="title" value="Home"/>
</jsp:include>

<%@page import="java.util.ArrayList"%>
<%@page import="model.user.User"%>



<%
	//ArrayList<User> users = (ArrayList<User>)request.getAttribute("users");
 
    //for(User user : users)
    //{
    //    out.print("Id: " + user.getId());
    //    out.print("<br/>");
    //    out.print("Name: " + user.getFname() + user.getLname());
    //    out.print("<br/>");
    //}
%>

<%
	//allow access only if session exists
	//int id;
	//String role = null;

	//if(session.getAttribute("id") == null){
	//	response.sendRedirect("/login");
	//}
	//else {
	//	id = (int) session.getAttribute("id");
	//	role = (String) session.getAttribute("role");
		
	//	out.print("ID : " + id);
	//	out.print("Role : " + role);
	//}
%>

<script src="${pageContext.request.contextPath}/js/home.js"></script>

<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>