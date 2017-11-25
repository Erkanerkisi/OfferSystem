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
  


<!-- JAVA SCRIPTS  -->

<script type="text/javascript">

function validateFields(){
	var number = document.getElementById("ProjectNumber").value;
	if(number =="")
	{
		alert("Please Enter Project Number");
		return false;
	}
}


$(function() {
	
    $('tr').click(function() {
           $('.highlighted').removeClass("highlighted");
        $(this).addClass("highlighted");
    });
});

// $(document).ready(function(){
//     $("table tr").dblclick(function(){
//         alert("The paragraph was double-clicked.");
//     });
// });
$(document).ready(function(){
$('table tr').dblclick(function () {
	
    var $this = $(this);
    var row = $this.closest("tr");
    row.find('td:eq(1)');
    var id = row.find('td:first').text();
    //alert(id);
    //window.location.href=$(this).attr('link');
    document.location='ContactController?Operation=LIST&id=' + id;
})
});



</script>
</head>

<body>

	<div class="container">
		</br> </br> </br> </br> </br> </br>
		<div class="row">
			<div class="col-md-8">

				<form class="form-horizontal" action="ProjectEntryController"
					method="GET">

					<input type="hidden" name="Operation" value="add" />
					<div class="col-md-3">
						<input type="text" class="form-control" name="ProjectNumber" id="ProjectNumber"
							placeholder="Entry Project No">
					</div>
					<div class="col-md-3">
						<input type="text" class="form-control" name="ProjectName" id="ProjectName"
							placeholder="Entry Project Name">
					</div>
						<div class="col-md-3">
							<select type="text" name="ConsName" class="form-control" id="ConsName"
								placeholder="Entry Constructor Name">
								<!--    <option value="0">Choose Offer Type</option>-->
								<option value="" disabled selected>Entry Constructor Name</option>
								<c:forEach var="ot" items="${ListOfCons}">
									<option value="${ot.id}">${ot.name}</option>
								</c:forEach>
							</select>
					   </div>
	
					<div class="col-md-3">
						<input type="submit" value="Add Project" onclick="return validateFields();"
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
						<th>Id</th>
						<th>Project No</th>
						<th>Project Name</th>
						<th>Constructor</th>
					</tr>
					</thead>
					
					
					
					<tbody >

					<c:forEach items="${ListOfProjects}" var="ot">
						<tr>

							<td>${ot.project_id}</td>
							<td>${ot.project_number}</td>
							<td>${ot.project_name}</td>
							<td>${ot.getConstructor().name}</td>
						</tr>
					</c:forEach>
					    </tbody>
				
					
				</table>
			</div>
		</div>
	</div>

</body>

</html>




