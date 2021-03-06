<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ include file = "header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Plan</title>
<link
	href='https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/ui-lightness/jquery-ui.css'
	rel='stylesheet'>
	

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js">
	
</script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js">
	
</script>


<script>
$(function() {   
    $( "#datepicker1" ).datepicker({   
   defaultDate: "+1w",  
   changeMonth: true,   
   numberOfMonths: 1,  
   onClose: function( selectedDate ) {  
     $( "#datepicker2" ).datepicker( "option", "minDate", selectedDate );  
   }  
 });   
});  
</script>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	
	background-image:none;
		
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
table{
	background-color: azure;
}

</style>


</head>
<body>
<div align="center">
<h2><font color="red">Update Applicant</font></h2>
    <form:form action="/updateApplicant" modelAttribute="applicantRegistration"
			method="post">
			<table>
			    <tr>
					<th>Applicant No </th>
				</tr>
				<tr>
					<td><form:input path="applicantRegNo" maxlength="40" readonly="true"
							required="required" /></td>
				</tr>
				<tr>
					<th>First tName</th>
				</tr>
				<tr>
					<td><form:input path="firstName" maxlength="12"
							required="required" /></td>
				</tr>
				<tr>
					<th>Last Name</th>
				</tr>
				<tr>
					<td><form:input path="lastName" maxlength="40"
							required="required" /></td>
				</tr>
				<tr>
					<th>dob</th>
				</tr>
				<tr>
					<td><form:input path="dob" id="datepicker1" /></td>
				</tr>
				<tr>
					<th>Email Address</th>
				</tr>
				<tr>
					<td><form:input path="emailAdd" maxlength="40" readonly="readonly"
							required="required" /></td>
				</tr>
				<tr>
					<th>Phone Number</th>
				</tr>
				<tr>
					<td><form:input path="phoneNo" maxlength="40"
							required="required" /></td>
				</tr>
				<tr>
					<th>SSN Number</th>
				</tr>
				<tr>
					<td><form:input path="ssnNo" maxlength="40"
							required="required" /></td>
				</tr>
				
				

				<tr>
					<td><input type="submit" value="Update" id="sumbitbtn"></td>
				</tr>


			</table>
		</form:form>
    </div>
</body>
</html>