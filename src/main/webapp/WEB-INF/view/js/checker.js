function checkPas() {
  var pas1 = document.getElementById("password");
  var pas2 = document.getElementById("password2");
  if(pas1.value != '' && pas2.value != '') {
    
    if(pas1.value != pas2.value){
      pas1.style.borderColor = "red";
      pas2.style.borderColor = "red";
      document.getElementById("password2").setCustomValidity("Пароли не совпадают!");
      return false;
    }
    else {
      pas1.style.borderColor = "#28921f";
      pas2.style.borderColor = "#28921f";
 
      return true;
    }
  }
}

function loadDoc() {
	 return checkPas();
}