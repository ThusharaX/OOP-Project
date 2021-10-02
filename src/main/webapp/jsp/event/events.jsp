<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param name="title" value="Events"/>
</jsp:include>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.event.Event"%>


<%
    ArrayList<Event> events = (ArrayList<Event>)request.getAttribute("events");
%>


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
                            src="#" alt="">
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
                            
                            <p class="card-text">
                                <b><i class="fas fa-map-marker-alt"></i> Venue:</b>
                                    ${event.getVenue()}
                            </p>
                        </div>
                        <div class="col text-center">
                        <a href="eventDetails?id=${event.getId()}" class="btn btn-danger"><i
                            class="fas fa-external-link-alt"></i> Open</a>
                        </div>
                        <br>
                    </div>
                </div>
            </c:forEach>
            
        </div>
	</div>
</div>

<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>