const batchesJson = [{
    "id": 1,
    "batchName": "MBA2019-21",
    "cid": 1,
    "courseName": "MBA",
    "startYear": 2019,
    "endYear": 2021,
    "totalStrength": 60,
    "noOfStud": 60
  },
  {
    "id": 2,
    "batchName": "MBA2020-22",
    "cid": 1,
    "courseName": "MBA",
    "startYear": 2020,
    "endYear": 2022,
    "totalStrength": 60,
    "noOfStud": 60
  },
  {
    "id": 3,
    "batchName": "MCA2015-18",
    "cid": 2,
    "courseName": "MCA (3 Year) 2015 Pat.",
    "startYear": 2015,
    "endYear": 2018,
    "totalStrength": 60,
    "noOfStud": 60
  },
  {
    "id": 4,
    "batchName": "MCA2016-19",
    "cid": 2,
    "courseName": "MCA (3 Year) 2015 Pat.",
    "startYear": 2016,
    "endYear": 2019,
    "totalStrength": 60,
    "noOfStud": 60
  },
  {
    "id": 5,
    "batchName": "MCA2017-20",
    "cid": 2,
    "courseName": "MCA (3 Year) 2015 Pat.",
    "startYear": 2017,
    "endYear": 2020,
    "totalStrength": 60,
    "noOfStud": 60
  },
  {
    "id": 6,
    "batchName": "MCA2018-21",
    "cid": 2,
    "courseName": "MCA (3 Year) 2015 Pat.",
    "startYear": 2018,
    "endYear": 2021,
    "totalStrength": 60,
    "noOfStud": 60
  },
  {
    "id": 7,
    "batchName": "MCA2019-22",
    "cid": 3,
    "courseName": "MCA (3 Year) 2019 Pat.",
    "startYear": 2019,
    "endYear": 2022,
    "totalStrength": 60,
    "noOfStud": 60
  },
  {
    "id": 8,
    "batchName": "MCA2020-22",
    "cid": 4,
    "courseName": "MCA (2 Year) 2020 Pat.",
    "startYear": 2020,
    "endYear": 2022,
    "totalStrength": 60,
    "noOfStud": 60
  }
];

const coursesJson = [{
    "cid": 1,
    "courseName": "MBA",
    "coursePattern": 2019,
    "courseDuration": 2,
    "courseUniversity": "Savitribai Phule Pune University"
  },
  {
    "cid": 2,
    "courseName": "MCA (3 Year) 2015 Pat.",
    "coursePattern": 2015,
    "courseDuration": 3,
    "courseUniversity": "Savitribai Phule Pune University"
  },
  {
    "cid": 3,
    "courseName": "MCA (3 Year) 2019 Pat.",
    "coursePattern": 2019,
    "courseDuration": 3,
    "courseUniversity": "Savitribai Phule Pune University"
  },
  {
    "cid": 4,
    "courseName": "MCA (2 Year) 2020 Pat.",
    "coursePattern": 2020,
    "courseDuration": 2,
    "courseUniversity": "Savitribai Phule Pune University"
  }
];

function activateSameAsPhone() {
  var whatsappNoEle = document.getElementById("whatsappNo");
  whatsappNoEle.classList.remove('disabled');
}

function sameAsPhone() {
  var phoneNumberTF = document.getElementById("phoneNo").value;
  //console.log(phoneNumberTF)
  document.getElementById("whatsappNo").value = phoneNumberTF;
}

function populateCourses() {
  var courseOptions = "<option>Select a course</option>";
  var courses = "";
  var currentCourse = document.getElementById("currentCourse");
  for (var i = 0; i < coursesJson.length; i++) {
    if (!courses.includes(coursesJson[i].courseName)) {
      courses += coursesJson[i].courseName + ", ";
      courseOptions += "<option>" +coursesJson[i].cid + ", " + coursesJson[i].courseName + "</option>";
    }
  }
  currentCourse.innerHTML = courseOptions;
}

/* window.onload = function () {
  populateCourses();
  populateBatches();
}; */

function courseValueChanged() {
	  var batchOptions = "";
	  var currentBatch = document.getElementById("currentBatch");
	  var courseVal = document.getElementById("currentCourse").value;
	  courseValue = courseVal.split(", ")[1];
	  console.log(courseValue);
	  for (var i = 0; i < batchesJson.length; i++) {
	    if (batchesJson[i].courseName === courseValue) {
	      console.log(batchesJson[i].courseName, "s === ", courseValue)
	      batchOptions += "<option>" + batchesJson[i].id + ", " + batchesJson[i].batchName + "</option>";
	    }
	  }
	  currentBatch.innerHTML = batchOptions;
	}

	document.addEventListener("DOMContentLoaded", function () {
	  populateCourses();
	  disableSelection();
	});
	
	

function SSCEnableDisableTextBox(eleValue) {
    var percentField = document.getElementById("sscPercent");
    var cgpaField = document.getElementById("SSCcgpaGrade");
    if (eleValue.value == "percent") {
        percentField.removeAttribute("disabled");
    } 
    else{
    	percentField.setAttribute("disabled", "disabled");
    }
    if(eleValue.value.includes("cgpa")){
    	cgpaField.removeAttribute("disabled");
    }
    else{
    	cgpaField.setAttribute("disabled", "disabled");
    }
}

