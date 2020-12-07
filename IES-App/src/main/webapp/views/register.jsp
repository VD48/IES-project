<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file = "header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register here</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	$(document).ready(
			function() {
				$("#emailAdd").blur(function() {
					$("#errMsg").text("");
					$.ajax({

						type : "GET",
						url : "uniqueMailCheck?email=" + $("#emailAdd").val(),
						success : function(data) {
							if (data == "DUPLICATE") {
								$("#errMsg").text("Duplicate Email");
								$("#sumbitbtn").prop('disabled', true);
							} else {
								$("#sumbitbtn").prop('disabled', false);
							}

						}
					});
				});
			});

	</script>
<link
	href='https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/ui-lightness/jquery-ui.css'
	rel='stylesheet'/>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js">
	
</script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js">
	
</script>
<script>
	$(document).ready(function() {

		$(function() {
			$("#datepicker").datepicker();
		});
	})
</script>

<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	background-image:
		url("https://image.freepik.com/free-vector/healthcare-medical-science-elegant-background_1017-26358.jpg");
}

input[type=text], input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

input[type=button], input[type=submit], input[type=reset] {
	background-color: green;
	border: none;
	color: white;
	padding: 16px 32px;
	text-decoration: none;
	margin: 4px 2px;
	cursor: pointer;
}

</style>

</head>
<body>
	<div align="center">
		<font color="red">
			<h2>Account Registration</h2>
		</font> <font color="green">${succMsg}</font> <font color="red">${failMsg}</font>
		<form:form action="/register" modelAttribute="account" method="post">
			<table>
				<tr>
					<th>First Name</th>
				</tr>
				<tr>
					<td><form:input path="firstName" maxlength="12" required="required"/></td>
				</tr>
				<tr>
					<th>Last Name</th>
				</tr>
				<tr>
					<td><form:input path="lastName" maxlength="12" required="required"/></td>
				</tr>
				<tr>
					<th>Email</th>
				</tr>
				<tr>
					<td><form:input path="emailAdd" id="emailAdd" maxlength="40"/> <font
						color="red"><span id="errMsg"></span></font></td>

				</tr>
				<tr>
					<th>Password</th>
				</tr>
				<tr>
					<td><form:password path="pazzword" maxlength="12" required="required"/></td>
				</tr>
				<tr>
					<th>Date of Birth</th>
				</tr>
				<tr>
					<td><form:input path="dob" id="datepicker" /></td>
				</tr>

				<tr>
					<th>Gender</th>
				</tr>
				<tr>
					<td>Male<form:radiobutton path="gender" value="male" /></td>
					<td>Female<form:radiobutton path="gender" value="female" /></td>
				</tr>

				<tr>
					<th>SSN no</th>
				</tr>
				<tr>
					<td><form:input path="ssnNo" maxlength="12" required="required"/></td>
				</tr>
				<tr>
					<th>Phone Number</th>
				</tr>
				<tr>
					<td><form:input path="phoneNo" maxlength="12" required="required"/></td>
				</tr>
				<tr>
					<th>Role</th>
				</tr>
				<tr>
					<td><form:select path="role">
							<form:option value="">-Select-</form:option>
							<form:option value="caseWorker">Caseworker</form:option>
							<form:option value="admin">Admin</form:option>
						</form:select></td>
				</tr>
				<tr>
					<td><input type="submit" value="Register" id="sumbitbtn"></td>
				</tr>


			</table>
		</form:form>
	</div>
</body>
</html>