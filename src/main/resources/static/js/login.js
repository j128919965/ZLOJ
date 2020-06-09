/**
 * 
 * @authors ZFXG
 * @date    2020-03-15 21:35:28
 * @version $Id$
 */

var username = document.getElementById("username");
var password1 = document.getElementById("password1");
var password2 = document.getElementById("password2");
var email = document.getElementById("email");
var flagArray = new Array();
var result;

username.addEventListener("input", function (event){
	if(username.value.length<3){
		username.classList.add("is-invalid");
		username.classList.remove("input-good");
		username.classList.remove("is-valid");
		flagArray[0] = 0;
	}
	else{
		username.classList.remove("is-invalid");
		username.classList.add("input-good");
		username.classList.add("is-valid");
		flagArray[0] = 1;
	}
});

password1.addEventListener("input", function (event){
	if(password1.value.length<6){
		password1.classList.add("is-invalid");
		password1.classList.remove("is-valid");
		password1.classList.remove("input-good");
		flagArray[1] = 0;
	}
	else{
		password1.classList.remove("is-invalid");
		password1.classList.add("is-valid");
		password1.classList.add("input-good");
		flagArray[1] = 1;
	}
});

password2.addEventListener("input", function (event){
	if(password1.value == password2.value){
		password2.classList.remove("is-invalid");
		password2.classList.add("is-valid");
		password2.classList.add("input-good");
		flagArray[2] = 1;
	}
	else{
		password2.classList.add("is-invalid");
		password2.classList.remove("is-valid");
		password2.classList.remove("input-good");
		flagArray[2] = 0;
	}
});

email.addEventListener("input", function (event){
	if(!isRight(email.value) ||mail.value.length>30){
		email.classList.add("is-invalid");
		email.classList.remove("is-valid");
		email.classList.remove("input-good");
		flagArray[3] = 0;
	}
	else{
		email.classList.remove("is-invalid");
		email.classList.add("is-valid");
		email.classList.add("input-good");
		flagArray[3] = 1;
	}
});

function isRight(str){
	var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	return reg.test(str);
}

function validateLogin(){
	result = 1;
	for(i = 0;i<2;i++){
		if(flagArray[i] == 0){
			result = 0;
			alert("请填写完整信息");
			return false;
		}
	}
	if(result == 1)
		if (username.value =="root" && password1.value =="123456") {
			alert("登录成功");
			setCookie("uid",1,1);
			return true;
		}
		alert("账户或密码错误！");
		return false;
}

function validateRegister(){
	result = 1;
	for(i = 0;i<4;i++){
		if(flagArray[i] == 0){
			result = 0;
			alert("请填写完整信息");
			return false;
		}
	}
	if(result == 1){
		alert("注册成功");
		return true;
	}
}

function setCookie(cname,cvalue,exdays)
{
  var d = new Date();
  d.setTime(d.getTime()+(exdays*24*60*60*1000));
  var expires = "expires="+d.toGMTString();
  document.cookie = cname + "=" + cvalue + "; " + expires;
}