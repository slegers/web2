<%@page import="domain.model.*"%>
<%@page import="domain.db.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="nl">

<head>
    <meta charset="UTF-8">
    <title>Overview</title>
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/stylsheet.css"> </head>

<body>
    <header class="header">
        <nav class="mainMenu">
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li> <a class="active" href="#top">Overzicht</a> </li>
                <li><a href="form.html">Add study</a></li>
            </ul>
        </nav>
        <h1 id="top" class="headerTitle">Study tracker</h1> <img class="banner" src="img/banner.jpg" alt="banner"> </header>
    <main>
        <h2> Overview </h2>
        <table>
            <tr>

                <th>Vak</th>
                <th>Dag van de week</th>
                <th>aantal uur</th>
            </tr>
            <%  for(StudieMoment s : StudyTracker.getStudie()){  %>
			<tr>
			  <td><%= s.getVak()   %> </td>
		     <td> <%= s.getDag()   %> </td>
		     <td> <%= s.getUur()   %> </td>
			</tr>
			<% } %>
        </table>
    </main>
</body>

</html>