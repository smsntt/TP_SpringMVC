<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des fonctionnaires</title>
</head>
<body>

	<div align="center">
		<h1 style="background-color: lime; color: darkgreen;">
		Liste des Fonctionnaires
		</h1>
		
		<table cellspacing="0" cellpadding="6" border="1" width="60%">
			<tr bgcolor="grey" style="color: white">
				<th>Identifiant</th>
				<th>Nom</th>
				<th>Prenom</th>
				<th>Département</th>
				<th>Fonction</th>
				<th>Salaire</th>
				<th>Supprimer</th>
			</tr>
			
			<c:forEach var="fonc" items="${attributeListeFonctionnaire}">
				<tr bgcolor="lightyellow">
					<td>${fonc.id}</td>
					<td>${fonc.nom}</td>
					<td>${fonc.prenom}</td>
					<td>${fonc.departement}</td>
					<td>${fonc.fonction}</td>
					<td>${fonc.salaire}</td>
					<td><a href="${pageContext.request.contextPath}/fonctionnaire/delete/${fonc.id}">X</a></td>
					<td><a href="${pageContext.request.contextPath}/fonctionnaire/updatefonctionnaireform?fonctid=${fonc.id}">Modifier</a></td>
				</tr>
			</c:forEach>
			
		</table>
	</div>
<br/>
	<button><a href="${pageContext.request.contextPath}/addfonctionnaireform">Ajouter un fonctionnaire</a></button>

</body>
</html>