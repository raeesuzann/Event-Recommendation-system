<%@page import="com.event.serviceImpl.AverageRateServiceImpl"%>
<%@page import="com.event.service.AverageRateService"%>
<%@page import="com.event.dao.EventDAO"%>
<%@page import="com.event.serviceImpl.RateServiceImpl"%>
<%@page import="com.event.service.RateService"%>
<%@page import="com.event.model.Rate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.event.daoImpl.EventDAOImpl"%>
<%@page import="com.event.model.Event"%>
<%@page import="com.event.serviceImpl.EventServiceImpl"%>
<%@page import="com.event.serviceImpl.AdminServiceImpl"%>
<%@page import="com.event.service.AdminService"%>
<%@page import="com.event.service.EventService"%>
<%@page import="java.util.List"%>
<%
	if (session.getAttribute("id") == null) {
		response.sendRedirect("default.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Latest Events</title>
<link rel="stylesheet" href="Assets/css/new.css" type="text/css" />
<link rel="stylesheet" href="Assets/css/bootstrap.min.css"
	type="text/css" />
<link rel="stylesheet" href="Assets/css/Event.css" type="text/css" />
<script src="Assets/js/jquery-2.2.4.min.js" /></script>
<script src="Assets/js/bootstrap.min.js" /></script>
<script src="Assets/fonts/fontawesome-all.js"></script>

</head>
<body>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">Highest Rated Events</h3>
		</div>
		<div class="panel-body">
			<%
				AdminService userService = new AdminServiceImpl();
				EventService eventService = new EventServiceImpl();
				AverageRateService avgrateservice  = new AverageRateServiceImpl();
				List<Event> highrate = eventService.highestrating();
				for (Event event : highrate) {
			%>
			<div class="container-fluid">
				<div class="row">
					<h3>
						<Label><a href="ViewDetails.jsp"><%=event.getEventName()%>
						</a> </Label>
					</h3>
					<b>Rating: <span id=stars></span></b>
					<%
						if (avgrateservice.getAvgRate(event.getId()) == 5) {
					%>
					<span class="fa fa-star checked"></span> <span
						class="fa fa-star checked"></span> <span
						class="fa fa-star checked"></span> <span
						class="fa fa-star checked"></span> <span
						class="fa fa-star checked"></span>
					<%
						} else if (avgrateservice.getAvgRate(event.getId()) == 4) {
					%>
					<span class="fa fa-star checked"></span> <span
						class="fa fa-star checked"></span> <span
						class="fa fa-star checked"></span> <span
						class="fa fa-star checked"></span> <span class="fa fa-star"></span>
					<%
						} else if (avgrateservice.getAvgRate(event.getId()) == 3) {
					%>
					<span class="fa fa-star checked"></span> <span
						class="fa fa-star checked"></span> <span
						class="fa fa-star checked"></span> <span class="fa fa-star"></span>
					<span class="fa fa-star"></span>
					<%
						} else if (avgrateservice.getAvgRate(event.getId()) == 2) {
					%>
					<span class="fa fa-star checked"></span> <span
						class="fa fa-star checked"></span> <span class="fa fa-star"></span>
					<span class="fa fa-star"></span> <span class="fa fa-star"></span>
					<%
						} else if (avgrateservice.getAvgRate(event.getId()) == 1) {
					%>
					<span class="fa fa-star checked"></span> <span class="fa fa-star"></span>
					<span class="fa fa-star"></span> <span class="fa fa-star"></span> <span
						class="fa fa-star"></span>
					<%
						} else {
					%>
					<span class="fa fa-star"></span> <span class="fa fa-star"></span> <span
						class="fa fa-star"></span> <span class="fa fa-star"></span> <span
						class="fa fa-star"></span>
					<%
						}
					%>
				</div>
			</div>
			<div class="form-group">
				<label>Posted Date: <%=event.getEventdate()%></label>&nbsp;&nbsp; <label>Posted
					On: <%=event.getEventTime()%></label>
			</div>
			<div class="form-group">
				<label>Posted By: <%=userService.getuserName(event.getAdminId())%></label>
			</div>
			<hr>
			<%
				}
			%>
		</div>
	</div>
</body>
</html>