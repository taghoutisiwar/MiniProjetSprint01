<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" />
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
<script type="text/javascript" src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Liste Employees</title>
</head>
<body>
	<div class="container mt-5">
		<div class="card">
			<div class="card-header">Liste Des Employees</div>
			<div class="card-body">

				<table class="table table-striped">
					<tr>
						<th>ID</th>
						<th>Employee First Name</th>
						<th>Employee LastName</th>
						<th>Email</th>
						<th>Suppression</th>
						<th>Edition</th>
					</tr>

					<c:forEach items="${employees}" var="e">
						<tr>
							<td>${e.id }</td>
							<td>${e.firstName }</td>
							<td>${e.lastName }</td>
							<td>${e.email }</td>
              <td><a onclick="return confirm('Etes-vous s�r ?')" href="supprimerEmployee?id=${e.id }">Supprimer</a></td>
               <td><a href="modifierEmployee?id=${e.id }">Edit</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>