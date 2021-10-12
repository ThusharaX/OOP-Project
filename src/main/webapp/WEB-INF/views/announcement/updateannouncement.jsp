<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<style type="text/css">
		table {
  			border-collapse: collapse;
		}

		table, th, td {
		  border: 1px solid black;
		}
	</style>
</head>
<body>

	<%
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String created_at = request.getParameter("created_at");
		
	%>
	
	
	<form action="updateannouncement?cusid=${announcement.getId()}' method="post">
	<table>
		<tr>
			<td>Customer ID</td>
			<td><input value="${announcement.getId()}" type="text" name="cusid"></td>
			
    
		</tr>
		<tr>
			<td>Title</td>
			<td><input value="${announcement.getTitle()}"  type="text" name="title" value="<%= title %>"></td>
		</tr>
		<tr>
		<td>Description</td>
		<td><input value="${announcement.getDescription()}"  type="text" name="description" value="<%= description %>"></td>
	</tr>
	<tr>
		<td>Created_at</td>
		<td><input value="${announcement.getCreated_at()}"  type="text" name="created_at" value="<%= created_at %>"></td>
	</tr>
			
	</table>
	<br>
	<input type="submit" name="submit" value="Update">
	</form>

</body>
</html>