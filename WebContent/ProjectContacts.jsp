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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/bootstrap-theme.min.css" rel="stylesheet"
	type="text/css" />

<script type="text/javascript" src="js/bootstrap.min.js"></script>

<script src="js/jquery-3.2.1.min.js"></script>

<jsp:include page="menu.jsp" />

<!-- CSS  -->

<style type="text/css">


.header-fixed {
	    width: 100% 
	}
	
	.header-fixed > thead,
	.header-fixed > tbody,
	.header-fixed > thead > tr,
	.header-fixed > tbody > tr,
	.header-fixed > thead > tr > th,
	.header-fixed > tbody > tr > td {
	    display: block;
	}

	.header-fixed > tbody > tr:after,
	.header-fixed > thead > tr:after {
	    content: ' ';
	    display: block;
	    visibility: hidden;
	    clear: both;
	}

	.header-fixed > tbody {
	    overflow-y: auto;
	    height: 400px;
	}

	.header-fixed > tbody > tr > td,
	.header-fixed > thead > tr > th {
	    width: 25%;
	    float: left;
	}
	
	.highlighted {
    background-color: #e0ebeb;
     
}

</style>

</head>
<body>


	DENEMEEEEEEEEEEEEEEEEE

	<c:out value="${id}"/>
	
	
	<div class="container">
		</br> </br> </br> </br> </br> </br>
		<div class="row">
			<div class="col-md-8">

				<form class="form-horizontal" action="ContactController"
					method="GET">

					<input type="hidden" name="Operation" value="add" />
					<input type="hidden" name="id" value="${id}" />
					<div class="col-md-3">
						<input type="text" class="form-control" name="NameSurname" id="NameSurname"
							placeholder="Entry Name Surname">
					</div>
					<div class="col-md-3">
						<input type="text" class="form-control" name="Email" id="Email"
							placeholder="Entry Email">
					</div>
					
					<div class="col-md-3">
						<input type="text" class="form-control" name="Phone" id="Phone"
							placeholder="Entry Phone">
					</div>
					
	
					<div class="col-md-3">
						<input type="submit" value="Add Contact"
							class="btn btn-success" />
					</div>
				</form>

			</div>

		</div>

		</br> </br>
		<div class="row">
			<div class="col-md-8" >

				<table class="table table-hover header-fixed" id = "table1">
				<thead>
					<tr>
						<th>Contact Name</th>
						<th>Email</th>
						<th>Phone</th>
						<th>Edit</th>
					</tr>
					</thead>
					
					
					
					<tbody >

					<c:forEach items="${ListOfContacts}" var="ot">
						<tr>

							<td>${ot.name_surname}</td>
							<td>${ot.email}</td>
							<td>${ot.phone}</td>
							<td><a
									href="ContactController?Operation=LIST&id=">
										Update</a></td>
						</tr>
					</c:forEach>
					    </tbody>
				
					
				</table>
			</div>
		</div>
	</div>
	
	

</body>
</html>