 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file = "header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Plan register</title>
<link rel="stylesheet" type="text/css" href="styles.css" />
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
 $( "#datepicker2" ).datepicker({
   defaultDate: "+1w",
   changeMonth: true,
   numberOfMonths: 1,
   onClose: function( selectedDate ) {
     $( "#datepicker2" ).datepicker( "option", "maxDate", selectedDate );
   }
 });  
});  
</script>

</head>
<body>
	<div align="center">
		<h2>
			<font color="red"><b>Plan Registration</b></font>
		</h2>
		<h3>
		  <font color="green">${succMsg}</font>
		</h3>
		<h3>
		  <font color="red">${failMsg}</font>
		</h3>
		<form:form action="/createPlan" modelAttribute="planRegister"
			method="post">
			<table>
				<tr>
					<th>Plan Name</th>
				</tr>
				<tr>
					<td><form:input path="planName" maxlength="12"
							required="required" /></td>
				</tr>
				<tr>
					<th>Plan Description</th>
				</tr>
				<tr>
					<td><form:input path="planDescription" maxlength="40"
							required="required" /></td>
				</tr>
				<tr>
					<th>Plan Start Date</th>
				</tr>
				<tr>
					<td><form:input path="planStartDate" id="datepicker1" /></td>
				</tr>
				<tr>
					<th>Plan End Date</th>
				</tr>
				<tr>
					<td><form:input path="planEndDate" id="datepicker2" /></td>
				</tr>


				<tr>
					<td><input type="submit" value="Register" id="sumbitbtn"></td>
				</tr>


			</table>
		</form:form>
	</div>
</body>
</html>