<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Income Details</title>
<link rel="stylesheet" type="text/css" href="styles.css" />
<link rel="stylesheet" type="text/css" href="radio.css" />
</head>
<body>
  <div align="center">
  <h3><font color="red">Income Details</font></h3>
  ${succMsg}
    <form:form action="/income" modelAttribute="incomeDetails" method="post">
         <table>
              <tr>
                 <th>Case No</th>
              </tr>
              <tr>
                  <td>
                     <form:input path="caseNo" readonly="true"/>
                  </td>
              </tr>
               <tr>
                 <th>Individual's Name</th>
              </tr>
              <tr>
                  <td>
                     <form:input path="firstName"  required="required"/>
                  </td>
              </tr>
              
              <tr>
					<th>Working Employee</th>
				</tr>
				<tr>
					<td>Yes<form:radiobutton path="workingEmployee" value="yes" cssClass="container" /></td>
					<td>No<form:radiobutton path="workingEmployee" value="no" cssClass="container"/></td>
				</tr>
				 <tr>
                 <th>Other Income</th>
              </tr>
              <tr>
                  <td>
                     <form:input path="otherIncome"  required="required"/>
                  </td>
              </tr>
              <tr>
					<td><input type="submit" value="Next" id="sumbitbtn"></td>
				</tr>
         
         </table>
     
    </form:form>
   </div>
</body>
</html>