<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
    <%@ include file="caseForm.jsp" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css" />
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<font color="red">
			<h2>Create Plan</h2>
		</font> <font color="green">${succMsg}</font> <font color="red">${failMsg}</font>
     <form:form action="/createCase" modelAttribute="caseform" method="post">
        <table>
                <tr>
					<th>Application Id</th>
				</tr>
				<tr>
					<td><form:input path="applicantRegNo" maxlength="12" required="required" readonly="true"/></td>
				</tr>
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
					<td><form:input path="emailAdd"/> 
						
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
					<td><input type="submit" value="Create Case" id="sumbitbtn"></td>
				</tr>


			</table>
        
     </form:form>
     </div>
</body>
</html>