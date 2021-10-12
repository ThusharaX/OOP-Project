<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param name="title" value="Update Announcement"/>
</jsp:include>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.announcement.Announcement"%>

<%
	Announcement announcement = (Announcement)request.getAttribute("announcement");
%>	

<form class="flex justify-center" action="/update-announcement?aid=${announcement.getId()}" method="post">
    <div class="form-group">
        <label for="title">Announcement Title</label>
        <input value="${announcement.getTitle()}" type="text" class="form-control" id="title" name="title" placeholder="Announcement Title">

        <label for="description">Announcement Description</label>
        <input value="${announcement.getDescription()}" type="text" class="form-control" id="description" name="description" placeholder="Announcement Description">
        
        <button type="submit" class="btn btn-primary">Update Announcement</button>

    </div>
</form>


<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>