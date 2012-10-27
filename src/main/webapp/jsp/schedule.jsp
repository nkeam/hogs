<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="hogs" uri="/WEB-INF/tag/HogsCustom.tld"%>


<html>
<body>
<h2><b>The 2012 Washington Redskins Schedule</b></h2>
<hogs:substring input="Did this work" start="0" end = "10"/><br/>
<hogs:currentDate/>

<table border = 1>
	<!--Headers-->
	<tr>
		<td><b>Week</b></td>
		<td><b>Home Team</b></td>
		<td><b>Away Team</b></td>
		<td><b>Win/Loss</b></td>
		<td><b>Home Team Score</b></td>
		<td><b>Away Team Score</b></td>
		<td><b>Date and Time</b></td>
	</tr>
	<!--The Table-->
	<tr>
		<c:forEach var="game" items="${gameList}">
		<td><c:out value="${game.week}" /></td>
		<td><c:out value="${game.homeTeam}" /></td>
		<td><c:out value="${game.awayTeam}" /></td>	
			<c:choose>
				<c:when test="${game.winLoss == 'Win'}">
					<td><div style='color:green'><c:out value="${game.winLoss }"/></div></td>
				</c:when>
				<c:when test="${game.winLoss == 'Loss' }">
					<td><div style='color:red'><c:out value="${game.winLoss }"/></div></td>
				</c:when>
				<c:otherwise>
					<td><div style='color:black'><c:out value="${game.winLoss }"/></div></td>
				</c:otherwise>
			</c:choose>
		<td><c:out value="${game.homeScore}" /></td>
		<td><c:out value="${game.awayScore}" /></td>
		<td><c:out value="${game.formattedDate}" /></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>