function HSCEnableDisableTextBox(eleValue) {
    var percentField = document.getElementById("hscPercent");
    var cgpaField = document.getElementById("HSCcgpaGrade");
    if (eleValue.value == "percent") {
        percentField.removeAttribute("disabled");
    } 
    else{
    	percentField.setAttribute("disabled", "disabled");
    }
    if(eleValue.value.includes("cgpa")){
    	cgpaField.removeAttribute("disabled");
    }
    else{
    	cgpaField.setAttribute("disabled", "disabled");
    }
}

function UGEnableDisableTextBox(eleValue) {
    var percentField = document.getElementById("gradPercent");
    var cgpaField = document.getElementById("UGcgpaGrade");
    if (eleValue.value == "percent") {
        percentField.removeAttribute("disabled");
    } 
    else{
    	percentField.setAttribute("disabled", "disabled");
    }
    if(eleValue.value.includes("cgpa")){
    	cgpaField.removeAttribute("disabled");
    }
    else{
    	cgpaField.setAttribute("disabled", "disabled");
    }
}

function CourseEnableDisableTextBox(eleValue){
	var otherField= document.getElementById("otherGrad");
	if(eleValue.value == "Other"){
		otherField.removeAttribute("disabled");
	}
	else{
		otherField.setAttribute("disabled", "disabled");
	}
}


function courseValueChanged() {
  var batchOptions = "";
  var currentBatch = document.getElementById("currentBatch");
  var courseVal = document.getElementById("currentCourse").value;
  courseValue = courseVal.split(", ")[1];
  console.log(courseValue);
  for (var i = 0; i < batchesJson.length; i++) {
    if (batchesJson[i].courseName === courseValue) {
      console.log(batchesJson[i].courseName, "s === ", courseValue)
      batchOptions += "<option>" + batchesJson[i].id + ", " + batchesJson[i].batchName + "</option>";
    }
  }
  currentBatch.innerHTML = batchOptions;
}

function upload_check(callbackOrigin,fieldMax)
{
    var upl = document.getElementById(callbackOrigin.id);
    var max = document.getElementById(fieldMax).value;

    if(upl.files[0].size > max)
    {
       alert("File too big!");
       upl.value = "";
    }
}

document.addEventListener("DOMContentLoaded", function () {
	initForm();
  populateCourses();
  disableSelection();
});

function initForm(){
	var currDate=new Date();
	var currTime=currDate.getHours().toString()+ currDate.getMinutes().toString()+ currDate.getSeconds().toString();
	var randNo= Math.floor(Math.random()*10001);
	
	var finalName= CryptoJS.MD5((randNo+currTime).toString()).toString();
	
	console.log(finalName);
	document.getElementById("formId").value=finalName;
	
	document.getElementById("resumeNameID").value=finalName;
	document.getElementById("formId").value=finalName;
	
}

function onlynum(eleName) {
    var fm = document.getElementById("form2");
    var ip = document.getElementById(eleName);
    var tag = document.getElementById("value");
    var res = ip.value;

    if (res != '') {
        if (isNaN(res)) {
              
            // Set input value empty
            ip.value = "";
              alert("Only numeric values allowed");
            // Reset the form
            fm.reset();
            return false;
        } else {
            return true
        }
    }
}

function phoneNoValidate(fieldValue,errorId){
	var phoneno = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;
	
	  if(fieldValue.value.match(phoneno))
	     {
		  document.getElementById(errorId).innerHTML="";
		 }
	   else
	     {
		   fieldValue.value="";
		   document.getElementById(errorId).innerHTML="Not a valid Phone Number";
	     }
}

/*$(function() {
    $("input[name='SSCcgpaGrade']").on('input', function(e) {
        $(this).val($(this).val().replace(^\d+(\.\d{1,2})?$, ''));
    });
});
//$(this).val($(this).val().replace(/[^0-9]/g, ''));
*/

var disableSelection = function () {
  $("cgpaGrade").prop("disabled", true);
};

var enableSelection = function () {
  $("cgpaGrade").prop("disabled", false);
};

/* $(document).ready(function () {
  $('select').formSelect();
  $('.datepicker').datepicker();
}); */

function gradeSystemSelected() {
  var percentageEle = document.getElementById("graduationPercent");
  var cgpaGradeEle = document.getElementById("cgpaGrade");

  switch (document.getElementById("gradingSystem").value) {
    case "percentage":
      break;
    case "cgpa10":
      cgpaGradeEle.disabled = false;
      var cgpaGrade = cgpaGradeEle.value;
      var percentCalc = cgpaGrade * 7.1 + 11;
      percentageEle.value = percentCalc;
      break;
    case "cgpa7":
      // code block
      break;
    case "cgpa5":
      // code block
      break;
    case "cgpa4":
      // code block
      break;
    default:
      // code block
  }
}

let dateOfBirth = document.querySelectorAll('.datepicker');
M.Datepicker.init(dateOfBirth, {
  format: 'dd-mm-yyyy',
  autoClose: true,
  showMonthAfterYear: true,
  onSelect: () => {
    console.log(document.getElementById('birthday').value);
  }
});

let dreamCompanies = [];
let dreamCompaniesChips = document.querySelectorAll('.chips');
M.Chips.init(dreamCompanies, {
  onChipAdd: () => {
    console.log(document.getElementById('dreamCompanies').value);
  },
  placeholder: "E.g. Apple, Infosys, etc."
});