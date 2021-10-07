<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param name="title" value="Update User"/>
</jsp:include>

<%@page import="model.user.User"%>

<%
    User user = (User)request.getAttribute("user");
%>

<form class="flex justify-center" action="/update-user" method="post">
    <div class="form-group">
        <label for="fname">First Name</label>
        <input value="${user.getFname()}" type="text" class="form-control" id="fname" name="fname" placeholder="First Name">

        <label for="lname">Last Name</label>
        <input value="${user.getLname()}" type="text" class="form-control" id="lname" name="lname" placeholder="Last Name">

        <label for="email">Email</label>
        <input value="${user.getEmail()}" type="email" class="form-control" id="email" name="email" placeholder="Email">

        <label for="mobile">Mobile</label>
        <input value="${user.getMobile()}" type="text" class="form-control" id="mobile" name="mobile" placeholder="Mobile">

        <label for="address">Address</label>
        <input value="${user.getAddress()}" type="text" class="form-control" id="address" name="address" placeholder="Address">

        <label for="NIC">NIC</label>
        <input value="${user.getNIC()}" type="text" class="form-control" id="NIC" name="NIC" placeholder="NIC">

		

        <button type="submit" class="btn btn-success">Update</button>

    </div>
</form>

<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>