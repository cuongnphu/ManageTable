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

var count = 0;
var index = 0;
function addMaterial(tabId,intIndex) {
    index = intIndex + count;
    var div = document.getElementById("myMaterial");
    var divrow = document.createElement("div");
    divrow.className = "row";
    divrow.id = index;
    var divleft = document.createElement("div");
    divleft.className = "p-0";
    divleft.style = "float: left;width: 95%";
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
    inputName.style = "width: 30%; ";
    inputName.name = "materialList["+index+"].name";
    var inputWeight = document.createElement("input");
    inputWeight.id = "materialList"+index+".weight";
    inputWeight.type = "text";
    inputWeight.style = "width: 22%; ";
    inputWeight.name = "materialList["+index+"].weight";
    var inputNumClass = document.createElement("input");
    inputNumClass.id = "materialList"+index+".num_class";
    inputNumClass.type = "text";
    inputNumClass.style = "width: 22%; ";
    inputNumClass.name = "materialList["+index+"].num_class";
    var inputQuantity = document.createElement("input");
    inputQuantity.id = "materialList"+index+".quantity";
    inputQuantity.type = "text";
    inputQuantity.style = "width: 23%; ";
    inputQuantity.name = "materialList["+index+"].quantity";
    divleft.appendChild(inputid);
    divleft.appendChild(inputtableid);
    divleft.appendChild(inputName);
    divleft.innerHTML += '&nbsp;';
    divleft.appendChild(inputWeight);
    divleft.innerHTML += '&nbsp;';
    divleft.appendChild(inputNumClass);
    divleft.innerHTML += '&nbsp;';
    divleft.appendChild(inputQuantity);
    divleft.innerHTML += '<br><br>';
    var divright = document.createElement("div");
    divright.className = "p-1";
    divright.style = "float:right;width:3%";
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