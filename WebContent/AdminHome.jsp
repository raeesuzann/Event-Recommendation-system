<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.event.model.Admin"%>
<%@page import="com.event.service.AdminService"%>
<%@page import="com.event.serviceImpl.AdminServiceImpl"%>
<%
	if (session.getAttribute("id") == null) {
		response.sendRedirect("default.jsp");
	}
%>

<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Csontent-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home</title>
<link rel="stylesheet" href="Assets/css/new.css" type="text/css" />
<link rel="stylesheet" href="Assets/css/bootstrap.min.css"
	type="text/css" />
<script src="Assets/js/bootstrap.min.js" /></script>
<script src="Assets/js/jquery-2.2.4.min.js" /></script>

</head>
<body>
	<%
		String id = session.getAttribute("id").toString();
		Admin admin = new Admin();
		AdminService adminService = new AdminServiceImpl();
	%>

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
								<li role="presentation" class="active"><a
									href="AdminHome.jsp">Home<span class="sr-only">(current)</span></a></li>
								<li><a href="CreateEvent.jsp">Create Event</a></li>
								<li><a href="ViewEvent.jsp">View Event</a></li>
								<li><a href="DeleteEvent.jsp">Delete Event</a></li>
								<li><a href="AdminProfile.jsp">Profile</a></li>
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
		<div class="row">
			<div class="col-md-6">
				<jsp:include page="LatestEvents.jsp" />
			</div>
		</div>
	</div>

	<div class="container">
		<jsp:include page="footer.jsp" />
	</div>

</body>
</html>