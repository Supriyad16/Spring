function validatePatientName(){
let patientName=document.getElementById("patientName");
let patientNameError=document.getElementById("patientNameError");
let namePattern = /^[A-Za-z ]+$/;

patientName.value = patientName.value.replace(/[^A-Za-z ]/g, '');

if(patientName.value.length<3 || patientName.value.length>15 ||!namePattern.test(patientName.value)){
patientNameError.innerHTML="Name length should be 3 to 15 characters ";
}else{
patientNameError.innerHTML=" "
}
}

function validateAge(){
let patientAge=document.getElementById("age").value;
let patientAgeError=document.getElementById("patientAgeError");
if(patientAge<1 || patientAge>100){
patientAgeError.innerHTML="Age should be 1-100 ";
}else{
patientAgeError.innerHTML="";
}
}



function validateEmail(){
let patientEmail=document.getElementById("email").value;
let patientEmailError=document.getElementById("patientEmailError");
let emailPattern=/^[a-z0-9._]+@gmail\.com$/;

 if (!emailPattern.test(patientEmail)) {
        patientEmailError.innerHTML = "Email must follow this pattern: username@gmail.com";
    } else {
        patientEmailError.innerHTML = "";
    }
}


function validatePhoneNumber(){
       let patientPhone = document.getElementById("phoneNumber");
        let patientPhoneErrorId = document.getElementById("patientPhoneErrorId");
        patientPhone.value = patientPhone.value.replace(/[^0-9]/g, '');
        let phonePattern=/^[6-9]\d{9}$/;
        if (!phonePattern.test(patientPhone.value)) {
            patientPhoneErrorId.innerHTML = "Phone must start with 6 to 9 and be exactly 10 digits.";
        } else {
            patientPhoneErrorId.innerHTML = "";
        }

}

function validateAddress() {
    let address = document.getElementById("address").value.trim();
    let addressError = document.getElementById("addressError");

    if (address.length < 5 || address.length > 200) {
        addressError.innerHTML = "Address must be 5 to 200 characters long";
    } else {
        addressError.innerHTML = "";
    }
}

function validateDisease() {
    let disease = document.getElementById("disease").value.trim();
    let diseaseError = document.getElementById("diseaseError");

    if (disease.length < 4 || disease.length > 100) {
        diseaseError.innerHTML = "Description must be 4 to 100 characters long";
        return false;
    } else {
        diseaseError.innerHTML = "";
        return true;
    }
}


