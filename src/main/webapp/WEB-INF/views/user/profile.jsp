<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param name="title" value="Profile"/>
</jsp:include>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="model.user.User"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/profile.css"/>

<%
    User user = (User)request.getAttribute("user");
%>

<img src="https://avatars.dicebear.com/api/micah/${user.getFname()}.svg" alt="Avatar" class="profile-avatar">

<h1>${user.getFname()} ${user.getLname()}</h1>
<h1>${user.getEmail()}</h1>
<h1>${user.getMobile()}</h1>
<h1>${user.getAddress()}</h1>
<h1>${user.getJoin_date()}</h1>
<h1>${user.getNIC()}</h1>
<h1>${user.getRole()}</h1>

<a href="/update-user" class="btn btn-success">Update</a>


<!-- Button trigger modal -->
<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModalCenter">
  Delete Account
</button>

<!-- Modal -->
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Are you sure?</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        Do you really want to delete your account?
        This process cannot be undone.
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
        
        <a href="/delete-user" class="btn btn-danger">Yes, Delete</a>
      </div>
    </div>
  </div>
</div>  



<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>