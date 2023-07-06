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
<h2>View Employee</h2>


<table>
<tr>
<td>Employee Name</td>
<td>Email</td>
</tr>

<tr>
<td><input type="text"  value="${employee.firstName} ${employee.lastName}"/></td>
<td><input type="text"  value="${employee.email}"/></td>
</tr>
 
<tr>
<td>Gender</td>
<td>DateOfBirth</td>
</tr>
<tr>
<td><input type="text"  value="${employee.genderId}"/></td>
<td><input type="text"   value="${employee.dateOfBirth}"/></td>
</tr>

<tr>
<td><form action="employees"method="post">
   <input type="submit" value="Back"  />
   </form></td>
<td> <form action="editEmployee"method="post">
   <input type="hidden" name="id" value="${employee.id}"/>
   <input type="submit" value="Edit"/>
   </form></td>
</tr>
</table>


<br><br><br>

<table border="1">
<tr>
     <th>Address Type</th>
     <th>Line 1</th>
     <th>Line 2</th>
     <th>Action</th>
     </tr>
     <c:forEach var="address"  items="${listOfAddress}">
      <tr>
         <td>${address.addressType}</td>
         <td>${address.line1}</td>
         <td>${address.line2}</td>
         <td><a href="employeeAddressInfo?id=${address.id}">Edit</a></td>
      </tr>
      </c:forEach>
</table>

</body>
</html>