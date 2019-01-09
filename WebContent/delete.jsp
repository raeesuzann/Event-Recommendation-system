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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>delete event</title>
<link rel="stylesheet" href="Assets/css/new.css" type="text/css" />
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
		<h3>Are you sure you want to delete this event?</h3>
		<% String id = request.getParameter("id").toString(); %>
		<form method="post" action="DeleteEvent">
			<input type="hidden" name="txtId" value="<%=id %>"/>
			<input type="submit" name="btnEvent" value="YES"
				class="btn btn-danger" style="margin-top: 20px" /> <a
				class="btn btn-default" style="margin-top: 20px" href="DeleteEvent.jsp">NO</a>
		</form>
	</div>
	<hr>
	<div class="container">
		<jsp:include page="footer.jsp" />
	</div>

</body>
</html>