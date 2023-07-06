<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Edit Address</h2>
<form action="saveAddress" method="post">
<table>
<tr>
<td>Line 1</td>
<td>Line 2</td>
</tr>

<tr>
<td><input type="text" name="line1" value="${addressDTO.line1} ${employee.lastName}"/></td>
<td><input type="text" name="line2" value="${addressDTO.line2}"/></td>
</tr>
 
<tr>
<td>Address Type</td>
<td> &nbsp;</td>
</tr>
<tr>
<td><select name="addressType">
            <option value="HOME">Home</option>
            <option value="WORK">Work</option>
            <option value="OTHER">Other</option>
        </select></td>
<td>&nbsp;</td>
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