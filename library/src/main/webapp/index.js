function validateName(){

    let nameInput = document.getElementById("name").value;
    let nameError = document.getElementById("nameError");

    if(nameInput.length < 3 || nameInput.length >20){
         nameError.textContent = "Name must be between 3 and 20 characters";
    }else{
        nameError.textContent = "";
    }

}

function validatePhoneNo(){

    let phoneNoInput = document.getElementById("phoneNumber").value;
    let phoneError = document.getElementById("phoneError");

    if(phoneNoInput.length != 10){
        phoneError.textContent = "Phone number should be 10 digits ";
    }else{
        phoneError.textContent = "";
    }

}

function validateEmail(){

    let emailInput = document.getElementById("email").value;
    let emailError = document.getElementById("emailError");

    let regex = /^[a-zA-Z0-9._%+-]+@gmail\.com$/;
    if(!regex.test(emailInput)){
        emailError.textContent = "Email should end with gmail.com";
    }else{
        emailError.textContent = "";
    }

}

function validateAge(){

    let ageInput = document.getElementById("age").value;
    let ageError = document.getElementById("ageError");

    if(ageInput <= 18){
        ageError.textContent = "Age should be above 18";
    }else{
        ageError.textContent = "";
    }

}

function validatePassword(){
    let passwordInput = document.getElementById("password").value;
    let passwordError = document.getElementById("passwordError");

    let regex = /^(?=.*[A-Za-z])(?=.*\d).{5,}$/;

    if(!regex.test(passwordInput)){
        passwordError.textContent = "Password must be at least 5 chars, contain letters & numbers , may have special char";
    }
    else{
        passwordError.textContent = "";
    }
}

function validateConfirmPassword(){
    let confirmPasswordInput = document.getElementById("confirmPassword").value;
    let passwordInput = document.getElementById("password").value;
    let confirmPasswordError = document.getElementById("confirmPasswordError");

    if(confirmPasswordInput !== passwordInput){
        confirmPasswordError.textContent = "Password and Confirm Password are not matching"
    }
    else{
        confirmPasswordError.textContent = "";
    }
}

function validateAddress(){

    let addressInput = document.getElementById("address").value;
    let addressError = document.getElementById("addressError");

    if(addressInput.length < 4 || addressInput.length > 50 ){
        addressError.textContent = "Address should be above 4 char and should not exceed 30 char";
    }else{
        addressError.textContent = "";
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