<%@page import="domain.model.StudieMoment"%>
<%@page import="domain.model.*"%>
<%@page import="domain.db.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="nl">

<head>
    <meta charset="UTF-8">
    <title>Studie overzicht</title>
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/stylsheet.css"> </head>

<body>
    <header class="header">
        <nav class="mainMenu">
            <ul>
                <li><a class="active" href="#top">Home</a></li>
                <li><a href="overview.jsp">Overzicht</a></li>
                <li><a href="form.html">Add study</a></li>
            </ul>
        </nav>
        <h1 id="top" class="headerTitle">Study tracker</h1> <img class="banner" src="img/banner.jpg" alt="banner"> </header>
    <main>
        <h2>Home</h2>
        <p id="welkomTekst"> Welkom op de site van Study tracker. Via deze site bieden we studenten de kans om op een makkelijke manier hun studieprocess bij te houden. Via deze site kan je op een makkelijke en efficïente manier vakken van je eigen opleiding toevoegen. Aan deze vakken kan je dan een studiemoment toevoegen.
            <br> In het tablad overzicht vind je dan een overzicht van al jou studiemomenten.</p>
        <p id="aantalUur"> Het aantal uren dat je reeds gestudeerd hebt is <%= StudyTracker.getStudyMoment().getAantalUur() %>.</p>
    </main>
</body>

</html>