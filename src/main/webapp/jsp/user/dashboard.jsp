<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param name="title" value="Profile"/>
</jsp:include>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h1 class="text-3xl font-bold mb-4">Dashboard</h1>

<a href="/profile" class="btn btn-primary">Profile</a>


<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>