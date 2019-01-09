<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.event.daoImpl.EventDAOImpl"%>
<%@page import="com.event.model.Event"%>
<%@page import="com.event.serviceImpl.EventServiceImpl"%>
<%@page import="com.event.serviceImpl.AdminServiceImpl"%>
<%@page import="com.event.service.AdminService"%>
<%@page import="com.event.service.EventService"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Event Recommendation System</title>
<link rel="stylesheet" href="Assets/css/new.css" type="text/css" />
<link rel="stylesheet" href="Assets/css/bootstrap.min.css"
	type="text/css" />
<link rel="stylesheet" href="Assets/css/Event.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="style.css">
<script src="Assets/js/jquery-2.2.4.min.js" /></script>
<script src="Assets/js/bootstrap.min.js" /></script>

</head>
<body>
	<div class="container">
		<jsp:include page="header.jsp" />
	</div>

	<div class="container">
		<div class="row">
			<div class="col-md-8">
				<jsp:include page="LatestEvents.jsp" />
			</div>

			<div class="col-md-4">
				<jsp:include page="Login.jsp" />
				<div class="container">
					<h4>
						<b>If you don't have an account, then</b>
					</h4>
					<a href="Registration.jsp" class="btn btn-primary">Sign Up</a>
				</div>
			</div>

		</div>
	</div>

	<div class="container">
		<jsp:include page="footer.jsp" />
	</div>

</body>
</html>