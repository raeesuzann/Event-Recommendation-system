<%@page import="com.event.serviceImpl.UserServiceImpl"%>
<%@page import="com.event.service.UserService"%>
<%@page import="com.event.serviceImpl.RateServiceImpl"%>
<%@page import="com.event.service.RateService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.event.daoImpl.EventDAOImpl"%>
<%@page import="com.event.daoImpl.RateDAOImpl"%>
<%@page import="com.event.model.Event"%>
<%@page import="com.event.model.Rate"%>
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
<title>viewing events</title>
<link rel="stylesheet" href="Assets/css/bootstrap.min.css"
	type="text/css" />
<script src="Assets/js/jquery-2.2.4.min.js"></script>
<script src="Assets/fonts/fontawesome-all.js"></script>
<script src="Assets/js/bootstrap.min.js" /></script>
<style>
form {width =70%;margin =auto;
	
}

label {
	display: block;
	width: 100%;
}

ul {
	padding: 0;
	margin: 0;
}

ul li {
	list-style-type: none;
	display: inline-block;
	margin: 5px;
	color: black;
	text-shadow: 2px 2px 7px grey;
	font-size: 25px !important;
}

ul li:hover {
	color: yellow;
}

ul li.active, ul li.secondary-active {
	color: yellow;
}

input[type="radio"] {
	display: none;
}
</style>
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
								<li><a href="UserHome.jsp">Home</a></li>
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

		<%
			String id = session.getAttribute("id").toString();
			String iid = request.getParameter("id").toString();
			RateService rateService = new RateServiceImpl();
			EventService eventService = new EventServiceImpl();
			Event event = new Event();
		%>


		<div class="row">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<label class="panel-title">Event: <%=eventService.getEventName(Integer.parseInt(iid))%></label>
				</div>
				<div class="panel-body">
					<div class="container-fluid">
						<div class="form-group">
							<label>Event Category: <%=eventService.getEventCategory(Integer.parseInt(iid))%></label>
						</div>
						<div class="form-group">
							<label>Proposed Date: <%=eventService.proposedDate(Integer.parseInt(iid))%></label>
						</div>
						<div class="form-group">
							<label>Proposed Time: <%=eventService.proposedTime(Integer.parseInt(iid))%></label>
						</div>
						<div class="form-group">
							<label>Event Notice: <%=eventService.getEventNotice(Integer.parseInt(iid))%></label>
						</div>
						<div class="form-group">
							<label>Posted Date: <%=eventService.getEventDate(Integer.parseInt(iid))%></label>&nbsp;&nbsp;
							<label>Posted Time:<%=eventService.getEventTime(Integer.parseInt(iid))%></label>
						</div>
					</div>
				</div>
			</div>
		</div>

		<%
			if (rateService.getRateByUser(Integer.parseInt(id), eventService.getEventId(Integer.parseInt(iid))) <= 0) {
		%>
		<form method="post">
			<h3>Rate us</h3>
			<ul>
				<li><label for="rating_1"><i class="fas fa-star"
						aria-hidden="true"></i></label> <input type="radio" name="rating"
					id="rating_1" value="1" /></li>
				<li><label for="rating_2"><i class="fas fa-star"
						aria-hidden="true"></i></label> <input type="radio" name="rating"
					id="rating_2" value="2" /></li>
				<li><label for="rating_3"><i class="fas fa-star"
						aria-hidden="true"></i></label> <input type="radio" name="rating"
					id="rating_3" value="3" /></li>
				<li><label for="rating_4"><i class="fas fa-star"
						aria-hidden="true"></i></label> <input type="radio" name="rating"
					id="rating_4" value="4" /></li>
				<li><label for="rating_5"><i class="fas fa-star"
						aria-hidden="true"></i></label> <input type="radio" name="rating"
					id="rating_5" value="5" /></li>
			</ul>

			<input type="submit" value="submit"
				onclick="form.action='rate?id=<%=eventService.getEventId(Integer.parseInt(iid))%>'"
				style="align: center;" />
		</form>
		<%
			} else {
		%>
		<h3>
			Already Rated :
			<%
			out.println(rateService.getRateByUser(Integer.parseInt(id),
						eventService.getEventId(Integer.parseInt(iid))));
		%>
		</h3>

		<%
			}
		%>


		<hr>

		<div class="container">
			<jsp:include page="recommendlist.jsp"></jsp:include>
		</div>

	</div>

	<script>
			$('li').on('click', function() {
				$('li').removeClass('active');
				$('li').removeClass('secondary-active');
				$(this).addClass('active');
				$(this).prevAll().addClass('secondary-active');
			})
		</script>
</body>
</html>