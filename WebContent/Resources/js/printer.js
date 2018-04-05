var print_count = 0;
var index = 0;
var listNameTeam = null;

function postPrinter(tableId) {
    console.log("add printer in table ...");
    $.ajax({
        type: "post",
        url: "/ManageTable/addprinter/" + tableId,
        success: function (data) {
            var redirect = data;
            if (redirect) {
                window.location.replace(redirect);
            }
        },
        error: function (e) {
            alert('Error: ' + JSON.stringify(e));
        }
    });
}

function addPrinter(tabId, intIndex) {
    index = intIndex + print_count;
    var div = document.getElementById("myPrinter");
    var divrow = document.createElement("div");
    divrow.className = "row";
    divrow.id = index;
    var div1 = document.createElement("div");
    div1.className = "col-sm-4 p-0";
    var div2 = document.createElement("div");
    div2.className = "col-sm-4 p-0";
    var div3 = document.createElement("div");
    div3.className = "col-sm-3 p-0";
    var div4 = document.createElement("div");
    div4.className = "col-sm-1 p-0";
    var inputid = document.createElement("input");
    inputid.id = "printerList" + index + ".id";
    inputid.type = "text";
    inputid.name = "printerList[" + index + "].id";
    inputid.readOnly = "true";
    inputid.hidden = "true";
    inputid.setAttribute('value', "0");
    var inputtableid = document.createElement("input");
    inputtableid.id = "printerList" + index + ".table_id";
    inputtableid.type = "text";
    inputtableid.name = "printerList[" + index + "].table_id";
    inputtableid.readOnly = "true";
    inputtableid.hidden = "true";
    inputtableid.setAttribute('value', tabId.toString());
    var selectName = document.createElement("select");
    selectName.id = "printerList" + index + ".name";
    selectName.name = "printerList[" + index + "].name";
    for (var i = 0; i < listNameTeam.length; i++) {
        if(listNameTeam[i].team_id == 1){
            var option = document.createElement("option");
            option.setAttribute('value', listNameTeam[i].name);
            option.innerHTML = listNameTeam[i].name;
            selectName.appendChild(option);
        }
    }
    var inputPrice = document.createElement("input");
    inputPrice.id = "printerList" + index + ".price";
    inputPrice.type = "text";
    inputPrice.name = "printerList[" + index + "].price";
    var inputQuantity = document.createElement("input");
    inputQuantity.id = "printerList" + index + ".quantity";
    inputQuantity.type = "text";
    inputQuantity.name = "printerList[" + index + "].quantity";
    div1.appendChild(inputid);
    div1.appendChild(inputtableid);
    div1.appendChild(selectName);
    div1.innerHTML += '<br><br>';
    div2.appendChild(inputPrice);
    div3.appendChild(inputQuantity);
    var a = document.createElement("a");
    a.className = "btn-danger btn-xs";
    a.innerText = "-";
    a.onclick = function (ev) {
        a.parentNode.parentNode.parentNode.removeChild(a.parentNode.parentNode);
    };
    div4.appendChild(a);
    divrow.appendChild(div1);
    divrow.appendChild(div2);
    divrow.appendChild(div3);
    divrow.appendChild(div4);
    div.appendChild(divrow);
    print_count++;
}

var printerScript = {
    editTableValidateForm: function () {
        var namePrinter = $("#myPrinter > div.row > div > select[id*=name]");
        var pricePrinter = $("#myPrinter > div.row > div > input[id*=price]");
        var quantityPrinter = $("#myPrinter > div.row > div > input[id*=quantity]");

        if (typeof namePrinter.val() === "undefined")
            return true;
        else {
            for (var i = 0; i < namePrinter.size(); i++) {
                if (namePrinter.get(i).value == "") {
                    namePrinter.get(i).style.borderColor = "red";
                    return false;
                } else
                    namePrinter.get(i).style.borderColor = "";

                if (isNaN(pricePrinter.get(i).value) || pricePrinter.get(i).value <= 0 || pricePrinter.get(i).value == "") {
                    pricePrinter.get(i).style.borderColor = "red";
                    return false;
                } else
                    pricePrinter.get(i).style.borderColor = "";

                if (isNaN(quantityPrinter.get(i).value) || quantityPrinter.get(i).value <= 0 || quantityPrinter.get(i).value == "") {
                    quantityPrinter.get(i).style.borderColor = "red";
                    return false;
                } else
                    quantityPrinter.get(i).style.borderColor = "";
            }

        }
    }
};

function getListTeamName() {
    $.post("/ManageTable/listteamname", function (result) {
        var str = JSON.stringify(result);
        listNameTeam = JSON.parse(str);
    });

}

$(document).ready(getListTeamName());