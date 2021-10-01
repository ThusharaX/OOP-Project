<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param name="title" value="Category display"/>
</jsp:include>




<%@page import="java.util.ArrayList"%>
<%@page import="model.category.Category"%>

<%



	ArrayList<Category> categories = (ArrayList<Category>)request.getAttribute("categories");
 
    for(Category category : categories)
    {
        out.print("Id: " + category.getId());
        out.print("<br/>");
        out.print("Name: " + category.getName());
        out.print("<br/>");
        out.print("Description: " + category.getDiscription());
        out.print("<br/>");

    }
%>




<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>