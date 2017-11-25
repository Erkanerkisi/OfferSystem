<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/bootstrap.min.js">
	
</script>
</head>
<body>
	<div class="container">

		<div class="row">

			<div class="col-md-3"></div>

			<div class="col-md-6">

				<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
				<br /> <br />
				<form action="LoginController" method="GET">
					<div class="form-group">
						<label for="exampleInputEmail1">Email address</label> <input
							type="email" class="form-control" name="email"
							placeholder="Email">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Password</label> <input
							type="password" class="form-control" name="password"
							placeholder="Password">
					</div>

					<%
						String pmessage = "";
						if (request.getAttribute("loginResult") != null && request.getAttribute("loginResult").equals("false"))

						{
							pmessage = "Invalid Password or email address";
						}
					%>

					<button type="submit" class="btn btn-default">Login</button>
					<label for="message"><%=pmessage%></label>
				</form>

			</div>
		</div>
	</div>



</body>
</html>