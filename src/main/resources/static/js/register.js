var username = document.getElementById("kullaniciAdi");
var email = document.getElementById("email");
var password = document.getElementById("password");
var firstName = document.getElementById("firstName");
var lastName = document.getElementById("lastName");
var phoneNumber = document.getElementById("phoneNumber");
var dateBirth = document.getElementById("dateBirth");
var addressLine1 = document.getElementById("addressLine1");
var addressLine2 = document.getElementById("addressLine2");
var city = document.getElementById("city");
var zipcode = document.getElementById("zipcode");
var state = document.getElementById("state");
var authority = document.getElementById("authority");
var gender = document.getElementById("gender");
var firstNames = document.getElementById("firstNames").value;
var lastNames = document.getElementById("lastNames").value;
var emails = document.getElementById("emails").value;
var phoneNumbers = document.getElementById("phoneNumbers").value;
var token = document.getElementById("csrf.token").value;

var aaddressLine1 = document.getElementById("aaddressLine1").value;
var aaddressLine2 = document.getElementById("aaddressLine2").value;
var acity = document.getElementById("acity").value;
var azipcode = document.getElementById("azipcode").value;
var astate = document.getElementById("astate").value;

var newpasswords = document.getElementById("newpasswords").value;

function register() {

	var user = {
		"userName": username.value,
		"firstName": firstName.value,
		"lastName": lastName.value,
		"email": email.value,
		"password": password.value,
		"phoneNumber": phoneNumber.value,
		"dateBirth": dateBirth.value,
		"gender": gender.value,
		"addressLine1": addressLine1.value,
		"addressLine2": addressLine2.value,
		"zipcode": zipcode.value,
		"city": city.value,
		"state": state.value,
		"authority": authority.value

	}
	console.log(user);

	fetch('http://localhost:8080/register', {
		method: 'POST',
		headers: {
			"Content-Type": "application/json",

		},
		body: JSON.stringify(user)
	})
		.then(window.location.href = 'http://localhost:8080/index');
}


function login() {

	window.location.href = ('http://localhost:8080/login');
}

function goregister() {

	window.location.href = ('http://localhost:8080/register');
}


function updatePersonal() {

	firstNames = document.getElementById("firstNames").value;
	lastNames = document.getElementById("lastNames").value;
	emails = document.getElementById("emails").value;
	phoneNumbers = document.getElementById("phoneNumbers").value;

	var personal = {
		"firstName": firstNames,
		"lastName": lastNames,
		"email": emails,
		"phoneNumber": phoneNumbers,



	}

	fetch('http://localhost:8080/personal', {
		method: 'POST',
		headers: {
			"Content-Type": "application/json",
			"X-CSRF-TOKEN": token

		},
		body: JSON.stringify(personal)
	}).then(alert("Your Informations Updated!"))
		.then(window.location.reload);
}


function updateAddress() {
	 aaddressLine1 = document.getElementById("aaddressLine1").value;
	 aaddressLine2 = document.getElementById("aaddressLine2").value;
	 acity = document.getElementById("acity").value;
	 azipcode = document.getElementById("azipcode").value;
	 astate = document.getElementById("astate").value;

	var address = {
		"aaddressLine1": aaddressLine1,
		"aaddressLine2": aaddressLine2,
		"acity": acity,
		"astate": astate,
		"azipcode": azipcode,
	}

	fetch('http://localhost:8080/addressUpdate', {
		method: 'POST',
		headers: {
			"Content-Type": "application/json",
			"X-CSRF-TOKEN": token

		},
		body: JSON.stringify(address)
	}).then(alert("Your Informations Updated!"))
		.then(window.location.reload);
}


function updatePassword() {
	 newpasswords = document.getElementById("newpasswords").value;


	var password = {
		"newpasswords": newpasswords,
	}

	fetch('http://localhost:8080/updatepassword', {
		method: 'POST',
		headers: {
			"Content-Type": "application/json",
			"X-CSRF-TOKEN": token

		},
		body: JSON.stringify(password)
	}).then(alert("Your Informations Updated!"))
		.then(window.location.reload);
}























