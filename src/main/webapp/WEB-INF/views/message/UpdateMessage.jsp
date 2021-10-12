<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param name="title" value="Update Message"/>
</jsp:include>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="model.message.Message"%>

<%
	Message message = (Message)request.getAttribute("message");
%>

<h1 class="text-3xl font-bold mb-4">Update Message</h1>

<form class="flex justify-center" action='/update-message?mid=${message.getId()}' method="post">
	    <div class="form-group">	
	       
	        <label for="name">Name</label>
	        <input value="${message.getName()}" type="text" class="form-control" id="name" name="name" placeholder="Name">
	        
	        <label for="description">Email</label>
	        <input value="${message.getEmail()}" type="text" class="form-control" id="email" name="email" placeholder="Email">
	
			 <label for="name">Subject</label>
	        <input value="${message.getSubject()}" type="text" class="form-control" id="subject" name="subject" placeholder="Subject">
	        
	         <label for="name">Message</label>
	        <input value="${message.getMessage()}" type="text" class="form-control" id="message" name="message" placeholder="Message">	
	
	
	    	<button type="submit" class="btn btn-primary">Update Message</button>  
	    </div>
	</form>
















<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>