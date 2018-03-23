function tableFormValidate() {
    var nameTable = document.getElementById('nameTable').value;
    var preWeight = document.getElementById('pre_weight').value;
    var afterWeight = document.getElementById('after_weight').value;

    if(nameTable == ""){
        document.getElementById('nameTable').style.borderColor = "red";
        return false;
    }

    if(isNaN(preWeight) || isNaN(afterWeight) || preWeight < 0 || afterWeight < 0 || preWeight == "" || afterWeight == "") {
        document.getElementById('pre_weight').style.borderColor = "red";
        document.getElementById('after_weight').style.borderColor = "red";
        return false;
    }

}