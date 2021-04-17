/**
 * 
 */

function checkData(elementid, value) {
	console.log(elementid, " - ", value);
}

function sameAsPhone() {
	var phoneNumberTF = document.getElementById("phoneNumber").value;
	//console.log(phoneNumberTF)
	document.getElementById("whatsappNumber").value = phoneNumberTF;
}

function EnableOtherLangs(checkOtherLang) {
	var otherLanguagesKnown = document.getElementById("otherLanguagesKnown");
	otherLanguagesKnown.disabled = checkOtherLang.checked ? false : true;
	if (!otherLanguagesKnown.disabled) {
		otherLanguagesKnown.focus();
	} else {
		otherLanguagesKnown.value = "";
	}
}

function EnableOtherCourse(checkOtherCourse) {
	var otherCourseName = document.getElementById("otherCourseName");
	if (checkOtherCourse == "OtherCourse") {
		otherCourseName.removeAttribute("disabled");
	} else {
		otherCourseName.setAttribute("disabled", "disabled");
	}
}

function enableAccChoice(choiceValue, valueField) {
	var valueField = document.getElementById(valueField);
	if (choiceValue == "yes") {
		valueField.removeAttribute("disabled");
	} else {
		valueField.setAttribute("disabled", "disabled");
	}
}
