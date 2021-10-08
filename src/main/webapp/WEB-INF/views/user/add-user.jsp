<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param name="title" value="Add User"/>
</jsp:include>

	<form class="flex justify-center" action="/add-user" method="post">
	    <div class="form-group">
	        <label for="fname">First Name</label>
	        <input type="text" class="form-control" id="fname" name="fname" placeholder="First Name">
	
	        <label for="lname">Last Name</label>
	        <input type="text" class="form-control" id="lname" name="lname" placeholder="Last Name">
	
	        <label for="email">Email</label>
	        <input type="email" class="form-control" id="email" name="email" placeholder="Email">
	
	        <label for="password">Password</label>
	        <input type="password" class="form-control" id="password" name="password" placeholder="Password">
	
	        <label for="re-password">Password</label>
	        <input type="password" class="form-control" id="re-password" name="re-password" placeholder="Retype Password">
	
	        <label for="mobile">Mobile</label>
	        <input type="text" class="form-control" id="mobile" name="mobile" placeholder="Mobile">
	
	        <label for="address">Address</label>
	        <input type="text" class="form-control" id="address" name="address" placeholder="Address">
	
	        <label for="NIC">NIC</label>
	        <input type="text" class="form-control" id="NIC" name="NIC" placeholder="NIC">
	
	        <label for="role">Role</label>
	        <select class="form-control" id="role" name="role">
	            <!-- <option value="admin">Admin</option> -->
	            <option value="event_manager">Event Manager</option>
	            <option value="attendee">Attendee</option>
	        </select>
	
	        <button type="submit" class="btn btn-primary">Submit</button>
	        
	        <a href="/login">Login</a>
	
	    </div>
	</form>

<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>