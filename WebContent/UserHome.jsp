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

<%
	if (session.getAttribute("id") == null) {
		response.sendRedirect("default.jsp");
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>User Home</title>
<link rel="stylesheet" href="Assets/css/new.css" type="text/css" />
<link rel="stylesheet" href="Assets/css/bootstrap.min.css"
	type="text/css" />
<link rel="stylesheet" href="Assets/css/Event.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="style.css">
<script src="Assets/js/jquery-2.2.4.min.js" /></script>
<script src="Assets/js/bootstrap.min.js" /></script>
<script src="Assets/fonts/fontawesome-all.js"></script>

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
						<div class="col-md-5">
							<ul class="nav nav-pills">
								<li role="presentation" class="active"><a
									href="UserHome.jsp">Home<span class="sr-only">(current)</span></a></li>
								<li><a href="ViewDetails.jsp">View Event</a></li>
								<li><a href="UserProfile.jsp">Profile</a></li>
							</ul>
						</div>
						<div class="col-md-5">
							<%
								String id = session.getAttribute("id").toString();
								AdminService userService = new AdminServiceImpl();
								EventService eventService = new EventServiceImpl();
								RateService rateService = new RateServiceImpl();
								List<Rate> allRate = rateService.list();
								Event eevent = new Event();
							%>

							<form method="POST" action="searchevent">
								<select name="eventCategory" id="eventCategory"
									class="navbar-form input-lg" style="margin-top: 10px" required>
									<option value="Data Science">Data Science</option>
									<option value="Networking">Networking</option>
									<option value="Machine Learning">Machine Learning</option>
									<option value="Programming">Programming</option>
								</select> <input type="submit" name="btnSearch" value="GO"
									class="btn btn-lg btn-success" style="margin-top: 0px"/>
							</form>
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
		<div class="col-md-6">
			<jsp:include page="LatestEvents.jsp" />
		</div>
		<div class="col-md-6">
			<jsp:include page="HighestRateEvents.jsp" />
		</div>
	</div>

	<div class="conatiner">
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>