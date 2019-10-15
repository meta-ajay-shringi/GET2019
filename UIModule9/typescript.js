var currentField;
var currentForm;
var label;
var Employee = /** @class */ (function () {
    function Employee() {
    }
    ;
    /* onclick of add employee
    shows name input */
    Employee.prototype.registerationForm = function () {
        label = document.getElementById("labelText");
        var empDiv;
        document.body.style.backgroundColor = "#7FDBFF";
        empDiv = document.getElementById("empName");
        document.getElementById("label").style.display = "block";
        empDiv.style.display = "block";
        document.getElementById("ename").focus();
        currentField = "name";
        currentForm = 1;
        var image = document.getElementById("coverImg");
        image.style.display = "none";
        document.getElementById("navigation").style.display = "none";
    };
    /* switch case for employee  form for switching input fields */
    Employee.prototype.employeeBlur = function () {
        if (currentForm == 2) {
            veh.vehicleBlur();
            return false;
        }
        switch (currentField) {
            case "name":
                this.employeeName = document.getElementById("ename").value;
                if (!(/^[A-z ]{2,}$/.test(this.employeeName))) {
                    document.getElementById("error").innerHTML = "please enter valid name";
                    return false;
                }
                else {
                    document.getElementById("error").innerHTML = " ";
                }
                label.innerHTML = "Hi " + this.employeeName + " may I know your gender?";
                document.getElementById("empName").style.display = "none";
                document.getElementById("empGender").style.display = "block";
                currentField = "gender";
                break;

            case "gender":
                if (!document.getElementsByName("egender")[0].checked && !document.getElementsByName("egender")[1].checked) {
                    document.getElementById("error").innerHTML = "Please select gender";
                    return false;
                }
                else {
                    document.getElementById("error").innerHTML = " ";
                }
                label.innerHTML = " You must be having a email Id";
                document.getElementById("empGender").style.display = "none";
                document.getElementById("empEmail").style.display = "block";
                document.getElementById("eemail").focus();
                currentField = "email";
                break;

            case "email":
                this.employeeEmail = document.getElementById("eemail").value;
                if (!(/^[A-z]+@[A-z]+\.[A-z]+$/.test(this.employeeEmail))) {
                    document.getElementById("error").innerHTML = "please enter valid email address";
                    return false;
                }
                else {
                    document.getElementById("error").innerHTML = " ";
                }
                label.innerHTML = "Please choose a password";
                document.getElementById("empEmail").style.display = "none";
                document.getElementById("empPass").style.display = "block";
                document.getElementById("epass").focus();
                currentField = "password";
                break;

            case "password":
                this.employeePassword = document.getElementById("epass").value;
                if (!(/(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}/.test(this.employeePassword))) {
                    document.getElementById("error").innerHTML = "password should contains Uppercase, Lowercase, Numeric and min 8 characters";
                    return false;
                }
                else {
                    document.getElementById("error").innerHTML = " ";
                }
                label.innerHTML = "Lets check if you remember your password";
                document.getElementById("empPass").style.display = "none";
                document.getElementById("empCnfrmPass").style.display = "block";
                document.getElementById("ecnfrmpass").focus();
                currentField = "cnfrmpasswrd";
                break;

            case "cnfrmpasswrd":
                this.employeePassword = document.getElementById("epass").value;
                this.employeeMatchPassword = document.getElementById("ecnfrmpass").value;
                if (this.employeePassword != this.employeeMatchPassword) {
                    document.getElementById("error").innerHTML = "password doesn't match";
                    return false;
                }
                else {
                    document.getElementById("error").innerHTML = " ";
                }
                label.innerHTML = "please enter your contact number  ...";
                document.getElementById("empCnfrmPass").style.display = "none";
                document.getElementById("empContact").style.display = "block";
                document.getElementById("ecnumber").focus();
                document.getElementById("next1").style.display = "block";
                currentField = "contact";
                break;

            default:
        }
    };
    return Employee;
}());
var Vehicle = /** @class */ (function () {
    function Vehicle() {
    }
    ;
    /*  shows first input of vehcle form */
    Vehicle.prototype.vehicleForm = function () {
        emp.employeeContact = document.getElementById("ecnumber").value;
        if (!(/^[0-9]{10}$/.test(emp.employeeContact))) {
            document.getElementById("error").innerHTML = "please enter valid contact number";
            return false;
        }
        else {
            document.getElementById("error").innerHTML = " ";
        }
        document.getElementById("empContact").style.display = "none";
        document.getElementById("next1").style.display = "none";
        currentField = "vehName";
        currentForm = 2;
        document.body.style.backgroundColor = "#FF851B";
        var vehNameDiv;
        vehNameDiv = document.getElementById("vehName");
        label.innerHTML = "may I know the name of your vehicle";
        vehNameDiv.style.display = "block";
        document.getElementById("vname").focus();
        currentField = "vehName";
    };
    /* switch case for vehicle  form for switching input fields */
    Vehicle.prototype.vehicleBlur = function () {
        switch (currentField) {
            case "vehName":
                this.vehicleName = document.getElementById("vname").value;
                if (this.vehicleName == "") {
                    document.getElementById("error").innerHTML = "required";
                    return;
                }
                document.getElementById("error").innerHTML = " ";
                document.getElementById("vehName").style.display = "none";
                label.innerHTML = " whats the type of " + this.vehicleName;
                document.getElementById("vehType").style.display = "block";
                currentField = "vehType";
                break;

            case "vehType":
                this.vehicleType = document.getElementById("vtype").value;
                if (this.vehicleType == "") {
                    document.getElementById("error").innerHTML = "required";
                    return;
                }
                document.getElementById("error").innerHTML = " ";
                document.getElementById("vehType").style.display = "none";
                label.innerHTML = "Mention the number of " + this.vehicleName;
                document.getElementById("vehNumber").style.display = "block";
                document.getElementById("vnumber").focus();
                currentField = "vehNumber";
                break;

            case "vehNumber":
                this.vehicleNumber = document.getElementById("vnumber").value;
                if (this.vehicleNumber == "") {
                    document.getElementById("error").innerHTML = "required";
                    return;
                }
                document.getElementById("error").innerHTML = " ";
                document.getElementById("vehNumber").style.display = "none";
                label.innerHTML = "Tell something about " + this.vehicleName;
                document.getElementById("vehDescription").style.display = "block";
                document.getElementById("videntity").focus();
                document.getElementById("next2").style.display = "block";
                currentField = "vehDescription";
                break;

            default:
        }
    };
    return Vehicle;
}());
var Plan = /** @class */ (function () {
    function Plan() {
    }
    ;
    /* opens up the plan and pricing form */
    Plan.prototype.planForm = function () {
        document.body.style.backgroundColor = "#DDDDDD";
        document.getElementById("vehDescription").style.display = "none";
        document.getElementById("next2").style.display = "none";
        label.innerHTML = "choose currency for your plan";
        document.getElementById("currType").style.display = "block";
        currentField = "currency";
        currentForm = 3;
    };
    /* on submit of plan and pricing form */
    Plan.prototype.submitForm = function () {
        label.innerHTML = "Thank you for registering <br><br> Employee Name : " + emp.employeeName +
            "<br>Vehicle Name : " + veh.vehicleName;
        document.getElementById("plans").style.display = "none";
        document.getElementById("next3").style.display = "none";
        document.getElementById("currType").style.display = "none";
    };
    /* showing available plans according to vehicle selected */
    Plan.prototype.showPrice = function () {
        this.currency = document.getElementById("currency").value;
        this.plan = document.getElementById("plans");
        this.plan.style.display = "block";
        var v = veh.vehicleType;
        var daily = 5;
        var monthly = 100;
        var yearly = 500;
        if (v == "Motocycle") {
            daily = 10;
            monthly = 200;
            yearly = 1000;
        }
        else if (v == "Car") {
            daily = 20;
            monthly = 500;
            yearly = 3500;
        }
        document.getElementById("next3").style.display = "block";
        var cur = this.currency;
        switch (cur) {
            case "INR":
                document.getElementById("daily").innerHTML = "" + daily;
                document.getElementById("monthly").innerHTML = "" + monthly;
                document.getElementById("yearly").innerHTML = "" + yearly;
                break;
            case "USD":
                document.getElementById("daily").innerHTML = (daily / 71.74).toFixed(2);
                document.getElementById("monthly").innerHTML = (monthly / 71.74).toFixed(2);
                document.getElementById("yearly").innerHTML = (yearly / 71.74).toFixed(2);
                break;
            case "YEN":
                document.getElementById("daily").innerHTML = (daily / 0.68).toFixed(2);
                document.getElementById("monthly").innerHTML = (monthly / 0.68).toFixed(2);
                document.getElementById("yearly").innerHTML = (yearly / 0.68).toFixed(2);
                break;
        }
    };
    return Plan;
}());

