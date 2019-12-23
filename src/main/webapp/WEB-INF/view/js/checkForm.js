function checkForm(form)
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

    if(form.password.value != form.pass.value) {
      alert("Error: Please check that you've entered and confirmed your password!");
      form.password.focus();
      return false;
    }

    return true;
}