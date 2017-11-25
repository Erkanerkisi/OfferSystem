<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/bootstrap-theme.min.css" rel="stylesheet"
	type="text/css" />
	

<script src="js/bootstrap.min.js"></script>

<script src="js/jquery-3.2.1.min.js"></script>

</head>
<body>


	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="HomeController">Home</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="<c:url value="HomeController" />">Offers</a></li>
					<li><a href="<c:url value="ApprovedController" />">Approved Offers</a></li>
					<li><a href="<c:url value="AddOfferController?Status=NEW" />">Add Offer</a></li>
					<li><a href="<c:url value="/form" />">Edit Offer</a></li>
					
					<li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Definitions <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="<c:url value="OfferTypeController?Operation=List" />"> Define Offer Type</a></li>
            <li><a href="<c:url value="ProjectEntryController?Operation=List" />">Define Project</a></li>
            
          </ul>
        </li>
				</ul>
			</div>
		</div>
	</div>

</body>
</html>