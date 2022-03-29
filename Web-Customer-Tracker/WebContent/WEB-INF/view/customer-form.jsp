<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>

<title></title>


</head>

<body>

CustomerForm.....

<h3>Save Customer</h3>

<form:form action="saveCustomer" modelAttribute="customer" method="POST">

<!-- need to associate this data with customer Id -->
<form:hidden path="id"/>

<table>

	<tbody>
		<tr>
		<td><label>First Name</label></td>
		<td><form:input path="firstName"/> </td>
		
		</tr>
<tr>
		<td><label>Last Name</label></td>
		<td><form:input path="lastName"/> </td>
		
		</tr>
<tr>
		<td><label>Email</label></td>
		<td><form:input path="email"/> </td>
		
		</tr>
<tr>
		<td><label></label></td>
		<td><input type="submit" value="Save"> </td>
		
		</tr>


	</tbody>

</table>


</form:form>

<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>

</body>


</html>