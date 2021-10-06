<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param name="title" value="Contact Us"/>
</jsp:include>



<h1 class="text-3xl font-bold mb-4">Contact Us</h1>

<form class="flex justify-center" action="/AddMessages" method="post">
	    <div class="form-group">	
	       
	        <label for="name">Name</label>
	        <input type="text" class="form-control" id="name" name="name" placeholder="Name">
	        
	        <label for="description">Email</label>
	        <input type="text" class="form-control" id="email" name="email" placeholder="Email">
	
			 <label for="name">Subject</label>
	        <input type="text" class="form-control" id="subject" name="subject" placeholder="Subject">
	        
	         <label for="name">Message</label>
	        <input type="text" class="form-control" id="message" name="message" placeholder="Message">	
	
	
	    	<button type="submit" class="btn btn-primary">Submit</button>  
	    </div>
	</form>
















<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>