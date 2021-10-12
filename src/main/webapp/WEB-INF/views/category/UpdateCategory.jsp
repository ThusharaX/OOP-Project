<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param name="title" value="Update Category"/>
</jsp:include>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="model.category.Category"%>

<%
	Category category = (Category)request.getAttribute("category");
%>

	<form class="flex justify-center" action='/update-category?cid=${category.getId()}' method="post">
	    <div class="form-group">	
	       
	        <label for="name">Name</label>
	        <input value="${category.getName()}" type="text" class="form-control" id="name" name="name" placeholder="Name">
	        
	        <label for="description">Description</label>
	        <input value="${category.getDiscription()}" type="text" class="form-control" id="description" name="description" placeholder="Description">
	
	    	<button type="submit" class="btn btn-primary">Update</button>  
	    </div>
	</form>



<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>