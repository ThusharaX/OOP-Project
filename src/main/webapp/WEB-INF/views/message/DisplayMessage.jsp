<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param name="title" value="Messages"/>
</jsp:include>



<%@page import="java.util.ArrayList"%>
<%@page import="model.message.Message"%>

<%
	ArrayList<Message> messages = (ArrayList<Message>)request.getAttribute("messages");
 
    for(Message message : messages)
    {
        out.print("Id: " + message.getId());
        out.print("<br/>");
        
        out.print("Name: " + message.getName());
        out.print("<br/>");
        
        out.print("email: " + message.getEmail());
        out.print("<br/>");
        
        out.print("subject: " + message.getSubject());
        out.print("<br/>");
        
        out.print("message: " + message.getMessage());
        out.print("<br/>");
        
        out.print("create_at: " + message.getCreate_at());
        out.print("<br/>");
    }
%>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>