<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.event.model.Admin"%>
<%@page import="com.event.serviceImpl.UserServiceImpl"%>
<%@page import="com.event.service.UserService"%>

<%
	if (session.getAttribute("id") == null) {
		response.sendRedirect("default.jsp");
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Profile</title>
<link rel="stylesheet" href="Assets/css/bootstrap.min.css"
	type="text/css" />
<script src="Assets/js/jquery-2.2.4.min.js" /></script>
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
								<li role="presentation"><a href="UserHome.jsp">Home</a>
								<li role="presentation" class="active"><a
									href="Profile.jsp">Profile<span class="sr-only">(current)</span></a></li>
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

	<%
		String id = session.getAttribute("id").toString();
		UserService userService = new UserServiceImpl();
		int ida = Integer.parseInt(id);
		String username = userService.getuserName(ida);
		String useraddress = userService.getuserAddress(ida);
	%>

	<div class="container">
		<div class="form-group">
			<label class="control-label col-sm-2">Name:</label>
			<div class="col-sm-6"><%=userService.getuserName(ida)%>
			</div>
			<br>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="pwd">Address:</label>
			<div class="col-sm-6"><%=userService.getuserAddress(ida)%>
			</div>
			<br>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="pwd">Faculty</label>
			<div class="col-sm-6"><%=userService.getuserFaculty(ida)%>
			</div>
			<br>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="pwd">Semester</label>
			<div class="col-sm-6"><%=userService.getusersemester(ida)%>
			</div>
			<br>
		</div>
	</div>

	<div class="container">
		<jsp:include page="footer.jsp" />
	</div>

</body>
</html>