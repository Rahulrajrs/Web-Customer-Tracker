
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>


</head>


<body>


<h2>Customer List coming soon</h2>

<!-- put new button :Add customer -->
<input type="button" value="Add Customer"
onclick="window.location.href='showFormForAdd';return false;"
>
<table>

<tr>
<th>FirstName</th>
<th>LastName</th>
<th>Email</th>

</tr>
<c:forEach var="tempCustomer" items="${customers}">

<!-- Construct an update link with customer id -->
<c:url var="updateLink" value="/customer/showFormForUpdate">
<c:param name="customerId" value="${tempCustomer.id}"></c:param>

</c:url>
<c:url var="deleteLink" value="/customer/delete">
<c:param name="customerId" value="${tempCustomer.id}"></c:param>

</c:url>

<tr>
<td>${tempCustomer.firstName}</td>
<td>${tempCustomer.lastName}</td>
<td>${tempCustomer.email}</td>
<td>
<!-- Display the update link -->
	<a href="${updateLink}">Update</a>
	|
	<a href="${deleteLink}"
		onclick="if(!(confirm('Are you sure you want to delete this customer'))) return false">Delete</a>
</td>
</tr>

</c:forEach>
	



</table>


</body>

</html>