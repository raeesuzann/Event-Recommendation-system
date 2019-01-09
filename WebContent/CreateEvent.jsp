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
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CreateEvent</title>

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
								<li role="presentation"><a href="AdminHome.jsp">Home</a>
								<li role="presentation" class="active"><a
									href="CreateEvent.jsp">Create Event<span class="sr-only">(current)</span></a></li>
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
		<div class="row centered-form">
			<div
				class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Add Your Event</h3>
					</div>
					<div class="panel-body">
						<form role="form" method="post">
							<div class="form-group">
								Event Name: <input type="text" name="eventName" id="eventName"
									class="form-control input-sm" placeholder="Name of Event">
							</div>
							<div class="form-group">
								Event Category: 
									<select name="eventCategory"
									id="eventCategory" class="form-control input-sm" required>
 									<option value="Data Science">Data Science</option>
  									<option value="Networking">Networking</option>
  									<option value="Machine Learning">Machine Learning</option>
 								 	<option value="Programming">Programming</option>
								</select>
							</div>
							<div class="row">
								<div class="col-xs-6 col-sm-6 col-md-7">
									<div class="form-group">
										Event Date: <input type="date" name="eventDate" id="eventDate"
											class="form-control input-sm" placeholder="Date of Event">
									</div>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-5">
									<div class="form-group">
										Event Time:<input type="time" name="eventTime" id="eventTime"
											class="form-control input-sm" placeholder="Time of Event">
									</div>
								</div>
							</div>
							<div class="form-group">
								Event Address:<input type="text" name="eventAddress"
									id="eventAddress" class="form-control input-sm"
									placeholder="Address of Event" />
							</div>
							<div class="form-group">
								Event Notice:
								<textarea name="eventNotice" id="eventNotice"
									class="form-control input-sm" placeholder="Notices:"></textarea>
							</div>
							<input type="submit" value="Save Event"
								class="btn btn-info btn-block" onclick="form.action='addEvent'">

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<jsp:include page="footer.jsp" />
	</div>

</body>
</html>