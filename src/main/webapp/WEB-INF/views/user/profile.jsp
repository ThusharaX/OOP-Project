<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param name="title" value="Profile"/>
</jsp:include>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="model.user.User"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/user/profile.css"/>

<%
    User user = (User)request.getAttribute("user");
%>


<div class="flex flex-wrap">
	<div class="w-full lg:w-1/2 p-3">
		<div class="bg-white border-2 border-gray-400 rounded shadow-lg">
			<div class="p-4">
				<div class="flex flex-wrap">
					<div class="w-full lg:w-1/2">
						<div class="text-center">
							<img src="https://avatars.dicebear.com/api/micah/${user.getFname()}.svg" class="rounded-full h-48 w-48 object-cover mx-auto">
						</div>
					</div>
					<div class="w-full lg:w-1/2">
						<div class="text-center">
							<h2 class="text-2xl font-bold">${user.getFname()} ${user.getLname()}</h2>
							
							<p class="text-gray-600">
								${user.getEmail()}
							</p>
							<p class="text-gray-600">
								${user.getMobile()}
							</p>
							<p class="text-gray-600">
								${user.getAddress()}
							</p>
							<p class="text-gray-600">
								${user.getJoin_date()}
							</p>
							<p class="text-gray-600">
								${user.getNIC()}
							</p>
							<p class="text-gray-600">
								${user.getRole()}
							</p>
							
							
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
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>



<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>