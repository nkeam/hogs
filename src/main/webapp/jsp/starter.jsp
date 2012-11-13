<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<h2><b>The 2012 Washington Redskins Offensive Starters</b></h2>

<table border = 1>
	<!--Headers-->
	<tr>
		<td><b>No.</b></td>
		<td><b>First Name</b></td>
		<td><b>Last Name</b></td>
		<td><b>Position</b></td>
		<td><b>Years Pro</b></td>
		<td><b>College</b></td>
	</tr>
	<!--The Table-->
	<tr>
		<c:forEach var="starter" items="${starterList}">
		<td><c:out value="${starter.number}" /></td>
		<td><c:out value="${starter.firstName}" /></td>
		<td><c:out value="${starter.lastName}" /></td>	
		<td><c:out value="${starter.position}" /></td>
		<td><c:out value="${starter.years}" /></td>
		<td><c:out value="${starter.college}" /></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>
