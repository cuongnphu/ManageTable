function postPrinter(tableId) {
    console.log("add printer in table ...");
    $.ajax({
        type: "post",
        url: "/ManageTable/addprinter/"+tableId,
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

var count = 0;
var index = 0;
function addPrinter(tableId,intIndex) {
    index = intIndex + count;
    var div = document.getElementById("myPrinter");
    var divrow = document.createElement("div");
    divrow.className = "row";
    divrow.id = index;
    var divleft = document.createElement("div");
    divleft.className = "p-0";
    divleft.style = "float: left;width: 90%";
    var inputid = document.createElement("input");
    inputid.id = "printerList"+index+".id";
    inputid.type = "text";
    inputid.name = "printerList["+index+"].id";
    inputid.readOnly = "true";
    inputid.hidden = "true";
    inputid.value = "0";
    var inputtableid = document.createElement("input");
    inputtableid.id = "printerList"+index+".table_id";
    inputtableid.type = "text";
    inputtableid.name = "printerList["+index+"].table_id";
    inputtableid.readOnly = "true";
    inputtableid.hidden = "true";
    inputtableid.value = tableId.toString();
    var inputName = document.createElement("input");
    inputName.id = "printerList"+index+".name";
    inputName.type = "text";
    inputName.name = "printerList["+index+"].name";
    var inputPrice = document.createElement("input");
    inputPrice.id = "printerList"+index+".price";
    inputPrice.type = "text";
    inputPrice.name = "printerList["+index+"].price";
    var inputQuantity = document.createElement("input");
    inputQuantity.id = "printerList"+index+".quantity";
    inputQuantity.type = "text";
    inputQuantity.name = "printerList["+index+"].quantity";
    var br = document.createElement("br");
    divleft.appendChild(inputid);
    divleft.appendChild(inputtableid);
    divleft.appendChild(inputName);
    divleft.appendChild(br);
    divleft.appendChild(inputPrice);
    divleft.appendChild(br);
    divleft.appendChild(inputQuantity);
    var br = document.createElement("br");
    divleft.appendChild(br);
    var br = document.createElement("br");
    divleft.appendChild(br);
    var divright = document.createElement("div");
    divright.className = "p-1";
    divright.style = "float:right;width:8%";
    var a = document.createElement("a");
    a.className = "btn-primary btn-xs";
    a.innerText = "-";
    a.onclick = function (ev) {
        a.parentNode.parentNode.parentNode.removeChild(a.parentNode.parentNode);
    };
    divright.appendChild(a);
    divrow.appendChild(divleft);
    divrow.appendChild(divright);
    div.appendChild(divrow);
    count++;
}