var emp = new Employee();
var veh = new Vehicle();
var plan = new Plan();

/* event listener for enter key */
window.addEventListener('keypress', function (e) {
    if (e.keyCode == 13) {
        emp.employeeBlur();
    }
}, false);
/* redirects to emp registration form */
function goToEmpRegister() {
    emp.registerationForm();
}
/* validating password against weak , moderate and strong */
function validatePassword() {
    var employeePassword = document.getElementById("epass").value;
    document.getElementById("epass").style.borderWidth = "thick";
    if (employeePassword.length < 8) {
        document.getElementById("epass").style.borderColor = "red";
        document.getElementById("error").innerHTML = "password should be of min 8 characters";
        return false;
    }
    else if (!(/(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}/.test(employeePassword))) {
        document.getElementById("epass").style.borderColor = "orange";
        document.getElementById("error").innerHTML = "password should contains Uppercase, Lowercase, Numeric";
        return false;
    }
    else {
        document.getElementById("epass").style.borderColor = "green";
        document.getElementById("error").innerHTML = " ";
    }
}
/* redirects to vehicle form */
function goToVehForm() {
    veh.vehicleForm();
}
/* redirects to plan form */
function goToPlanForm() {
    plan.planForm();
}
/* redirects to submit form method*/
function goToSubmitForm() {
    plan.submitForm();
}
/* redirects to show price method */
function goToShowPrice() {
    plan.showPrice();
}
