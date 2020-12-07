<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ include file = "header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Plan</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script type="text/javascript">
    function deletefuction(){
    	return confirm("Press OK to Deactive contact");
        }
</script>
  <style>
     table {
	background-image: url("viewApplicant.jpg");
}
  </style>
  </head>
<body>
<div class="container">
   <table class="table table-bordered">
      <thead>
        <tr>
          <th>Applicant Registration No</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Email Add</th>
          <th>Phone No</th>
          <th>SSN NO</th>
          <th>action</th>
        </tr>
     </thead>
      <tbody>
         
         <c:forEach items="${allApplicants}" var="c">
            <tr>
               
               <td>${ c.applicantRegNo }</td>
               <td>${c.firstName }</td>
               <td>${c.lastName}</td>
               <td>${c.emailAdd}</td>
               <td>${c.phoneNo}</td>
               <td>${c.ssnNo}</td>
               
                 <td><a href="/editApplicant?regNo=${c.applicantRegNo }">edit</a></td>
                <td><a href="/deleteApplicant?regNo=${c.applicantRegNo }" onclick="return deletefuction()"> 
                <c:choose>
                   <c:when test="${c.status}">
							       active
							</c:when>
							<c:otherwise>
								delete
							</c:otherwise>
                   
                </c:choose> 
                </a></td>
                
               
            </tr>
         </c:forEach>
      </tbody>
   </table>
   </div>
</body>
</html>