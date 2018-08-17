<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!--     taglib form propre à Spring MVC -->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter un fonctionnaire</title>
</head>
<body>

	<div align="center">
		<h1>Ajout d'un nouveau Fonctionnaire</h1>
		
		<div align="center">
			<table>
				<form:form modelAttribute="fonctionnaireCommand" action="${pageContext.request.contextPath}/fonctionnaire/add" method="POST">
					<tr>
						<td><form:label path="nom">Nom :</form:label></td>
						<td>
							<form:input path="nom"/>
						</td>
					</tr>
					<tr>
						<td><form:label path="prenom">Prenom :</form:label></td>
						<td>
							<form:input path="prenom"/>
						</td>
					</tr>
					<tr>
						<td><form:label path="departement">Département :</form:label></td>
						<td>
							<form:input path="departement"/>
						</td>
					</tr>
					<tr>
						<td><form:label path="fonction">Fonction :</form:label></td>
						<td>
							<form:input path="fonction"/>
						</td>
					</tr>
					<tr>
						<td><form:label path="salaire">Salaire :</form:label></td>
						<td>
							<form:input path="salaire"/>
						</td>
					</tr>
					<tr colspan="2">
						<td><input type="submit" value="Ajouter"/></td>
					</tr>
				</form:form>
			</table>
		</div>
	</div>

</body>
</html>