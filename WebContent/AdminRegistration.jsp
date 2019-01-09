<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Registration</title>
<link rel="stylesheet" href="Assets/css/new.css" type="text/css" />
<link rel="stylesheet" href="Assets/css/bootstrap.min.css"
	type="text/css" />
<script src="Assets/js/bootstrap.min.js" /></script>
<link rel="stylesheet" href="Assets/css/registration.css"
	type="text/css" />

<script src="Assets/js/registration.js"></script>
</head>
<body>
	<div class="container">
		<form class="well form-horizontal" method="post" id="contact_form">
			<fieldset>
				<legend>
					<b>Register Today!</b>
				</legend>

				<div class="form-group">
					<label class="col-md-4 control-label">First Name</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input type="text"
								name="firstName" id="firstName" placeholder="First Name"
								class="form-control" class="responsive" required>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label">Last Name</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input type="text"
								name="lastName" id="lastName" placeholder="Last Name"
								class="form-control" class="responsive" required />
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label">Gender</label>
					<div class="col-md-4 selectContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-book"></i></span> <select name="sex"
								id="sex" class="form-control selectpicker">
								<option value=" ">Please select Gender</option>
								<option>Male</option>
								<option>Female</option>
								<option>Others</option>
							</select>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label">Address</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-home"></i></span> <input name="address"
								placeholder="Address" class="form-control" type="text"
								class="responsive" required>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label">DOB</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-calendar"></i></span> <input type="date"
								name="dob" id="dob" placeholder="Jan12,2012"
								class="form-control" class="responsive" type="text" required>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label">E-Mail</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-envelope"></i></span> <input type="email"
								name="emailAddress" id="emailAddress" class="form-control"
								class="responsive" required>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label">Password</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span> <input type="password"
								name="password" id="password" class="form-control"
								class="responsive" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
								title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
								required>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label">Confirm Password</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span> <input type="password"
								name="confirmPassword" id="confirmPassword" class="form-control"
								class="responsive" required>
						</div>
					</div>
				</div>
				<!-- Success message -->
				<div class="alert alert-success" role="alert" id="success_message">
					Success <i class="glyphicon glyphicon-thumbs-up"></i> You
					Registered Successfully!
				</div>

				<hr>
				<div class="row">
					<label class="col-md-4 control-label"></label>
					<div class="col-md-4">
						<button type="submit" class="btn btn-success"
							onclick="form.action='inputAdmin'" class="form-control">
							Admin Registration <span
								class="glyphicon glyphicon-registration-mark"></span>
						</button>
					</div>

					<hr>
					<h4 align="center">
						If you already have an account,<a href="model fade"
							data-toggle="modal" data-target="#myModal">Click Here.</a>
					</h4>
				</div>
			</fieldset>
		</form>
	</div>

	<!-- Modal -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Login</h4>
				</div>
				<div class="modal-body">
					<div class="container py-5">
						<div class="row">
							<div class="col-md-12">
								<div class="row">
									<div class="col-md-6 mx-auto">
										<div class="card rounded-0">
											<div class="card-body">
												<jsp:include page="Login.jsp" />
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal Message -->
	<div class="modal fade" id="myModal1" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title" class="alert alert-warning">
						<strong>Warning!</strong> PLZ,Login First
					</h4>
				</div>
			</div>
		</div>
	</div>

	<div class="container">
		<jsp:include page="footer.jsp" />
	</div>

	<script type="text/javascript">
		var password = document.getElementById("password"), confirmPassword = document
				.getElementById("confirmPassword");

		function validatePassword() {
			if (password.value != confirmPassword.value) {
				confirmPassword.setCustomValidity("Passwords Don't Match");
			} else {
				confirmPassword.setCustomValidity('');
			}
		}

		password.onchange = validatePassword;
		confirmPassword.onkeyup = validatePassword;
	</script>

</body>
</html>