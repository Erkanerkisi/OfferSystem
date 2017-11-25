<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ page import="Model.Offer"%>
<%@ page import="_JSP.DbConnection"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/bootstrap-theme.min.css" rel="stylesheet"
	type="text/css" />

<script type="text/javascript" src="js/bootstrap.min.js"></script>

<script src="js/jquery-3.2.1.min.js"></script>

<jsp:include page="menu.jsp" />
</head>


<body>

	
	
	<div class="container">


		</br> </br> </br> </br> </br> </br>

		<div class="row">
			<div class="col-md-1"></div>


			<div class="col-md-8">

				<form class="form-horizontal" action="OfferTypeController"
					method="GET">

					<input type="hidden" name="Operation" value="add" />
					<div class="col-md-4">
						<input type="text" class="form-control" name="name"
							placeholder="Entry Name">
					</div>
					<div class="col-md-4">
						<input type="text" class="form-control" name="offertype"
							placeholder="Entry Offer Type">
					</div>
					<div class="col-md-4">
						<input type="submit" value="Add Offer Type"
							class="btn btn-success" />
					</div>
				</form>


			</div>

		</div>

		</br> </br>
		<div class="row">
			<div class="col-md-8">

				<table class="table table-striped">
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Type</th>
					</tr>

					<c:forEach items="${ListOfferTypes}" var="ot">
						<tr>

							<td>${ot.id}</td>
							<td>${ot.name}</td>
							<td>${ot.type}</td>

						</tr>
					</c:forEach>


				</table>
			</div>
		</div>
	</div>

</body>

</html>




