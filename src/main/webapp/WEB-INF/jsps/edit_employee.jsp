<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Edit Employee</h2>
<form action="saveEmployee" method="post">
<table>
<tr>
<td>Employee Name</td>
<td>Email</td>
</tr>

<tr>
<td><input type="text" name="firstName" value="${employee.firstName} ${employee.lastName}"/></td>
<td><input type="text" name="email" value="${employee.email}"/></td>
</tr>
 
<tr>
<td>Gender</td>
<td>DateOfBirth</td>
</tr>
<tr>
<td> <select name="genderId" >
         <option value="M">M</option>
         <option value="F">F</option>
       </select></td>
<td><input type="date"  name="dateOfBirth" value="${employee.dateOfBirth}"/></td>
</tr>

<tr>
<td></td>
<td><input type="submit" value="Save"/>
   </td>
</tr>
</table>

</form>
<form action="employees"method="post">
   <input type="submit" value="Cancel"  />
   </form>
</body>
</html>