<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="domain.*"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	ArrayList<Vak> vakken = new ArrayList<Vak>();
	Vak bop = new Vak("BOP", 6, "1TX");
	vakken.add(bop);
	Vak web2 = new Vak("Web2", 3, "1TX");
	vakken.add(web2);
	Vak web3 = new Vak("Web3", 3, "2TX");
	vakken.add(web3);
	Vak capita = new Vak("Capita Selecta", 3, "3TX");
	vakken.add(capita);
%>
</head>
<body>
	<main>
	<table>
		<tr>
			<th>Vak</th>
			<th>Studiepunten</th>
			<th>Jaar</th>
		</tr>
		<%
		String t = "";
		for(Vak v : vakken){
			t = t + "<tr> <td>" + v.getNaam() + " </td><td>" + v.getStudiePunten() + "</td><td>" + v.getJaar() + "</td></tr>";
		}
		
		%>
		<%= t%>
	</table>
	</main>
</body>
</html>