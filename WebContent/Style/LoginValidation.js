function validateLoginForm(){
	var un=document.loginform.uname.value;
	var pd=document.loginform.pass.value;
	var submit = document.loginform.login_selection.value;
	
	if(submit=="register"){
		return false;
	}else if(un==null || un==""){
		alert("enter user name");
		return false;
	}else if(pd==null || pd==""){
		alert("enter the password");
		return false;
	}
}