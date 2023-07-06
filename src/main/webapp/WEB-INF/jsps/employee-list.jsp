<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Employee List</h2>
<table border="1">
<tr>
     <th>EmployeeName</th>
     <th>Email</th>
     <th>Gender</th>
     <th>DateOfBirth</th>
     <th>Action</th>
     </tr>
     <c:forEach var="employee"  items="${employees}">
      <tr>
         <td><a href="viewEmployee?id=${employee.id}">${employee.firstName} ${employee.lastName}</a></td>
         <td>${employee.email}</td>
         <td>${employee.genderId}</td>
         <td>${employee.dateOfBirth}</td>
         <td><a href="editEmployee?id=${employee.id}">Edit</a></td>
      </tr>
      </c:forEach>
</table>

</body>
</html>