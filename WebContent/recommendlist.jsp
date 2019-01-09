<%@page import="com.event.serviceImpl.RateServiceImpl"%>
<%@page import="com.event.service.RateService"%>
<%@page import="com.event.model.Rate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.event.daoImpl.EventDAOImpl"%>
<%@page import="com.event.model.Event"%>
<%@page import="com.event.serviceImpl.EventServiceImpl"%>
<%@page import="com.event.serviceImpl.AdminServiceImpl"%>
<%@page import="com.event.serviceImpl.RateServiceImpl"%>
<%@page import="com.event.service.AdminService"%>
<%@page import="com.event.service.EventService"%>
<%@page import="java.util.List"%>

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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="style.css">
<script src="Assets/js/jquery-2.2.4.min.js" /></script>
<script src="Assets/js/bootstrap.min.js" /></script>
<script src="Assets/fonts/fontawesome-all.js"></script>

</head>
<body>
	<h2 align="center">
		<b>Recommended Events</b>
	</h2>
	<%
		AdminService userService = new AdminServiceImpl();
		EventService eventService = new EventServiceImpl();
		RateService rateService = new RateServiceImpl();
		List<Event> recommendedList = eventService.recommendedList();
		for (Event recommend : recommendedList) {
	%>
	
	<div class="panel panel-primary">
		<div class="panel-heading">
			<label class="panel-title"><a
				href="RateEvent.jsp?id=<%=recommend.getId()%>"><%=recommend.getEventName()%></a></label>
		</div>

		<div class="panel-body">
			<div class="container-fluid">
				<div class="form-group">
					<label>Posted Date: <%=recommend.getEventdate()%></label>&nbsp;&nbsp;
					<label>Posted On: <%=recommend.getEventTime()%></label>
				</div>
				<div class="form-group">
					<label>Posted By: <%=userService.getuserName(recommend.getAdminId())%></label>
				</div>
			</div>
		</div>
	</div>
	<hr>
	
	<%
		}
	%>
</body>
</html>