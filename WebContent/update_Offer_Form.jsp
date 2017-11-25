<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@ page import="Model.Offer"%>
<%@ page import="_JSP.DbConnection"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update</title>

<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/bootstrap.min.js">
</script>

</head>
<body>


<% 
Offer of = (Offer) request.getAttribute("THE_OFFER");
%>




<div id="wrapper">

		<div id="header">

			<h2>  Update Offer</h2>

		</div>

	</div>
<br>
<br>

	<div id="container">
	
	<form class="form-horizontal" action="OfferController" method = "GET">
	
	<input type = "hidden" name = "command" value="UPDATE"/>
	
	<input type = "hidden" name = "offerid" value=<%=of.getOrder_header_id() %> />
	
	

	
  <div class="form-group">
    <label class="col-md-1 control-label">Offer Number</label>
    <div class="col-md-2">
      <input type="text" class="form-control"  name="offernumber" value = <%=of.getOrder_number() %> >
    </div>
  </div>
  <div class="form-group">
    <label class="col-md-1 control-label">Offer Type</label>
    <div class="col-md-2">
      <input type="text" class="form-control" name="offertype" value = <%=of.getOrder_type()%> >
    </div>
  </div>
  
  <%
  SimpleDateFormat formatter=new SimpleDateFormat("dd.MM.YYYY");

  String dates=formatter.format(of.getOrder_date());
  %>
  
    <div class="form-group">
    <label class="col-md-1 control-label">Offer Date</label>
    <div class="col-md-2">
      <input type="text" class="form-control" name="offerdate" value = <%=dates %>>
    </div>
  </div>
  
    <div class="form-group">
    <label class="col-md-1 control-label">Customer ID</label>
    <div class="col-md-2">
      <input type="text" class="form-control" name="customerid" value = <%=of.getCustomer_id() %>>
    </div>
  </div>
  
    <div class="form-group">
    <label class="col-md-1 control-label">Offer Type</label>
    <div class="col-md-2">
      <input type="text" class="form-control" name="totalamount" value = <%=of.getTotal_amount() %>>
    </div>
  </div>

    <div class="col-md-offset-1 col-md-10">
     <a class="btn btn-info" href="OfferController">Back to offers</a> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
      <button type="submit" class="btn btn-success">Update</button>
    </div>
 
</form>
 </div>

		

</body>
</html>