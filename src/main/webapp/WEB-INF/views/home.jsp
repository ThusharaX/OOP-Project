<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param name="title" value="Home"/>
</jsp:include>

<%@page import="java.util.ArrayList"%>
<%@page import="model.user.User"%>

<style>
	.masthead {
		  height: 100vh;
		  min-height: 500px;
		  background-image: url('https://source.unsplash.com/BtbjCFUvBXs/1920x1080');
		  background-size: cover;
		  background-position: center;
		  background-repeat: no-repeat;
}
</style>

<!-- Full Page Image Header with Vertically Centered Content -->
<header class="masthead">
  <div class="container h-100">
    <div class="row h-100 align-items-center">
      <div class="col-12 text-center">
        <h1 class="text-7xl fw-light">Event Management System</h1>
        </br>
        <p class="text-xl lead">It's all about Events</p>
      </div>
    </div>
  </div>
</header>

<!-- Page Content -->
<section class="py-5">
  <div class="container">
    <h2 class="fw-light"></h2>
    <p></p>
  </div>
</section>

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