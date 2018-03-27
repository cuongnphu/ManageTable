var tableScript = {
    editTableValidateForm: function () {
        var nameTable = $("#tableForm > div > table > tbody > tr > td > input[id*=name]");
        var preWeight = $("#tableForm > div > table > tbody > tr > td > input[id*=pre_weight]");
        var afterWeight = $("#tableForm > div > table > tbody > tr > td > input[id*=after_weight]");

        if(nameTable.val() == ""){
            nameTable.css("borderColor","red");
            return false;
        }else
            nameTable.css("borderColor","");

        if(isNaN(preWeight.val()) || preWeight.val() <= 0 ||  preWeight.val() == "" ) {
            preWeight.css("borderColor","red");
            return false;
        }else
            preWeight.css("borderColor","");

        if(isNaN(afterWeight.val()) || afterWeight.val() <= 0 || afterWeight.val() == "") {
            afterWeight.css("borderColor","red");
            return false;
        }else
            afterWeight.css("borderColor","");
    },

    tableFormValidate: function () {
        var nameTable = document.getElementById('nameTable').value;
        var preWeight = document.getElementById('pre_weight').value;
        var afterWeight = document.getElementById('after_weight').value;

        if(nameTable == ""){
            document.getElementById('nameTable').style.borderColor = "red";
            return false;
        }else
            document.getElementById('nameTable').style.borderColor = "";

        if(isNaN(preWeight) || preWeight <= 0 ||  preWeight == "" ) {
            document.getElementById('pre_weight').style.borderColor = "red";
            return false;
        }else
            document.getElementById('pre_weight').style.borderColor = "";

        if(isNaN(afterWeight) || afterWeight <= 0 || afterWeight == "") {
            document.getElementById('after_weight').style.borderColor = "red";
            return false;
        }else
            document.getElementById('after_weight').style.borderColor = "";
    }
};

function editTableFormValidate() {
    if((tableScript.editTableValidateForm() === false )||(productScript.editTableValidateForm() === false)||(printerScript.editTableValidateForm()=== false)||
        (embroideryScript.editTableValidateForm()=== false)||(sewingScript.editTableValidateForm()===false)||(materialScript.editTableValidateForm()===false)){
        return false;
    }

}