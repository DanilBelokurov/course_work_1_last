<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Signup page</title>

<%-- <script><%@include file='js/main.js' %></script> --%>

<script><%@include file='js/jquery-3.2.1.min.js' %></script>


<script type="text/javascript">

	function checkForm()
	{
			
	  if(form.name.value == "") {
	      alert("Error: Name cannot be blank!");
	      form.name.focus();
	      return false;
	    }
	
	  if(form.login.value == "") {
	    alert("Error: Login cannot be blank!");
	    form.login.focus();
	    return false;
	  }
	
	  re = /^\w+$/;
	  if(!re.test(form.login.value)) {
	    alert("Error: Login must contain only letters, numbers and underscores!");
	    form.login.focus();
	    return false;
	  }
	  
	  if(form.password.value == "") {
	      alert("Error: Password cannot be blank!");
	      form.password.focus();
	      return false;
	    }
	
	  if(form.password.value != form.password2.value) {
	    alert("Error: Please check that you've entered and confirmed your password!");
	    form.password.focus();
	    return false;
	  }
	  
	  if(form.role.value == "Student"){
		  var checked = [];
		  $('input:checkbox:checked').each(function() {
		  	checked.push($(this).val());
		  });
		  
		  if(checked.length > 1){
			  alert("Only one group for student");
			  return false;
		  }
	  }
	  
		return true;
	}

</script>

<style><%@include file='css/bootstrap.min.css'%></style>

<style><%@include file='css/main.css'%></style>


</head>

<body>

	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-t-50 p-b-90">

				<form name="form" method="post" class="login100-form validate-formflex-sbflex-w">
					<input type="hidden" name="redirectId" value="${param.redirectId}" />
					<span class="login100-form-title p-b-51"> Signup </span>

					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Name is required">
						<input class="input100" type="text" required placeholder="Name"
							name="name" autofocus required> <span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Username is required">
						<input class="input100" type="text" required placeholder="Login"
							name="login" autofocus required"> <span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Password is required">
						<input class="input100" type="password" required
							placeholder="Password" name="password" id="password"> <span
							class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-16"
						data-validate="Password is required">
						<input class="input100" type="password" required
							placeholder="Repeat your password" name="password2" id="password2"> <span
							class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-16" data-validate="Role is required">
						 <select class="input100" name="role" >
						    <option value="Student" selected>Student</option>
						    <option value="Teacher">Teacher</option>
						  </select>
					</div>
					
					<div class="wrap-input100 checkboxes_div m-b-16"
						data-validate="Password is required">
						<div class="checkboxes">
							<input type="checkbox" name="groups[]" value="5711">
							<label for="5711">5711</label>
						</div>
						
						<div class="checkboxes">
							<input type="checkbox" name="groups[]" value="5712">
							<label for="5712">5712</label>
						</div>
						
						<div class="checkboxes">
							<input type="checkbox" name="groups[]" value="5721">
							<label for="5721">5721</label>
						</div>
						
						<div class="checkboxes">
							<input type="checkbox" name="groups[]" value="5722">
							<label for="5722">5722</label>
						</div>
						
						<div class="checkboxes">
							<input type="checkbox" name="groups[]" value="5723">
							<label for="5723">5723</label>
						</div>
					</div>

					<div class="container-login100-form-btn m-t-17">
						<button class="login100-form-btn" type="submit" onClick="return checkForm();"value="signup">Signup</button>
					</div>

				</form>
			</div>
		</div>
	</div>



</body>
</html>
