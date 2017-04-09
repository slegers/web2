<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dynamische pagina</title>
</head>
<body>
	<main>
	<h1> hsl kleuren </h1>
	<a href="dynamysch.jsp" id="home">second page</a>
	
	<%
	String tekst="";
	int een = 0;
	int twee = 0;
	int drie = 0;
	for(int i = 0; i < 3600;i++){
		tekst+="<div class=blokje style=\"background-color:hsl(" + een +"," + twee  + "%," + drie + "%);\"> <p> hsl(" + een +"," + twee  + "%," + drie + "%) </p>  </div>";
		drie = drie + 10;
		if(drie > 100){
			drie = 0;
			twee = twee + 10;
		}if(twee > 100){
			twee = 0;
			een = een + 10;
		}
	}
	%>
	<p id="dynamisch"> 
	<%= tekst %>
	</p>
	</main>
</body>
</html>