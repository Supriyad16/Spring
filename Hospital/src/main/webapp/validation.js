function validateName() {
    const nameField = document.getElementById("doctorName");
    if (!nameField) {
        console.error("doctorName input not found in DOM");
        return;
    }

    let nameValue = nameField.value || "";
    nameValue = nameValue.replace(/[^A-Za-z\s]/g, '').trim();

    const nameError = document.getElementById("doctorNameError");
    if (!nameError) return;

    if (nameValue.length < 3 || nameValue.length > 20) {
        nameError.textContent = "Name must be 3 to 20 letters only ";
    } else {
        nameError.textContent = "";
    }
}

function validatePatientName() {
    const nameField = document.getElementById("doctorName");
    if (!nameField) {
        console.error("doctorName input not found in DOM");
        return;
    }

    let nameValue = nameField.value || "";
    nameValue = nameValue.replace(/[^A-Za-z\s]/g, '').trim();

    const nameError = document.getElementById("patientNameError");
    if (!nameError) return;

    if (nameValue.length < 3 || nameValue.length > 20) {
        nameError.textContent = "Name must be 3 to 20 letters only ";
    } else {
        nameError.textContent = "";
    }
}



function onlyLetters(event) {
    let char = String.fromCharCode(event.which);

    if (!/^[A-Za-z]$/.test(char)) {
        event.preventDefault();
        return false;
    }
    return true;
}


function onlyNumbers(event) {
    let char = event.key;

    if (!/^[0-9]$/.test(char)) {
        event.preventDefault();
        return false;
    }
    return true;
}


function validatePhoneNo() {
    let phoneNoInput = document.getElementById("phoneNumber").value;
    let phoneError = document.getElementById("phoneError");


   if (!/^[6-9]/.test(phoneNoInput)) {
        phoneError.textContent = "Phone number should start with 6, 7, 8, or 9";
        return;
    }

    if (phoneNoInput.length !== 10) {
        phoneError.textContent = "Phone number should be 10 digits";
        return;
    }

    phoneError.textContent = "";
}

function validateEmail() {
    let emailInput = document.getElementById("email").value.trim();
    let emailError = document.getElementById("emailError");
    console.log("hello world");

    let regex = /^[A-Za-z][A-Za-z0-9._%+-]*@gmail\.com$/;

    if (!regex.test(emailInput)) {
        emailError.textContent = "Email must start with a letter and end with gmail.com";
    } else {
        emailError.textContent = "";
    }
}


function validateAge(){

    let ageInput = document.getElementById("age").value;
    let ageError = document.getElementById("ageError");

    if(ageInput <= 18 || ageInput > 61){
        ageError.textContent = "Age should be above 18 and less than 60";
    }else{
        ageError.textContent = "";
    }

}

function validateGender() {
    let genderInput = document.getElementById("gender").value;
    let genderError = document.getElementById("genderError");

    if (genderInput === "") {
        genderError.textContent = "Please select the gender";
    } else {
        genderError.textContent = "";
    }

}

function validateExperience() {
    let experienceInput = document.getElementById("experience").value.trim();
    let experienceError = document.getElementById("experienceError");

    if (experienceInput.length < 1) {
        experienceError.textContent = "Experience is required";
    } else if (isNaN(experienceInput)) {
        experienceError.textContent = "Experience must be a number";
    } else if (parseInt(experienceInput) < 2 || parseInt(experienceInput) > 30) {
        experienceError.textContent = "Experience must be between 2 and 30 years";
    } else {
        experienceError.textContent = "";
    }
}
