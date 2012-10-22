<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@page import = "java.util.List"%>
<%@page import = "com.acme.model.Game"%>
<%@page import = "com.acme.database.GameDAO"%>
<%@page import = "com.acme.database.GameDAOImpl"%>

<html>
<body>
<h2><b>The 2012 Washington Redskins Schedule</b></h2>

<table border = 1>
<%
	GameDAO gameDAO = new GameDAOImpl();
	List<Game> gameList = gameDAO.getGames();
	pageContext.setAttribute("gameList", gameList);
%>

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
	<%
	for(Game game: gameList){
	%>	
	<tr>
		<td><%out.println(game.getWeek());%></td>
		<td><%out.println(game.getHomeTeam());%></td>
		<td><%out.println(game.getAwayTeam());%></td>
		<!-- Print 'Win' in green and 'Loss' in red. Everything else is black -->
		<%if (game.getWinLoss().equals("Win")){%>
			<td><b><div style='color:green'><%out.println(game.getWinLoss());%></div></b></td>
		<%}else if (game.getWinLoss().equals("Loss")){%>
			<td><b><div style='color:red'><%out.println(game.getWinLoss());%></div></b></td>
		<%}else{ %>
			<td><b><div style='color:black'><%out.println(game.getWinLoss());%></div></b></td>
		<%} %>
		<td><%out.println(game.getHomeScore());%></td>
		<td><%out.println(game.getAwayScore());%></td>
		<td><%out.println(game.getFormattedDate());%></td>	
	</tr>
	<%
	} %>
</table>
</body>
</html>
