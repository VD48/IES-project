<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
body {
	background-image:
		url("https://image.freepik.com/free-vector/healthcare-background-with-medical-symbols-hexagonal-frame_1017-26363.jpg");
}

.dropbtn {
	background-color: #4CAF50;
	color: white;
	padding: 30px;
	font-size: 25px;
	border: none;
	cursor: pointer;
}

.dropdown {
	position: relative;
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 10px 20px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown-content a:hover {
	background-color: #f1f1f1
}

.dropdown:hover .dropdown-content {
	display: block;
}

.dropdown:hover .dropbtn {
	background-color: #3e8e41;
}

.div1 {
	width: 300px;
	height: 100px;
	border: 1px solid blue;
	align-content: center;
}


</style>
</head>
<body>
	<h1 align="center">
		<font color="red"><b>Integrated Eligibity System
				Application</b></font>
	</h1>
	
	<div class="dropdown" align="center">
		<button class="dropbtn">Admin</button>
		<div class="dropdown-content">
			<a href="/load">Create Account</a> <a
				href="/viewAccount?role=caseWorker">View Accounts</a> <a href="/loadPlanForm">Create
				Plan</a><a href="/viewPlan">View Plan</a>
		</div>
	</div>
	<div class="dropdown" align="center">
		<button class="dropbtn">Application Register</button>
		<div class="dropdown-content">
			<a href="/applicantForm">Applicant Registration</a> <a href="/viewApplicant">View Applicant</a>
				
		</div>
	</div>
	<div class="dropdown" align="center">
		<button class="dropbtn">Data Collection</button>
		<div class="dropdown-content">
			<a href="/emptyForm">Create Case</a>  
			<a href="#">View Case</a>
		</div>
	</div>
	<div class="dropdown" align="center">
		<button class="dropbtn">Logout</button>
		<div class="dropdown-content">
			<a href="#">Create Account</a> <a href="#">View Accounts</a> <a
				href="#">Create Plan</a><a href="#">View Plan</a>
		</div>
	</div>
  
  
</body>
</html>