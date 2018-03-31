var tableScript = {
    editTableValidateForm: function () {
        var nameTable = $("#tableForm > div > table > tbody > tr > td > input[id*=name]");

        if(nameTable.val() == ""){
            nameTable.css("borderColor","red");
            return false;
        }else
            nameTable.css("borderColor","");

    },

    tableFormValidate: function () {
        var nameTable = document.getElementById('nameTable').value;

        if(nameTable == ""){
            document.getElementById('nameTable').style.borderColor = "red";
            return false;
        }else
            document.getElementById('nameTable').style.borderColor = "";

    },

    editTableConfirmOut: function () {
        if (confirm("Bạn muốn thoát ??? ") == true)
            window.location.replace('/ManageTable/tables');
    }
};

function editTableFormValidate() {
    if((tableScript.editTableValidateForm() === false )||(productScript.editTableValidateForm() === false)||(printerScript.editTableValidateForm()=== false)||
        (embroideryScript.editTableValidateForm()=== false)||(sewingScript.editTableValidateForm()===false)||(materialScript.editTableValidateForm()===false)){
        return false;
    }

}