<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.event.serviceImpl.RateServiceImpl"%>
<%@page import="com.event.service.RateService"%>
<%@page import="com.event.model.Rate"%>
<%@page import="com.event.controller.EventController"%>
<%@page import="com.event.daoImpl.EventDAOImpl"%>
<%@page import="com.event.model.Event"%>
<%@page import="com.event.serviceImpl.EventServiceImpl"%>
<%@page import="com.event.serviceImpl.AdminServiceImpl"%>
<%@page import="com.event.service.AdminService"%>
<%@page import="com.event.service.EventService"%>
<%@page import="java.util.List"%>

<!DOCTYPE html >
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Searched Events</title>
<link rel="stylesheet" href="Assets/css/bootstrap.min.css"
	type="text/css" />
<link rel="stylesheet" href="Assets/css/Event.css" type="text/css" />
<script src="Assets/js/jquery-2.2.4.min.js" /></script>
<script src="Assets/fonts/fontawesome-all.js" /></script>
<script src="Assets/js/bootstrap.min.js" /></script>

</head>
<body>

	<div class="container">
		<jsp:include page="header.jsp" />
	</div>

	<div class="container">
		<div class="row">
			<nav class="navbar navbar-default">
				<div class="container-fluid">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target="#navbar-collapse-1"
							aria-expanded="false">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand">Welcome</a>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse" id="navbar-collapse-1">
						<div class="col-md-10">
							<ul class="nav nav-pills">
								<li><a href="AdminHome.jsp">Home</a></li>
								<li role="presentation" class="active"><a
									href="ViewEvent.jsp">View Event<span class="sr-only">(current)</span></a></li>
							</ul>
						</div>
						<div class="col-md-1">
							<ul class="nav nav-pills">
								<li><a href="Logout" class="btn btn-lg btn-info">Logout</a></li>
							</ul>
						</div>
					</div>
				</div>
				<!-- /.container-fluid -->
			</nav>
		</div>
	</div>

	<div class="container">
		<h2 align="center">
			<b>Events Searched </b>
		</h2>
		<%
			AdminService userService = new AdminServiceImpl();
			EventService eventService = new EventServiceImpl();
			List<Event> allEvent = eventService.list();
			for (Event event : allEvent) {
		%>
		<div class="panel panel-primary">
			<div class="panel-heading">
				<label class="panel-title"><a
					href="RateEvent.jsp?id=<%=event.getId()%>"><%=event.getEventName()%></a></label>

			</div>
			<div class="panel-body">
				<div class="container-fluid">
					<div class="form-group">
						<label>Event Category: <%=event.getEventCategory()%></label>
					</div>
					<div class="form-group">
						<label>Proposed Date: <%=event.getProposedDate()%></label>
					</div>
					<div class="form-group">
						<label>Proposed Time: <%=event.getProposedTime()%></label>
					</div>
					<div class="form-group">
						<label>Event Notice: <%=event.getEventNotice()%></label>
					</div>
					<div class="form-group">
						<label>Posted Date: <%=event.getEventdate()%></label>&nbsp;&nbsp;
						<label>Posted On: <%=event.getEventTime()%></label>
					</div>
					<div class="form-group">
						<label>Posted By: <%=userService.getuserName(event.getAdminId())%></label>
					</div>
				</div>
			</div>
		</div>
		<%
			}
		%>
	</div>

	<hr>
	<div class="container">
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>