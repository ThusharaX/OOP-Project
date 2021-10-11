<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form action="insert" method="post">
		Title <input type="text" name="title"><br>
		Description <input type="text" name="description"><br>
		Date <input type="text" name="created_at"><br>
		
		<input type="submit" name="submit" value="Add">
	</form>


</body>
</html>