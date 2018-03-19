function postSewing(tableId) {
    console.log("add sewing in table ...");
    $.ajax({
        type: "post",
        url: "/ManageTable/addSewing/"+tableId,
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
function addSewing(tableId,intIndex) {
    index = intIndex + count;
    var div = document.getElementById("mySewing");
    var divrow = document.createElement("div");
    divrow.className = "row";
    divrow.id = index;
    var divleft = document.createElement("div");
    divleft.className = "p-0";
    divleft.style = "float: left;width: 90%";
    var inputid = document.createElement("input");
    inputid.id = "sewingList"+index+".id";
    inputid.type = "text";
    inputid.name = "sewingList["+index+"].id";
    inputid.readOnly = "true";
    inputid.hidden = "true";
    inputid.value = "0";
    var inputtableid = document.createElement("input");
    inputtableid.id = "sewingList"+index+".table_id";
    inputtableid.type = "text";
    inputtableid.name = "sewingList["+index+"].table_id";
    inputtableid.readOnly = "true";
    inputtableid.hidden = "true";
    inputtableid.value = tableId.toString();
    var inputName = document.createElement("input");
    inputName.id = "sewingList"+index+".name";
    inputName.type = "text";
    inputName.name = "sewingList["+index+"].name";
    var inputPrice = document.createElement("input");
    inputPrice.id = "sewingList"+index+".price";
    inputPrice.type = "text";
    inputPrice.name = "sewingList["+index+"].price";
    var inputQuantity = document.createElement("input");
    inputQuantity.id = "sewingList"+index+".quantity";
    inputQuantity.type = "text";
    inputQuantity.name = "sewingList["+index+"].quantity";
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