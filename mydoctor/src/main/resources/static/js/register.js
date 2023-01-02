
	var username = document.getElementById("username");
	var email= document.getElementById("email");
	var password= document.getElementById("password");
	var firstName= document.getElementById("firstName");
	var lastName= document.getElementById("lastName");
	var phoneNumber= document.getElementById("phoneNumber");
	var dateBirth= document.getElementById("dateBirth");
	var addressLine1= document.getElementById("addressLine1");
	var addressLine2= document.getElementById("addressLine2");
	var city= document.getElementById("city");
	var zipcode= document.getElementById("zipcode");
	var state= document.getElementById("state");
	var authority= document.getElementById("authority");
	var gender= document.getElementById("gender");
	
	
	var token = document.getElementById("csrf.token").value;
	
	
	
	
	
	
	function register(){
	
	var user = {
		"username" : username.value,
		"firstName" : firstName.value,
		"lastName": lastName.value,
		"username" : username.value,
		"email" : email.value,
		"password" : password.value,
		"phoneNumber" : phoneNumber.value,
		"dateBirth" : dateBirth.value,
		"gender" : gender.value,
		"addressLine1" : addressLine1.value,
		"addressLine2" : addressLine2.value,
		"zipcode" : zipcode.value,
		"city" : city.value,
		"state" : state.value,
		"authority" : authority.value

		}
	console.log(user);
	
	 fetch('http://localhost:8080/register', {
		method: 'POST',
		headers: {
			'Accept': 'application/JSON',
			'Content-Type': 'multipart/mixed; boundary=gc0p4Jq0M2Yt08jU534c0p',
			"X-CSRF-TOKEN": "token"
		},
		body: JSON.stringify(user)
	}) .then((response) => response.json())
  .then((data) => {
    console.log('Success:', data);
  })
	}