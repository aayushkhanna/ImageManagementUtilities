<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.15.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="CSS/style.css">
<script type="text/javascript" src="Javascript/script.js"></script>

</head>
<body>
<div class="container-fluid">
	<header>Login</header>
			<br>
				<form action="Login" method="post">
					<table class="t1">
						<tr>
							<td><label>Username</label></td>
							<td><label class="required">* </label></td>
							<td><input type="text" name="name" id="name" size="50"
								required></td>
						</tr>
						<tr>
							<td><label>Password</label></td>
							<td><label class="required">* </label></td>
							<td><input type="password" name="password" id="password"
								size="50" required></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td><a href=""> Forgotten your password?</a></td>
						</tr>
					</table>
					<footer>

						<input type="submit" value="Login" class="btn1">
						
					</footer>
				</form>
</div>
</body>
</html>
