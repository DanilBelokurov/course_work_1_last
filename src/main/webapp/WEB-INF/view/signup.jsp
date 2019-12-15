<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Signup page</title>
<%-- <style>
   		<%@include file='css/bootstrap.min.css' %>
	</style>
	<style>
   		<%@include file='css/main.css' %>
	</style>
		<script >
		<%@include file='js/main.js' %>
	</script> --%>
</head>

<body>

	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-t-50 p-b-90">
			
			<p>
			user name
					<%
						if (request.getAttribute("userName") != null) {
							out.println("<p>" + "Username " + request.getAttribute("userName") + "</p>");
						}
					%>
				</p>

				<form method="post" "login100-form validate-form flex-sbflex-w">
					<input type="hidden" name="redirectId" value="${param.redirectId}" />
					<span class="login100-form-title p-b-51"> Signup </span>

					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Name is required">
						<input class="input100" type="text" required placeholder="Name"
							name="name"> <span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Username is required">
						<input class="input100" type="text" required placeholder="Login"
							name="login"> <span class="focus-input100"></span>
					</div>


					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Password is required">
						<input class="input100" type="password" required
							placeholder="Password" name="password"> <span
							class="focus-input100"></span>
					</div>
					
					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Password is required">
						<input class="input100" type="password" required
							placeholder="Repeat your password" name="password"> <span
							class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Password is required">
						<input class="input100" type="text" required
							placeholder="role" name="role"> <span
							class="focus-input100"></span>
					</div>
					
					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Password is required">
						<input class="input100" type="text" required
							placeholder="Group" name="groups"> <span
							class="focus-input100"></span>
					</div>

					<div class="container-login100-form-btn m-t-17">
						<button class="login100-form-btn" type="submit" value="signup">
							Signup</button>
					</div>

				</form>

				<!-- Button goes to registration -->
				<div class="container-login100-form-btn m-t-17"></div>
			</div>
		</div>
	</div>



</body>
</html>
