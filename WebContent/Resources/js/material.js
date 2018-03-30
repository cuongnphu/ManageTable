function postMaterial(tableId) {
    console.log("add material in table ...");
    $.ajax({
        type: "post",
        url: "/ManageTable/addMaterial/"+tableId,
        success: function (data) {
            var redirect =  data;
            if(redirect){
                window.location.replace(redirect);
            }
        },
        error: function(e){
            alert('Error: ' +JSON.stringify(e));
        }
    });
}

var mate_count = 0;
var index = 0;
function addMaterial(tabId,intIndex) {
    index = intIndex + mate_count;
    var div = document.getElementById("myMaterial");
    var divrow = document.createElement("div");
    divrow.className = "row";
    divrow.id = index;
    var div1 = document.createElement("div");
    div1.className = "col-sm-3 p-0";
    var div2 = document.createElement("div");
    div2.className = "col-sm-3 p-0";
    var div3 = document.createElement("div");
    div3.className = "col-sm-2 p-0";
    var div4 = document.createElement("div");
    div4.className = "col-sm-3 p-0";
    var div5 = document.createElement("div");
    div5.className = "col-sm-1 p-0";
    var inputid = document.createElement("input");
    inputid.id = "materialList"+index+".id";
    inputid.type = "text";
    inputid.name = "materialList["+index+"].id";
    inputid.readOnly = "true";
    inputid.hidden = "true";
    inputid.setAttribute('value',"0");
    var inputtableid = document.createElement("input");
    inputtableid.id = "materialList"+index+".table_id";
    inputtableid.type = "text";
    inputtableid.name = "materialList["+index+"].table_id";
    inputtableid.readOnly = "true";
    inputtableid.hidden = "true";
    inputtableid.setAttribute('value',tabId.toString());
    var inputName = document.createElement("input");
    inputName.id = "materialList"+index+".name";
    inputName.type = "text";
    inputName.name = "materialList["+index+"].name";
    var inputWeight = document.createElement("input");
    inputWeight.id = "materialList"+index+".weight";
    inputWeight.type = "text";
    inputWeight.name = "materialList["+index+"].weight";
    var inputNumClass = document.createElement("input");
    inputNumClass.id = "materialList"+index+".num_class";
    inputNumClass.type = "text";
    inputNumClass.name = "materialList["+index+"].num_class";
    var inputQuantity = document.createElement("input");
    inputQuantity.id = "materialList"+index+".quantity";
    inputQuantity.type = "text";
    inputQuantity.name = "materialList["+index+"].quantity";
    div1.appendChild(inputid);
    div1.appendChild(inputtableid);
    div1.appendChild(inputName);
    div1.innerHTML += '<br><br>';
    div2.appendChild(inputWeight);
    div3.appendChild(inputNumClass);
    div4.appendChild(inputQuantity);
    var a = document.createElement("a");
    a.className = "btn-danger btn-xs";
    a.innerText = "-";
    a.onclick = function (ev) {
        a.parentNode.parentNode.parentNode.removeChild(a.parentNode.parentNode);
    };
    div5.appendChild(a);
    divrow.appendChild(div1);
    divrow.appendChild(div2);
    divrow.appendChild(div3);
    divrow.appendChild(div4);
    divrow.appendChild(div5);
    div.appendChild(divrow);
    mate_count++;
}

var materialScript = {
    editTableValidateForm: function () {
        var nameMate = $("#myMaterial > div.row > div > input[id*=name]");
        var weightMate = $("#myMaterial > div.row > div > input[id*=weight]");
        var numClassMate = $("#myMaterial > div.row > div > input[id*=num]");
        var quantityMate = $("#myMaterial > div.row > div > input[id*=quantity]");

        if(typeof nameMate.val() === "undefined")
            return true;
        else{
            for(var i = 0 ; i<nameMate.size();i++){
                if(nameMate.get(i).value == ""){
                    nameMate.get(i).style.borderColor = "red";
                    return false;
                }else
                    nameMate.get(i).style.borderColor = "";

                if(isNaN(weightMate.get(i).value) || weightMate.get(i).value <= 0 ||  weightMate.get(i).value == "" ) {
                    weightMate.get(i).style.borderColor = "red";
                    return false;
                }else
                    weightMate.get(i).style.borderColor = "";

                if(isNaN(numClassMate.get(i).value) || numClassMate.get(i).value <= 0 ||  numClassMate.get(i).value == "" ) {
                    numClassMate.get(i).style.borderColor = "red";
                    return false;
                }else
                    numClassMate.get(i).style.borderColor = "";

                if(isNaN(quantityMate.get(i).value) || quantityMate.get(i).value <= 0 ||  quantityMate.get(i).value == "" ) {
                    quantityMate.get(i).style.borderColor = "red";
                    return false;
                }else
                    quantityMate.get(i).style.borderColor = "";
            }
        }
    }
};