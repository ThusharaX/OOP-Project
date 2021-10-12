<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param name="title" value="Add Announcement"/>
</jsp:include>
	

<form class="flex justify-center" action="/create-announcement" method="post">
    <div class="form-group">
        <label for="title">Announcement Title</label>
        <input type="text" class="form-control" id="title" name="title" placeholder="Announcement Title">

        <label for="description">Announcement Description</label>
        <input type="text" class="form-control" id="description" name="description" placeholder="Announcement Description">
        
        <button type="submit" class="btn btn-primary">Add Announcement</button>

    </div>
</form>


<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>