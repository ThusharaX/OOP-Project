<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param name="title" value="Search Result"/>
</jsp:include>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.event.Event"%>

<%
    ArrayList<Event> events = (ArrayList<Event>)request.getAttribute("events");
%>

<h1 class="text-3xl font-bold mb-4">Search Result for: ${result}</h1>

<div class="tab-content" id="myTabContent">
        <div class="tab-pane fade show active" id="All" role="tabpanel"
            aria-labelledby="home-tab">
            <c:if test="${events.size() == 0}" var="event" scope="session">
                <h4 class="text-center py-3 empty-events">
                    <i class="far fa-folder-open"></i> No events
                </h4>
            </c:if>
        <div class="row">
            
            <c:forEach var="event" items="${events}">
                <div class="col-md-4">
                    <br>
                    <div class="card">
                        <img class="card-img-top img-fluid"
                            src="http://colomboconferences.com/wp-content/uploads/2018/11/1-3-1080x450-768x320.jpg" alt="">
                        <div class="card-body">
                            <h4 class="card-title text-center">${event.getName()}</h4>
                            <hr>
                            <h5 class="card-title">${event.getDescription()}</h5>
                            
                            <p class="card-text">
                                <b><i class="far fa-calendar-alt"></i> Date:</b> ${event.getDate()}
                            </p>
                            <p class="card-text">
                                <b><i class="fas fa-clock"></i> Time:</b> ${event.getTime()}
                            </p>
                            
                            <p class="card-text">
                                <b><i class="fa fa-user"></i> Manager:</b>
                                    ${event.getEventManagerId()}
                            </p>
                            
                            <p class="card-text">
                                <b><i class="fa fa-ticket-alt"></i> Tickets:</b>
                                    ${event.getAvailableTickets()}
                            </p>
                            
                            <c:choose>
							    <c:when test="${event.getOnlineEvent() == 1}">
							        <p class="card-text">
		                                <b><i class="fas fa-globe-americas"></i> Online Event</b>
		                            </p>
							    </c:when>    
							    <c:otherwise>
							        <p class="card-text">
		                                <b><i class="fas fa-map-marker-alt"></i> Venue:</b>
		                                    ${event.getVenue()}
		                            </p>
							    </c:otherwise>
							</c:choose>
							
							<c:choose>
							    <c:when test="${event.getStatus() == 1}">
							        <p class="card-text text-green-600">
		                                <b><i class="fas fa-info-circle"></i> Status:</b>
		                                Active
		                            </p>
							    </c:when>    
							    <c:otherwise>
							        <p class="card-text text-red-600">
		                                <b><i class="fas fa-info-circle"></i> Status:</b>
		                                Inactive
		                            </p>
							    </c:otherwise>
							</c:choose>

                        </div>
                        <div class="col text-center">
                        <a href="eventDetails?id=${event.getId()}" class="btn btn-danger">
                        	<i class="fas fa-external-link-alt"></i> Open
                        </a>
                        
                        </div>
                        <br>
                    </div>
                </div>
            </c:forEach>
            
        </div>
	</div>
</div>


<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>