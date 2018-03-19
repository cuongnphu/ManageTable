function postEmbroidery(tableId) {
    console.log("add embroidery in table ...");
    $.ajax({
        type: "post",
        url: "/ManageTable/addEmbroidery/"+tableId,
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
function addEmbroidery(tableId,intIndex) {
    index = intIndex + count;
    var div = document.getElementById("myEmbroidery");
    var divrow = document.createElement("div");
    divrow.className = "row";
    divrow.id = index;
    var divleft = document.createElement("div");
    divleft.className = "p-0";
    divleft.style = "float: left;width: 90%";
    var inputid = document.createElement("input");
    inputid.id = "embroideryList"+index+".id";
    inputid.type = "text";
    inputid.name = "embroideryList["+index+"].id";
    inputid.readOnly = "true";
    inputid.hidden = "true";
    inputid.value = "0";
    var inputtableid = document.createElement("input");
    inputtableid.id = "embroideryList"+index+".table_id";
    inputtableid.type = "text";
    inputtableid.name = "embroideryList["+index+"].table_id";
    inputtableid.readOnly = "true";
    inputtableid.hidden = "true";
    inputtableid.value = tableId.toString();
    var inputName = document.createElement("input");
    inputName.id = "embroideryList"+index+".name";
    inputName.type = "text";
    inputName.name = "embroideryList["+index+"].name";
    var inputPrice = document.createElement("input");
    inputPrice.id = "embroideryList"+index+".price";
    inputPrice.type = "text";
    inputPrice.name = "embroideryList["+index+"].price";
    var inputQuantity = document.createElement("input");
    inputQuantity.id = "embroideryList"+index+".quantity";
    inputQuantity.type = "text";
    inputQuantity.name = "embroideryList["+index+"].quantity";
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