<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ page import="Model.Offer"%>
<%@ page import="_JSP.DbConnection"%>


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

<%
	int a = 0;

	List<Offer> TheOffers = (List<Offer>) request.getAttribute("APPROVED_OFFER_LISTS");
%>

<body>

	<div class="container">

		<div class="row">

			<div class="col-md-3"></div>


			<div class="col-md-10">



				<div id="wrapper"></div>


				<div id="container">

					<div id="content">
						</br> </br> </br> </br> </br> </br> <input type="button" value="Add Offer"
							class="btn btn-success"
							onClick="window.open('add_Offer_Form.jsp','popuppage','width=200,toolbar=1,resizable=1,scrollbars=yes,height=200,top=100,left=100');" />
						</br> </br>

						<table class="table table-striped">
							<tr>
								<th>Offer Number</th>
								<th>Offer Date</th>
								<th>Offer Type</th>
								<th>Action</th>
							</tr>

							<%
								for (Offer xx : TheOffers) {
							%>




							<tr>
								<td><%=xx.getOrder_number()%></td>
								<td><%=xx.getOrder_date()%></td>
								<td><%=xx.getOrder_type()%></td>
								<td><a
									href="OfferController?command=LOAD&offerid=<%=xx.getOrder_header_id()%>">
										Update</a></td>
							</tr>


							<%
								}
							%>


						</table>
					</div>

				</div>


			</div>



		</div>


	</div>

</body>

</html>