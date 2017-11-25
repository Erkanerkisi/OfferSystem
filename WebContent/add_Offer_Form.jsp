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
<script type="text/javascript" src="js/bootstrap.min.js">
	
</script>
<script src="js/jquery-3.2.1.min.js"></script>

<!-- <jsp:include page="menu.jsp" />  -->

</head>
<body>

	<div id="container">
		<div class="row">
			<jsp:include page="menu.jsp" />
			<br /> <br /> <br /> <br /> <br />

		</div>


		<div class="row">

			<div class="col-md-2"></div>
			<div class="col-md-3">
				<!-- Sol FrameWork  -->

			
				<form class="form-horizontal" action="AddOfferController" method="GET">
					<button type="submit" class="btn btn-success">Create Offer</button>

					<input type="hidden" name="Status" value="create" />
					<div class="form-group">
						<label class="col-md-6 control-label">Offer Number</label>
						<div class="col-md-6">
							<input type="text" class="form-control" name="offernumber"
								placeholder="Entry Offer Number">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-6 control-label">Offer Type</label>
						<div class="col-md-6">

							<!-- 							<input type="text" class="form-control" name="offertype" -->
							<!-- 							placeholder="Entry Offer Type"> -->

							<select type="text" name="offertype" class="form-control"
								placeholder="Entry Offer Type">
								<!--    <option value="0">Choose Offer Type</option>-->
								<option value="" disabled selected>Entry Offer Type</option>
								<c:forEach var="ot" items="${OFFERTYPES}">
									<option value="${ot.name}">${ot.name}</option>
								</c:forEach>

							</select>

						</div>
					</div>

					<div class="form-group">
						<label class="col-md-6 control-label">Offer Date</label>
						<div class="col-md-6">
							<input type="text" class="form-control" name="offerdate"
								placeholder="Entry Offer Date">
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-6 control-label">Customer ID</label>
						<div class="col-md-6">
							<input type="text" class="form-control" name="customerid"
								placeholder="Entry Customer ID">
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-6 control-label">Offer Type</label>
						<div class="col-md-6">
							<input type="text" class="form-control" name="totalamount"
								placeholder="Entry Total Amount">
						</div>
					</div>


					<br /> <br /> <br /> <br />

				</form>



			</div>
			<!-- Sol FrameWork  -->
			<div class="col-md-5">
				<!-- orta FrameWork  -->

				<form class="form-horizontal" action="AddOfferController"
					method="GET">
					<input type="hidden" name="Status" value="ADD" />
					<div class="col-md-2">
						<button type="submit" class="btn btn-success">Add Item</button>
					</div>

					<div class="col-md-5">
						<select name="items" class="form-control">
							<c:forEach var="item" items="${ALLITEMS}">
								<option value="${item.itemId}">${item.itemDesc}</option>
							</c:forEach>

						</select>
					</div>
					<div class="col-md-3">
						<input type="text" class="form-control" name="qty"
							placeholder="Entry Quantity">
					</div>

				</form>
				<br /> <br /> <br /> <br />
				<table class="table table-striped">
					<tr>
						<th>Line</th>
						<th>Item Number</th>
						<th>Item Description</th>
						<th>Quantity</th>
						<th>Edit</th>

					</tr>
							<% int i = 1; %>
					<c:forEach items="${viewItems}" var="user">
						<tr>
							
							<td><%=i %></td>
							<td>${user.item_number}</td>
							<td>${user.item_desc}</td>
							<td>${user.quantity}</td>
							<td><a
									href="AddOfferController?Status=Delete&indexofarray=<%=i-1%>">
										Remove</a></td>
							
							<% i++; %>	
						</tr>
					</c:forEach>

				</table>


			</div>
			<!-- orta FrameWork  -->
			<div class="col-md-2">
				<!-- sag FrameWork  -->

			</div>
			<!-- sag FrameWork  -->
		</div>
	</div>

</body>
</html>